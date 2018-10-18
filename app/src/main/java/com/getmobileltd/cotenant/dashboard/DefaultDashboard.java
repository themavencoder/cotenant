package com.getmobileltd.cotenant.dashboard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.availablespacechecked.AvailableSpaceChecked;
import com.getmobileltd.cotenant.history.HistoryActivity;
import com.getmobileltd.cotenant.interest.InterestActivity;
import com.getmobileltd.cotenant.mergedashboard.MergedDashboard;
import com.getmobileltd.cotenant.payment.EmptyPayment;
import com.getmobileltd.cotenant.payment.SetUpCardActivity;
import com.getmobileltd.cotenant.settings.SettingsActivity;

import java.util.ArrayList;
import java.util.List;

public class DefaultDashboard extends AppCompatActivity {
    private List<DefaultDashboardModel> modelList;
    private RecyclerView recyclerView;
    private DefaultDashboardAdapter defaultDashboardAdapter;
    private DrawerLayout d;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private ImageView imageViewFirstEdit, imageViewSecondEdit;
    private TextView textViewFirstEdit, textViewSecondEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Dashboard");
        modelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_defaultDashboard);
        defaultDashboardAdapter = new DefaultDashboardAdapter(this,modelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(defaultDashboardAdapter);
        d = findViewById(R.id.drawerLayout);
        t = new ActionBarDrawerToggle(this, d,R.string.Open,R.string.Close);
        d.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {

                    case R.id.your_dashboard:
                        Toast.makeText(DefaultDashboard.this, "Sermons",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.available_space:
                        startActivity(new Intent(DefaultDashboard.this, AvailableSpaceChecked.class));
                        break;
                    case R.id.interest:
                        startActivity(new Intent(DefaultDashboard.this, InterestActivity.class));
                        break;
                    case R.id.history:
                        startActivity(new Intent(DefaultDashboard.this, HistoryActivity.class));
                        break;

                    case R.id.payment:
                        startActivity(new Intent(DefaultDashboard.this, EmptyPayment.class));
                        break;

                    case R.id.settings:
                        startActivity(new Intent(DefaultDashboard.this, SettingsActivity.class));
                        break;

                    default:

                }
                return true;
            }
        });
        //Populating with same image.
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));
        modelList.add(new DefaultDashboardModel(R.drawable.defaultdashboard));

        textViewFirstEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DefaultDashboard.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView  = inflater.inflate(R.layout.alertdialog_custom_view,null);
                builder.setCancelable(false);
                builder.setView(dialogView);
                Button btn_positive = dialogView.findViewById(R.id.dialog_positive_btn);
                Button btn_negative = dialogView.findViewById(R.id.dialog_negative_btn);

                final EditText et_name = dialogView.findViewById(R.id.et_name);
                if (et_name.getText().toString().length() < 4) {
                    et_name.setError("Field must be 4 or more");
                }
                final AlertDialog dialog = builder.create();

                btn_positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                        String location = et_name.getText().toString();
                        textViewFirstEdit.setText(location);
                    }
                });
                btn_negative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        textViewSecondEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DefaultDashboard.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.alertdialog_custom_view,null);
                builder.setCancelable(false);
                builder.setView(dialogView);
                Button btn_positive = dialogView.findViewById(R.id.dialog_positive_btn);
                Button btn_negative = dialogView.findViewById(R.id.dialog_negative_btn);
                final EditText et_name = dialogView.findViewById(R.id.et_name);
                final AlertDialog dialog = builder.create();

                btn_positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                        String location = et_name.getText().toString();
                        textViewSecondEdit.setText(location);
                    }
                });
                btn_negative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

    }

    private void init() {
        imageViewFirstEdit = findViewById(R.id.imag_edit_location_one);
        imageViewSecondEdit = findViewById(R.id.imag_edit_location_two);
        textViewFirstEdit  = findViewById(R.id.tv_location_one);
        textViewSecondEdit = findViewById(R.id.tv_location_two);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }



}
