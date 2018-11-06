package com.getmobileltd.cotenant.registration.comfortablegendermvp;

import com.getmobileltd.cotenant.R;

public class ComfortableGenderPresenter implements ComfortableGenderContract.Presenter {
    private ComfortableGenderContract.View view;
    private ComfortableGenderModel model;

    public ComfortableGenderPresenter(ComfortableGenderContract.View view) {
        this.view = view;
        model = new ComfortableGenderModel();
    }

    @Override
    public void loadNextScreen() {
        view.navigateToNextScreen();

    }

    @Override
    public void savePreferredSex(String sex) {
        model.setPreferredRoommateSex(sex);
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
}
