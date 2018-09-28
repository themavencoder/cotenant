package com.getmobileltd.cotenant.registration.choosedisabilitymvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.chooselivemvp.ChooseLiveActivity;

public class ChooseDisabilityActivity extends AppCompatActivity implements ChooseDisablityContract.View, RadioGroup.OnCheckedChangeListener {
    private ChooseDisablityContract.Presenter presenter;
    private Button mButton;
    private RadioGroup mRadioGroup1, mRadioGroup2;
    private RadioButton mRadioButton1, mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_disability);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");

        init();
        presenter = new ChooseDisablityPresenter(this);
        presenter.defaultSettings();


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRadioButton1 = findViewById(mRadioGroup1.getCheckedRadioButtonId());
                mRadioButton2 = findViewById(mRadioGroup2.getCheckedRadioButtonId());
                presenter.saveDisabilityChoice(mRadioButton1.getText().toString());
                presenter.saveRoomateDisability(mRadioButton2.getText().toString());
                Toast.makeText(ChooseDisabilityActivity.this, mRadioButton1.getText().toString(), Toast.LENGTH_SHORT).show();

                Toast.makeText(ChooseDisabilityActivity.this, mRadioButton2.getText().toString(), Toast.LENGTH_SHORT).show();
                presenter.loadNextScreen();

            }
        });

    }

    private void init() {
        mButton = findViewById(R.id.btn_choose_disabliity);
        mRadioGroup1 = findViewById(R.id.yourdisability);
        mRadioGroup2 = findViewById(R.id.roomatedisability);
        mRadioGroup1.setOnCheckedChangeListener(this);
        mRadioGroup2.setOnCheckedChangeListener(this);
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
       setContentView(R.layout.great_job);
        LinearLayout linearLayout = findViewById(R.id.linearlayout_greatjob);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseDisabilityActivity.this, ChooseLiveActivity.class));


            }
        });

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
       switch(radioGroup.getId()) {
           case R.id.yourdisability:
               if(mRadioGroup1.getCheckedRadioButtonId() != -1 && mRadioGroup2.getCheckedRadioButtonId() !=  -1 ) {
                   presenter.verifyEntries();
               }
               break;
           case R.id.roomatedisability:
               if(mRadioGroup2.getCheckedRadioButtonId() != -1 && mRadioGroup1.getCheckedRadioButtonId() != -1) {
                   presenter.verifyEntries();
               }
               break;

           default:

               Log.i(getCallingPackage(),"RadioGroupID does not exist");

       }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
