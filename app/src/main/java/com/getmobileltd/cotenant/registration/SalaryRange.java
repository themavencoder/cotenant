package com.getmobileltd.cotenant.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.getmobileltd.cotenant.R;

public class SalaryRange extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_salary_range);
        init();
        ArrayAdapter<CharSequence> salaryAdapter = ArrayAdapter.createFromResource(this,R.array.Salary,android.R.layout.simple_spinner_item);
        salaryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(salaryAdapter);

    }

    private void init() {
        spinner = findViewById(R.id.salarySpinner);
    }
}
