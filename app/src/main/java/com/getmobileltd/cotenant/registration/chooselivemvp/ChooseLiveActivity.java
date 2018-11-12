package com.getmobileltd.cotenant.registration.chooselivemvp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.chooseworkmvp.ChooseWorkActivity;
import com.hootsuite.nachos.NachoTextView;
import com.hootsuite.nachos.chip.Chip;
import com.hootsuite.nachos.terminator.ChipTerminatorHandler;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ChooseLiveActivity extends AppCompatActivity {
    private Button mButton;
     private NachoTextView nachoTextView;
     private AppInstance app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_live);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        app = AppInstance.getInstance();
        mButton = findViewById(R.id.btn_choose_live);


        nachoTextView = findViewById(R.id.nacho_text_view);
        nachoTextView.enableEditChipOnTouch(true,true);
        nachoTextView.addChipTerminator(' ', ChipTerminatorHandler.BEHAVIOR_CHIPIFY_TO_TERMINATOR);
       // nachoTextView.addChipTerminator('\n', ChipTerminatorHandler.BEHAVIOR_CHIPIFY_TO_TERMINATOR);
        nachoTextView.setIllegalCharacters('.',',','!');
        /*nachoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nachoTextView.getAllChips().size() == 2) {
                    mButton.setEnabled(true);
                    mButton.setBackground(getResources().getDrawable(R.drawable.btn_red));
                    return;
                }

                if (nachoTextView.getAllChips().size() < 2 || nachoTextView.getAllChips().size() > 2 ) {
                    mButton.setEnabled(false);
                    mButton.setBackground(getResources().getDrawable(R.drawable.btn_ash));
                }
            }
        });
*/
       /* nachoTextView.setOnChipClickListener(new NachoTextView.OnChipClickListener() {
            @Override
            public void onChipClick(Chip chip, MotionEvent event) {
                if (nachoTextView.getAllChips().size() == 2) {
                    mButton.setEnabled(true);
                    mButton.setBackground(getResources().getDrawable(R.drawable.btn_red));
                     return;
                }

                if (nachoTextView.getAllChips().size() < 2 || nachoTextView.getAllChips().size() > 2 ) {
                    mButton.setEnabled(false);
                    mButton.setBackground(getResources().getDrawable(R.drawable.btn_ash));
                }
            }
        });*/


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             List<Chip> chip = nachoTextView.getAllChips();
             if (chip.size() == 2 ) {

                 app.setLocation_1(chip.get(0).toString());
                 app.setLocation_2(chip.get(1).toString());
                 startActivity(new Intent(ChooseLiveActivity.this, ChooseWorkActivity.class));
             }
             else {
                 Toast.makeText(ChooseLiveActivity.this, "Enter two locations only! Terminate each location with a space", Toast.LENGTH_LONG).show();
             }
            }
        });


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
