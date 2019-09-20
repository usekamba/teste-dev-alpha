package com.example.testekamba.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testekamba.*;
import com.example.testekamba.models.Operation;

import java.util.List;

public class ClientOperationAdapter extends RecyclerView.Adapter<ClientOperationAdapter.mViewHolder> {

    private Context mContext;
    private List<Operation> operations;
    private OnItemClickListener listener;


    public interface  OnItemClickListener
    {
        void onItemClick(Operation operation);
    }
    public ClientOperationAdapter(Context mContext, List<Operation> operations, View.OnClickListener listener) {
        this.mContext = mContext;
        this.operations = operations;
    }

    public ClientOperationAdapter(Context mContext, List<Operation> operations, OnItemClickListener onItemClickListener) {
        this.mContext = mContext;
        this.operations = operations;
        this.listener=onItemClickListener;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_layout,parent, false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

        holder.bind(operations.get(position), listener);
        holder.operation_name .setText(operations.get(position).getOperationName());
        switch (operations.get(position).getOperationName())
        {

            case  "Pagamento":  holder.card.setCardBackgroundColor(mContext.getResources().getColor(R.color.payment_color));
                break;

            case  "Depósito":  holder.card.setCardBackgroundColor(mContext.getResources().getColor(R.color.deposit_color));
                break;
            case  "Levantamento":  holder.card.setCardBackgroundColor(mContext.getResources().getColor(R.color.withdraw_color));
                break;
            default:
                holder.card.setCardBackgroundColor(mContext.getResources().getColor(R.color.tvRecharge_color));
                break;
        }
        Glide.with(mContext).load(operations.get(position).getImgResource()).
                apply(RequestOptions.centerCropTransform()).
                into(holder.picture);

    }

    @Override
    public int getItemCount() {
        return operations.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder {

        private ImageView picture;
        private TextView operation_name;
        private CardView card;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.idImageOperation);
            operation_name=itemView.findViewById(R.id.idOperationName);
            card =itemView.findViewById(R.id.cardView);
        }

        void bind(final Operation operationItem, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(operationItem);
                }
            });
        }
    }


}
