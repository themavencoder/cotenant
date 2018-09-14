package com.getmobileltd.cotenant.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.support.v7.widget.AppCompatSpinner;


import com.getmobileltd.cotenant.R;

public class AboutYou extends AppCompatActivity {
    AppCompatSpinner spinner;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_about_you);
        init();
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,R.array.Gender,android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       spinner.setAdapter(genderAdapter);

    }

    private void init() {
        spinner = findViewById(R.id.genderSpinner);

    }
}
