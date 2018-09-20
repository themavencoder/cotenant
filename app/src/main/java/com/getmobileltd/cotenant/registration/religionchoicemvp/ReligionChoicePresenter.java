package com.getmobileltd.cotenant.registration.religionchoicemvp;

import com.getmobileltd.cotenant.R;

public class ReligionChoicePresenter implements ReligionChoiceContract.Presenter {
    private ReligionChoiceContract.View view;
    private ReligionChoiceModel model;

    public ReligionChoicePresenter(ReligionChoiceContract.View view) {
        this.view = view;
        model = new ReligionChoiceModel();
    }

    @Override
    public void saveReligionChoice(String religionChoice) {
        model.setPersonalReligion(religionChoice);
    }

    @Override
    public void saveRoomateReligion(String roommateReligion) {
        model.setRoomateReligion(roommateReligion);

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
        String personalReligion = model.getPersonalReligion();
        String roommateReligion = model.getRoomateReligion();
        if ((personalReligion != null) && (roommateReligion != null)) {
            view.setButtonColor(R.drawable.btn_red);
            view.showButtonClick(true);

        }
    }

    @Override
    public void displayError() {
        view.showError("Please choose an option!");
    }
}
