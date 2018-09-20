package com.getmobileltd.cotenant.registration.choosesmokemvp;

public class ChooseSmokeModel {

    private String youSmoke;
    private String staySmoke;

    public ChooseSmokeModel(String youSmoke, String staySmoke) {
        this.youSmoke = youSmoke;
        this.staySmoke = staySmoke;
    }

    public ChooseSmokeModel() {
    }

    public String getYouSmoke() {
        return youSmoke;
    }

    public void setYouSmoke(String youSmoke) {
        this.youSmoke = youSmoke;
    }

    public String getStaySmoke() {
        return staySmoke;
    }

    public void setStaySmoke(String staySmoke) {
        this.staySmoke = staySmoke;
    }
}
