package com.getmobileltd.cotenant.update_available_space;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.update_available_space.adapter.AvailableSpaceAdapter;
import com.getmobileltd.cotenant.update_available_space.model.AvailableSpaceModel;

import java.util.ArrayList;
import java.util.List;

public class AvailableSpaceActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private AvailableSpaceAdapter availableSpaceAdapter;
    private List<AvailableSpaceModel> modelList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_space);
        Toolbar toolbar = findViewById(R.id.include5);
        setSupportActionBar(toolbar);
        setTitle("Available Space");

     modelList = new ArrayList<>();
     //dummyData();
     searchView = findViewById(R.id.editTextHint);
     searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search location");
     availableSpaceAdapter = new AvailableSpaceAdapter(modelList, this);
     recyclerView = findViewById(R.id.recycler_view);
     recyclerView.setNestedScrollingEnabled(false);
     recyclerView.setHasFixedSize(true);
     recyclerView.setLayoutManager(new GridLayoutManager(this,2));
     recyclerView.setAdapter(availableSpaceAdapter);
    }

    /*private void dummyData() {

        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Kastina","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Kastina","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Kastina","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Sango","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Sango","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Ikorodu","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));

    }*/


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String userInput = newText.toLowerCase();
        List<AvailableSpaceModel> newList = new ArrayList<>();
        for (AvailableSpaceModel location: modelList) {
            if (location.getStateLocation().toLowerCase().contains(userInput)) {
                newList.add(location);
            }
        }
        availableSpaceAdapter.updateList(newList);
        return true;
    }
}
