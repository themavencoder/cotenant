package com.getmobileltd.cotenant.registration.entercodemvp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EnterCodeModel {
    @Expose(deserialize = false)
    private String firstcode;
    @Expose(deserialize = false)
    private String secondcode;
    @Expose(deserialize = false)
    private String thirdcode;
    @Expose(deserialize = false)
    private String fourthcode;
    @SerializedName("email")
    private String email;

    @SerializedName("code")
        private int code;

    public EnterCodeModel(String firstcode, String secondcode, String thirdcode, String fourthcode) {
        this.firstcode = firstcode;
        this.secondcode = secondcode;
        this.thirdcode = thirdcode;
        this.fourthcode = fourthcode;
    }

    public EnterCodeModel() {

    }
    public EnterCodeModel(int code) {
        this.code = code;
    }
    public EnterCodeModel(String email, int code) {
        this.email = email;
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstcode() {
        return firstcode;
    }

    public void setFirstcode(String firstcode) {
        this.firstcode = firstcode;
    }

    public String getSecondcode() {
        return secondcode;
    }

    public void setSecondcode(String secondcode) {
        this.secondcode = secondcode;
    }

    public String getThirdcode() {
        return thirdcode;
    }

    public void setThirdcode(String thirdcode) {
        this.thirdcode = thirdcode;
    }

    public String getFourthcode() {
        return fourthcode;
    }

    public void setFourthcode(String fourthcode) {
        this.fourthcode = fourthcode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
