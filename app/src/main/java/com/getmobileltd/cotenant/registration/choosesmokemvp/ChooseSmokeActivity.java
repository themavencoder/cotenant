
package com.getmobileltd.cotenant.registration.choosesmokemvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.choosedisabilitymvp.ChooseDisabilityActivity;

public class ChooseSmokeActivity extends AppCompatActivity implements ChooseSmokeContract.View {
    private ChooseSmokeContract.Presenter presenter;
    private RadioGroup mRadioGroupMe, mRadioGroupYou;
    private RadioButton radiobtn1, radiobtn2;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_smoke);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");

        init();

        presenter = new ChooseSmokePresenter(this);
      //  presenter.defaultSettings();



        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                radiobtn1 = findViewById(mRadioGroupMe.getCheckedRadioButtonId());
                radiobtn2 = findViewById(mRadioGroupYou.getCheckedRadioButtonId());
                String one = radiobtn1.getText().toString();
                String two = radiobtn2.getText().toString();
                Toast.makeText(getApplicationContext(), one, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), two, Toast.LENGTH_SHORT).show();
                presenter.saveSmokeChoice(radiobtn1.getText().toString());
                presenter.saveRoomateSmoke(radiobtn2.getText().toString());
                presenter.loadNextScreen();

            }
        });



    }


    private void init() {
        mButton = findViewById(R.id.choosesmoke_button);
        mRadioGroupMe = findViewById(R.id.radiogroup_choosesmoke_one);
        mRadioGroupYou = findViewById(R.id.radiogroup_choosesmoke_two);
        /*mRadioButtonOne = findViewById(R.id.radiobutton_choosesmoke_one_yes);
        mRadioButtonTwo = findViewById(R.id.radiobutton_choosesmoke_one_no);
        mRadioButtonThree = findViewById(R.id.radiobutton_choosesmoke_two_yes);
        mRadioButtonFour = findViewById(R.id.radiobutton_choosesmoke_two_no);
        mRadioButtonOne, mRadioButtonTwo, mRadioButtonThree, mRadioButtonFour,
*/
    }


    @Override
    public void showButtonClick(boolean b) {
        mButton.setEnabled(b);

    }

    @Override
    public void setButtonColor(int color) {
        mButton.setBackground(getResources().getDrawable(color));

    }

    @Override
    public void naviagateNextScreen() {
        startActivity(new Intent(this, ChooseDisabilityActivity.class));

    }

    @Override
    public void showError(String error) {

    }


}
