package com.example.testekamba.controllers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testekamba.R;
import com.example.testekamba.models.activities;

import java.util.ArrayList;
import java.util.List;

public class RechargeAdapter extends RecyclerView.Adapter <RechargeAdapter.ViewHolder>{

    private List<activities> activitiesList;
    private Context context;

    public RechargeAdapter(List<activities> activitiesList, Context context) {
        this.activitiesList = activitiesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.grid_tv_recharge, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        activities  activity=activitiesList.get(position);

        holder.id_recharge_code.setText(activity.getRecharge_code());
        holder.idrecharge_price.setText(activity.getRecharge_price());
        holder.id_mobile_operator_type.setText(activity.getId_mobile_operator_type());
        holder.idValidaty.setText(activity.getValidity_days());
        holder.id_mobile_operator.setText(activity.getMobile_operator_name());
    }

    @Override
    public int getItemCount() {
        return activitiesList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

    private TextView id_mobile_operator, id_recharge_code, idrecharge_price, idValidaty,id_mobile_operator_type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id_mobile_operator =itemView.findViewById(R.id.id_mobile_operator);
            id_recharge_code=itemView.findViewById(R.id.id_recharge_code);
            idrecharge_price=itemView.findViewById(R.id.idValidaty);
            idValidaty=itemView.findViewById(R.id.idValidaty);
            id_mobile_operator_type=itemView.findViewById(R.id.mobile_operator_type);
        }
    }
}
