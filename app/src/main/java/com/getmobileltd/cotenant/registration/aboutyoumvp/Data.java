package com.getmobileltd.cotenant.registration.aboutyoumvp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    public Data(String email, String password, String first_name, String last_name, String gender, String phone_number) {
        this.email  = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone_number = phone_number;
    }


    public Data() {

    }

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("phone_number")
    @Expose
    private String phone_number;


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}