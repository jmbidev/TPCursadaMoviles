package com.noefluxa.tpcursadamoviles

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_class1.*
import kotlinx.android.synthetic.main.activity_class1.button_home
import kotlinx.android.synthetic.main.activity_class1.textViewCounter
import kotlinx.android.synthetic.main.activity_class3.*
import kotlin.math.absoluteValue

class Class3 : AppCompatActivity() {
    private var asyncCounter: AsyncStepCounter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class3)

        val preferences = getSharedPreferences("class3", Context.MODE_PRIVATE)
        var count = preferences.getInt("stepCount", 0)
        var time = preferences.getInt("timeIn", 0)

        textViewCounter.text = count.toString()

        timeIn.setText(time.toString(), TextView.BufferType.EDITABLE)

        asyncCounter = AsyncStepCounter(count)

        button_home.setOnClickListener {
            finish()
        }

        buttonPlay.setOnClickListener {
            asyncCounter?.execute()
        }

        buttonStop.setOnClickListener {
            asyncCounter?.cancel(true)
            asyncCounter = AsyncStepCounter(textViewCounter.text.toString().toInt())
        }

        buttonReset.setOnClickListener {
            asyncCounter?.cancel(true)
            asyncCounter = AsyncStepCounter()
            textViewCounter.text = "0"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        asyncCounter?.cancel(true)
        val preferences = getSharedPreferences("class3", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        editor.putInt("stepCount", textViewCounter.text.toString().toInt())
        editor.putInt("timeIn", timeIn.text.toString().toInt())
        editor.commit()
    }

    inner class AsyncStepCounter(count: Int = 0) : AsyncTask<Void, Int, Int> () {
        var count:Int = count
            private set

        private var stepTime : Int = 0


        override fun onPreExecute() {
            super.onPreExecute()
            println("hasta aca llegue pre execute")
            stepTime = this@Class3.timeIn.text.toString().toIntOrNull() ?: 0
            println("hasta aca llegue pre execute")
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            println("hasta aca llegue progress update")
            this@Class3.textViewCounter.text = values[0].toString()
            println("hasta aca llegue progress update")
        }

        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)
        }

        override fun doInBackground(vararg params: Void?): Int {
            while (true){
                println("hasta aca llegue do in background")
                Thread.sleep(stepTime.toLong())
                count++
                publishProgress(count)
            }
        }

        override fun onCancelled() {
            super.onCancelled()
        }

    }
}
