package com.acelabs.kambaapi.model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.acelabs.kambaapi.R;
import com.acelabs.kambaapi.controller.DetailActivity;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Activity> mActivities;

    public MainAdapter(Context context, ArrayList<Activity> activities){
        this.context = context;
        this.mActivities = activities;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.mTransaction_type.setText(mActivities.get(position).getTransaction_type());

    }

    @Override
    public int getItemCount() {
        return mActivities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTransaction_type;

        public ViewHolder(View itemView) {
                        super(itemView);

                    mTransaction_type = (TextView) itemView.findViewById(R.id.transaction_type);

                    itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                    int pos = getAdapterPosition();
                    //Checking if item still exist
                    if(pos != RecyclerView.NO_POSITION){
                        Activity clickedDataItem = mActivities.get(pos);

                        if(clickedDataItem.getTransaction_type().equals("PAYMENT")){
                            Intent intent = new Intent(context, DetailActivity.class);

                            intent.putExtra("transaction_type", clickedDataItem.getTransaction_type());
                            intent.putExtra("to", clickedDataItem.getTo().getFirstname()+" "+clickedDataItem.getTo().getLastname());
                            intent.putExtra("amount", String.valueOf(clickedDataItem.getAmount()));
                            intent.putExtra("description", clickedDataItem.getDescription());
                            intent.putExtra("date", clickedDataItem.getCreated_at());

                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }else if(clickedDataItem.getTransaction_type().equals("WITHDRAWAL")){
                            Intent intent = new Intent(context, DetailActivity.class);

                            intent.putExtra("transaction_type", clickedDataItem.getTransaction_type());
                            intent.putExtra("amount",String.valueOf(clickedDataItem.getAmount()));
                            if(clickedDataItem.getBank_account() == null){
                                intent.putExtra("bank", "No bank");
                            }else{
                                intent.putExtra("bank", clickedDataItem.getBank_account().getBank().getName());
                            }
                            intent.putExtra("status", clickedDataItem.getStatus());
                            intent.putExtra("date", clickedDataItem.getCreated_at());

                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }else if(clickedDataItem.getTransaction_type().equals("DEPOSIT")){

                            Intent intent = new Intent(context, DetailActivity.class);

                            intent.putExtra("transaction_type", clickedDataItem.getTransaction_type());
                            intent.putExtra("to", clickedDataItem.getCompany_bank_account().getHolder());
                            intent.putExtra("amount", String.valueOf(clickedDataItem.getAmount()));
                            intent.putExtra("paymentMethod", clickedDataItem.getPayment_method().getName());
                            intent.putExtra("accountType", clickedDataItem.getCompany_bank_account().getType_of());
                            intent.putExtra("bank", clickedDataItem.getCompany_bank_account().getBank().getName());
                            intent.putExtra("status", clickedDataItem.getStatus());
                            intent.putExtra("date", clickedDataItem.getCreated_at());

                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }else if (clickedDataItem.getTransaction_type().equals("RECHARGE")) {

                            Intent intent = new Intent(context, DetailActivity.class);

                            intent.putExtra("transaction_type", clickedDataItem.getTransaction_type());
                            intent.putExtra("phoneNumber", clickedDataItem.getPhone_number());
                            intent.putExtra("amountPaid", String.valueOf(clickedDataItem.getAmount_paid()));
                            intent.putExtra("rechargePrice", String.valueOf(clickedDataItem.getRecharge_price()));
                            intent.putExtra("amountOfUtts", String.valueOf(clickedDataItem.getAmount_of_utts()));
                            intent.putExtra("validityDays", String.valueOf(clickedDataItem.getValidity_days()));
                            intent.putExtra("mobOperatorName", clickedDataItem.getMobile_operator_name());
                            intent.putExtra("mobOperatorType", clickedDataItem.getMobile_operator_type());
                            intent.putExtra("status", clickedDataItem.getStatus());
                            intent.putExtra("date", clickedDataItem.getCreated_at());

                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }

                    }

                }
            });

        }
    }
}
