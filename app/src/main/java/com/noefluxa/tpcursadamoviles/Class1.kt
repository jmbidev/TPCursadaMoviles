package com.noefluxa.tpcursadamoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_class1.*

class Class1 : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class1)

        button_home.setOnClickListener {
            finish()
        }

        buttonAdd.setOnClickListener {
            this.counter++
            this.setCounterValue()
        }

        buttonSubtract.setOnClickListener {
            this.counter--
            this.setCounterValue()
        }

        buttonRestart.setOnClickListener {
            this.counter = 0
            this.setCounterValue()
        }
    }

    private fun setCounterValue(){
        textViewCounter.text = this.counter.toString()
    }
}
