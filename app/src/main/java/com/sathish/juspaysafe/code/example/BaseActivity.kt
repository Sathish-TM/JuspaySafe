package com.sathish.juspaysafe.code.example


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebSettings
import android.widget.Toast

import org.json.JSONException
import org.json.JSONObject

import `in`.juspay.godel.analytics.GodelTracker
import `in`.juspay.godel.ui.JuspayBrowserFragment
import `in`.juspay.godel.ui.JuspayWebView


@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    private var juspayBrowserFragment: JuspayBrowserFragment? = null

    protected val juspayArgumentBundle: Bundle
        get() {
            val args = Bundle()
            args.putString("url", Constants.URL)
            args.putString("postData", Constants.POST_DATA)
            args.putString("merchantId", Constants.MERCHANT_ID)
            args.putString("clientId", Constants.CLIENT_ID)
            args.putString("transactionId", Constants.transactionId)
            args.putString("displayNote", Constants.DISPLAY_NOTE)
            args.putString("remarks", Constants.REMARKS)
            args.putString("amount", Constants.AMOUNT.toString())
            args.putString("customerPhoneNumber", Constants.CUSTOMER_PHONE_NUMBER)
            args.putString("UDF_FIRST", "first_value")
            args.putString("UDF_SECOND", "second_value")
            args.putString("UDF_THIRD", "third_value")
            args.putString("UDF_FOURTH", "fourth_value")

            return args
        }

    internal var juspayWebviewCallback: JuspayBrowserFragment.JuspayWebviewCallback = JuspayBrowserFragment.JuspayWebviewCallback {
        val webView = juspayBrowserFragment!!.webView
        initWebView(webView, juspayBrowserFragment)
    }

    internal var backButtonCallback: JuspayBrowserFragment.JuspayBackButtonCallback = object : JuspayBrowserFragment.JuspayBackButtonCallback() {

        @Throws(JSONException::class)
        override fun transactionCancelled(jsonObject: JSONObject) {
            Toast.makeText(applicationContext, "Transaction cancelled by the User", Toast.LENGTH_LONG).show()
            finish()

        }
    }


    fun setupCallbacks(browserFragment: JuspayBrowserFragment) {
        this.juspayBrowserFragment = browserFragment
        juspayBrowserFragment!!.setupJuspayWebviewCallbackInterface(juspayWebviewCallback)
        juspayBrowserFragment!!.setupJuspayBackButtonCallbackInterface(backButtonCallback)
    }

    protected fun setJuspayArgumentBundle(browserFragment: JuspayBrowserFragment) {
        browserFragment.arguments = juspayArgumentBundle
    }

    internal fun initWebView(webView: JuspayWebView, juspayBrowserFragment: JuspayBrowserFragment?) {
        val webSettings = webView.settings
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.pluginState = WebSettings.PluginState.ON

        val viewClient = WebViewClient(webView, juspayBrowserFragment!!, this)
        webView.webViewClient = viewClient
    }

    /**
     * Payment is completed for the existing request. Process the url and send back the payment status.
     */
    fun handlePaymentResponse(url: String) {
        if (url.contains("success")) {
            GodelTracker.getInstance().trackPaymentStatus(Constants.transactionId, GodelTracker.SUCCESS)
        } else if (url.contains("failure")) {
            GodelTracker.getInstance().trackPaymentStatus(Constants.transactionId, GodelTracker.FAILURE)
        } else {
            GodelTracker.getInstance().trackPaymentStatus(Constants.transactionId, GodelTracker.CANCELLED)
        }
    }
}
