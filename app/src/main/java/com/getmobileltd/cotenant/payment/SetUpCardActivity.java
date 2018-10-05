package com.getmobileltd.cotenant.payment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.getmobileltd.cotenant.R;

public class SetUpCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_card);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Payment");
     }

    public void nextScreenLoad(View view) {
        setContentView(R.layout.item_saved_cards);
    }
}
