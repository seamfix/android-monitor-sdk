package com.seamfix.appmonitortester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seamfix.appmonitor.common.Config
import com.seamfix.appmonitor.common.ConfigBuilder
import com.seamfix.appmonitor.heartbeat.HeartBeat
import com.seamfix.appmonitor.heartbeat.model.DeviceHeartBeatRequest
import com.seamfix.appmonitor.login.LoginAttemptManager
import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.enums.LoginMethod
import com.seamfix.appmonitor.login.model.enums.LoginMode
import com.seamfix.appmonitor.login.model.enums.LoginStatus
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val config = ConfigBuilder()
            .setBaseURL("http://10.158.13.105:8190")//set the base url

            .addHeader("Client-ID" to "smartclient")
            .addHeader("User-Agent" to "Smart Client for KYC [Build: 1.0.0, Install Date: NA]")
            .addHeader("User-UUID" to "10be74e7-3337-4e93-9114-c71707a7c220")
            .addHeader("sc-auth-key" to "AHVZ0xgM8X3ghf-1zBqnnAQO1nthw6dlik2zXTh1XpnWkbp" +
                    "FkGz4S8dL7u-2e1F6E2WKrQo9t4dfyVJib1_gk_in6O6oSHyN2w")
            .addHeader("Content-Type" to "application/x-www-form-urlencoded")
            .addHeader("User-Agent" to "Smart Client for KYC [Build: 1.2, Install Date: NA]")
            .addHeader("Accept" to "*/*")
            .addHeader("Accept-Encoding" to "gzip, deflate, br")
            .addHeader("Connection" to "keep-alive")
            .build()


        //Start the heart beat job:
        HeartBeat.runJob(this, object : HeartBeat.HeartbeatOperation{
            override fun getDeviceHeartBeat(): DeviceHeartBeatRequest {

                //Create your device heart beat and set the values you are interested in:
                val deviceHeartBeat = DeviceHeartBeatRequest()
                deviceHeartBeat.clientCurrentTime = System.currentTimeMillis().toString()

                return deviceHeartBeat
            }

            override fun getInterval(): Int {
                return 5000
            }

            override fun getConfig(): Config {
                return config
            }
        })

        //create a login attempt object
        val loginAttempt = LoginAttempt(
            "GLO-DN-921C",
            "jeffemuveyan@gmail.com",
            100000,
            "NA",
            LoginStatus.SUCCESS,
            "NA",
            LoginMode.ONLINE,
            LoginMethod.EMAIL)

        button.setOnClickListener {

            //save the login attempt object
            LoginAttemptManager.addLoginAttempt(this@MainActivity, config, loginAttempt)
        }

    }
}
