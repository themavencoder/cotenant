package com.getmobileltd.cotenant.registration.religionchoicemvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import android.widget.RadioGroup;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.choosesmokemvp.ChooseSmokeActivity;

public class ReligionChoiceActivity extends AppCompatActivity implements ReligionChoiceContract.View, RadioGroup.OnCheckedChangeListener {


    private ReligionChoiceContract.Presenter presenter;
RadioGroup radioGroup1, radioGroup2;
RadioButton selectedRadioButton1,selectedRadioButton2;
     private Button mButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_religion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        presenter = new ReligionChoicePresenter(this);
        presenter.defaultSettings();








            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedRadioButton1 = findViewById(radioGroup1.getCheckedRadioButtonId());
                    selectedRadioButton2 = findViewById(radioGroup2.getCheckedRadioButtonId());

                    String yourreligion = selectedRadioButton1.getText().toString();
                    String yourreligion2 = selectedRadioButton2.getText().toString();
                    Toast.makeText(ReligionChoiceActivity.this, yourreligion, Toast.LENGTH_SHORT).show();
                    Toast.makeText(ReligionChoiceActivity.this, yourreligion2, Toast.LENGTH_SHORT).show();
                    presenter.saveReligionChoice(yourreligion);
                    presenter.saveRoomateReligion(yourreligion2);
                    presenter.loadNextScreen();






                }
            });
    }


    private void init() {

        mButton = findViewById(R.id.btn_choose_religion);
        radioGroup1 = findViewById(R.id.myreligion);
        radioGroup2 = findViewById(R.id.roomatereligion);
radioGroup1.setOnCheckedChangeListener(this);
radioGroup2.setOnCheckedChangeListener(this);








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
    public void naviagateNextScreen() {
        startActivity(new Intent(this, ChooseSmokeActivity.class));

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (radioGroup.getId()) {
            case R.id.myreligion:
                if (radioGroup1.getCheckedRadioButtonId() != -1 && radioGroup2.getCheckedRadioButtonId() != -1) {
                    presenter.verifyEntries();

                }
            case R.id.roomatereligion:
                if (radioGroup2.getCheckedRadioButtonId() != -1 && radioGroup1.getCheckedRadioButtonId() != -1) {
                    presenter.verifyEntries();

                }
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
