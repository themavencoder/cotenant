package com.getmobileltd.cotenant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.getmobileltd.cotenant.registration.chooseworkmvp.ChooseWorkModel;

public class TestActivity extends AppCompatActivity {
    TextView tv,tv2,tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

 /*       tv = findViewById(R.id.sampletext);
        tv2 = findViewById(R.id.sampletext2);
        tv3 = findViewById(R.id.sampletext3);
       AppInstance app = AppInstance.getInstance();
       String data = app.getFirstName();
       tv.setText(data);
       String data2 = app.getLastName();
       String data3 = app.getWork();
tv2.setText(data2);
tv3.setText(data3);
*/
 AppInstance app = (AppInstance)getApplication();

    }
}
