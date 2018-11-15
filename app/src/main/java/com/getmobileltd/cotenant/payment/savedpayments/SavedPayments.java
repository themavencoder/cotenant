package com.getmobileltd.cotenant.payment.savedpayments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.payment.ChooseCardType;
import com.getmobileltd.cotenant.payment.savedpayments.adapter.OtherCardsAdapter;
import com.getmobileltd.cotenant.payment.savedpayments.helper.Operations;
import com.getmobileltd.cotenant.payment.savedpayments.model.OtherCardsModel;

import java.util.ArrayList;
import java.util.List;

public class SavedPayments extends AppCompatActivity {
    private RecyclerView recyclerView;
    private OtherCardsAdapter adapter;
    private List<OtherCardsModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_payments);
        Toolbar toolbar = findViewById(R.id.include7);
        setSupportActionBar(toolbar);
        setTitle("Saved Cards");
        modelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view_cards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new OtherCardsAdapter(this,Operations.CARDS);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.add_card, menu);
    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_card) {
            startActivity(new Intent(this, ChooseCardType.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
