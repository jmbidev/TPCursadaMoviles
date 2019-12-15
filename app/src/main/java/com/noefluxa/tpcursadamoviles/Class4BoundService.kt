package com.noefluxa.tpcursadamoviles

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlin.random.Random

class Class4BoundService : Service() {
    private val mGenerator = java.util.Random()
    private val mBinder = LocalBinder()

    inner class LocalBinder : Binder(){
        fun getService() : Class4BoundService {
            return this@Class4BoundService
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    fun getRandomNumber() : Int {
        return mGenerator.nextInt(100)
    }

}
