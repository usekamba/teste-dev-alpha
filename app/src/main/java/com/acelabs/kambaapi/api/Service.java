package com.acelabs.kambaapi.api;

import com.acelabs.kambaapi.model.Activity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface Service {

    //Setting up the GET Http request to Kamba API end-point
    // along with a static and a dynamic header and to expect an ArrayList of Activities
    @Headers("Content-Type: application/json")
    @GET("v1/users/activities")
    Call<ArrayList<Activity>> getActivities(@Header("Authorization") String auth);


}
