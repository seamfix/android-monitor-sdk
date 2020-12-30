package com.seamfix.appmonitor.common

import com.seamfix.appmonitor.heartbeat.model.DeviceHeartBeatRequest
import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.response.LoginAttemptResponse
import retrofit2.Response
import retrofit2.http.*

internal interface Service {

    @POST("/biocapture/audit/alog")
    suspend fun sync(@Body loginAttempt: List<LoginAttempt>): Response<List<LoginAttemptResponse>>

    @POST("{path}")
    suspend fun sync(@Path("path", encoded = true) endPoint: String, @Body deviceHeartBeat: DeviceHeartBeatRequest): Response<String>
}