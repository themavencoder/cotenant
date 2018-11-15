package com.getmobileltd.cotenant.update_available_space_details;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.getmobileltd.cotenant.R;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class AvailableSpaceDetails extends AppCompatActivity {
    private List<DataSource> dataSourceList;
    private DetailsPagerAdapter adapter;
    private ViewPager viewPager;
    private LikeButton likeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_space_details_merged);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Available space");
        CircleIndicator circleIndicator = findViewById(R.id.indicator);
        dataSourceList = getAllItems();
        adapter = new DetailsPagerAdapter(this,dataSourceList);
        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
        likeButton = findViewById(R.id.like_button);

        likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {

            }

            @Override
            public void unLiked(LikeButton likeButton) {

            }
        });

    }

    private List<DataSource> getAllItems() {
        List<DataSource> items = new ArrayList<>();
        items.add(new DataSource(R.drawable.sample_image));
        items.add(new DataSource(R.drawable.sample_image));
        items.add(new DataSource(R.drawable.sample_image));

        return items;
    }

}
