package com.seamfix.appmonitortester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seamfix.appmonitor.heartbeat.HeartBeat
import com.seamfix.appmonitor.login.LoginAttemptManager
import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.enums.LoginMethod
import com.seamfix.appmonitor.login.model.enums.LoginMode
import com.seamfix.appmonitor.login.model.enums.LoginStatus
import com.sf.rest.request.device.DeviceHeartBeat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Start the heart beat job:
        HeartBeat.runJob(this, 5000, object : HeartBeat.HeartbeatOperation{

            override fun getDeviceHeartBeat(): com.sf.rest.request.device.DeviceHeartBeat {

                //Create your device heart beat and set the values you are interested in:
                val deviceHeartBeat = DeviceHeartBeat()
                deviceHeartBeat.setClientCurrentTime(Date())

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
