package com.filomenadeveloper.teste_alpha

import com.filomenadeveloper.teste_alpha.models.Activities
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface Cruds {
// Construção da estrutura  e tipo de requisão a ser feita na api
    @GET("/v1/users/activities")
    fun getUserActivity(): Call<List<Activities>>


}