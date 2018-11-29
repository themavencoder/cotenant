package com.getmobileltd.cotenant.update_dashboard;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.database.MyDatabase;
import com.getmobileltd.cotenant.database.table.UserModel;
import com.getmobileltd.cotenant.database.table.UserModel_Table;
import com.getmobileltd.cotenant.history.HistoryActivity;
import com.getmobileltd.cotenant.interest.InterestActivity;
import com.getmobileltd.cotenant.interest.adapter.InterestAdapter;
import com.getmobileltd.cotenant.interest.api.InterestData;
import com.getmobileltd.cotenant.interest.api.InterestResponse;
import com.getmobileltd.cotenant.interest.model.InterestModel;
import com.getmobileltd.cotenant.payment.EmptyPayment;

import com.getmobileltd.cotenant.registration.apppinmvp.Client;
import com.getmobileltd.cotenant.settings.SettingsActivity;
import com.getmobileltd.cotenant.update_available_space.AvailableSpaceActivity;
import com.getmobileltd.cotenant.update_available_space_details.AvailableSpaceDetails;
import com.getmobileltd.cotenant.update_dashboard.adapters.DashboardInterestAdapter;
import com.getmobileltd.cotenant.update_dashboard.adapters.HouseOnClickInterface;
import com.getmobileltd.cotenant.update_dashboard.adapters.LocationAdapter;
import com.getmobileltd.cotenant.update_dashboard.api.ApiService;
import com.getmobileltd.cotenant.update_dashboard.api.LocationOne;
import com.getmobileltd.cotenant.update_dashboard.api.LocationTwo;
import com.getmobileltd.cotenant.update_dashboard.api.TwoLocationResponse;
import com.getmobileltd.cotenant.update_dashboard.api.TwoLocations;
import com.getmobileltd.cotenant.update_dashboard.models.DashboardInterestModel;
import com.getmobileltd.cotenant.update_dashboard.models.HousesModel;
import com.getmobileltd.cotenant.update_dashboard.models.LocationModel;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewInterest;
    private LocationAdapter locationAdapter;
    private InterestAdapter interestAdapter;
    private List<InterestModel> modelList = new ArrayList<>();
    private List<LocationModel> locationModelList = new ArrayList<>();
    private DrawerLayout d;
    private ActionBarDrawerToggle t;
    private ImageView imageView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private NavigationView nv;
    private TextView mFullName, mWorkPlace;
    private ApiService mApiService;
    public static String api_key = "YxOhbH00LdvzLFlY3rFXWC15bPRJWp7nEonxqR2LAE3RjTCNXp$2y$10$9Wn.dPfS9DzdHnd.pHjtzupKE8azq1eTXGQzQPSQHTL.JC1ZwGOH2vDTFa2vpGizwyBvFLxexqGXiL0h1ZQvu6n08TYzwsiTjdwD746QcYD3OJQi4wI75XgQDhLo7ktZYrRUi2KJ4MXsE3h8SnFXwqdQ4fAecrVpbTvRM3PACiiAHZoiAr5UtOF9OeRKkJ4px2JSyk";
    private TwoLocations twoLocations;
    private String a = "Yaba";
    private String b = "Surulere";
    private com.getmobileltd.cotenant.interest.api.ApiService interestApi;
    private List<LocationModel> emptyList = new ArrayList<>();
   UserModel userModel;
    public static final String HOUSEMODEL = "house_model";
    public static final String HOUSE_KEY = "house";
    final static int Gallery_Pick = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Dashboard");

        mSwipeRefreshLayout = findViewById(R.id.activity_dashboard_swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.green_500),getResources().getColor(R.color.green_600),getResources().getColor(R.color.green_700));

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerViewInterest = findViewById(R.id.recycler_view_dashboard_interest);
        recyclerViewInterest.setHasFixedSize(true);
        nv = findViewById(R.id.nv);
        NavigationMenuView navMenuView = (NavigationMenuView) nv.getChildAt(0);
        View header = nv.getHeaderView(0);
        imageView = header.findViewById(R.id.circleImageView);
        mFullName = header.findViewById(R.id.fullName);
        mWorkPlace = header.findViewById(R.id.workPlace);

      userModel = SQLite.select()
               .from(UserModel.class)
        .where(UserModel_Table.id.eq(1)).querySingle();

      String firstName = userModel.getFirstName();
      String lastName = userModel.getLastName();
      String workPlace = userModel.getPlaceOfWork();

        mFullName.setText(firstName + " " + lastName );
        mWorkPlace.setText(workPlace);
        navProfileImageClick();

        navMenuView.isSelected();
        //  dummyInterest();
        //   dummyData();
        getAllInterest();
        getLocation();


        locationAdapter = new LocationAdapter(this, locationModelList);
        interestAdapter = new InterestAdapter(this, modelList);
        recyclerViewInterest.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewInterest.setAdapter(interestAdapter);
        recyclerView.setAdapter(locationAdapter);
        d = findViewById(R.id.drawerLayout);
        t = new ActionBarDrawerToggle(this, d, R.string.Open, R.string.Close);
        d.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        refresh();


        HouseOnClickInterface houseOnClickInterface = new HouseOnClickInterface() {
            @Override
            public void showDetails(HousesModel housesModel) {
                Intent intent = new Intent(DashboardActivity.this, AvailableSpaceDetails.class);
                intent.putExtra(HOUSEMODEL, housesModel);
                startActivity(intent);
            }
        };
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

    private void refresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
             // recyclerView.setAdapter(null);
           //recyclerViewInterest.setAdapter(null);
               locationModelList.clear();
              modelList.clear();
                getLocation();
                getAllInterest();

            }
        });
    }

    private void navProfileImageClick() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, Gallery_Pick);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
       // refresh();

    }

    private void dummyInterest() {
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba","This is an example of an addtional detail", "NGN 50 000"));
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "vvffv","NGN 50 000"));
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "ddvdvdv", "NGN 50 000"));
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba", "dddd", "NGN 50 000"));
        if (modelList.isEmpty()) {
            findViewById(R.id.empty_interest).setVisibility(View.VISIBLE);
        }
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
        Call<TwoLocationResponse> call = mApiService.getLocation(api_key, a, b);
        call.enqueue(new Callback<TwoLocationResponse>() {
            @Override
            public void onResponse(Call<TwoLocationResponse> call, Response<TwoLocationResponse> response) {

                if (response.body().getStatus().equals("success")) {
                    List<LocationOne> model1 = new ArrayList<>();
                    List<LocationTwo> model2 = new ArrayList<>();
                    List<HousesModel> modelHouse = new ArrayList<>();
                    List<HousesModel> modelHouse2 = new ArrayList<>();
                    model1 = response.body().getData().getLocation_one();
                    LocationModel locationModelOne = new LocationModel();
                    locationModelOne.setLocationOfPlace("Yaba");

                                for (LocationOne m : model1) {
                                    String bathroom = m.getBathroom();
                                    String location = m.getLocation();
                                    String address = m.getAddress();
                                    String amount = m.getAmount();
                                    String image = m.getImage();
                                    String additional_details = m.getDescription();
                                    int id = m.getId();
                                    modelHouse.add(new HousesModel(bathroom, location, address, amount, additional_details, id));

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
                                String additional_details = m.getDescription();
                                int id = m.getId();


                                modelHouse2.add(new HousesModel(bathroom, location, address, amount, additional_details, id));
                            }
                            locationModelTwo.setModelList(modelHouse2);
                            locationModelList.add(locationModelTwo);
                            mSwipeRefreshLayout.setRefreshing(false);


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Gallery_Pick && resultCode == RESULT_OK && data != null) {
            Uri ImageUri = data.getData();
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1, 1)
                    .start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK) {

                final Uri resultUri = result.getUri();
                imageView.setImageURI(resultUri);

            }

        }
    }
    private void getAllInterest() {
        interestApi = Client.getClient().create(com.getmobileltd.cotenant.interest.api.ApiService.class);
        Call<InterestResponse> call = interestApi.getLocation(api_key, 35);

        call.enqueue(new Callback<InterestResponse>() {
            @Override
            public void onResponse(Call<InterestResponse> call, Response<InterestResponse> response) {
                if (response.body().getStatus().equals("success")) {
                    findViewById(R.id.empty_interest).setVisibility(View.GONE);
                    recyclerViewInterest.setVisibility(View.VISIBLE);
                    //  mSwipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(DashboardActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
                    List<InterestData> results = new ArrayList<>();
                    results =  response.body().getData();

                    for (InterestData m : results ) {
                        String bathroom = m.getBathroom();
                        String location = m.getLocation();
                        String address = m.getAddress();
                        String amount = m.getAmount();
                        String additional_details = m.getDescription();
                        modelList.add(new InterestModel(bathroom,location,address,additional_details,amount));


                    }
                    interestAdapter = new InterestAdapter(getApplicationContext(),modelList);
                    recyclerViewInterest.setLayoutManager(new LinearLayoutManager(DashboardActivity.this,LinearLayoutManager.HORIZONTAL,false));
                    recyclerViewInterest.setAdapter(interestAdapter);

                    mSwipeRefreshLayout.setRefreshing(false);




                }
                else {
                    if (response.body().getCode() == 404)
                        findViewById(R.id.empty_interest).setVisibility(View.VISIBLE);
                        recyclerViewInterest.setVisibility(View.GONE);
                    Toast.makeText(DashboardActivity.this, "No saved interest", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<InterestResponse> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "No connection made to host", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        modelList.clear();
    }
}