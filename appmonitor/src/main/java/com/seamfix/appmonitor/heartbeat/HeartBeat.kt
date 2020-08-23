package com.seamfix.appmonitor.heartbeat

import android.content.Context
import android.util.Log
import androidx.work.*
import com.seamfix.appmonitor.heartbeat.remote.HeartbeatWorker
import java.util.concurrent.TimeUnit

object HeartBeat {

    private var heartbeatInterval = 10000 //default heart beat sync interval: 10 seconds

    /*** Starts the process to gather and sync data for heart beat.
     * @param heartbeatInterval: The duration the library should wait before sending another
     * heart beat request.
     */
    fun sync(context: Context, heartbeatInterval: Int){
        this.heartbeatInterval = heartbeatInterval

        //We need to ensure that we don't already have a Work manager instance running so that we don't
        //mistakenly create multiple work managers.
        val existingUUID = getCurrentUploadWorkInformation(context)

        if(existingUUID != null){//existing work manger instance exists:
            Log.e("HeartBeat", "Work manger instance has already been created.")
        }else{
            //Create a new work manager:
            createWorker(context)
        }
    }


    private fun createWorker(context: Context) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val syncWorkRequest: OneTimeWorkRequest = OneTimeWorkRequestBuilder<HeartbeatWorker>()
            .addTag("sync_heartbeat")
            .setInputData(workDataOf(
                "heartbeatInterval" to heartbeatInterval
            ))
            .setConstraints(constraints)
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                TimeUnit.MILLISECONDS)
            .build()

        WorkManager
            .getInstance(context)
            .enqueueUniqueWork("sync_heartbeat", ExistingWorkPolicy.REPLACE, syncWorkRequest)

        //save the uuid for later use to monitor this worker:
        saveCurrentUploadWorkInformation(context, syncWorkRequest.id)
    }
}