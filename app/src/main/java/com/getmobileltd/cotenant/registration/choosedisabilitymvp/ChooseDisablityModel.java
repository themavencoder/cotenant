package com.getmobileltd.cotenant.registration.choosedisabilitymvp;

public class ChooseDisablityModel {

    private String myDisability;
    private String yourDisability;

    public String getMyDisability() {
        return myDisability;
    }

    public void setMyDisability(String myDisability) {
        this.myDisability = myDisability;
    }

    public String getYourDisability() {
        return yourDisability;
    }

    public void setYourDisability(String yourDisability) {
        this.yourDisability = yourDisability;
    }

    public ChooseDisablityModel() {

    }

    public ChooseDisablityModel(String myDisability, String yourDisability) {

        this.myDisability = myDisability;
        this.yourDisability = yourDisability;
    }
}
