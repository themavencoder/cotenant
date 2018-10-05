package com.getmobileltd.cotenant.registration.chooseworkmvp;

public interface ChooseWorkContractor  {

        interface View {
            void navigateToNextScreen();
            void showError(String error);
            void enableButtonClick(boolean b);
            void enableButtonColor(int color);
        }

        interface Presenter {
            void loadNextScreen();
            void displayError();
            void defaultSettings();
            void verify();
            void save(String work);
            String work();
        }

}
