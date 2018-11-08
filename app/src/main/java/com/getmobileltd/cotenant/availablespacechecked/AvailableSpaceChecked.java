package com.getmobileltd.cotenant.availablespacechecked;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.update_available_space_details.DataSource;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class AvailableSpaceChecked extends AppCompatActivity {
    private List<DataSource> listItem;
    private ViewPager viewPager;
    private PagerSpaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_space_checked);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Available space");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = findViewById(R.id.viewPager);
        CircleIndicator circleIndicator = findViewById(R.id.indicator);

        listItem = getAllItems();
        adapter = new PagerSpaceAdapter(this,listItem);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);


    }

    private List<DataSource> getAllItems() {
        List<DataSource> listItem = new ArrayList<>();

        listItem.add(new DataSource(R.drawable.merged_dashborad));
        listItem.add(new DataSource(R.drawable.defaultdashboard));
        listItem.add(new DataSource(R.drawable.merged_dashborad));

        return listItem;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
