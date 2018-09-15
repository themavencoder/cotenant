package com.getmobileltd.cotenant.history;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.getmobileltd.cotenant.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HistoryDetailsAdapter adapter;
    private List<HistoryDetailsModel> modelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        setTitle("History");
        modelList = new ArrayList<>();
        recyclerView = findViewById(R.id.history_recyclerview);
        adapter = new HistoryDetailsAdapter(this, modelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));
        modelList.add(new HistoryDetailsModel("N50,000", "28 Aug 2018", "August 2018"));


    }
}
