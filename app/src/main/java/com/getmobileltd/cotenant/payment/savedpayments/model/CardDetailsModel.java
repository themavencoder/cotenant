package com.getmobileltd.cotenant.payment.savedpayments.model;

public class CardDetailsModel {
    private static String cardNumber;
    private static String month;

    public CardDetailsModel() {

    }

    public static String getCardNumber() {
        return cardNumber;
    }

    public static void setCardNumber(String cardnumber) {
        cardNumber = cardnumber;
    }

    public static void setMonth(String months) {
        month = months;
    }

    public static String getMonth() {
        return month;
    }
}
