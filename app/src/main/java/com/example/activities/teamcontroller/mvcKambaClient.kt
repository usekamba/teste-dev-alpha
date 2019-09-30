package com.example.activities.teamcontroller
import com.example.activities.model.activities
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface mvcKambaClient
{
    @Headers("Authorization:Token VS7elyzN7ZqMNcQmQA5Cjgtt", "Content-Type: application/json")
    @GET("activities")
    fun getActivities():Call<List<activities>>

}

