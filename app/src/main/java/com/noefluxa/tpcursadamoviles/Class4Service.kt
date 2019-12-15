package com.noefluxa.tpcursadamoviles

import android.app.Service
import android.content.Intent
import android.os.*
import java.util.logging.Logger

class Class4Service : Service() {

    var mServiceLooper: Looper? = null
    var mServiceHandler: Class4ServiceHandler? = null


    override fun onCreate() {
        val thread = HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND)
        thread.start()

        mServiceLooper = thread.looper
        mServiceHandler = Class4ServiceHandler(thread.looper)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var msg = mServiceHandler?.obtainMessage()
        msg?.arg1 = startId
        msg?.arg2 = intent?.getIntExtra("iteration", 0) ?: 0
        mServiceHandler?.sendMessage(msg!!)

        return START_STICKY
    }

    inner class  Class4ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            try {
                Thread.sleep(3000)
                val intent = Intent("iteration")
                intent.putExtra("iterationService", msg.arg2.toString())
                sendBroadcast(intent)
            } catch (e : InterruptedException) {
                Thread.currentThread().interrupt()
            }

            this@Class4Service.stopSelf(msg.arg1)
        }
    }
}
