package com.getmobileltd.cotenant.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.getmobileltd.cotenant.R;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {
    // Array of strings...
    private RecyclerView recyclerView;
    private List<SettingsModel> modelList;
    private SettingsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        android.support.v7.widget.Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        modelList  = new ArrayList<>();
        adapter = new SettingsAdapter(this,modelList);
        recyclerView = findViewById(R.id.recyclerVieww);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);


        modelList.add(new SettingsModel("Profile"));
        modelList.add(new SettingsModel("Legal"));
        modelList.add(new SettingsModel("Help"));
        modelList.add(new SettingsModel("Log out"));





    }

}
