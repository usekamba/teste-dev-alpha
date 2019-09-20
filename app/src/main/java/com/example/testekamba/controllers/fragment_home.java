package com.example.testekamba.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.testekamba.R;
import com.example.testekamba.models.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class fragment_home extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private ClientOperationAdapter adapterRecycler;
    private List<Operation> operations;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayout linearLayout;
    private TextView textTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragement_home, container, false );

        recyclerView =view.findViewById(R.id.idOperationRecycler);
        swipeRefreshLayout=view.findViewById(R.id.idRefresh);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        linearLayout=view.findViewById(R.id.LinearError);
        textTitle=view.findViewById(R.id.hometitle);

        if(!isNetworkConnected())
        {textTitle.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            linearLayout.setVisibility(View.VISIBLE);
            swipeRefreshLayout.setRefreshing(false);
            textTitle.setVisibility(View.GONE);
        }
        operations =new ArrayList<>();

        InputData();
        recyclerView.setLayoutManager(new GridLayoutManager( this.getContext(), 2 ));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterRecycler);



        swipeRefreshLayout.setOnRefreshListener(() -> {
            linearLayout.setVisibility(View.INVISIBLE);
            if(isNetworkConnected())
            {
              //  swipeRefreshLayout.setEnabled(true);
                linearLayout.setVisibility(View.GONE);
               // swipeRefreshLayout.setRefreshing(false);
                textTitle.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);

                InputData();

            }
            else {
                 recyclerView.setVisibility(View.GONE);
                 linearLayout.setVisibility(View.VISIBLE);
                 swipeRefreshLayout.setRefreshing(false);
                 textTitle.setVisibility(View.GONE);
            }

        });
        return view;
    }

    private void InputData() {

        operations.clear();
        TypedArray operationName =getResources().obtainTypedArray(R.array.operation_img_list);
        String [] strings =getResources().getStringArray(R.array.operation_name_list);
        for (int i=0; i<strings.length; i++)
        {
            operations.add(new Operation(operationName.getResourceId(i, 0), strings[i]));
        }

        adapterRecycler = new ClientOperationAdapter(this.getContext(), operations,
                new ClientOperationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Operation operation) {
                switch (operation.getOperationName())
                {
                    case "Pagamento": startActivity(new Intent(getContext(), Payment.class));
                        break;
                    case "Depósito": startActivity(new Intent(getContext(), DepositActivity.class ));

                    break;

                    case "Levantamento"://startActivity(new Intent(getContext(), DepositActivity.class ));
                        Toast.makeText(getActivity(), "Not available at moment", Toast.LENGTH_LONG).show();
                        break;
                    case "Recarga" :startActivity(new Intent(getContext(), Recharge.class ));
                }
            }
        });
        adapterRecycler.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);

    }

    private boolean isNetworkConnected()
    {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) Objects.requireNonNull(getActivity()).getSystemService(Context.CONNECTIVITY_SERVICE);

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
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().show();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().show();
    }
}
