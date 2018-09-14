package com.getmobileltd.cotenant.dashboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.getmobileltd.cotenant.R;

import java.util.ArrayList;
import java.util.List;

public class DefaultDashboard extends AppCompatActivity {
    private List<DefaultDashboardModel> modelList;
    private RecyclerView recyclerView;
    private DefaultDashboardAdapter defaultDashboardAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        modelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_defaultDashboard);
        defaultDashboardAdapter = new DefaultDashboardAdapter(this,modelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(defaultDashboardAdapter);

        //Populating with same image.
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));


    }
}
