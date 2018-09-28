package com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp;

public interface ChooseMonthlyPaymentContractor {

    interface View {
        void navigateScreen();
    }

    interface Presenter{
        void loadNextScreen();
        void saveRange(String minRange, String maxRange);
    }


}
