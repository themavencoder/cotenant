package com.getmobileltd.cotenant.registration.entercodemvp;

import android.util.Log;

import com.getmobileltd.cotenant.R;

import java.util.Set;
import java.util.TreeSet;

public class EnterCodePresenter implements EnterCodeContract.Presenter {
    private EnterCodeContract.View view;
    private EnterCodeModel model;
    private Integer code;

    public EnterCodePresenter(EnterCodeContract.View view) {
        this.view = view;
        model = new EnterCodeModel();
    }

    @Override
    public void verifyCode() {
        if (appendStrings(model.getFirstcode(),model.getSecondcode(),model.getThirdcode(),model.getFourthcode()).length() == 4) {
                view.enableButtonColor(R.drawable.btn_red);
                view.enableButtonClick(true);
                view.enablePositiveChecked();


        } else {
            defaultSettings();
        }

    }

    @Override
    public void defaultSettings() {
        view.enableButtonClick(false);
        view.enableButtonColor(R.drawable.btn_ash);
        view.disablePositiveChecked();

    }

    @Override
    public String appendStrings(String firstcode, String secondcode, String thirdcode, String fourthcode) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstcode).append(secondcode).append(thirdcode).append(fourthcode);

        return sb.toString();

    }


    @Override
    public void saveCode(String first, String second, String third, String fourth) {
        model.setFirstcode(first);
        model.setSecondcode(second);
        model.setThirdcode(third);
        model.setFourthcode(fourth);

        String a = appendStrings(model.getFirstcode(),model.getSecondcode(),model.getThirdcode(),model.getFourthcode());

    code = Integer.parseInt(a);
    model.setCode(String.valueOf(code));

        Log.d("Codesaved","Your code has been saved" + a);


    }

    @Override
    public void loadNextScreen() {
        view.navigateTonextScreen();
    }

    @Override
    public String showSavedCode() {
        return model.getCode();
    }
}
