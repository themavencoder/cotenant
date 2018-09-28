package com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp;

public class ChooseMonthlyPaymentModel {
    private String minValue;
    private String maxValue;

    public ChooseMonthlyPaymentModel(String minValue, String maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public ChooseMonthlyPaymentModel() {
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }
}
