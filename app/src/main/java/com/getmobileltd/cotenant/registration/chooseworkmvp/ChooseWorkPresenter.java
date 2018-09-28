package com.getmobileltd.cotenant.registration.chooseworkmvp;

import com.getmobileltd.cotenant.R;

public class ChooseWorkPresenter implements ChooseWorkContractor.Presenter {
    private ChooseWorkContractor.View view;
    private ChooseWorkModel model;

    public ChooseWorkPresenter(ChooseWorkContractor.View view) {
        this.view = view;
        model = new ChooseWorkModel();
    }

    @Override
    public void loadNextScreen() {
        view.navigateToNextScreen();

    }

    @Override
    public void displayError() {
        view.showError("Field cannot be less than 4 characters");

    }

    @Override
    public void defaultSettings() {
        view.enableButtonClick(false);
        view.enableButtonColor(R.drawable.btn_ash );
    }

    @Override
    public void verify() {
        view.enableButtonClick(true);
        view.enableButtonColor(R.drawable.btn_red);

    }
}
