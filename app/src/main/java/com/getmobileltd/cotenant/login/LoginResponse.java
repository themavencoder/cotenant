package com.getmobileltd.cotenant.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("code")
    private Integer code;

    @SerializedName("message")
    private String message;

    public LoginResponse(String status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
