package com.seamfix.appmonitor.login.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.seamfix.appmonitor.login.model.enums.LoginMethod
import com.seamfix.appmonitor.login.model.enums.LoginMode
import com.seamfix.appmonitor.login.model.enums.LoginStatus

@Keep
@Entity(tableName = "login_attempt")
data class LoginAttempt(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                        val email: String,
                        val loginDuration: Long,
                        val loginType: String,
                        val loginStatus: LoginStatus,
                        val loginFailureReason: String,
                        val loginMode: LoginMode,
                        val loginMethod: LoginMethod)