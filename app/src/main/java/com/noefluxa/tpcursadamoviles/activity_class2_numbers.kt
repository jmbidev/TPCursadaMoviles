package com.noefluxa.tpcursadamoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_class2_numbers.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class activity_class2_numbers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class2_numbers)

        button_calculate.setOnClickListener {
            val intent = Intent(this, Class2::class.java)
            intent.putExtra("oper1", operator1.text.toString().toFloat())
            intent.putExtra("oper2", operator2.text.toString().toFloat())
            startActivity(intent)
        }
    }
}
