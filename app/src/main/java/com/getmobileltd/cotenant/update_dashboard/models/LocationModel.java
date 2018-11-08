package com.getmobileltd.cotenant.update_dashboard.models;

import java.util.List;

public class LocationModel {

    private String locationOfPlace;

    private List<HousesModel> modelList;

    public LocationModel(String locationOfPlace, List<HousesModel> modelList) {
        this.locationOfPlace = locationOfPlace;
        this.modelList = modelList;
    }

    public LocationModel() {

    }

    public String getLocationOfPlace() {
        return locationOfPlace;
    }

    public void setLocationOfPlace(String locationOfPlace) {
        this.locationOfPlace = locationOfPlace;
    }

    public List<HousesModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<HousesModel> modelList) {
        this.modelList = modelList;
    }
}
