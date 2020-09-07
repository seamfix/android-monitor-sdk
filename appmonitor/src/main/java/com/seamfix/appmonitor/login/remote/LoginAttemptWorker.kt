package com.seamfix.appmonitor.login.remote

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.seamfix.appmonitor.common.ApiClient
import com.seamfix.appmonitor.common.Config
import com.seamfix.appmonitor.common.Service
import com.seamfix.appmonitor.login.BASE_URL
import com.seamfix.appmonitor.login.LoginAttemptManager
import com.seamfix.appmonitor.login.local.AppDatabase
import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.response.LoginAttemptResponse
import retrofit2.Response
import retrofit2.Retrofit

internal class LoginAttemptWorker(private val context: Context, params: WorkerParameters): CoroutineWorker(context, params) {

    private val db = AppDatabase.getDatabase(context)
    private lateinit var retrofit : Retrofit
    private lateinit var service: Service
    private lateinit var config: Config

    override suspend fun doWork(): Result {
        Log.e(LoginAttemptWorker::class.java.simpleName, "Worker started...")

        return sync()
    }


    private suspend fun sync(): Result {

        if(haveNetworkConnection(context)) {

            config = LoginAttemptManager.config
            retrofit = ApiClient.getClient(context, config)
            service = retrofit.create(Service::class.java)

            //get all login attempt in the database
            val savedLoginAttempts = db.loginAttemptDao().getAllSynchronously()

            //get the first element
            if (savedLoginAttempts != null && savedLoginAttempts.isNotEmpty()) {

                val loginAttempt = savedLoginAttempts[0]

                Log.e(LoginAttemptWorker::class.java.simpleName,
                    "Syncing record(s): ${savedLoginAttempts.size}\nIn progress: $loginAttempt")

                try {
                    val request: List<LoginAttempt> = listOf(loginAttempt)
                    val response: Response<List<LoginAttemptResponse>> = service.sync(request)

                    if (response.code() == 200 && response.body() != null) { //response form server:
                        val loginAttemptResponseList = response.body() as List<LoginAttemptResponse>

                        if (loginAttemptResponseList.isNotEmpty() && loginAttemptResponseList[0].code == 0) {
                            //Successful sync. Now we delete the record from the database:
                            db.loginAttemptDao().delete(loginAttempt)
                            Log.e(LoginAttemptWorker::class.java.simpleName, "Sync successful")

                        } else if (loginAttemptResponseList.isNotEmpty() && loginAttemptResponseList[0].code == -1) {
                            Log.e(LoginAttemptWorker::class.java.simpleName,
                                "Sync failed: ${loginAttemptResponseList[0].description}")
                            //Delay a little before trying again
                            Thread.sleep(10000)
                        }

                        //and start the process again until the database is empty:
                        sync()
                    } else {
                        retry("Sync failed: ${response?.code()}")
                    }
                } catch (e: Exception) {
                    retry("Network error: ${e.message}")
                }
            } else {
                retry("No work to do.")
            }
        }else {
            retry("Offline, will retry")
        }

        return Result.retry()//the process should always retry.
    }


    private suspend inline fun retry(reason: String){
        Log.e(LoginAttemptWorker::class.java.simpleName, reason)
        //delay for 10 seconds then retry:
        Thread.sleep(10000)
        sync()
    }


    private fun haveNetworkConnection(context: Context?): Boolean {
        var haveConnectedWifi = false
        var haveConnectedMobile = false
        if (context != null) {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.allNetworkInfo
            for (ni in netInfo) {
                if (ni.typeName.equals("WIFI", ignoreCase = true) && ni.isConnected) {
                    haveConnectedWifi = true
                }
                if (ni.typeName.equals("MOBILE", ignoreCase = true) && ni.isConnected) {
                    haveConnectedMobile = true
                }
            }
            return haveConnectedWifi || haveConnectedMobile
        }
        return false
    }

}