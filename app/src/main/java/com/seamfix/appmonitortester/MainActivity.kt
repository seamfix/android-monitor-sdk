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
            .setBaseURL("http://10.158.13.105:8190")//set the base url

            .addHeader("Mac-Address" to "AHVZ0xjKtAKKWJQGPATmhhieuGCa0uYpNwhiBO8fqROnyWMULZIow6IchnPBPogwAmIoBHGj2JLeN6j9THnL4f4B_dhcQr0c-g")
            .addHeader("Client-ID" to "smartclient")
            .addHeader("User-Agent" to "Smart Client for KYC [Build: 1.0.0, Install Date: NA]")
            .addHeader("User-UUID" to "755facd3-8556-4ef2-84fc-884279978be9")
            .addHeader("sc-auth-key" to "AHVZ0xhboOeVb_UiSww5Ozq66_Oh856fE2fqO7anzgFdaZviFO-9cjYHN7mzi4WDC2w_g4NoPcnujXCaVTT5m9b135OntoS_13Ywg6aBHsuMWfwsQPXdVMcx_VMNd2fMM3yWSGFSFpby4ajtdrEe7WfPdEEg4QaXtPQwoq-8Cl5jHBv9HRCUFlM")
            .addHeader("Device-ID" to "AHVZ0xizFFUGX0Oa4jGqW34l4HPENlaVCs2EPbAvqTf87EldBIjvrOVLIroGkbZYuGcfpVqBfOj3PGXYPAu_jzb49qU1L3jsmw")
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
