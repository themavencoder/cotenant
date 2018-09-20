package com.getmobileltd.cotenant.registration.comfortablegendermvp;

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
}
