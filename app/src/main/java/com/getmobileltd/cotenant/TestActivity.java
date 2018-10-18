package com.getmobileltd.cotenant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    TextView tv, tv2, tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv = findViewById(R.id.sampletext);
        AppInstance instance = AppInstance.getInstance();
        String emailaddress = instance.getEmailAddress();
        String password = instance.getPassword();
        String firstName = instance.getFirstName();
        String lastName = instance.getLastName();
        String gender = instance.getGender();
        String phoneNumber = instance.getPhone_number();

        tv.setText("Your email address is "
                + emailaddress +
                "\n password is "
                + password +
                "\n  first name is "
                + firstName +
                "\n last name is"
                + lastName +
                "\n gender is "
                + gender +
                "\n Phone number is " +
                phoneNumber);

    }
}
