package com.sathish.juspaysafe.code.example

import android.os.Bundle

import `in`.juspay.godel.ui.JuspayBrowserFragment

class EFragmentActivity : BaseActivity() {

    private var browserFragment: JuspayBrowserFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_embedded_fragment)
        browserFragment = supportFragmentManager.findFragmentById(R.id.fragment) as JuspayBrowserFragment
        browserFragment!!.startPaymentWithArguments(juspayArgumentBundle)
        setupCallbacks(browserFragment!!)
    }

    override fun onBackPressed() {
        if (browserFragment != null) {
            browserFragment!!.juspayBackPressedHandler(true)
        } else {
            super.onBackPressed()
        }
    }
}
