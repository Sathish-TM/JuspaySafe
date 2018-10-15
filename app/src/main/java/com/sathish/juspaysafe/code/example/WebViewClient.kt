package com.sathish.juspaysafe.code.example

import android.webkit.WebView

import `in`.juspay.godel.browser.JuspayWebViewClient
import `in`.juspay.godel.ui.JuspayBrowserFragment

class WebViewClient(webView: WebView, browserFragment: JuspayBrowserFragment, private val activity: BaseActivity) : JuspayWebViewClient(webView, browserFragment) {

    override fun onPageFinished(view: WebView, url: String) {
        super.onPageFinished(view, url)
        if (view.title != null && view.title == "Juspay Payment Response") {
            activity.handlePaymentResponse(url)
        }
    }

}
