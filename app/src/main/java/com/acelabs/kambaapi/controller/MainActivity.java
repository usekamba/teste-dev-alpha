package com.acelabs.kambaapi.controller;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.acelabs.kambaapi.R;
import com.acelabs.kambaapi.api.Client;
import com.acelabs.kambaapi.api.Service;
import com.acelabs.kambaapi.model.Activity;
import com.acelabs.kambaapi.model.MainAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private String token = "VS7elyzN7ZqMNcQmQA5Cjgtt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);

        //This divides the recyclerview items with an horizontal line
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, mLayoutManager.getOrientation());

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadJSON();

    }

    // Setting up Retrofit
    private void loadJSON(){

        try {
            //Creating service instance
            Service apiService = Client.getClient().create(Service.class);
            Call<ArrayList<Activity>> call = apiService.getActivities("Token token=" + token);

            call.enqueue(new Callback<ArrayList<Activity>>() {
                @Override
                public void onResponse(Call<ArrayList<Activity>> call, Response<ArrayList<Activity>> response) {

                    //Creating an Adapter with the Context and the ArrayList of Activities
                    //returned by the Kamba API
                    mAdapter = new MainAdapter(getApplicationContext(),response.body());

                    //Setting the RecyclerView Adapter
                    mRecyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onFailure(Call<ArrayList<Activity>> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(MainActivity.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


}
