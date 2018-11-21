package com.acelabs.kambaapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class To {
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("phone_number")
    private String phone_number;
    @Expose
    @SerializedName("lastname")
    private String lastname;
    @Expose
    @SerializedName("firstname")
    private String firstname;
    @Expose
    @SerializedName("id")
    private String id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
