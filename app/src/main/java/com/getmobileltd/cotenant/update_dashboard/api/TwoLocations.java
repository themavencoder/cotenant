package com.getmobileltd.cotenant.update_dashboard.api;

public class TwoLocations {

    private String location_one;
    private String location_two;

    public TwoLocations(String location_one, String location_two) {
        this.location_one = location_one;
        this.location_two = location_two;


    }

    public String getLocation_one() {
        return location_one;
    }

    public String getLocation_two() {
        return location_two;
    }

    public void setLocation_one(String location_one) {
        this.location_one = location_one;
    }

    public void setLocation_two(String location_two) {
        this.location_two = location_two;
    }
}
