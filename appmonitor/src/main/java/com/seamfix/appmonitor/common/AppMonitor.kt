package com.seamfix.appmonitor.common

object AppMonitor {
    var config: Config = ConfigBuilder()//set the default default values for config:
        .setBaseURL("http://10.158.13.105:8190")
        .addHeader("Content-Type" to "application/x-www-form-urlencoded")
        .addHeader("User-Agent" to "Smart Client for KYC [Build: 1.2, Install Date: NA]")
        .addHeader("Accept" to "*/*")
        .addHeader("Accept-Encoding" to "gzip, deflate, br")
        .addHeader("Connection" to "keep-alive")
        .build()
}