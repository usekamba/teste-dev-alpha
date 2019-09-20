package com.example.testekamba.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.testekamba.*;
import com.example.testekamba.models.activities;
import com.example.testekamba.services.KambaClient;
import com.example.testekamba.services.ServiceBuilder;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepositActivity extends AppCompatActivity {


    private Deposit_Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<activities> activitiesArrayList;
    private Call<List<activities>> call;
    private KambaClient kambaClient;
   private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        activitiesArrayList = new ArrayList<>();

        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView=findViewById(R.id.deposit_recycler);
        if(isNetworkConnected())
        {
            kambaClient = ServiceBuilder.createSevice();
            call = kambaClient.all_activities();
            CallKambaClient(call);

        }
        else {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "No internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    private void CallKambaClient(Call<List<activities>> call) {
        call.enqueue(new Callback<List<activities>>() {

            @Override
            public void onResponse(Call<List<activities>> call, Response<List<activities>> response) {
                List<activities> activities;
                progressBar.setVisibility(View.GONE);

                if(response.isSuccessful()) {
                    String string = response.body()!=null ? String.valueOf(response.code()):"null";
                    //Toast.makeText(getApplicationContext(),"Works good "+ string, Toast.LENGTH_LONG).show();
                    activities =response.body();
                    if(activities.size()>0)
                    {
                        activitiesArrayList.clear();
                        for (activities act :activities) {
                            if (act.getTransaction_type() != null) {
                                if (act.getTransaction_type().equals("DEPOSIT")) {
                                    activitiesArrayList.add(act);
                                }
                            }
                        }
                     //   progressBar.setVisibility(View.GONE);
                        UpdateRecycler(activitiesArrayList);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "No Activity Availabe ", Toast.LENGTH_LONG).show();

                    }
                }
            }
            private void UpdateRecycler(ArrayList<activities> list) {
                adapter = new Deposit_Adapter(list, getApplicationContext());
                adapter.notifyDataSetChanged();
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<activities>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error "+t.getMessage(), Toast.LENGTH_LONG).show();
               progressBar.setVisibility(View.GONE);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        call = kambaClient.all_activities();
        CallKambaClient(call);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    private boolean isNetworkConnected()
    {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null &&  networkInfo.isConnected())
        {
            connected=true;
        }
        return connected;
    }

}


