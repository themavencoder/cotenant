package com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp;

import com.getmobileltd.cotenant.registration.choosedisabilitymvp.ChooseDisablityContract;

public class ChooseMonthlyPresenter implements ChooseMonthlyPaymentContractor.Presenter{

    private ChooseMonthlyPaymentContractor.View view;
    private ChooseMonthlyPaymentModel model;

    public ChooseMonthlyPresenter(ChooseMonthlyPaymentContractor.View view) {
        this.view = view;
        model = new ChooseMonthlyPaymentModel();
    }

    @Override
    public void loadNextScreen() {
        view.navigateScreen();

    }

    @Override
    public void saveRange(String minRange) {
      model.setMinValue(minRange);

    }
}
