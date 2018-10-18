package com.getmobileltd.cotenant.registration.apppinmvp;

public interface AppPinContract {

    interface  View {
        void showButtonClick(boolean b);
        void setButtonColor(int color);
        void navigateNextScreen();
        void showError(String error);
        void showTickVisibility(int value);

    }

    interface Presenter {
        void loadNextScreen();
        void defaultSettings();
        void verifyEntries();
        void displayPasswordError(String error);
        void savePassword(String password);
        String appPassword();
        String appendIndvidualPassword(String first, String second, String third, String fourth);
    }
}
