package com.getmobileltd.cotenant.registration.religionchoicemvp;

public class ReligionChoiceModel  {
    private String personalReligion;
     private String roomateReligion;

    public String getPersonalReligion() {
        return personalReligion;
    }

    public void setPersonalReligion(String personalReligion) {
        this.personalReligion = personalReligion;
    }

    public String getRoomateReligion() {
        return roomateReligion;
    }

    public void setRoomateReligion(String roomateReligion) {
        this.roomateReligion = roomateReligion;
    }

    public ReligionChoiceModel() {

    }

    public ReligionChoiceModel(String personalReligion, String choiceOfReligion) {

        this.personalReligion = personalReligion;
        this.roomateReligion = choiceOfReligion;
    }
}
