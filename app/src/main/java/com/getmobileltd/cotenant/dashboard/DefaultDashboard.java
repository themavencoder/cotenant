package com.getmobileltd.cotenant.dashboard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.history.HistoryActivity;
import com.getmobileltd.cotenant.interest.InterestActivity;
import com.getmobileltd.cotenant.mergedashboard.MergedDashboard;
import com.getmobileltd.cotenant.payment.EmptyPayment;
import com.getmobileltd.cotenant.payment.SetUpCardActivity;

import java.util.ArrayList;
import java.util.List;

public class DefaultDashboard extends AppCompatActivity {
    private List<DefaultDashboardModel> modelList;
    private RecyclerView recyclerView;
    private DefaultDashboardAdapter defaultDashboardAdapter;
    private DrawerLayout d;
    private ActionBarDrawerToggle t;
    private NavigationView nv;


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
        d = findViewById(R.id.drawerLayout);
        t = new ActionBarDrawerToggle(this, d,R.string.Open,R.string.Close);
        d.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {

                    case R.id.your_dashboard:
                        Toast.makeText(DefaultDashboard.this, "Sermons",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.available_space:
                        startActivity(new Intent(DefaultDashboard.this, MergedDashboard.class));
                        break;
                    case R.id.interest:
                        startActivity(new Intent(DefaultDashboard.this, InterestActivity.class));
                        break;
                    case R.id.history:
                        startActivity(new Intent(DefaultDashboard.this, HistoryActivity.class));
                        break;

                    case R.id.payment:
                        startActivity(new Intent(DefaultDashboard.this, EmptyPayment.class));
                        break;

                    default:

                }
                return true;
            }
        });
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }
}
