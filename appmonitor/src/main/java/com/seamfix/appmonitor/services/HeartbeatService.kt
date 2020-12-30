package com.seamfix.appmonitor.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.seamfix.appmonitor.heartbeat.HeartBeat
import com.seamfix.appmonitor.heartbeat.HeartBeat.runJob

class HeartbeatService : Service() {

     override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         synchronized (this) {
             if (!sInitialized) {
                 intent?.let {
                     val operation: HeartBeat.HeartbeatOperation? = it.getParcelableExtra(HEARTBEAT_OPERATION)
                     runJob(this, operation!!)
                 }

                 sInitialized = true
             }
         }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    companion object {
        const val HEARTBEAT_OPERATION = "heartbeat"
        var sInitialized = false
    }
}