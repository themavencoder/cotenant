package com.getmobileltd.cotenant.registration.phonenumbermvp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.entercodemvp.EnterCodeActivity;
import com.hbb20.CountryCodePicker;


public class EnterPhoneNumberActivity extends AppCompatActivity implements EnterPhoneNumberContract.View{


    private EditText editTextCarrierNumber;
    private ImageView postiveChecked;
    private EnterPhoneNumberContract.Presenter presenter;
    private Button mButton;
    private static final String DEFAULT_CODE = "+234";
    private AppInstance app;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.enter_mobile_number_registration);
        init();
        presenter = new EnterPhoneNumberPresenter(this);
        presenter.defaultSettings();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = editTextCarrierNumber.getText().toString();
                String result2 = DEFAULT_CODE + result;
                presenter.saveNumber(result2);
                Toast.makeText(EnterPhoneNumberActivity.this, result2, Toast.LENGTH_SHORT).show();
                presenter.loadNextScreen();


            }
        });

    }

    private void init() {
            presenter = new EnterPhoneNumberPresenter(this);

            postiveChecked =findViewById(R.id.positivechecked);
            editTextCarrierNumber = findViewById(R.id.editText_carrierNumber);
            editTextCarrierNumber.addTextChangedListener(watcher);
                     mButton = findViewById(R.id.btn_enter_phone_number);
                     editTextCarrierNumber.setTransformationMethod(new NumericKeyBoardTransformationMethod());

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
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String text = editTextCarrierNumber.getText().toString();



            if (text.length() == 10) {
                presenter.verifyNumber();
                return;
            }

            presenter.defaultSettings();

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }
}