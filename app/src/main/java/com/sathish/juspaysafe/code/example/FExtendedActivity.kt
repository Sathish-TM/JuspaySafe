package com.sathish.juspaysafe.code.example

import android.os.Bundle
import android.support.v4.app.FragmentTransaction

import `in`.juspay.godel.ui.JuspayBrowserFragment
import `in`.juspay.godel.ui.JuspayWebView


class FExtendedActivity : BaseActivity() {

    private var paymentFragment: PaymentFragment? = null
    private val webView: JuspayWebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)

        if (savedInstanceState != null) {
            paymentFragment = supportFragmentManager
                    .getFragment(savedInstanceState, "paymentFragment") as PaymentFragment
        } else {
            paymentFragment = PaymentFragment()
            setJuspayArgumentBundle(paymentFragment!!)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.container, paymentFragment)
            transaction.commit()
        }
        setupCallbacks(paymentFragment!!)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Put the lastFragment in the outState Bundle
        supportFragmentManager.putFragment(outState, "paymentFragment", paymentFragment)
        super.onSaveInstanceState(outState)
    }


    override fun onBackPressed() {
        if (paymentFragment != null) {
            paymentFragment!!.juspayBackPressedHandler(true)
        } else {
            super.onBackPressed()
        }
    }

    /**
     * fragment extending JuspayBrowserFragment.
     */
    class PaymentFragment : JuspayBrowserFragment()
}
