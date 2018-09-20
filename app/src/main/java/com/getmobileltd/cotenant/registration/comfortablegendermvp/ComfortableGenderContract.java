package com.getmobileltd.cotenant.registration.comfortablegendermvp;

public interface ComfortableGenderContract {

    interface View {
        void navigateToNextScreen();

    }

    interface Presenter {
        void loadNextScreen();
        void savePreferredSex(String sex);


    }
}
