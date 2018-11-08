package com.getmobileltd.cotenant.update_dashboard;

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
import com.getmobileltd.cotenant.availablespacechecked.AvailableSpaceChecked;
import com.getmobileltd.cotenant.dashboard.DefaultDashboard;
import com.getmobileltd.cotenant.history.HistoryActivity;
import com.getmobileltd.cotenant.interest.InterestActivity;
import com.getmobileltd.cotenant.payment.EmptyPayment;
import com.getmobileltd.cotenant.settings.SettingsActivity;
import com.getmobileltd.cotenant.update_dashboard.adapters.LocationAdapter;
import com.getmobileltd.cotenant.update_dashboard.models.HousesModel;
import com.getmobileltd.cotenant.update_dashboard.models.LocationModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LocationAdapter locationAdapter;
    private List<LocationModel>  locationModelList = new ArrayList<>();
    private DrawerLayout d;
    private ActionBarDrawerToggle t;
    private NavigationView nv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Dashboard");
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        dummyData();
        locationAdapter = new LocationAdapter(this,locationModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(locationAdapter);
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
                        Toast.makeText(DashboardActivity.this, "Sermons",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.available_space:
                        startActivity(new Intent(DashboardActivity.this, AvailableSpaceChecked.class));
                        break;
                    case R.id.interest:
                        startActivity(new Intent(DashboardActivity.this, InterestActivity.class));
                        break;
                    case R.id.history:
                        startActivity(new Intent(DashboardActivity.this, HistoryActivity.class));
                        break;

                    case R.id.payment:
                        startActivity(new Intent(DashboardActivity.this, EmptyPayment.class));
                        break;

                    case R.id.settings:
                        startActivity(new Intent(DashboardActivity.this, SettingsActivity.class));
                        break;

                    default:

                }
                return true;
            }
        });






    }

    private void dummyData() {
        LocationModel locationModel = new LocationModel();
        int i = 0;
        while (i < 3) {
            locationModel.setLocationOfPlace("Yaba");
            List<HousesModel> model = new ArrayList<>();
            model.add(new HousesModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
            model.add(new HousesModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
            model.add(new HousesModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
            model.add(new HousesModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
            model.add(new HousesModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
            model.add(new HousesModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));

            locationModel.setModelList(model);

            locationModelList.add(locationModel);

            i++;

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }
}
