package com.getmobileltd.cotenant.registration.religionchoicemvp;

public interface ReligionChoiceContract {

    interface View {
        void showButtonClick(boolean b);
        void setButtonColor(int color);
        void naviagateNextScreen();
        void showError(String error);

    }
    interface Presenter {
        void saveReligionChoice(String relgionChoice);
        void saveRoomateReligion(String roommateReligion);
        void loadNextScreen();
        void defaultSettings();
        void verifyEntries();
        void displayError();
    }
}
