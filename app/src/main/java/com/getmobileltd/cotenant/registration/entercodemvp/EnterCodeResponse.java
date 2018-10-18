package com.getmobileltd.cotenant.registration.entercodemvp;

import com.google.gson.annotations.SerializedName;

public class EnterCodeResponse {

    @SerializedName("success")
    private Boolean success;

    @SerializedName("status")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
