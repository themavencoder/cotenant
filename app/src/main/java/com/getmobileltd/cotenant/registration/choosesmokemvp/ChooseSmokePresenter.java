package com.getmobileltd.cotenant.registration.choosesmokemvp;

import com.getmobileltd.cotenant.R;

public class ChooseSmokePresenter implements ChooseSmokeContract.Presenter {
    private ChooseSmokeModel model;
    private ChooseSmokeContract.View view;

    public ChooseSmokePresenter(ChooseSmokeContract.View view) {
        this.view = view;
        model = new ChooseSmokeModel();
    }

    @Override
    public void saveSmokeChoice(String smokeChoice) {
        model.setYouSmoke(smokeChoice);

    }

    @Override
    public void saveRoomateSmoke(String roommateSmoke) {
        model.setStaySmoke(roommateSmoke);
    }

    @Override
    public void loadNextScreen() {
        view.naviagateNextScreen();

    }

    @Override
    public void defaultSettings() {
            view.setButtonColor(R.drawable.btn_ash);
            view.showButtonClick(false);
    }

    @Override
    public void verifyEntries() {
        view.setButtonColor(R.drawable.btn_red);
        view.showButtonClick(true);
    }

    @Override
    public void displayError() {

    }
}
