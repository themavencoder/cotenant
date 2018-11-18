package com.getmobileltd.cotenant.update_dashboard;

import android.content.Intent;
import android.location.Location;
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
import com.getmobileltd.cotenant.registration.apppinmvp.Client;
import com.getmobileltd.cotenant.settings.SettingsActivity;
import com.getmobileltd.cotenant.update_available_space.AvailableSpaceActivity;
import com.getmobileltd.cotenant.update_dashboard.adapters.DashboardInterestAdapter;
import com.getmobileltd.cotenant.update_dashboard.adapters.LocationAdapter;
import com.getmobileltd.cotenant.update_dashboard.api.ApiService;
import com.getmobileltd.cotenant.update_dashboard.api.LocationOne;
import com.getmobileltd.cotenant.update_dashboard.api.LocationTwo;
import com.getmobileltd.cotenant.update_dashboard.api.TwoLocationResponse;
import com.getmobileltd.cotenant.update_dashboard.api.TwoLocations;
import com.getmobileltd.cotenant.update_dashboard.models.DashboardInterestModel;
import com.getmobileltd.cotenant.update_dashboard.models.HousesModel;
import com.getmobileltd.cotenant.update_dashboard.models.LocationModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private ApiService mApiService;
    public static String api_key = "qpy4HYo3ct5iIO6oDEBdUNgGd8Kkb2mnU0hM4hiyMDU9zRSMUP$2y$10$XaeWYtEQBOyyeHINATHx/eemd.bJPmHa/U1TZ4Xwty8AfFr0FTxMi7iGYyK19Ll1kZTKpWi4W4crDFZMav3KQWj6yl22yDJOyTuFBWwPsfKzw2VA4uQEdVj4vH8lI0ZNNpigNs1xcvYaOsxc2et2gJdxTvNXmFVA1K9uiXw9vNuwqOy34VYZPtbBRINT8wzVdVLHGt";
    private TwoLocations twoLocations;
    private String a = "Yaba";
    private String b = "Surulere";

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
     //   dummyData();
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

        getLocation();
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


   /* private void dummyData() {
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
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }

    private void getLocation() {
        mApiService = Client.getClient().create(ApiService.class);
        Call<TwoLocationResponse> call = mApiService.getLocation(api_key,a,b);
        call.enqueue(new Callback<TwoLocationResponse>() {
            @Override
            public void onResponse(Call<TwoLocationResponse> call, Response<TwoLocationResponse> response) {

                    if (response.body().getStatus().equals("success")) {
                        List<LocationOne> model1 = new ArrayList<>();
                        List<LocationTwo> model2 = new ArrayList<>();
                        List<HousesModel> modelHouse = new ArrayList<>();
                        List<HousesModel> modelHouse2 = new ArrayList<>();
                       model1 =    response.body().getData().getLocation_one();
                         response.body().getData().getLocation_two();
                         LocationModel locationModelOne = new LocationModel();
                         locationModelOne.setLocationOfPlace("Yaba");
                         for (LocationOne m : model1) {
                             String bathroom = m.getBathroom();
                             String location = m.getLocation();
                             String address = m.getAddress();
                             String amount = m.getAmount();
                             String image = m.getImage();
                             modelHouse.add(new HousesModel(bathroom,location, address, amount));

                         }
                         locationModelOne.setModelList(modelHouse);
                         locationModelList.add(locationModelOne);


                        model2 = response.body().getData().getLocation_two();
                        LocationModel locationModelTwo = new LocationModel();
                        locationModelTwo.setLocationOfPlace("Surulere");
                        for (LocationTwo m : model2) {
                            String bathroom = m.getBathroom();
                            String location = m.getLocation();
                            String address = m.getAddress();
                            String amount = m.getAmount();


                            modelHouse2.add(new HousesModel(bathroom,location,address,amount));
                        }
                        locationModelTwo.setModelList(modelHouse2);
                        locationModelList.add(locationModelTwo);


                        locationAdapter = new LocationAdapter(getApplicationContext(), locationModelList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                        recyclerView.setAdapter(locationAdapter);
                        recyclerView.smoothScrollToPosition(0);


                    } else {
                        Toast.makeText(DashboardActivity.this, "Falied in the response method", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(Call<TwoLocationResponse> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Fatal failure " + t.fillInStackTrace(), Toast.LENGTH_LONG).show();

            }
        });


    }
}
