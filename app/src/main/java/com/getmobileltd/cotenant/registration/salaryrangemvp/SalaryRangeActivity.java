package com.getmobileltd.cotenant.registration.salaryrangemvp;

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
import com.getmobileltd.cotenant.registration.chooselivemvp.ChooseLiveActivity;
import com.getmobileltd.cotenant.registration.livinglengthmvp.LivingLengthActivity;

public class SalaryRangeActivity extends AppCompatActivity {
    Spinner spinner;
    Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_salary_range);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        ArrayAdapter<CharSequence> salaryAdapter = ArrayAdapter.createFromResource(this, R.array.Salary, android.R.layout.simple_spinner_item);
        salaryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(salaryAdapter);
        mButton = findViewById(R.id.btn_choose_salary_range);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SalaryRangeActivity.this, LivingLengthActivity.class));
            }
        });

    }

    private void init() {
        spinner = findViewById(R.id.salarySpinner);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
