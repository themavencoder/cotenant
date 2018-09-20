package com.getmobileltd.cotenant.registration.aboutyoumvp;

import com.getmobileltd.cotenant.R;

public class AboutYouPresenter implements AboutYouContract.Presenter{
    private AboutYouContract.View view;
    private AboutYouModel model;

    public AboutYouPresenter(AboutYouContract.View view) {
        this.view = view;
        model = new AboutYouModel();
    }

    @Override
    public void defaultSettings() {
        view.enableButtonClick(false);
        view.enableButtonColor(R.drawable.btn_ash);


    }

    @Override
    public void verifyEntries() {
        String firstName = model.getFirst_name();
        String lastName = model.getLast_name();
        String gender = model.getGender();

        if (firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty()) {
                defaultSettings();
        return;
        }

            view.enableButtonColor(R.drawable.btn_red);
            view.enableButtonClick(true);



    }

    @Override
    public void loadNextScreen() {
        view.navigateToNextScreen();

    }

    @Override
    public void saveData(String firstName, String lastName, String gender) {
        model.setFirst_name(firstName);
        model.setLast_name(lastName);
        model.setGender(gender);

    }
}
