package com.getmobileltd.cotenant.registration.entercodemvp;

import com.google.gson.annotations.SerializedName;

public class EnterCodeResponse {

    @SerializedName("status")
 private String status;

@SerializedName("code")
    private Integer code;

@SerializedName("message")
    private String message;

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
}

