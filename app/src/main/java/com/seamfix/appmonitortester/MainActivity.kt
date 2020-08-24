package com.seamfix.appmonitortester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seamfix.appmonitor.common.AppMonitor
import com.seamfix.appmonitor.common.ConfigBuilder
import com.seamfix.appmonitor.heartbeat.HeartBeat
import com.seamfix.appmonitor.heartbeat.model.DeviceHeartBeatRequest
import com.seamfix.appmonitor.login.LoginAttemptManager
import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.enums.LoginMethod
import com.seamfix.appmonitor.login.model.enums.LoginMode
import com.seamfix.appmonitor.login.model.enums.LoginStatus
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val config = ConfigBuilder()
            .setBaseURL("http://13.56.69.207:8190")//set the base url

            .addHeader("Mac-Address" to "AHVZ0xjvKxQNwWaiA1rSynDyFqnh89DBdN4ZPXOUbIMt2SjFpAR217a22n7C30RaS0u0-Ni84NRCX1rkkTyDMo8PQ5R3yeD9o4oVcnwbw5FMxyveAhiwoSc}")
            .addHeader("Client-ID" to "smartclient")
            .addHeader("User-Agent" to "GLO-HH-SFX001-LAG-ETI-785D")
            .addHeader("User-UUID" to "2ea4fbd3-6e01-4c8f-a6ef-f24e4c2100f9")
            .addHeader("sc-auth-key" to "AHVZ0xi17WwW9nHIIKe5gD-dajR6q8WnPiJ1EIB7Fooq8dzoG9EKPfS2ZV0kH5nslZ0ZfNfWEKAjjwjyuqkcPXyh6UVq1BlVigFbPKe7DuvRe_U_Wgurqss7vihZxdSjmUZbia5XTwGNlDfhZ1hA-iTLxhNdgoM3-g")
            .addHeader("Device-ID" to "AHVZ0xhVxA-dJPdvqldEzRzJCWUdjtHH9xSk7JKgImBarhDSPQXyEAfRwN9C-Bf21zWD63BX9ENlmm9hVGQKxSKV-TKAZsnAEp3HUot9qp-QK-QeBR26m-8")
            .addHeader("Content-Type" to "application/x-www-form-urlencoded")
            .addHeader("User-Agent" to "Smart Client for KYC [Build: 1.2, Install Date: NA]")
            .addHeader("Accept" to "*/*")
            .addHeader("Accept-Encoding" to "gzip, deflate, br")
            .addHeader("Connection" to "keep-alive")
            .build()

        //set the config
        AppMonitor.config = config


        //Start the heart beat job:
        HeartBeat.runJob(this, 5000, object : HeartBeat.HeartbeatOperation{
            override fun getDeviceHeartBeat(): DeviceHeartBeatRequest {

                //Create your device heart beat and set the values you are interested in:
                val deviceHeartBeat = DeviceHeartBeatRequest()
                deviceHeartBeat.clientCurrentTime = System.currentTimeMillis().toString()

                return deviceHeartBeat
            }
        })

        //create a login attempt object
        val loginAttempt = LoginAttempt(
            "jeffemuveyan@gmail.com",
            100000,
            "NA",
            LoginStatus.SUCCESS,
            "NA",
            LoginMode.ONLINE,
            LoginMethod.EMAIL)

        button.setOnClickListener {

            //save the login attempt object
            LoginAttemptManager.addLoginAttempt(this@MainActivity, loginAttempt)
        }

    }
}
