package com.getmobileltd.cotenant.registration.apppinmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.lastregmvp.LastRegActivity;

public class AppPinActivity extends AppCompatActivity {
    Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_pin);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        mButton = findViewById(R.id.btn_choose_pin);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        startActivity(new Intent(AppPinActivity.this, LastRegActivity.class));
            }
        });
    }

}
