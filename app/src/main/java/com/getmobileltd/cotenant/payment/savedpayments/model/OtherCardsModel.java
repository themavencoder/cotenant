package com.getmobileltd.cotenant.payment.savedpayments.model;

public  class OtherCardsModel {
    private int id;
    private String lastFourDigits;
    private String month;
    private int cardType;

    public OtherCardsModel(String lastFourDigits, String month, int cardType) {
        this.cardType = cardType;
        this.month = month;
        this.lastFourDigits = lastFourDigits;



    }
    public OtherCardsModel() {

    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getCardType() {
        return cardType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }
}
