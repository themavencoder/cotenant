package com.getmobileltd.cotenant.update_dashboard.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationData {

    @SerializedName("location_1")
    private List<LocationOne> location_one;

    @SerializedName("location_2")
    private List<LocationTwo> location_two;

    public List<LocationOne> getLocation_one() {
        return location_one;
    }

    public void setLocation_one(List<LocationOne> location_one) {
        this.location_one = location_one;
    }

    public List<LocationTwo> getLocation_two() {
        return location_two;
    }

    public void setLocation_two(List<LocationTwo> location_two) {
        this.location_two = location_two;
    }
}
