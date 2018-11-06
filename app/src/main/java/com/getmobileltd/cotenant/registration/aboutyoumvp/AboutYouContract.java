package com.getmobileltd.cotenant.registration.aboutyoumvp;

import android.text.Spanned;

public interface AboutYouContract {

    interface View {
        void enableButtonClick(boolean b);
        void enableButtonColor(int color);
        void navigateToNextScreen();
        void showError(String error);
        void showError2(String error);


    }

    interface Presenter {
        void defaultSettings();
        void verifyEntries();
        void loadNextScreen();
        void saveData(String firstName, String lastName, String emailAddress, String phoneNumber, String gender);
        void displayError();
        void displayError2();
        String firstName();
        String lastName();
        String emailAddress();
        String phoneNumber();
        String gender();
        String removeSpace(String s );

    }
}
