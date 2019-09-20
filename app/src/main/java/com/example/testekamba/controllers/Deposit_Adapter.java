package com.example.testekamba.controllers;

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

public class Deposit_Adapter extends RecyclerView.Adapter<Deposit_Adapter.Withdrawal> {

    ArrayList<activities> activities;
    Context mContext;

    public Deposit_Adapter(ArrayList<activities> operations, Context mContext) {
        this.activities = operations;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Withdrawal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Withdrawal(LayoutInflater.from(mContext).inflate(R.layout.grid_withdrawal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Withdrawal holder, int position) {

        activities activity =activities.get(position);

         holder.amount.setText(activity.getAmount());
         holder.name_depos.setText(activity.getPayment_method().name);
         holder.desc_payment.setText(activity.getPayment_method().description);

          holder.iban.setText(activity.getBank_account().iban);
          holder.bank_number.setText(activity.getBank_account().number);

         holder.typeof.setText(activity.getBank_account().typeCof);
       holder.holder.setText(activity.getBank_account().holder);
          holder.bank_name.setText(activity.getBank_account().bank.name);
       holder.bank_description.setText(activity.getBank_account().bank.description);
         holder.date.setText(activity.getDate());


    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    public class Withdrawal extends RecyclerView.ViewHolder
    {

        private TextView amount, name_depos,  desc_payment, bank_number, holder, bank_name, date, bank_description, typeof, iban;

        public Withdrawal(@NonNull View itemView) {
            super(itemView);

            amount =itemView.findViewById(R.id.idAmount_Unity);
            name_depos=itemView.findViewById(R.id.id_name_depos);
            desc_payment=itemView.findViewById(R.id.id_descritpion_payment);
            bank_number=itemView.findViewById(R.id.id_mobile_operator);
            holder=itemView.findViewById(R.id.idHolder);
            bank_name=itemView.findViewById(R.id.idrecharge_price);
            date=itemView.findViewById(R.id.date);
            bank_description=itemView.findViewById(R.id.idBank_description_ba);
            typeof=itemView.findViewById(R.id.idtype_of);
            iban=itemView.findViewById(R.id.id_iban_pm);
        }
    }
}
