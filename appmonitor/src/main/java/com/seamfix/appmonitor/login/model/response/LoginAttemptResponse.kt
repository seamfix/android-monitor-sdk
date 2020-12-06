package com.seamfix.appmonitor.login.model.response

import androidx.annotation.Keep

@Keep
internal data class LoginAttemptResponse(val description : String,
                                val responseCode: Int,
                                val responseDescription : String,
                                val token : Any?,
                                val responseParams: Any?,
                                val message : String,
                                val code : Int,
                                val id: Any?)