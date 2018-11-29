package com.getmobileltd.cotenant.interest;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.interest.adapter.InterestAdapter;
import com.getmobileltd.cotenant.interest.api.ApiService;
import com.getmobileltd.cotenant.interest.api.InterestData;
import com.getmobileltd.cotenant.interest.api.InterestResponse;
import com.getmobileltd.cotenant.interest.model.InterestModel;
import com.getmobileltd.cotenant.registration.apppinmvp.Client;
import com.getmobileltd.cotenant.update_dashboard.models.DashboardInterestModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.getmobileltd.cotenant.update_dashboard.DashboardActivity.api_key;

public class InterestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private InterestAdapter adapter;
    private static List<InterestModel> modelList = new ArrayList<>();
    private ApiService mApiService;
    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.include2);
        setSupportActionBar(toolbar);
        setTitle("Interest");
        getAllInterest();

        mSwipeRefreshLayout = findViewById(R.id.activity_dashboard_swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.green_500),getResources().getColor(R.color.green_600),getResources().getColor(R.color.green_700));



        recyclerView = findViewById(R.id.recycler_interest);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));



        if (modelList.isEmpty()) {
            Toast.makeText(this, "Inteest is empty" + modelList.size(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Length is " + modelList.size(), Toast.LENGTH_SHORT).show();
        }

        adapter = new InterestAdapter(getApplicationContext(), modelList);
        recyclerView.setAdapter(adapter);


        refresh();

    }

    private void getAllInterest() {
        mApiService = Client.getClient().create(ApiService.class);
        Call<InterestResponse> call = mApiService.getLocation(api_key, 35);

        call.enqueue(new Callback<InterestResponse>() {
            @Override
            public void onResponse(Call<InterestResponse> call, Response<InterestResponse> response) {
                if (response.body().getStatus().equals("success")) {
                  //  mSwipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(InterestActivity.this, "Yes success", Toast.LENGTH_SHORT).show();
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
                    adapter = new InterestAdapter(getApplicationContext(),modelList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.smoothScrollToPosition(0);
                    mSwipeRefreshLayout.setRefreshing(false);




                }
                else {
                    Toast.makeText(InterestActivity.this, "There was an error processing your result", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<InterestResponse> call, Throwable t) {
                Toast.makeText(InterestActivity.this, "No connection made to host", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void dummyInterest() {
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba","This house is not for sale", "NGN 50 000"));
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba","This house is not for sale", "NGN 50 000"));
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba","This house is not for sale", "NGN 50 000"));
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba","This house is not for sale", "NGN 50 000"));
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba","This house is not for sale", "NGN 50 000"));
        modelList.add(new InterestModel("2 BEDROOM", "Yaba", "42,Montgomerry road, Yaba","This house is not for sale", "NGN 50 000"));

    }
    private void refresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.setAdapter(null);
                modelList.clear();
                getAllInterest();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        modelList.clear();
    }
}
