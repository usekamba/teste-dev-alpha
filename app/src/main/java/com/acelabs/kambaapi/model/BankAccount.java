package com.acelabs.kambaapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankAccount {

    @Expose
    @SerializedName("bank")
    private Bank bank;
    @Expose
    @SerializedName("holder")
    private String holder;
    @Expose
    @SerializedName("type_of")
    private String type_of;
    @Expose
    @SerializedName("number")
    private String number;
    @Expose
    @SerializedName("id")
    private String id;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getType_of() {
        return type_of;
    }

    public void setType_of(String type_of) {
        this.type_of = type_of;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
