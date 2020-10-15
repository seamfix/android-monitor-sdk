package com.seamfix.appmonitor.login.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.seamfix.appmonitor.login.model.enums.LoginMethod
import com.seamfix.appmonitor.login.model.enums.LoginMode
import com.seamfix.appmonitor.login.model.enums.LoginStatus

@Keep
@Entity(tableName = "login_attempt")
data class LoginAttempt(var kitTag : String,
                        val username: String,
                        var activityStartTime: Long,
                        var activityEndTime: Long,
                        val loginType: String,
                        val loginStatus: LoginStatus,
                        val failureReason: String,
                        val loginMode: LoginMode,
                        val loginMethod: LoginMethod){

    @PrimaryKey(autoGenerate = true) var id: Int = 0
    var macAddress: String = ""
    var fullName : String = ""
    var activity : String = ""
    var duration = this.activityStartTime - this.activityEndTime
    var enrollmentRef: String = ""
    var activityCode : String = ""
    var refDeviceId : String = ""
    var realTimeDeviceId : String = ""
    var appVersion : Double = 0.00
    var failureCount : Int = 0
    var networkStrength : String = ""
    var syncFileStatus : String = ""
    var syncTransferMode : String = ""
    var syncFileName : String = ""
    var networkType : String = ""
    var networkStatus : String = ""
    var extensionCount : Int = 0
    var pointOfTermination : String = ""
    var terminationFlag : String = ""
    var phoneNumber: String = ""
    var simSerial: String = ""
    var info1 : String = ""
    var info2 : String = this.loginMode.name
    var info3 : String = ""
    var info4 : String = this.loginMethod.name
    var info5 : String = this.loginStatus.name
}