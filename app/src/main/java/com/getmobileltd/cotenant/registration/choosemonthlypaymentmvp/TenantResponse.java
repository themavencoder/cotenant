package com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp;

import com.google.gson.annotations.SerializedName;

public class TenantResponse {
    @SerializedName("success")
    private Boolean success;

    @SerializedName("status")
    private Integer status;

    @SerializedName("data")
    private TenantBody data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TenantBody getData() {
        return data;
    }

    public void setData(TenantBody data) {
        this.data = data;
    }
}
