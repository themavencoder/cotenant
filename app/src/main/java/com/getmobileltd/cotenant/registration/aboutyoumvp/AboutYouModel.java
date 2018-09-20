package com.getmobileltd.cotenant.registration.aboutyoumvp;

public class AboutYouModel {
    private String first_name;
    private String last_name;
    private String gender;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AboutYouModel() {

    }

    public AboutYouModel(String first_name, String last_name, String gender) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
    }
}
