package com.getmobileltd.cotenant.registration.comfortablegendermvp;

public class ComfortableGenderModel {

   private String preferredRoommateSex;

    public ComfortableGenderModel(String preferredRoommateSex) {
        this.preferredRoommateSex = preferredRoommateSex;
    }

    public ComfortableGenderModel() {
    }

    public String getPreferredRoommateSex() {
        return preferredRoommateSex;
    }

    public void setPreferredRoommateSex(String preferredRoommateSex) {
        this.preferredRoommateSex = preferredRoommateSex;
    }
}
