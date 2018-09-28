package com.getmobileltd.cotenant.payment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.getmobileltd.cotenant.R;

public class EmptyPayment extends AppCompatActivity {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_payment);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.include4);
        setSupportActionBar(toolbar);
        setTitle("Payment");
        init();
       mButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(EmptyPayment.this,SetUpCardActivity.class));
           }
       });

    }

    private void init() {
        mButton = findViewById(R.id.btn_empty_payment);

    }



}
