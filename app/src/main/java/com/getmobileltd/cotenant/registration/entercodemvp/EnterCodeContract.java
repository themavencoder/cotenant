package com.getmobileltd.cotenant.registration.entercodemvp;

public interface EnterCodeContract {

    interface View {
        void enableButtonClick(boolean b);
        void enableButtonColor(int color);
        void showError(String error);
        void disablePositiveChecked();
        void enablePositiveChecked();
        void hideKeyboard();
        void navigateTonextScreen();



    }

    interface Presenter {

        void verifyCode();
        void defaultSettings();
        String appendStrings(String firstcode, String secondcode, String thirdcode, String fourthcode);
        void saveCode(String first, String second, String third, String fourth);
        void loadNextScreen();



    }

}
