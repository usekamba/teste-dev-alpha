package com.example.testekamba.controllers;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.testekamba.R;
import com.example.testekamba.models.activities;
import com.example.testekamba.services.KambaClient;
import com.example.testekamba.services.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_activities extends Fragment {


    private RecyclerView recyclerView;
    private ActivityAdapter adapter;
    private List<activities> activitiesArrayList;
    private SwipeRefreshLayout SwipeRefresh;
    private KambaClient kambaClient;
    private Call<List<activities>> call;
    private ImageView img_Not_Found;
    private TextView text_No_connection;
    private Toolbar toolbar;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view =inflater.inflate(R.layout.fragment_activities, container, false);



       SwipeRefresh=view.findViewById(R.id.SwipeRefresh);
       SwipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
       SwipeRefresh.setRefreshing(true);

       recyclerView =view.findViewById(R.id.general_recycler);
       activitiesArrayList=new ArrayList<>();
       img_Not_Found=view.findViewById(R.id.img_error_not_found);
       text_No_connection=view.findViewById(R.id.text_error);

       adapter = new ActivityAdapter(activitiesArrayList, this.getContext());

       SwipeRefresh.setOnRefreshListener(() -> {
           if(isNetworkConnected())
           {
               recyclerView.setVisibility(View.VISIBLE);
               img_Not_Found.setVisibility(View.GONE);
               text_No_connection.setVisibility(View.GONE);
               CallKambaClient(call);
           }
           else {
               recyclerView.setVisibility(View.GONE);
               img_Not_Found.setVisibility(View.VISIBLE);
               text_No_connection.setVisibility(View.VISIBLE);
               SwipeRefresh.setRefreshing(false);
           }

       });

         kambaClient = ServiceBuilder.createSevice();
         call =kambaClient.all_activities();

         CallKambaClient(call);


       return view;
    }
    private void CallKambaClient(Call<List<activities>> call) {
        recyclerView.setVisibility(View.VISIBLE);
        img_Not_Found.setVisibility(View.GONE);
        text_No_connection.setVisibility(View.GONE);

        call.clone().enqueue(new Callback<List<activities>>() {

            @Override
            public void onResponse(Call<List<activities>> call, Response<List<activities>> response) {
                List<activities> activity;
                if(response.isSuccessful()) {

                    String string = response.body()!=null ? String.valueOf(response.code()):"null";

                    //Toast.makeText(getApplicationContext(),"Works good "+ string, Toast.LENGTH_LONG).show();
                    //activities =response.body()
                   activity =response.body();
                   for(activities act : activity)
                    {
                        if(act.getTransaction_type()!=null )
                        {
                            activitiesArrayList.add(act);
                        }


                    }
                    if(activitiesArrayList.size()>0)
                    {

                        SwipeRefresh.setRefreshing(false);
                        UpdateRecycler(activitiesArrayList);
                    }
                    else {
                        Toast.makeText(getContext(), "No Activity Availabe ", Toast.LENGTH_LONG).show();
                    }
                }
            }
            private void UpdateRecycler(List<activities> list) {
                SwipeRefresh.setRefreshing(false);
                adapter = new ActivityAdapter(list, getContext());
                adapter.notifyDataSetChanged();
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<activities>> call, Throwable t) {
                Toast.makeText(getContext(), "Error "+t.getMessage(), Toast.LENGTH_LONG).show();
                Hide();
            }
        });
    }

    private void Hide() {
        SwipeRefresh.setRefreshing(false);
        recyclerView.setVisibility(View.VISIBLE);
        img_Not_Found.setVisibility(View.GONE);
        text_No_connection.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        img_Not_Found.setVisibility(View.VISIBLE);
        text_No_connection.setVisibility(View.VISIBLE);
    }

    private boolean isNetworkConnected()
    {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
        
        if(networkInfo!=null &&  networkInfo.isConnected())
        {
            connected=true;
        }
        return connected;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().show();
    }
}
