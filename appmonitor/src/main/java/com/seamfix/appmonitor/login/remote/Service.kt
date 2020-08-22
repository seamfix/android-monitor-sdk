package com.seamfix.appmonitor.login.remote

import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.response.LoginAttemptResponse
import retrofit2.Response
import retrofit2.http.*

internal interface Service {

    @POST("/biocapture/audit/alog")
    suspend fun sync(@Body loginAttempt: List<LoginAttempt>): Response<List<LoginAttemptResponse>>
}