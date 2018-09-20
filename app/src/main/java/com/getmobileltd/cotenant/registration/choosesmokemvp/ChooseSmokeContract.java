package com.getmobileltd.cotenant.registration.choosesmokemvp;

public interface ChooseSmokeContract {

    interface View {
        void showButtonClick(boolean b);
        void setButtonColor(int color);
        void naviagateNextScreen();
        void showError(String error);
    }

    interface Presenter {
        void saveSmokeChoice(String smokeChoice);
        void saveRoomateSmoke(String roommateSmoke);
        void loadNextScreen();
        void defaultSettings();
        void verifyEntries();
        void displayError();

    }
}
