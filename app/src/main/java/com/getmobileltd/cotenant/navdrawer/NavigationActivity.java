package com.getmobileltd.cotenant.navdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;

public class NavigationActivity extends AppCompatActivity {

    private DrawerLayout d;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        d = findViewById(R.id.drawerLayout);
        t = new ActionBarDrawerToggle(this, d,R.string.Open,R.string.Close);
        d.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = findViewById(R.id.nv);
            nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    switch (id) {

                        case R.id.your_dashboard:
                            Toast.makeText(NavigationActivity.this, "Sermons",Toast.LENGTH_SHORT).show();
                        case R.id.available_space:
                            Toast.makeText(NavigationActivity.this, "Sermons",Toast.LENGTH_SHORT).show();

                        case R.id.interest:
                            Toast.makeText(NavigationActivity.this, "Sermons",Toast.LENGTH_SHORT).show();


                        case R.id.history:
                            Toast.makeText(NavigationActivity.this, "Sermons",Toast.LENGTH_SHORT).show();

                        case R.id.payment:
                            Toast.makeText(NavigationActivity.this, "Sermons",Toast.LENGTH_SHORT).show();

                        default:
                        return true;
                    }
                }
            });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item)) return true;
        
        return super.onOptionsItemSelected(item);
    }
}
