package com.getmobileltd.cotenant.registration.choosedisabilitymvp;

public class ChooseDisablityPresenter implements ChooseDisablityContract.Presenter {

    private ChooseDisablityModel model;
    private ChooseDisablityContract.View view;

    public ChooseDisablityPresenter(ChooseDisablityContract.View view) {
        this.view = view;
        model = new ChooseDisablityModel();
    }

    @Override
    public void saveDisabilityChoice(String smokeChoice) {
        model.setMyDisability(smokeChoice);

    }

    @Override
    public void saveRoomateDisability(String roommateSmoke) {
        model.setYourDisability(roommateSmoke);

    }

    @Override
    public void loadNextScreen() {
        view.naviagateNextScreen();

    }

    @Override
    public void defaultSettings() {

    }

    @Override
    public void verifyEntries() {

    }

    @Override
    public void displayError() {

    }
}
