package com.getmobileltd.cotenant.update_dashboard.models;

public class HousesModel {

    private String bedroom;
    private String stateLocation;
    private String addressLocation;
    private String rent;
    private int imageOfLocation;

    public HousesModel(String bedroom, String stateLocation, String addressLocation, String rent, int imageOfLocation) {
        this.bedroom = bedroom;
        this.stateLocation = stateLocation;
        this.addressLocation = addressLocation;
        this.rent = rent;
        this.imageOfLocation = imageOfLocation;
    }

    public HousesModel() {

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

    public int getImageOfLocation() {
        return imageOfLocation;
    }

    public void setImageOfLocation(int imageOfLocation) {
        this.imageOfLocation = imageOfLocation;
    }
}
