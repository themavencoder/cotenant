package com.getmobileltd.cotenant.interest.api;

import com.google.gson.annotations.SerializedName;

public class InterestData {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("description")
    private String description;

    @SerializedName("address")
    private String address;

    @SerializedName("location")
    private String location;

    @SerializedName("amount")
    private String amount;

    @SerializedName("bathroom")
    private String bathroom;

    @SerializedName("kitchen")
    private String kitchen;

    @SerializedName("living_room")
    private String living_room;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public String getAmount() {
        return amount;
    }

    public String getBathroom() {
        return bathroom;
    }

    public String getKitchen() {
        return kitchen;
    }

    public String getLiving_room() {
        return living_room;
    }

    public String getNumber_of_rooms() {
        return number_of_rooms;
    }

    public String getAdditional_details() {
        return additional_details;
    }

    public String getStatus() {
        return status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    @SerializedName("number_of_rooms")
    private String number_of_rooms;


    @SerializedName("additional_details")
    private String additional_details;

    @SerializedName("status")
    private String status;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

}
