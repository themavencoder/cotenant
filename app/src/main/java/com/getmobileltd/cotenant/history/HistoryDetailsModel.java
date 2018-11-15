package com.getmobileltd.cotenant.history;

public class HistoryDetailsModel {
    private String amount;
    private String fullDate;
    private String halfDate;

    public String getHalfDate() {
        return halfDate;
    }

    public void setHalfDate(String halfDate) {
        this.halfDate = halfDate;
    }

    public HistoryDetailsModel(String amount, String fullDate, String halfDate) {
        this.amount = amount;
        this.fullDate = fullDate;
        this.halfDate = halfDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFullDate() {
        return fullDate;
    }

    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
    }

    public HistoryDetailsModel() {

    }
}