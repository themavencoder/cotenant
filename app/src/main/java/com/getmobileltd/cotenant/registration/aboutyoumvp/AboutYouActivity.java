package com.getmobileltd.cotenant.registration.aboutyoumvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;


import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.aboutyoumvp.utilities.EmailValidator;
import com.getmobileltd.cotenant.registration.apppinmvp.AppPinActivity;
import com.getmobileltd.cotenant.registration.comfortablegendermvp.ComfortableGenderActivity;

import java.util.Objects;

public class AboutYouActivity extends AppCompatActivity implements AboutYouContract.View {
    private AppCompatSpinner spinner;
    private Button mButton;
    private AboutYouContract.Presenter presenter;
    private EditText mFirstName, mLastName, mPhoneNumber, mEmailAddress;
    private TextInputLayout t1, t2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_about_you);

        init();
        presenter = new AboutYouPresenter(this);

        presenter.defaultSettings();


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.loadNextScreen();


                AppInstance app = AppInstance.getInstance();
                app.setFirstName(presenter.firstName());
                app.setLastName(presenter.lastName());
                app.setEmailAddress(presenter.emailAddress());
                app.setPhone_number(presenter.phoneNumber());
                app.setGender(presenter.gender());


            }
        });

    }

    private void init() {
        spinner = findViewById(R.id.genderSpinner);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        mButton = findViewById(R.id.btn_reg_about_you);
        mFirstName = findViewById(R.id.firstname_reg_about_you);
        mLastName = findViewById(R.id.lastname_reg_abou_you);
        mEmailAddress = findViewById(R.id.ediText_emailAddress);
        mPhoneNumber = findViewById(R.id.editText_phoneNumber);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this, R.array.Gender, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(genderAdapter);
        spinner.setSelection(0);
        mFirstName.addTextChangedListener(watch);
        mLastName.addTextChangedListener(watch);
        mEmailAddress.addTextChangedListener(watch);
        mPhoneNumber.addTextChangedListener(watch);
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
    public void navigateToNextScreen() {
      /*  setContentView(R.layout.few_more_questions);
        LinearLayout linearLayout = findViewById(R.id.tapanywheretoContinue);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {*/
        startActivity(new Intent(AboutYouActivity.this, AppPinActivity.class));


        /*    }
        });*/


    }

    @Override
    public void showError(String error) {
        mFirstName.setError(error);


    }

    @Override
    public void showError2(String error) {
        mLastName.setError(error);
    }



/*
   */
 TextWatcher watch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String firstname = mFirstName.getText().toString();
            String lastName = mLastName.getText().toString().trim();
            String emailAddress = mEmailAddress.getText().toString().trim();
            String phoneNumber = mPhoneNumber.getText().toString().trim();



            if (firstname.length() < 4) {


                if (firstname.length() == 3) {
                    presenter.displayError();
                    presenter.defaultSettings();
                    return;
                }

                presenter.defaultSettings();


            }
            if (mLastName.getText().toString().length() < 4) {
                if (mLastName.getText().toString().length() == 3) {
                    presenter.displayError2();
                    presenter.defaultSettings();
                    return;
                }

                presenter.defaultSettings();
                return;
            }
            if (!EmailValidator.isValidEmail(emailAddress)) {
                if (emailAddress.length() > 10) {
                    mEmailAddress.setError("Enter a valid email address");
                    presenter.defaultSettings();
                    return;
                }

                presenter.defaultSettings();
                return;
            }

            if (phoneNumber.length() < 11) {
                presenter.defaultSettings();
                return;

            }
            presenter.saveData(firstname, lastName, emailAddress, phoneNumber, spinner.getSelectedItem().toString());
            presenter.verifyEntries();



        }
    };


}

