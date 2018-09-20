package com.getmobileltd.cotenant.registration.aboutyoumvp;

public interface AboutYouContract {

    interface View {
        void enableButtonClick(boolean b);
        void enableButtonColor(int color);
        void navigateToNextScreen();


    }

    interface Presenter {
        void defaultSettings();
        void verifyEntries();
        void loadNextScreen();
        void saveData(String firstName, String lastName, String gender);

    }
}
