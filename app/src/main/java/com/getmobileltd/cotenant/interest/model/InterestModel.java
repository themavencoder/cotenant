package com.getmobileltd.cotenant.interest.model;

import com.google.gson.annotations.SerializedName;

public class InterestModel {


    private String bedroom;
    private String stateLocation;
    private String addressLocation;
    private String rent;
    private String imageOfLocation;
    private String additional_details;

    public InterestModel(String bedroom, String stateLocation, String addressLocation, String additional_details, String rent) {
        this.bedroom = bedroom;
        this.stateLocation = stateLocation;
        this.addressLocation = addressLocation;
        this.additional_details = additional_details;
        this.rent = rent;


    }


    public InterestModel() {

    }

    public String getAdditional_details() {
        return additional_details;
    }

    public void setAdditional_details(String additional_details) {
        this.additional_details = additional_details;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getStateLocation() {
        return stateLocation;
    }

    public void setStateLocation(String stateLocation) {
        this.stateLocation = stateLocation;
    }

    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getImageOfLocation() {
        return imageOfLocation;
    }

    public void setImageOfLocation(String imageOfLocation) {
        this.imageOfLocation = imageOfLocation;
    }

}
