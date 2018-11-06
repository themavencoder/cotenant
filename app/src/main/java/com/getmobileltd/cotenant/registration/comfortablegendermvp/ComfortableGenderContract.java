package com.getmobileltd.cotenant.registration.comfortablegendermvp;

public interface ComfortableGenderContract {

    interface View {
        void showButtonClick(boolean b);
        void setButtonColor(int color);
        void navigateToNextScreen();

    }

    interface Presenter {
        void loadNextScreen();
        void savePreferredSex(String sex);
        void defaultSettings();
        void verifyEntries();


    }
}
