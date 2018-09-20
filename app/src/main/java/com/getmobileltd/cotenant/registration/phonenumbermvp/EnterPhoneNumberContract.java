package com.getmobileltd.cotenant.registration.phonenumbermvp;

import android.view.Window;
import android.view.WindowManager;

public interface EnterPhoneNumberContract {



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
        void verifyNumber();
        void defaultSettings();
    void loadNextScreen();
        void saveNumber(String phonenumber);




    }
}
