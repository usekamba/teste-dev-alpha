package com.example.testekamba.services;

import android.content.Context;
import android.content.res.Resources;

import com.example.testekamba.R;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class ServiceBuilder {

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();


    static String URL = "https://kamba-api-staging.herokuapp.com/v1/users/";
   static Context context;
   static OkHttpClient.Builder OkhttpClient =new OkHttpClient.Builder().addInterceptor(
            new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original =chain.request();

                    Request request=original.newBuilder()
                           .header("Authorization", "Token VS7elyzN7ZqMNcQmQA5Cjgtt")
                            .header("Content-Type", "application/json")
                            .build();
                    return chain.proceed(request);
                }
            }
    );

   static  OkHttpClient client = OkhttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel
           (HttpLoggingInterceptor.Level.BODY)).
           build();

    public static Retrofit builder =new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(client)
            .build();


    public  static KambaClient createSevice()
    {
        return builder.create(KambaClient.class);
    }



}
