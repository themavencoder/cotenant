package com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.apppinmvp.AppPinActivity;

public class ChooseMonthlyPayment extends AppCompatActivity {
Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_monthly_payment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        mButton = findViewById(R.id.btn_choose_monthly_payment);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.wrap_it_up);
                startActivity(new Intent(ChooseMonthlyPayment.this, AppPinActivity.class));
            }
        });


    }
}
