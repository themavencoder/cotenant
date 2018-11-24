package com.getmobileltd.cotenant.update_available_space_details;

import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.database.table.Favorites;
import com.getmobileltd.cotenant.database.table.Favorites_Table;
import com.getmobileltd.cotenant.update_dashboard.adapters.HousesAdapter;
import com.getmobileltd.cotenant.update_dashboard.models.HousesModel;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

import static com.getmobileltd.cotenant.update_dashboard.adapters.HousesAdapter.HOUSEADAPTER;

public class AvailableSpaceDetails extends AppCompatActivity {
    private List<DataSource> dataSourceList;
    private DetailsPagerAdapter adapter;
    private ViewPager viewPager;
    private LikeButton likeButton;
    private TextView mBedroom, mLocation, mAddressLocation, mAddtionalDetails;
    private HousesModel housesModel;
    private static final String SHARED_PREF = "shared_prefs";
    private static final String LIKE = "like";
    private static final String iD = "id";
    private int id;

        private boolean checkLike;
        private boolean like;
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
        housesModel = new HousesModel();
        housesModel = getIntent().getParcelableExtra(HOUSEADAPTER);
        likeButton = findViewById(R.id.like_button);

        List<Favorites> favorites = SQLite.select()
                .from(Favorites.class)
                .where(Favorites_Table.isLike.eq(true)).queryList();

       for (int i = 0; i < favorites.size(); i++) {
           if (favorites.get(i).getId() == housesModel.getId()) {
            likeButton.setLiked(true);
           }
       }


        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);









        likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {

                Favorites favorites = new Favorites();
                if (housesModel != null) {
                    favorites.setId(housesModel.getId());
                }
                favorites.setLike(true);
                favorites.save();

            }

            @Override
            public void unLiked(LikeButton likeButton) {
                Favorites favorites = new Favorites();
                if (housesModel != null) {
                    favorites.setId(housesModel.getId());
                }
                favorites.setLike(false);
                favorites.save();


            }
        });

            init();

            if (housesModel != null) {


                populateViews();
            }
    }

    private void populateViews() {
        mBedroom.setText(housesModel.getBedroom());
        mLocation.setText(housesModel.getStateLocation());
        mAddressLocation.setText(housesModel.getAddressLocation());
        mAddtionalDetails.setText(housesModel.getAdditional_details());
        id = housesModel.getId();
    }

    private void init() {
        mBedroom =findViewById(R.id.bedroomNumber);
        mLocation = findViewById(R.id.stateLocation);
        mAddressLocation  = findViewById(R.id.addressLocation);
        mAddtionalDetails = findViewById(R.id.textView32);


    }

    private List<DataSource> getAllItems() {
        List<DataSource> items = new ArrayList<>();
        items.add(new DataSource(R.drawable.sample_image));
        items.add(new DataSource(R.drawable.sample_image));
        items.add(new DataSource(R.drawable.sample_image));

        return items;
    }

}
