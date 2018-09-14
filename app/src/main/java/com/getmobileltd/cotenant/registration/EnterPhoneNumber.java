package com.getmobileltd.cotenant.registration;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.getmobileltd.cotenant.R;
import com.hbb20.CountryCodePicker;


public class EnterPhoneNumber extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText editTextCarrierNumber;
    ImageView postiveChecked;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.enter_mobile_number_registration);

        init();
        ccp.isValidFullNumber();
        ccp.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {

                // your code
                if (ccp.isValidFullNumber() && editTextCarrierNumber.length() > 9) {
                    postiveChecked.setVisibility(View.VISIBLE);

                } else {
                    postiveChecked.setVisibility(View.INVISIBLE);
                }

            }
        });

    }

    private void init() {
            ccp = findViewById(R.id.ccp);
            postiveChecked =findViewById(R.id.positivechecked);
            editTextCarrierNumber = findViewById(R.id.editText_carrierNumber);
            ccp.registerCarrierNumberEditText(editTextCarrierNumber);


           }

           private void hideKeyboard() {

           }




    public void nextScreen(View view) {

        if (ccp.isValidFullNumber()){
            startActivity(new Intent(EnterPhoneNumber.this, EnterCode.class));

        } else {
            Toast.makeText(this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
        }
    }
}