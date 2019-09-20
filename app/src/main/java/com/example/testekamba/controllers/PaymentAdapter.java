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
import com.example.testekamba.R;
import com.example.testekamba.models.activities;

import java.util.ArrayList;

public class PaymentAdapter  extends RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder> {

    private ArrayList<activities> activitiesList;
    private Context context;

    public PaymentAdapter(ArrayList<activities> activitiesList, Context context) {
        this.activitiesList = activitiesList;
        this.context = context;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaymentViewHolder(
                LayoutInflater.from(context).inflate(R.layout.grid_payment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {

        activities activities =activitiesList.get(position);

        holder.amount.setText(activities.getAmount() +" kz");
        holder.subtotal.setText(activities.getSubtotal());
        holder.description.setText(activities.getDescription()+" kz");

        //From
        holder.from_Name.setText(activities.getFromUser().firstname +" "+ activities.getFromUser().lastname);
        holder.from_PhoneNumer.setText(""+activities.getFromUser().phone);
        holder.from_Email.setText(""+activities.getFromUser().email);

        String from_Url =activities.getFromUser().profile_photo;
        String to_Url=activities.getToUser().profile_photo;

        if(from_Url==null)
        {
            Glide.with(context).load(R.drawable.ic_user).into(holder.from_profile_photo);

        }
        else
        {
            Glide.with(context).load(from_Url).into(holder.from_profile_photo);

        }
        if(to_Url==null)
        {
            Glide.with(context).load(R.drawable.ic_user).into(holder.to_profile_photo);
        }
        else
        {

            Glide.with(context).load(to_Url).into(holder.to_profile_photo);
        }
        //To
        holder.to_Name.setText(activities.getToUser().firstname +" "+ activities.getToUser().lastname);
        holder.to_PhoneNumer.setText(""+activities.getToUser().phone);
        holder.to_Email.setText(""+activities.getToUser().email);


    }

    @Override
    public int getItemCount() {
        return activitiesList.size();
    }

    public class PaymentViewHolder extends RecyclerView.ViewHolder {

        private TextView amount, subtotal,  fee , from_Name,
                from_Email, from_PhoneNumer, to_Name, to_Email, to_PhoneNumer, description;
        private ImageView from_profile_photo, to_profile_photo;

        PaymentViewHolder(@NonNull View itemView) {
            super(itemView);
            amount =itemView.findViewById(R.id.idAmount_Unity);
            subtotal=itemView.findViewById(R.id.idsubtotal);
            from_Name=itemView.findViewById(R.id.idfromUserName);
            from_PhoneNumer =itemView.findViewById(R.id.idfromUserNumber);
            from_Email=itemView.findViewById(R.id.idfromUserEmail);
            to_Name=itemView.findViewById(R.id.idtoUserName);
            to_PhoneNumer=itemView.findViewById(R.id.idtoUserNumber);
            to_Email=itemView.findViewById(R.id.idtoUserEmail);
            description=itemView.findViewById(R.id.id_name_depos);
            from_profile_photo=itemView.findViewById(R.id.fromUser);
            to_profile_photo=itemView.findViewById(R.id.photo);

        }
    }
}
