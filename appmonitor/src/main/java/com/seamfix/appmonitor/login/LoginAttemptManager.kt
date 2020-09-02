package com.seamfix.appmonitor.login

import android.content.Context
import android.util.Log
import androidx.work.*
import com.seamfix.appmonitor.common.Config
import com.seamfix.appmonitor.login.local.AppDatabase
import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.remote.LoginAttemptWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

object LoginAttemptManager {

    //Local
    private lateinit var db : AppDatabase
    lateinit var config: Config


    /*** Add a login attempt. This login attempt will be saved and synced in queue ***/
    fun addLoginAttempt(context: Context, config: Config, loginAttempt: LoginAttempt){
        this.config = config
        GlobalScope.launch(Dispatchers.IO){
            db = AppDatabase.getDatabase(context)
            db.loginAttemptDao().save(loginAttempt)

            //After the record has been saved, we need to start syncing it:
            syncLoginAttempts(context)
        }
    }


    /*** This starts the process to sync all LoginAttempts from the database ****/
    private fun syncLoginAttempts(context: Context){
        db = AppDatabase.getDatabase(context)
        //Create a new work manager:
        createWorker(context)
    }


    private fun createWorker(context: Context) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .build()
        val syncWorkRequest: OneTimeWorkRequest = OneTimeWorkRequestBuilder<LoginAttemptWorker>()
            .addTag("sync_offline_attempts")
            .setConstraints(constraints)
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                TimeUnit.MILLISECONDS)
            .build()

        WorkManager
            .getInstance(context)
            .enqueueUniqueWork("sync_offline_attempts", ExistingWorkPolicy.REPLACE, syncWorkRequest)
    }
}