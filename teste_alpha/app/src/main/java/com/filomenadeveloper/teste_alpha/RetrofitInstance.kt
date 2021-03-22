package com.filomenadeveloper.teste_alpha

import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private const val BASE_URL ="https://kamba-api-staging.herokuapp.com"

    // Definir o endereço da api, passar os cabeçalho como tipo do formato da resposta e passar o dados de autorização a api
    // E fazer a conversão da resposta dada pela api
    fun <Api> buildApi(api : Class<Api>,token:String? = null): Api {
       return Retrofit.Builder().baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.header("Content-Type","application/json").header("Authorization", "Token $token")
                }.build())
            }.also { client ->
                if (BuildConfig.DEBUG) {
                    val loggin = HttpLoggingInterceptor()
                    loggin.setLevel(HttpLoggingInterceptor.Level.HEADERS)
                    client.addInterceptor(loggin)
                }
            }.build()
            ).addConverterFactory(GsonConverterFactory.create()).build().create(api)
    }
}