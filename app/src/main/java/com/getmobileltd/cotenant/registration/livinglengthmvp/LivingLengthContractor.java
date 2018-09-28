package com.getmobileltd.cotenant.registration.livinglengthmvp;

public interface LivingLengthContractor {

    interface View {
        void navigateNextScreen();
    }

    interface  Presenter {
        void loadNextScreen();
        void saveYears();

    }
}
