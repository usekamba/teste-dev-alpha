package com.example.testekamba.services;

import com.example.testekamba.models.activities;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface KambaClient {

    @Headers({"Authorization:Token VS7elyzN7ZqMNcQmQA5Cjgtt",
            "Content-Type: application/json"})
    @GET("activities")
    Call<List<activities>> all_activities();



}
