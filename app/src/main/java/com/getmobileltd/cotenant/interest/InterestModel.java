package com.getmobileltd.cotenant.interest;

import com.google.gson.annotations.SerializedName;

public class InterestModel {


    @SerializedName("poster_path")
    private String interestImage;

    public InterestModel(String interestImage) {
        this.interestImage = interestImage;
    }

    public String getInterestImage() {

        return "https://image.tmdb.org/t/p/w500" + interestImage;
    }

    public void setInterestImage(String interestImage) {
        this.interestImage = interestImage;
    }

    public InterestModel() {

    }
}
