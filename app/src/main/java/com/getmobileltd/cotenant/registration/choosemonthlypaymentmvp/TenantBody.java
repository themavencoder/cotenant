package com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp;

import com.google.gson.annotations.SerializedName;

public class TenantBody {
    @SerializedName("user_id")
    private Integer user_id;

    @SerializedName("co_gender")
    private String co_gender;

    @SerializedName("religion")
    private String religion;

    @SerializedName("co_religion")
    private String co_religion;

    @SerializedName("smoke")
    private String smoke;

    @SerializedName("co_smoke")
    private String co_smoke;

    @SerializedName("disabled")
    private String disabled;

    @SerializedName("co_disabled")
    private String co_disabled;

    @SerializedName("location_1")
    private String location_1;

    @SerializedName("location_2")
    private String location_2;

    @SerializedName("work")
    private String work;

    public TenantBody(Integer user_id, String co_gender, String religion, String co_religion, String smoke, String co_smoke, String disabled, String co_disabled, String location_1, String location_2, String work, String duration) {
        this.user_id = user_id;
        this.co_gender = co_gender;
        this.religion = religion;
        this.co_religion = co_religion;
        this.smoke = smoke;
        this.co_smoke = co_smoke;
        this.disabled = disabled;
        this.co_disabled = co_disabled;
        this.location_1 = location_1;
        this.location_2 = location_2;
        this.duration = duration;
        this.work = work;
    }

    @SerializedName("duration")
    private String duration;
}
