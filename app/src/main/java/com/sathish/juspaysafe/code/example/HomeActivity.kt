package com.sathish.juspaysafe.code.example

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class HomeActivity : AppCompatActivity() {


    internal var intent: Intent? = null
    private var extendedButton: Button? = null
    private var simpleButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        extendedButton = findViewById<View>(R.id.FL_Extended) as Button
        simpleButton = findViewById<View>(R.id.FL_Simple) as Button
        intent = Intent()
    }

    override fun onResume() {
        super.onResume()
        enableButtons()
    }

    private fun enableButtons() {
        extendedButton!!.isEnabled = true
        simpleButton!!.isEnabled = true
        extendedButton!!.text = EXTENDED_BUTTON
        simpleButton!!.text = SIMPLE_BUTTON
    }

    private fun disableButtons() {
        extendedButton!!.isEnabled = false
        simpleButton!!.isEnabled = false
    }


    fun extendedButtonClicked(view: View) {
        disableButtons()
        extendedButton!!.text = "Processing..."
        intent!!.setClass(this, FExtendedActivity::class.java)
        startActivity(intent)
    }

    fun directButtonClicked(view: View) {
        disableButtons()
        simpleButton!!.text = "Processing..."
        intent!!.setClass(this, FLSimpleActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private val EXTENDED_BUTTON = "FL + JBF Extended"
        private val SIMPLE_BUTTON = "FL + JBF Direct"
    }
}
