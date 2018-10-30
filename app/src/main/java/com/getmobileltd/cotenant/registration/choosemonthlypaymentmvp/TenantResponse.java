package com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp;

import com.google.gson.annotations.SerializedName;

public class TenantResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("code")
    private Integer code;

    @SerializedName("data")
    private TenantBody data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")

   private String message;

    public TenantBody getData() {
        return data;
    }

    public void setData(TenantBody data) {
        this.data = data;
    }
}
