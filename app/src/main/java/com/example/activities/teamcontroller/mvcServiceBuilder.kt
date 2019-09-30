package com.example.activities.teamcontroller

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object  mvcServiceBuilder
{
    private const val URL ="https://kamba-api-staging.herokuapp.com/v1/users/"

    private val logger=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    val headerInterceptor =object : Interceptor
    {
        override fun intercept(chain: Interceptor.Chain): Response {

            var request =chain.request();

            request =request.newBuilder()
                .addHeader("Authorization", "Token VS7elyzN7ZqMNcQmQA5Cjgtt")
                .addHeader("Content-Type", "application/json")
                .build()

            val response =chain.proceed(request)

            return response
        }

    }

    private val OkHttp =OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)

    private val builder =Retrofit.Builder().baseUrl(URL).
        addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .client(OkHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}