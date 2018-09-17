package com.getmobileltd.cotenant.registration.entercodemvp;

public class EnterCodeModel {
    String firstcode, secondcode,thirdcode, fourthcode;

    public EnterCodeModel(String firstcode, String secondcode, String thirdcode, String fourthcode) {
        this.firstcode = firstcode;
        this.secondcode = secondcode;
        this.thirdcode = thirdcode;
        this.fourthcode = fourthcode;
    }

    public EnterCodeModel() {
    }

    public String getFirstcode() {
        return firstcode;
    }

    public void setFirstcode(String firstcode) {
        this.firstcode = firstcode;
    }

    public String getSecondcode() {
        return secondcode;
    }

    public void setSecondcode(String secondcode) {
        this.secondcode = secondcode;
    }

    public String getThirdcode() {
        return thirdcode;
    }

    public void setThirdcode(String thirdcode) {
        this.thirdcode = thirdcode;
    }

    public String getFourthcode() {
        return fourthcode;
    }

    public void setFourthcode(String fourthcode) {
        this.fourthcode = fourthcode;
    }
}
