package com.noefluxa.tpcursadamoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_class1.setOnClickListener {
            val intent = Intent(this, Class1::class.java)
            startActivity(intent)
        }

        button_class2.setOnClickListener {
            val intent = Intent(this, Class2::class.java)
            startActivity(intent)
        }

        button_class3.setOnClickListener {
            val intent = Intent(this, Class3::class.java)
            startActivity(intent)
        }

        button_class4.setOnClickListener {
            val intent = Intent(this, Class4::class.java)
            startActivity(intent)
        }
    }
}
