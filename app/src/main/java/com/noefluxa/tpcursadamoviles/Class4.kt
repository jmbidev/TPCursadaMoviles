package com.noefluxa.tpcursadamoviles

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_class4.*
import android.os.IBinder


class Class4 : AppCompatActivity() {

    var mBoundService : Class4BoundService? = null
    var mBound = false

    var mConnection = object :ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as Class4BoundService.LocalBinder
            mBoundService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mBound = false
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class4)

        val myBroadCastReceiver = MyBroadcastReceiver()

        val progressfilter = IntentFilter("iteration")
        registerReceiver(myBroadCastReceiver, progressfilter)

        button_home.setOnClickListener {
            finish()
        }

        button_service.setOnClickListener {
            for (i in 1..4){
                println(i)
                val intent = Intent(this, Class4Service::class.java)
                intent.putExtra("iteration", i)
                startService(intent)
            }
        }

        button_intentService.setOnClickListener {
            for (i in 1..4){
                println(i)
                val intent = Intent(this, Class4IntentService::class.java)
                intent.putExtra("iteration", i)
                startService(intent)
            }
        }

        button_getRandom.setOnClickListener {
            textGetRandom.text = mBoundService?.getRandomNumber()?.toString() ?: textGetRandom.text
        }

    }

    override fun onStart() {
        super.onStart()
        var intent = Intent(this, Class4BoundService::class.java)
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()

        if (mBound){
            unbindService(mConnection)
            mBound = false
        }
    }

    inner class MyBroadcastReceiver() : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            this@Class4.textService.text = intent?.getStringExtra("iterationService") ?: this@Class4.textService.text
            this@Class4.textIntentService.text = intent?.getStringExtra("iterationIntentService") ?: this@Class4.textIntentService.text
        }
    }
}
