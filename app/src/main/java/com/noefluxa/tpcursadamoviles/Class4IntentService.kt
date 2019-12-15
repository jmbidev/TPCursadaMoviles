package com.noefluxa.tpcursadamoviles

import android.app.IntentService
import android.content.Intent
import android.content.Context
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class Class4IntentService : IntentService("Class4IntentService") {

    override fun onHandleIntent(intent: Intent?) {
        val iteration = intent?.getIntExtra("iteration",0 ) ?: 0
        val intent = Intent("iteration")

        intent.putExtra("iterationIntentService", iteration.toString())

        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }

        sendBroadcast(intent)
    }
}
