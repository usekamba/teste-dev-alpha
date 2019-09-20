package com.example.testekamba.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.testekamba.R;
import com.example.testekamba.models.activities;
import com.example.testekamba.services.KambaClient;
import com.example.testekamba.services.ServiceBuilder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Payment extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private PaymentAdapter adapter;
    private ArrayList<activities> payment_list=new ArrayList<>();
    private Call<List<activities>> call;
    private KambaClient kambaClient;
    private ProgressBar progressBar;
    private CollapsingToolbarLayout toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        toolbar = findViewById(R.id.toolbar);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        toolbar.setTitle("");
        //setSupportActionBar(toolbar);

        toolbarLayout =findViewById(R.id.toolbar_layout);

        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            boolean isShow = false;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + i == 0) {
                    isShow = true;
                } else if (isShow) {
                    isShow = false;
                }
            }
        });
        recyclerView=findViewById(R.id.recycler_payment);
        if(isNetworkConnected())
        {
            kambaClient = ServiceBuilder.createSevice();
            call = kambaClient.all_activities();
            CallKambaClient(call);
        }
        else {
            Toast.makeText(getApplicationContext(), "No internet Connection", Toast.LENGTH_LONG).show();
        }
    }


    private void CallKambaClient(Call<List<activities>> call) {
        call.enqueue(new Callback<List<activities>>() {

            @Override
            public void onResponse(Call<List<activities>> call, Response<List<activities>> response) {
                List<activities> activities;

                if(response.isSuccessful()) {
                    String string = response.body()!=null ? String.valueOf(response.code()):"null";
                    //Toast.makeText(getApplicationContext(),"Works good "+ string, Toast.LENGTH_LONG).show();
                    activities =response.body();
                    if(activities.size()>0)
                    {
                        payment_list.clear();
                        for (activities act :activities) {
                            if (act.getTransaction_type() != null) {
                                if (act.getTransaction_type().equals("Payment") || act.getTransaction_type().equals("PAYMENT")) {
                                    payment_list.add(act);
                                }
                            }
                        }
                                progressBar.setVisibility(View.GONE);
                                UpdateRecycler(payment_list);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "No Activity Availabe ", Toast.LENGTH_LONG).show();
                    }
                }
            }
            private void UpdateRecycler(ArrayList<activities> list) {
                adapter = new PaymentAdapter(list, getApplicationContext());
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
