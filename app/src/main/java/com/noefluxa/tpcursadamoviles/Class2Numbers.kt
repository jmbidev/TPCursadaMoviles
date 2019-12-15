package com.noefluxa.tpcursadamoviles

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_class2_numbers.*

class Class2Numbers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class2_numbers)

        operator1.setText(savedInstanceState?.getString("oper1", ""))
        operator2.setText(savedInstanceState?.getString("oper2", ""))

        button_calculate.setOnClickListener {
            val oper1 = operator1.text.toString().toDoubleOrNull() ?: 0.0
            val oper2 = operator2.text.toString().toDoubleOrNull() ?: 0.0

            var result = 0.0
            val operation = intent?.extras?.get("operation") ?: Class2.OPERATION_ADD

            val intent = Intent(this, Class2::class.java)

            result = when (operation) {
                Class2.OPERATION_ADD -> oper1 + oper2
                Class2.OPERATION_SUBS -> oper1 - oper2
                Class2.OPERATION_MULT -> oper1 * oper2
                Class2.OPERATION_DIV -> oper1 / oper2
                else -> 0.0
            }

            intent.putExtra("result", result)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Add information for saving HelloToast counter
        // to the to the outState bundle
        outState.putString("oper1", operator1.text.toString())
        outState.putString("oper2", operator2.text.toString())
    }
}
