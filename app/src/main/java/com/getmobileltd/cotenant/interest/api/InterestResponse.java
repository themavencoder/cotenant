package com.getmobileltd.cotenant.interest.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InterestResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("code")
    private int code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<InterestData> getData() {
        return data;
    }

    public void setData(List<InterestData> data) {
        this.data = data;
    }

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<InterestData> data;

}
