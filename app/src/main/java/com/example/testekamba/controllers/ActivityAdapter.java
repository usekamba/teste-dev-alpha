package com.example.testekamba.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testekamba.*;
import com.example.testekamba.models.activities;


import java.util.ArrayList;
import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {

    List<activities> activitieslist;
    Context context;


    public ActivityAdapter(List<activities> activitieslist, Context context) {
        this.activitieslist = activitieslist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.grid_general,parent, false ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        activities activity =activitieslist.get(position);

        String content="";
        String date =activity.getDate();
        String status =activity.getStatus() !=null ?activity.getStatus() :"";

        if(status.equals("RECHARGED"))
        {
            status="RECARREGADO";
        }
        else if(status.equals("PAID"))
        {
            status="PAGO";

        }
        else if(status.equals("WAITING"))
        {
            status="ESPERANDO";

        }
        if(activity.getTransaction_type()!=null) {
            switch (activity.getTransaction_type()) {
                case "PAYMENT":
                    String to_user = activity.getToUser().firstname + " " + activity.getToUser().lastname;
                    content = "Pagaste a " + to_user;
                    holder.head.setText(content);
                    holder.subhead_2.setText(date);
                    holder.subhead1.setText(activity.getDescription());
                    holder.amount_paid.setText("Kz " + activity.getAmount());
                    Glide.with(context).load(R.drawable.ic_payment_edit).into(holder.photo);
                    break;

                case "DEPOSIT":
                    String deposit = "Depositar na conta do " + activity.getBank_account().holder;
                    holder.head.setText(deposit);
                    String description = activity.getBank_account().bank.name + "\n" + activity.getBank_account().bank.description;
                    holder.subhead_2.setText(status);
                    holder.subhead1.setText(description);
                    holder.amount_paid.setText("Kz " + activity.getAmount());
                    Glide.with(context).load(R.drawable.ic_deposit_edit).into(holder.photo);
                    break;

                case "RECHARGE":

                    String recharge = "Recarregar o saldo " + activity.getMobile_operator_name();
                    holder.head.setText(recharge);
                    holder.subhead_2.setText(status);
                    holder.subhead1.setText(activity.getMobile_operator_type());
                    holder.amount_paid.setText("kz "+activity.getAmount_paid());
                    Glide.with(context).load(R.drawable.ic_recharge).into(holder.photo);
                    break;
                default:
                    activitieslist.remove(activity);
                    break;

            }

        }

    }

    @Override
    public int getItemCount() {
        return activitieslist.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
         //Payment variables
        private ImageView photo;
        private TextView head, amount_paid, subhead_2, subhead1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

          photo =itemView.findViewById(R.id.photo);
          head=itemView.findViewById(R.id.head);
          amount_paid=itemView.findViewById(R.id.subhead_amount);
          subhead_2 =itemView.findViewById(R.id.subhead2);
          subhead1 =itemView.findViewById(R.id.subhead1);



        }
    }
}
