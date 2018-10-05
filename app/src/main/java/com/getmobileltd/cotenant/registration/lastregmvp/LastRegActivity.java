package com.getmobileltd.cotenant.registration.lastregmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.TestActivity;
import com.getmobileltd.cotenant.dashboard.DefaultDashboard;

public class LastRegActivity extends AppCompatActivity {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_reg);
        Toolbar toolbar = findViewById(R.id.include3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        mButton = findViewById(R.id.skip_to_dashboard);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LastRegActivity.this, DefaultDashboard.class));
            }
        });
    }
}
