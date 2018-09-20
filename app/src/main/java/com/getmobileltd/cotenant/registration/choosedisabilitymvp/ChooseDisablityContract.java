package com.getmobileltd.cotenant.registration.choosedisabilitymvp;

public interface ChooseDisablityContract {

    interface View {
        void showButtonClick(boolean b);
        void setButtonColor(int color);
        void naviagateNextScreen();
        void showError(String error);
    }
    interface Presenter {
        void saveDisabilityChoice(String smokeChoice);
        void saveRoomateDisability(String roommateSmoke);
        void loadNextScreen();
        void defaultSettings();
        void verifyEntries();
        void displayError();

    }
}
