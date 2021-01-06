package com.seamfix.appmonitortester

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seamfix.appmonitor.common.Config
import com.seamfix.appmonitor.common.ConfigBuilder
import com.seamfix.appmonitor.heartbeat.HeartBeat
import com.seamfix.appmonitor.heartbeat.model.DeviceHeartBeatRequest
import com.seamfix.appmonitor.services.HeartbeatService
import kotlinx.android.parcel.Parcelize


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start heartbeat
//        HeartBeat.runJob(this, object : HeartBeat.HeartbeatOperation{
//            override fun getDeviceHeartBeat(): DeviceHeartBeatRequest {
//
//                //Create your device heart beat and set the values you are interested in:
//                val deviceHeartBeat = DeviceHeartBeatRequest()
//                deviceHeartBeat.clientUptime = System.currentTimeMillis()
//
//                return deviceHeartBeat
//            }
//
//            override fun getInterval(): Long {
//                return 5000
//            }
//
//            override fun getConfig(): Config {
//                return ConfigBuilder()
//                    //set the base url
//                    .setBaseURL("https://servicecloud.bioregistra.com")
//                    .addEndPoints("br", "device-heartbeat", "api", "v1", "save")
//                    .addHeader("sc-auth-key" to "57662cef-cd4a-4e5b-87dc-f0ef7481ef84")
//                    .addHeader(
//                        "br-auth-key" to "Mg44yZaLFFFvDOnLi3MSXOrj/ru0mzGwR4dPLti1fmV7/" +
//                                "Kj4VMIbXNIfh/IVJrz0kESMSNR5ki8cED59bxU7/A=="
//                    )
//                    .addHeader("br-tag" to "testseun@yopmail.com")
//                    .addHeader("br-client-type" to "portal")
//                    .addHeader("br-time" to "1605171344913")
//                    .addHeader("Content-Type" to "application/json")
//                    .addHeader("Accept" to "*/*")
//                    .addHeader("Accept-Encoding" to "gzip, deflate, br")
//                    .addHeader("Connection" to "keep-alive")
//                    .build()
//            }
//        })

        // Start heart beat as a service:
        val intent = Intent(this, HeartbeatService::class.java)
        intent.putExtra(
            HeartbeatService.HEARTBEAT_OPERATION,
            @Parcelize object : HeartBeat.ParceledHeartbeatOperation {
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
                    return ConfigBuilder()
                        //set the base url
                        .setBaseURL("https://servicecloud.bioregistra.com")
                        .addEndPoints("br", "device-heartbeat", "api", "v1", "save")
                        .addHeader("sc-auth-key" to "57662cef-cd4a-4e5b-87dc-f0ef7481ef84")
                        .addHeader(
                            "br-auth-key" to "Mg44yZaLFFFvDOnLi3MSXOrj/ru0mzGwR4dPLti1fmV7/" +
                                    "Kj4VMIbXNIfh/IVJrz0kESMSNR5ki8cED59bxU7/A=="
                        )
                        .addHeader("br-tag" to "testseun@yopmail.com")
                        .addHeader("br-client-type" to "portal")
                        .addHeader("br-time" to "1605171344913")
                        .addHeader("Content-Type" to "application/json")
                        .addHeader("Accept" to "*/*")
                        .addHeader("Accept-Encoding" to "gzip, deflate, br")
                        .addHeader("Connection" to "keep-alive")
                        .build()
                }
            })
        startService(intent)
    }
}
