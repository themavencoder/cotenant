package com.getmobileltd.cotenant.registration.aboutyoumvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.Button;
import android.widget.EditText;


import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.comfortablegendermvp.ComfortableGenderActivity;

public class AboutYouActivity extends AppCompatActivity implements AboutYouContract.View {
    private AppCompatSpinner spinner;
    private Button mButton;
    private AboutYouContract.Presenter presenter;
    private EditText mFirstName, mLastName;


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
               String text = spinner.getSelectedItem().toString();


             presenter.loadNextScreen();



           }
       });

    }

    private void init() {
        spinner = findViewById(R.id.genderSpinner);
        mButton = findViewById(R.id.btn_reg_about_you);
        mFirstName = findViewById(R.id.firstname_reg_about_you);
        mLastName = findViewById(R.id.lastname_reg_abou_you);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,R.array.Gender,android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(genderAdapter);
        mFirstName.addTextChangedListener(watch);
        mLastName.addTextChangedListener(watch);

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
        setContentView(R.layout.few_more_questions);
        startActivity(new Intent(this, ComfortableGenderActivity.class));

    }
    TextWatcher watch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            presenter.saveData(mFirstName.getText().toString(),mLastName.getText().toString(),spinner.getSelectedItem().toString());
            presenter.verifyEntries();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
