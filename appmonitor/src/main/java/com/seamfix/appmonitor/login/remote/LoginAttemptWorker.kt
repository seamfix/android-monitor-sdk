package com.seamfix.appmonitor.login.remote

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Operation
import androidx.work.WorkerParameters
import com.seamfix.appmonitor.login.local.AppDatabase
import com.seamfix.appmonitor.login.model.response.LoginAttemptResponse
import retrofit2.Response

class LoginAttemptWorker(private val context: Context, params: WorkerParameters): CoroutineWorker(context, params) {

    private val db = AppDatabase.getDatabase(context)
    private val retrofit = ApiClient.getClient(context)
    private val service: Service = retrofit.create(Service::class.java)

    override suspend fun doWork(): Result {
        return sync()
    }


    private suspend fun sync(): Result {
        Log.e(LoginAttemptWorker::class.java.simpleName, "Worker started...")

        //get all login attempt in the database
        val savedLoginAttempts = db.loginAttemptDao().getAllSynchronously()

        //get the first element
        if(savedLoginAttempts != null && savedLoginAttempts.isNotEmpty()){

            for(loginAttempt in savedLoginAttempts){
                Log.e(LoginAttemptWorker::class.java.simpleName, "Syncing record: $loginAttempt")

                val response: Response<LoginAttemptResponse> = service.sync(loginAttempt)

                try {
                    if(response.code() == 200 && response.body() != null){ //response form server:
                        val  loginAttemptResponse = response.body() as LoginAttemptResponse

                        if(loginAttemptResponse != null && loginAttemptResponse.code == 0){
                            //Successful sync. Now we delete the record from the database:
                            db.loginAttemptDao().delete(loginAttempt)

                            //and start the process again until the database is empty:
                            sync()
                        }
                    }
                } catch (e: Exception) {
                    return Result.retry()
                }
            }
        }else{
            Log.e(LoginAttemptWorker::class.java.simpleName, "No work to do.")
        }

        return Result.retry()//the process should always retry.
    }

}