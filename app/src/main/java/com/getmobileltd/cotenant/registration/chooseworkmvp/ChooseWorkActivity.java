package com.getmobileltd.cotenant.registration.chooseworkmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.salaryrangemvp.SalaryRangeActivity;

public class ChooseWorkActivity extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_work);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");

        mButton = findViewById(R.id.btn_choose_work);
       mButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(),SalaryRangeActivity.class);
               startActivity(intent);
           }
       });
    }
}
