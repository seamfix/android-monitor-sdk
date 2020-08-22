package com.seamfix.appmonitortester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val loginAttempt = LoginAttempt(0,
            "jeffemuveyan@gmail.com",
            100000,
            "NA",
            LoginStatus.SUCCESS,
            "NA",
            LoginMode.ONLINE,
            LoginMethod.EMAIL)

        button.setOnClickListener {

        }

    }
}
