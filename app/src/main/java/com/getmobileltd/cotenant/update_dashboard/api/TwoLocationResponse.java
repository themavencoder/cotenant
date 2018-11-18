package com.getmobileltd.cotenant.update_dashboard.api;

import com.google.gson.annotations.SerializedName;

public class TwoLocationResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("code")
    private int code;

    @SerializedName("Search successful")
    private String message;

    @SerializedName("data")
    private LocationData data;


    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(LocationData data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public LocationData getData() {
        return data;
    }


}
