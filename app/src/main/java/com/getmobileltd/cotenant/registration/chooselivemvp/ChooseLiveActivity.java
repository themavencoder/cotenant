package com.getmobileltd.cotenant.registration.chooselivemvp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.chooseworkmvp.ChooseWorkActivity;

public class ChooseLiveActivity extends AppCompatActivity {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_live);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        mButton = findViewById(R.id.btn_choose_live);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseLiveActivity.this, ChooseWorkActivity.class));

            }
        });


    }
}
