package com.seamfix.appmonitortester

import android.content.Context
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
import kotlinx.android.parcel.Parcelize


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val config = ConfigBuilder()
            //set the base url
            .setBaseURL("https://servicecloud.bioregistra.com")
            .addEndPoints("br", "device-heartbeat", "api", "v1", "save")
            .addHeader("sc-auth-key" to "57662cef-cd4a-4e5b-87dc-f0ef7481ef84")
            .addHeader("br-auth-key" to "Mg44yZaLFFFvDOnLi3MSXOrj/ru0mzGwR4dPLti1fmV7/" +
                    "Kj4VMIbXNIfh/IVJrz0kESMSNR5ki8cED59bxU7/A==")
            .addHeader("br-tag" to "testseun@yopmail.com")
            .addHeader("br-client-type" to "portal")
            .addHeader("br-time" to "1605171344913")
            .addHeader("Content-Type" to "application/json")
            .addHeader("Accept" to "*/*")
            .addHeader("Accept-Encoding" to "gzip, deflate, br")
            .addHeader("Connection" to "keep-alive")
            .build()

        // Start the heart beat job:
        HeartBeat.runJob(this, @Parcelize object : HeartBeat.HeartbeatOperation{
            override fun getDeviceHeartBeat(context: Context): DeviceHeartBeatRequest {

                //Create your device heart beat and set the values you are interested in:
                val deviceHeartBeat = DeviceHeartBeatRequest()
                deviceHeartBeat.clientUptime = System.currentTimeMillis()

                return deviceHeartBeat
            }

            override fun getInterval(): Long {
                return 5000
            }

            override fun getConfig(context: Context): Config {
                return config
            }
        })
    }
}
