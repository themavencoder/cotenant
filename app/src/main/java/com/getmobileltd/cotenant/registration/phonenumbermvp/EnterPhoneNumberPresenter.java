package com.getmobileltd.cotenant.registration.phonenumbermvp;

import android.view.Window;
import android.view.WindowManager;

import com.getmobileltd.cotenant.R;

public class EnterPhoneNumberPresenter implements EnterPhoneNumberContract.Presenter {

private EnterPhoneNumberContract.View view;

private PhoneNumberModel model;

public EnterPhoneNumberPresenter(EnterPhoneNumberContract.View view) {
        this.view = view;
        this.model = new PhoneNumberModel();
}

    @Override
    public void verifyNumber() {

        view.enableButtonColor(R.drawable.btn_red);
        view.enableButtonClick(true);
        view.enablePositiveChecked();






    }

    @Override
    public void defaultSettings() {
        view.enableButtonClick(false);
        view.enableButtonColor(R.drawable.btn_ash);
        view.disablePositiveChecked();
    }

    @Override
    public void loadNextScreen() {
        view.navigateTonextScreen();
    }

    @Override
    public void saveNumber(String phonenumber) {
        model.setPhonenumber(phonenumber);
    }



}
