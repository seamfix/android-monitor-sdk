package com.seamfix.appmonitor.heartbeat

import android.content.Context
import android.os.Parcelable
import android.util.Log
import com.seamfix.appmonitor.common.ApiClient
import com.seamfix.appmonitor.common.Config
import com.seamfix.appmonitor.common.Service
import com.seamfix.appmonitor.heartbeat.model.DeviceHeartBeatRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

object HeartBeat {

    fun runJob(context: Context, heartbeatOperation: HeartbeatOperation) {

        GlobalScope.launch(Dispatchers.IO) {
            while (true) {
                Thread.sleep((heartbeatOperation.getInterval()))
                val retrofit = ApiClient.getClient(context, heartbeatOperation.getConfig(context))
                val service: Service = retrofit.create(Service::class.java)
                Log.e("HeartbeatWorker", "Heartbeat syncing. Interval: ${heartbeatOperation.getInterval()}")
                Log.e("HeartbeatWorker", "Client up time: ${heartbeatOperation.getDeviceHeartBeat(context).clientUptime}\n ")

                try {
                    val deviceHeartBeat: DeviceHeartBeatRequest = heartbeatOperation.getDeviceHeartBeat(context)
                    val paths = heartbeatOperation.getConfig(context).endPoints
                    val response: Response<String> = service.sync(paths, deviceHeartBeat)

                    if (response.code() == 200 && response.body() != null) {
                        val newHeartbeatInterval: String = response.body() as String
                        if (!newHeartbeatInterval.isNullOrEmpty()) {
                            //the response is an integer string that indicates the next heartbeat interval:
                            //We just log the response:
                            Log.e("HeartbeatWorker", "Heartbeat sync success.\nResponse: $newHeartbeatInterval")

                        } else {
                            Log.e("HeartbeatWorker", "Heartbeat Response is empty")
                        }
                    } else {
                        Log.e("HeartbeatWorker", "Heartbeat sync failed, code: ${response.code()}")
                    }
                    //restart
                    //runJob(context, heartbeatOperation)

                } catch (e: Exception) {
                    Log.e("HeartbeatWorker", "Heartbeat sync failed: ${e.message}")
                    //restart
                    //runJob(context,  heartbeatOperation)
                }
            }
        }
    }


    interface HeartbeatOperation: Parcelable {
        fun getDeviceHeartBeat(context: Context): DeviceHeartBeatRequest
        fun getInterval(): Long
        fun getConfig(context: Context): Config
    }
}