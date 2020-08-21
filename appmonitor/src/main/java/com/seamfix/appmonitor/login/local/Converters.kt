package com.seamfix.appmonitor.login.local

import androidx.annotation.Keep
import androidx.room.TypeConverter
import com.seamfix.appmonitor.login.model.enums.LoginMethod
import com.seamfix.appmonitor.login.model.enums.LoginMode
import com.seamfix.appmonitor.login.model.enums.LoginStatus

@Keep
class Converters {

    @TypeConverter
    fun loginStatusToString(loginStatus: LoginStatus): String{
        return loginStatus.name
    }

    @TypeConverter
    fun stringToLoginStatus(string: String): LoginStatus{
        return enumValueOf<LoginStatus>(string.toUpperCase())
    }


    @TypeConverter
    fun loginModeToString(loginMode: LoginMode): String{
        return loginMode.name
    }

    @TypeConverter
    fun stringToLoginMode(string: String): LoginMode{
        return enumValueOf<LoginMode>(string.toUpperCase())
    }


    @TypeConverter
    fun loginMethodToString(loginMethod: LoginMethod): String{
        return loginMethod.name
    }

    @TypeConverter
    fun stringToLoginMethod(string: String): LoginMethod{
        return enumValueOf<LoginMethod>(string.toUpperCase())
    }
}