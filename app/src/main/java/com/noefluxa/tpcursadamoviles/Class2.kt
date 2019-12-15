package com.noefluxa.tpcursadamoviles

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_class1.button_home
import kotlinx.android.synthetic.main.activity_class2.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class Class2 : AppCompatActivity() {

    companion object {
        const val OPERATION_ADD = 1
        const val OPERATION_SUBS = 2
        const val OPERATION_MULT = 3
        const val OPERATION_DIV = 4
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class2)

        text_result.text = (savedInstanceState?.getString("result", ""))

        button_home.setOnClickListener {
            finish()
        }

        button_add.setOnClickListener {
            val intent = Intent(this, Class2Numbers::class.java)
            intent.putExtra("operation", OPERATION_ADD)
            startActivityForResult(intent, OPERATION_ADD)
        }

        button_subs.setOnClickListener {
            val intent = Intent(this, Class2Numbers::class.java)
            intent.putExtra("operation", OPERATION_SUBS)
            startActivityForResult(intent, OPERATION_SUBS)
        }

        button_mult.setOnClickListener {
            val intent = Intent(this, Class2Numbers::class.java)
            intent.putExtra("operation", OPERATION_MULT)
            startActivityForResult(intent, OPERATION_MULT)
        }

        button_div.setOnClickListener {
            val intent = Intent(this, Class2Numbers::class.java)
            intent.putExtra("operation", OPERATION_DIV)
            startActivityForResult(intent, OPERATION_DIV)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        text_result.text = ((data?.extras?.getDouble("result", 0.0) ?: 0.0).toString())
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Add information for saving HelloToast counter
        // to the to the outState bundle
        outState.putString("result",text_result.text.toString())
    }
}