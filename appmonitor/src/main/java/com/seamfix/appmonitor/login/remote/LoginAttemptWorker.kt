package com.seamfix.appmonitor.login.remote

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.seamfix.appmonitor.login.local.AppDatabase
import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.response.LoginAttemptResponse
import retrofit2.Response

internal class LoginAttemptWorker(private val context: Context, params: WorkerParameters): CoroutineWorker(context, params) {

    private val db = AppDatabase.getDatabase(context)
    private val retrofit = ApiClient.getClient(context)
    private val service: Service = retrofit.create(Service::class.java)

    override suspend fun doWork(): Result {
        Log.e(LoginAttemptWorker::class.java.simpleName, "Worker started...")
        return sync()
    }


    private suspend fun sync(): Result {

        //get all login attempt in the database
        val savedLoginAttempts = db.loginAttemptDao().getAllSynchronously()

        //get the first element
        if(savedLoginAttempts != null && savedLoginAttempts.isNotEmpty()){

            val loginAttempt = savedLoginAttempts[0]

            Log.e(LoginAttemptWorker::class.java.simpleName,
                "Syncing record(s): ${savedLoginAttempts.size}\nIn progress: $loginAttempt")

            try {
                val request: List<LoginAttempt> = listOf(loginAttempt)
                val response: Response<List<LoginAttemptResponse>> = service.sync(request)

                if(response.code() == 200 && response.body() != null){ //response form server:
                    val  loginAttemptResponseList = response.body() as List<LoginAttemptResponse>

                    if(loginAttemptResponseList.isNotEmpty() && loginAttemptResponseList[0].code == 0){
                        //Successful sync. Now we delete the record from the database:
                        db.loginAttemptDao().delete(loginAttempt)
                        Log.e(LoginAttemptWorker::class.java.simpleName, "Sync successful")
                    }

                    //and start the process again until the database is empty:
                    sync()
                }else{
                    sync()//restart
                }
            } catch (e: Exception) {
                sync()//restart
            }

        }else{
            Log.e(LoginAttemptWorker::class.java.simpleName, "No work to do.")
        }

        return Result.retry()//the process should always retry.
    }

}