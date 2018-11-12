package com.getmobileltd.cotenant.registration.choosemonthlypaymentmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.BubbleThumbSeekbar;
import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.apppinmvp.AppPinActivity;
import com.getmobileltd.cotenant.registration.apppinmvp.Client;
import com.getmobileltd.cotenant.registration.lastregmvp.LastRegActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChooseMonthlyPayment extends AppCompatActivity  implements ChooseMonthlyPaymentContractor.View{
private Button mButton;
private BubbleThumbSeekbar rangeSeekBar;
private ChooseMonthlyPaymentContractor.Presenter presenter;
private AppInstance app;
private TenantBody tenantBody;
private ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_monthly_payment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        init();
        final TextView min_Value = findViewById(R.id.textMin2);
       final TextView max_Value = findViewById(R.id.textMax2);
        app = AppInstance.getInstance();

        presenter = new ChooseMonthlyPresenter(this);
        rangeSeekBar.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
            @Override
            public void valueChanged(Number value) {
                min_Value.setText(String.valueOf(value + "k"));


            }
        });


      rangeSeekBar.setOnSeekbarFinalValueListener(new OnSeekbarFinalValueListener() {
          @Override
          public void finalValue(Number value) {

              presenter.saveRange(String.valueOf(value));
              app.setRent(String.valueOf(value) + "000");


          }
      });


        mButton = findViewById(R.id.btn_choose_monthly_payment);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              tenantBody = new TenantBody(app.getUser_id(),app.getCo_gender(),app.getReligion(),app.getCo_religion(),app.getSmoke(),app.getCo_smoke(),app.getDisabled(),app.getCo_disabled(),app.getLocation_1(),app.getLocation_2(),app.getWork(),app.getDuration(),app.getRent());
              createTenants(tenantBody);

                presenter.loadNextScreen();


            }
        });


    }

    private void init() {
        rangeSeekBar = findViewById(R.id.rangeSeekbar);


    }

    @Override
    public void navigateScreen() {
        startActivity(new Intent(getApplicationContext(), LastRegActivity.class));

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void createTenants(TenantBody tenantBody) {
        mApiService = Client.getClient().create(ApiService.class);
        Call<TenantResponse> call = mApiService.createTenant(tenantBody);
        call.enqueue(new Callback<TenantResponse>() {
            @Override
            public void onResponse(Call<TenantResponse> call, Response<TenantResponse> response) {
                if (response.body().getCode() == 201) {
                    Toast.makeText(ChooseMonthlyPayment.this, "Value inserted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ChooseMonthlyPayment.this, "Error code" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TenantResponse> call, Throwable t) {
                Toast.makeText(ChooseMonthlyPayment.this, "No connection was made to the server", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
