package com.getmobileltd.cotenant.payment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;

public class ChooseCardType extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mCardType;
    private RadioButton mRadioButton;
    private static final String MASTER_CARD = "1";
    private static final String  VISA = "2";
    public static final String ARG_ITEM_ID = "item_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_card_type);
        init();


    }

    private void init() {

        mCardType = findViewById(R.id.typeOfCard);

    }


    public void cardSelected(View view) {
        mRadioButton = findViewById(mCardType.getCheckedRadioButtonId());
        String cardType = mRadioButton.getText().toString();
        if (cardType.toLowerCase().equals("mastercard")) {
            Intent intent = new Intent(this,CardDetailsActivity.class);
            intent.putExtra("type_of_card",MASTER_CARD);
            startActivity(intent);
            return;
        } else if (cardType.toLowerCase().equals("visa")) {
            Intent intent = new Intent(this, CardDetailsActivity.class);
            intent.putExtra("type_of_card",VISA);
            startActivity(intent);
            return;
        } else {
            Toast.makeText(this, "You clicked a button without image", Toast.LENGTH_SHORT).show();
            return;
        }
      //  startActivity(new Intent(this, CardDetailsActivity.class));
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id = radioGroup.getId();

        if (mCardType.getCheckedRadioButtonId() != -1) {
            findViewById(R.id.btn_select_card).setEnabled(true);
            findViewById(R.id.btn_select_card).setBackground(getResources().getDrawable(R.drawable.btn_red));

        }

    }
}
