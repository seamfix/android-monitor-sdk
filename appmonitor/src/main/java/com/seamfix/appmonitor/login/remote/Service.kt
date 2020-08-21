package com.seamfix.appmonitor.login.remote

import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.response.LoginAttemptResponse
import retrofit2.Response
import retrofit2.http.*

interface Service {

    @POST("/biocapture/audit/alog")
    suspend fun sync(@Body loginAttempt: LoginAttempt): Response<LoginAttemptResponse>
}