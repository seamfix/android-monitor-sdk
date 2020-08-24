package com.seamfix.appmonitor.heartbeat

import android.content.Context
import android.util.Log
import com.seamfix.appmonitor.common.ApiClient
import com.seamfix.appmonitor.common.Service
import com.sf.rest.request.device.DeviceHeartBeat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

object HeartBeat {

    fun runJob(context: Context, heartbeatInterval: Int, heartbeatOperation: HeartbeatOperation){

        GlobalScope.launch(Dispatchers.IO) {
            val retrofit = ApiClient.getClient(context)
            val service: Service = retrofit.create(Service::class.java)
            Log.e("HeartbeatWorker", "Heartbeat syncing. Interval: $heartbeatInterval")
            Log.e("HeartbeatWorker", "Client up time: ${heartbeatOperation.getHeartbeatDevice().clientCurrentTime}\n ")

            val deviceHeartBeat: DeviceHeartBeat = heartbeatOperation.getHeartbeatDevice()
            val response: Response<String> = service.sync(deviceHeartBeat)

            try {
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

                Thread.sleep((heartbeatInterval).toLong())
                //restart
                runJob(context, heartbeatInterval, heartbeatOperation)

            } catch (e: Exception) {
                Log.e("HeartbeatWorker", "Heartbeat sync failed: ${e.message}")
                //restart
                runJob(context, heartbeatInterval, heartbeatOperation)
            }
        }
    }
    interface HeartbeatOperation{
        fun getHeartbeatDevice(): DeviceHeartBeat
    }

}