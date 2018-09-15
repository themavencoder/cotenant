package com.getmobileltd.cotenant.interest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.getmobileltd.cotenant.R;

import java.util.ArrayList;
import java.util.List;

public class InterestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private InterestAdapter adapter;
    private List<InterestModel> modelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.include2);
        setSupportActionBar(toolbar);
        setTitle("Interest");
        modelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_interest);
        adapter = new InterestAdapter(this, modelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        modelList.add(new InterestModel(R.drawable.defaultdashboard));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));
        modelList.add(new InterestModel(R.drawable.interests_apartment));



    }

}
