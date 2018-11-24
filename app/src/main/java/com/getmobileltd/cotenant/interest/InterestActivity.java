package com.getmobileltd.cotenant.interest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.getmobileltd.cotenant.BuildConfig;
import com.getmobileltd.cotenant.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));

        adapter = new InterestAdapter(getApplicationContext(),modelList);
        recyclerView.setAdapter(adapter);


    }

  /*  private void loadJson() {

        try {
            if (BuildConfig.THE_MOVIE_DB_API_TOKEN.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please obtain api key from themoviedb.org", Toast.LENGTH_SHORT).show();
                return;
            }
            Client client = new Client();
            Server apiServer =
                    client.getClient(this).create(Server.class);
            Call<InterestResponse> call = apiServer.getPopularMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN);
            call.enqueue(new Callback<InterestResponse>() {
                @Override
                public void onResponse(Call<InterestResponse> call, Response<InterestResponse> response) {
                     modelList = response.body().getResults();
                     for (InterestModel m : modelList) {
                     }

                     adapter = new InterestAdapter(getApplicationContext(),modelList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.smoothScrollToPosition(0);


                }

                @Override
                public void onFailure(Call<InterestResponse> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                    Toast.makeText(InterestActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                }
            });

        } catch(Exception e ) {
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

*/

}
