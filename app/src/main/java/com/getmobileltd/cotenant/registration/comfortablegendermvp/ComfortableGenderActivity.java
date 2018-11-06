package com.getmobileltd.cotenant.registration.comfortablegendermvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.religionchoicemvp.ReligionChoiceActivity;

public class ComfortableGenderActivity extends AppCompatActivity implements ComfortableGenderContract.View, RadioGroup.OnCheckedChangeListener {
    private Spinner spinner;
    private Button mButton;
    private ComfortableGenderContract.Presenter presenter;
    private AppInstance app;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comfortable_gender);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        init();
        presenter = new ComfortableGenderPresenter(this);
        presenter.defaultSettings();


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRadioButton = findViewById(mRadioGroup.getCheckedRadioButtonId());
                String co_gender = mRadioButton.getText().toString();
                Toast.makeText(ComfortableGenderActivity.this, co_gender, Toast.LENGTH_SHORT).show();
                app.setCo_gender(co_gender);
                presenter.loadNextScreen();

            }
        });
    }

    private void init() {

        mButton = findViewById(R.id.btn_comfortable_gender);
        app = AppInstance.getInstance();
        mRadioGroup = findViewById(R.id.roomategender);
        mRadioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void showButtonClick(boolean b) {
        mButton.setEnabled(b);
    }

    @Override
    public void setButtonColor(int color) {
        mButton.setBackground(getResources().getDrawable(color));

    }

    @Override
    public void navigateToNextScreen() {
        startActivity(new Intent(this, ReligionChoiceActivity.class));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id = radioGroup.getId();
        if (mRadioGroup.getCheckedRadioButtonId() != -1) {
            presenter.verifyEntries();
        }
    }
}
