package com.websarva.wings.android.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                if (hour < 2) {
                    changeText("こんばんは")
                } else if ( hour < 10 ) {
                    changeText("おはよう")
                } else if ( hour < 18 ) {
                    changeText("こんにちは")
                } else {
                    changeText("こんばんは")
                }
            },
            13, 0, true)
        timePickerDialog.show()
    }

    private fun changeText(result: String) {
        textView.text = result
    }
}