package com.seamfix.appmonitor.common

import com.seamfix.appmonitor.heartbeat.model.DeviceHeartBeatRequest
import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.response.LoginAttemptResponse
import retrofit2.Response
import retrofit2.http.*

internal interface Service {

    @POST("/biocapture/audit/alog")
    suspend fun sync(@Body loginAttempt: List<LoginAttempt>): Response<List<LoginAttemptResponse>>

    /**
     * @param deviceHeartBeat the device information that is sent to server
     * @return String
     */
    @POST("/biocapture/heartbeat/")
    suspend fun sync(@Body deviceHeartBeat: DeviceHeartBeatRequest): Response<String>

    /**
     * @param endPoint url path where the heartbeat request is sent
     * @param deviceHeartBeat the device information that is sent to server
     * @return String
     */
    @POST("{path}")
    suspend fun sync(@Path("path", encoded = true) endPoint: String, @Body deviceHeartBeat: DeviceHeartBeatRequest): Response<String>
}