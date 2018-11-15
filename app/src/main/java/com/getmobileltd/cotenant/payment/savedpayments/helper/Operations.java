package com.getmobileltd.cotenant.payment.savedpayments.helper;

import com.getmobileltd.cotenant.payment.savedpayments.model.OtherCardsModel;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    private static int COUNT = 0;

    public static List<OtherCardsModel> CARDS = new ArrayList<>();



    public static void createCard(OtherCardsModel card) {
        COUNT += 1;
        card.setId(COUNT);
        CARDS.add(card);

    }

    public static OtherCardsModel getCardById(int id) {
        for (int i = 0;  i < CARDS.size(); i++) {
                if (CARDS.get(i).getId() == id) {
                    return CARDS.get(i);
                }

        }
        return null;
    }

    public static void deleteCard(int id) {
            OtherCardsModel cardToRemove = null;
            for (int i = 0;  i < CARDS.size(); i++) {
                    if (CARDS.get(i).getId() == id) {
                        cardToRemove = CARDS.get(i);
                    }
            }
            if (cardToRemove != null) {
                CARDS.remove(cardToRemove);
            }
    }


    public static void updateCard(OtherCardsModel card) {
        for (int i = 0; i < CARDS.size(); i++) {
            if (CARDS.get(i).getId() == card.getId()) {
                OtherCardsModel cardToUpdate = CARDS.get(i);
                cardToUpdate.setCardType(card.getCardType());
                cardToUpdate.setLastFourDigits(card.getLastFourDigits());
                cardToUpdate.setMonth(card.getMonth());
            }
        }

    }



}
