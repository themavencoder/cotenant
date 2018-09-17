package com.getmobileltd.cotenant.registration.phonenumbermvp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.entercodemvp.EnterCodeActivity;
import com.hbb20.CountryCodePicker;


public class EnterPhoneNumberActivity extends AppCompatActivity implements EnterPhoneNumberContract.View{

    private CountryCodePicker ccp;
    private EditText editTextCarrierNumber;
    private ImageView postiveChecked;
    private EnterPhoneNumberContract.Presenter presenter;
    private Button mButton;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.enter_mobile_number_registration);
        init();
        presenter = new EnterPhoneNumberPresenter(this);
        presenter.defaultSettings();

        ccp.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {

                // your code
                if (ccp.isValidFullNumber()) {

                        presenter.verifyNumber();




                }
                else {


                   presenter.defaultSettings();

                }

            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.saveNumber(editTextCarrierNumber.getText().toString());

                presenter.verifyNumber();


            }
        });

    }

    private void init() {
            presenter = new EnterPhoneNumberPresenter(this);
            ccp = findViewById(R.id.ccp);
            postiveChecked =findViewById(R.id.positivechecked);
            editTextCarrierNumber = findViewById(R.id.editText_carrierNumber);
            ccp.registerCarrierNumberEditText(editTextCarrierNumber);
            mButton = findViewById(R.id.btn_enter_phone_number);

           }




    @Override
    public void enableButtonClick(boolean b) {
        mButton.setEnabled(b);


    }

    @Override
    public void enableButtonColor(int color) {
        mButton.setBackground(getResources().getDrawable(color));

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void disablePositiveChecked() {
        postiveChecked.setVisibility(View.INVISIBLE);

    }

    @Override
    public void enablePositiveChecked() {
        postiveChecked.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideKeyboard() {


    }

    @Override
    public void navigateTonextScreen() {
        startActivity(new Intent(this,EnterCodeActivity.class));

    }
}