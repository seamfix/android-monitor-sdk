package com.seamfix.appmonitor.common

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

internal object ApiClient {

    fun getClient(context: Context): Retrofit{

        val httpClient =  OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request();

            val request = original.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")

                .method(original.method(), original.body())
                .build()

            chain.proceed(request);
        }

        val  client = httpClient.build()

        return Retrofit.Builder()
            .baseUrl("http://13.56.69.207:8190")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}