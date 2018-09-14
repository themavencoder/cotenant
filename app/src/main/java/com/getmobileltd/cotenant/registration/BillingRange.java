package com.getmobileltd.cotenant.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.getmobileltd.cotenant.R;

public class BillingRange extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_billing);
        init();
        ArrayAdapter<CharSequence> billingAdapter = ArrayAdapter.createFromResource(this,R.array.Duration,android.R.layout.simple_spinner_item);
        billingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(billingAdapter);
    }

    private void init() {
        spinner =findViewById(R.id.billingSpinner);
    }
}
