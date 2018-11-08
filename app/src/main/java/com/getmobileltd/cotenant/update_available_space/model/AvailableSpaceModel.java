package com.getmobileltd.cotenant.update_available_space.model;

public class AvailableSpaceModel {
    private String bedroom;
    private String stateLocation;
    private String addressLocation;
    private String rent;
    private int imageOfLocation;

    public AvailableSpaceModel(String bedroom, String stateLocation, String addressLocation, String rent, int imageOfLocation) {
        this.bedroom = bedroom;
        this.stateLocation = stateLocation;
        this.addressLocation = addressLocation;
        this.rent = rent;
        this.imageOfLocation = imageOfLocation;
    }

    public AvailableSpaceModel() {

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
