package com.seamfix.appmonitor.common

import android.content.Context
import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

internal object ApiClient {

    fun getClient(context: Context, config: Config): Retrofit{
        val collectedHeaders = config.headers

        val httpClient =  OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request();
            val requestBuilder = original.newBuilder()

            try {
                for(header in collectedHeaders){
                    requestBuilder.addHeader(header.first, header.second)
                }
            } catch (e: Exception) {
                Log.e(ApiClient::class.java.simpleName, "Error generating headers")
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