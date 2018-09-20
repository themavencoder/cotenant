package com.getmobileltd.cotenant.registration.comfortablegendermvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.religionchoicemvp.ReligionChoiceActivity;

public class ComfortableGenderActivity extends AppCompatActivity implements ComfortableGenderContract.View{
    private Spinner spinner;
    private Button mButton;
    private ComfortableGenderContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comfortable_gender);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        init();
        presenter = new ComfortableGenderPresenter(this);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this, R.array.Gender, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(genderAdapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadNextScreen();

            }
        });
    }

    private void init() {
        spinner = findViewById(R.id.spinnerComfortable);
        mButton = findViewById(R.id.btn_comfortable_gender);
    }

    @Override
    public void navigateToNextScreen() {
        startActivity(new Intent(this, ReligionChoiceActivity.class));

    }

}
