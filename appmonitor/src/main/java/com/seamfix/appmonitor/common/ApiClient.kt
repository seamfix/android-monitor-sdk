package com.seamfix.appmonitor.common

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

internal object ApiClient {

    private lateinit var config: Config

    fun getClient(context: Context): Retrofit{
        config = AppMonitor.config
        val collectedHeaders = config.headers

        val httpClient =  OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request();
            val requestBuilder = original.newBuilder()

            for(header in collectedHeaders){
                requestBuilder.addHeader(header.first, header.second)
            }

            requestBuilder.method(original.method(), original.body())
            val request = requestBuilder.build()

            chain.proceed(request);
        }

        val  client = httpClient.build()

        return Retrofit.Builder()
            .baseUrl(config.baseURL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}