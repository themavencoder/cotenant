package com.getmobileltd.cotenant.update_dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.history.HistoryActivity;
import com.getmobileltd.cotenant.interest.InterestActivity;
import com.getmobileltd.cotenant.payment.EmptyPayment;
import com.getmobileltd.cotenant.settings.SettingsActivity;
import com.getmobileltd.cotenant.update_available_space.AvailableSpaceActivity;
import com.getmobileltd.cotenant.update_dashboard.adapters.DashboardInterestAdapter;
import com.getmobileltd.cotenant.update_dashboard.adapters.LocationAdapter;
import com.getmobileltd.cotenant.update_dashboard.models.DashboardInterestModel;
import com.getmobileltd.cotenant.update_dashboard.models.HousesModel;
import com.getmobileltd.cotenant.update_dashboard.models.LocationModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewInterest;
    private LocationAdapter locationAdapter;
    private DashboardInterestAdapter interestAdapter;
    private List<DashboardInterestModel> interestModelList = new ArrayList<>();
    private List<LocationModel> locationModelList = new ArrayList<>();
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
        recyclerViewInterest = findViewById(R.id.recycler_view_dashboard_interest);
        recyclerViewInterest.setHasFixedSize(true);
        nv = findViewById(R.id.nv);
        NavigationMenuView navMenuView = (NavigationMenuView) nv.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        navMenuView.isSelected();
      //  dummyInterest();
        dummyData();
        if (interestModelList.isEmpty()) {
            findViewById(R.id.empty_interest).setVisibility(View.VISIBLE);
        }
        locationAdapter = new LocationAdapter(this, locationModelList);
        interestAdapter = new DashboardInterestAdapter(this, interestModelList);
        recyclerViewInterest.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewInterest.setAdapter(interestAdapter);
        recyclerView.setAdapter(locationAdapter);
        d = findViewById(R.id.drawerLayout);
        t = new ActionBarDrawerToggle(this, d, R.string.Open, R.string.Close);
        d.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {

                    case R.id.your_dashboard:
                        Toast.makeText(DashboardActivity.this, "Sermons", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.available_space:
                        startActivity(new Intent(DashboardActivity.this, AvailableSpaceActivity.class));
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

    private void dummyInterest() {
        interestModelList.add(new DashboardInterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
        interestModelList.add(new DashboardInterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
        interestModelList.add(new DashboardInterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
        interestModelList.add(new DashboardInterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
        interestModelList.add(new DashboardInterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
    }


    private void dummyData() {
        LocationModel locationModel = new LocationModel();
        LocationModel locationModel2 = new LocationModel();
        int i = 0;

        locationModel.setLocationOfPlace("Yaba");
        List<HousesModel> model = new ArrayList<>();
        model.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
        model.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
        model.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
        model.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
        model.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));
        model.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.defaultimage));

        locationModel.setModelList(model);

        locationModelList.add(locationModel);

        locationModel2.setLocationOfPlace("Surulere");
        List<HousesModel> model1 = new ArrayList<>();
        model1.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.secondsample));
        model1.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.secondsample));
        model1.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.secondsample));
        model1.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.secondsample));
        model1.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.secondsample));
        model1.add(new HousesModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "NGN 50 000", R.drawable.secondsample));

        locationModel2.setModelList(model1);

        locationModelList.add(locationModel2);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }
}
