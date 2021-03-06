package com.getmobileltd.cotenant.registration.livinglengthmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp.ChooseMonthlyPayment;

public class LivingLengthActivity extends AppCompatActivity implements LivingLengthContractor.View {
    private Spinner spinner;
    private Button mButton;
    private AppInstance app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_living_length);
    Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        init();
        ArrayAdapter<CharSequence> billingAdapter = ArrayAdapter.createFromResource(this, R.array.Duration, android.R.layout.simple_spinner_item);
        billingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(billingAdapter);

        mButton = findViewById(R.id.btn_choose_living_length);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a  = spinner.getSelectedItem().toString();
              char aa = a.charAt(0);
              String result = aa + "";
                Toast.makeText(LivingLengthActivity.this, a, Toast.LENGTH_SHORT).show();
              Toast.makeText(LivingLengthActivity.this, result, Toast.LENGTH_SHORT).show();
              app.setDuration(result);
                setContentView(R.layout.wrap_it_up);
                LinearLayout wrapitup = findViewById(R.id.wrapitup);
                wrapitup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(LivingLengthActivity.this, ChooseMonthlyPayment.class));

                    }
                });
            }
        });
    }


    private void init() {
        app = AppInstance.getInstance();

        spinner = findViewById(R.id.billingSpinner);
    }

    @Override
    public void navigateNextScreen() {

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
