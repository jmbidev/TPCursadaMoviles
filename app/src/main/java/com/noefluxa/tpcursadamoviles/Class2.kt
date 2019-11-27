package com.noefluxa.tpcursadamoviles

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_class1.*
import kotlinx.android.synthetic.main.activity_class1.button_home
import kotlinx.android.synthetic.main.activity_class2.*
import kotlinx.android.synthetic.main.activity_class2_numbers.*

class Class2 : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class2)

        val oper1 = intent.extras?.getFloat("oper1")
        val oper2 = intent.extras?.getFloat("oper2")

        answer_sum.text = oper1.toString()+" "+oper2.toString()

        button_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button_enterValues.setOnClickListener {
            val intent = Intent(this, activity_class2_numbers::class.java)
            startActivityForResult()
        }
    }
}