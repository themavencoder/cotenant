package com.getmobileltd.cotenant.update_dashboard.models;

import android.os.Parcel;
import android.os.Parcelable;

public class HousesModel implements Parcelable{

    private String bedroom;
    private String stateLocation;
    private String addressLocation;
    private String rent;
    private String imageOfLocation;
    private String additional_details;
    private int id;
    private boolean like = false;
    public HousesModel(String bedroom, String stateLocation, String addressLocation, String rent, String imageOfLocation,String additional_details, int id) {
        this.bedroom = bedroom;
        this.stateLocation = stateLocation;
        this.addressLocation = addressLocation;
        this.rent = rent;
        this.imageOfLocation = imageOfLocation;
        this.additional_details = additional_details;
        this.id = id;
    }

    public HousesModel(String bedroom, String stateLocation, String addressLocation, String rent, String additional_details, int id) {
        this.bedroom = bedroom;
        this.stateLocation = stateLocation;
        this.addressLocation = addressLocation;
        this.rent = rent;
        this.additional_details = additional_details;
        this.id = id;

    }
        public HousesModel(boolean like) {
            this.like = like;
        }
    public HousesModel() {

    }

    protected HousesModel(Parcel in) {
        bedroom = in.readString();
        stateLocation = in.readString();
        addressLocation = in.readString();
        rent = in.readString();
        imageOfLocation = in.readString();
        additional_details = in.readString();
        id = in.readInt();
        like = in.readInt() == 1;
    }

    public static final Creator<HousesModel> CREATOR = new Creator<HousesModel>() {
        @Override
        public HousesModel createFromParcel(Parcel in) {
            return new HousesModel(in);
        }

        @Override
        public HousesModel[] newArray(int size) {
            return new HousesModel[size];
        }
    };

    public void setAdditional_details(String additional_details) {
        this.additional_details = additional_details;
    }

    public String getAdditional_details() {
        return additional_details;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bedroom);
        parcel.writeString(stateLocation);
        parcel.writeString(addressLocation);
        parcel.writeString(rent);
        parcel.writeString(imageOfLocation);
        parcel.writeString(additional_details);
        parcel.writeInt(id);
        parcel.writeInt(like ? 1 : 0);
    }
}
