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

    fun runJob(context: Context, heartbeatOperation: Suspendable) {

        GlobalScope.launch(Dispatchers.IO) {
            while (true) {
                Thread.sleep(((heartbeatOperation as? Suspendable)?.getInterval() ?: 0))

                val (request, config) = if (heartbeatOperation is ParceledHeartbeatOperation) {
                    heartbeatOperation.getDeviceHeartBeat(context) to
                            heartbeatOperation.getConfig(context)
                } else {
                    (heartbeatOperation as HeartbeatOperation).getDeviceHeartBeat() to
                            heartbeatOperation.getConfig()
                }

                try {
                    val retrofit = ApiClient.getClient(context, config)
                    val service: Service = retrofit.create(Service::class.java)

                    val deviceHeartBeat: DeviceHeartBeatRequest = request
                    val paths = config.endPoints
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

                } catch (e: Exception) {
                    Log.e("HeartbeatWorker", "Heartbeat sync failed: ${e.message}")
                }
            }
        }
    }

    interface Suspendable {
        fun getInterval(): Long
    }

    interface HeartbeatOperation: Suspendable {
        fun getDeviceHeartBeat(): DeviceHeartBeatRequest
        fun getConfig(): Config
    }

    interface ParceledHeartbeatOperation: Parcelable, Suspendable {
        fun getDeviceHeartBeat(context: Context): DeviceHeartBeatRequest
        fun getConfig(context: Context): Config
    }
}