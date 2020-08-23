package com.seamfix.appmonitor.heartbeat.remote

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.seamfix.appmonitor.common.ApiClient
import com.seamfix.appmonitor.common.Service
import com.seamfix.appmonitor.heartbeat.getDeviceHeartBeat
import com.sf.rest.request.device.DeviceHeartBeat
import retrofit2.Response

class HeartbeatWorker(private val context: Context, params: WorkerParameters): CoroutineWorker(context, params) {

    private var heartbeatInterval: Int = 0
    private val retrofit = ApiClient.getClient(context)
    private val service: Service = retrofit.create(Service::class.java)

    override suspend fun doWork(): Result {

        heartbeatInterval = inputData.getInt("heartbeatInterval", 10000)
        Log.e("HeartbeatWorker", "Heartbeat interval: $heartbeatInterval")

        return sync()
    }


    private suspend fun sync(): Result{
        Log.e("HeartbeatWorker", "Heartbeat syncing...")
        val deviceHeartBeat: DeviceHeartBeat = getDeviceHeartBeat()
        val response: Response<String> = service.sync(deviceHeartBeat)

        try {
            if(response.code() == 200 && response.body() != null){
                Log.e("HeartbeatWorker", "Heartbeat sync success.")
                //the response is an integer string that indicates the next heartbeat interval:
                val newHeartbeatIntervalString: String = response.body() as String
                val newHeartbeatInterval = newHeartbeatIntervalString.toInt()

                //convert to seconds. If 'newHeartbeatInterval' = 10
                //We should wait for 60 seconds ie 60,000 milli
                Thread.sleep((newHeartbeatInterval * 6000).toLong())
            }else{
                Log.e("HeartbeatWorker", "Heartbeat sync failed, code: ${response.code()}")
                Thread.sleep((heartbeatInterval).toLong())
            }

            //restart
            sync()

        } catch (e: Exception) {
            return Result.retry()
        }

        return Result.retry()
    }
}