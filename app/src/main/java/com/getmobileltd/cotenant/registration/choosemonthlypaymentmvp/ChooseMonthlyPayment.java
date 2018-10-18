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

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.apppinmvp.AppPinActivity;
import com.getmobileltd.cotenant.registration.lastregmvp.LastRegActivity;


public class ChooseMonthlyPayment extends AppCompatActivity  implements ChooseMonthlyPaymentContractor.View{
private Button mButton;
private RangeBar rangeSeekBar;
private ChooseMonthlyPaymentContractor.Presenter presenter;


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

        presenter = new ChooseMonthlyPresenter(this);
      rangeSeekBar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
          @Override
          public void valueChanged(Number minValue, Number maxValue) {
              min_Value.setText(String.valueOf(minValue + "k"));
              max_Value.setText(String.valueOf(maxValue) + "k");
          }
      });
      rangeSeekBar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
          @Override
          public void finalValue(Number minValue, Number maxValue) {
              String min = minValue + "";
              String max = maxValue +"";
              presenter.saveRange(min,max);



          }
      });


        mButton = findViewById(R.id.btn_choose_monthly_payment);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
}
