package com.getmobileltd.cotenant.update_available_space;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.update_available_space.adapter.AvailableSpaceAdapter;
import com.getmobileltd.cotenant.update_available_space.model.AvailableSpaceModel;

import java.util.ArrayList;
import java.util.List;

public class AvailableSpaceActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AvailableSpaceAdapter availableSpaceAdapter;
    private List<AvailableSpaceModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_space);
     modelList = new ArrayList<>();
     dummyData();
     availableSpaceAdapter = new AvailableSpaceAdapter(modelList, this);
     recyclerView = findViewById(R.id.recycler_view);
     recyclerView.setHasFixedSize(true);
     recyclerView.setLayoutManager(new GridLayoutManager(this,2));
     recyclerView.setAdapter(availableSpaceAdapter);
    }

    private void dummyData() {

        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));
        modelList.add(new AvailableSpaceModel("2 BEDROOM","Yaba","42,Montgomerry road, Yaba","NGN 50 000",R.drawable.defaultimage));

    }


}
