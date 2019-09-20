package com.example.testekamba.models;

import com.google.gson.annotations.SerializedName;

public class activities {


    @SerializedName("transaction_type")
    private String transaction_type;

    @SerializedName("id")
    private  String id_operation;

    @SerializedName("amount")
    private String amount;

    private String subtotal;

    private String fee;

    @SerializedName("created_at")
    private String date;

    @SerializedName("from")
    private from fromUser;

    @SerializedName("to")
    private to toUser;

    private String description;

    private String reference_checkout;

    private String reference_recharge;

    private String status;

    private String intent;
    private String recharge_code;
    private String echarge_price;
    private String amount_of_utts;
    private String validity_days;
    private String mobile_operator_name;
    private String mobile_operator_type;
    private String amount_paid;

    private String id_mobile_operator_type;
    private String recharge_price;

    public String getRecharge_price() {
        return recharge_price;
    }

    public String getId_mobile_operator_type() {
        return id_mobile_operator_type;
    }

    public String getRecharge_code() {
        return recharge_code;
    }

    public String getEcharge_price() {
        return echarge_price;
    }

    public String getAmount_of_utts() {
        return amount_of_utts;
    }

    public String getValidity_days() {
        return validity_days;
    }

    public String getMobile_operator_name() {
        return mobile_operator_name;
    }

    public String getMobile_operator_type() {
        return mobile_operator_type;
    }

    public String getAmount_paid() {
        return amount_paid;
    }

    @SerializedName("payment_method")
    private payment_method payment_method;
    @SerializedName("company_bank_account")
    private bank_account bank_account;


    public activities.bank_account getBank_account() {
        return bank_account;
    }

    public String getReference_checkout() {
        return reference_checkout;
    }

    public String getReference_recharge() {
        return reference_recharge;
    }

    public String getStatus() {
        return status;
    }

    public String getIntent() {
        return intent;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public String getId_operation() {
        return id_operation;
    }

    public String getAmount() {
        return amount;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public String getFee() {
        return fee;
    }

    public String getData() {
        return date;
    }

    public from getFromUser() {
        return fromUser;
    }


    public to getToUser() {
        return toUser;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public payment_method getPayment_method() {
        return payment_method;
    }

    public class from
    {
        @SerializedName("id")
        public  String from_id;

        public String firstname;

        public String lastname;

        public long phone;

        public  String email;

        public String profile_photo;


    }

    public class to
    {
        @SerializedName("id")
        public  String from_id;

        public String firstname;

        public String lastname;

        public long phone;

        public  String email;

        public String profile_photo;


    }

    public class payment_method
    {
        public   String id;
        public  String name;
        public  String description;

    }

    public class bank_account
    {
        public   String id;
        public  String iban;
        public  String number;
        public  String typeCof;
        @SerializedName("holder")
        public  String holder;
        public  bank bank;
    }


    public  class  bank{
        public   String id;
        public  String name;
        public  String description;
    }



}
