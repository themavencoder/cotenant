package com.getmobileltd.cotenant.payment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.payment.savedpayments.SavedPayments;
import com.getmobileltd.cotenant.payment.savedpayments.helper.Operations;
import com.getmobileltd.cotenant.payment.savedpayments.model.CardDetailsModel;
import com.getmobileltd.cotenant.payment.savedpayments.model.OtherCardsModel;

public class CardDetailsActivity extends AppCompatActivity {
    private EditText mEditText, mExpirationDate;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Payment");
        init();
        String cardType = getIntent().getStringExtra("type_of_card");
        //   Toast.makeText(this, cardType, Toast.LENGTH_SHORT).show();
    }

    private void init() {
        mExpirationDate = findViewById(R.id.expiration_date);
        mEditText = findViewById(R.id.cardNumber);
        checkDrawableType();
        mEditText.addTextChangedListener(cardNumberwatcher);
        mExpirationDate.addTextChangedListener(expiration);

    }

    private void checkDrawableType() {
        if (getIntent().getStringExtra("type_of_card").equals("1")) {
            Drawable img = getApplicationContext().getResources().getDrawable(R.drawable.ic_mastercard);
            mEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, img, null);
        }
        if (getIntent().getStringExtra("type_of_card").equals("2")) {
            Drawable img = getApplicationContext().getResources().getDrawable(R.drawable.ic_visa);
            mEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, img, null);
        }

    }

    public void nextScreenLoad(View view) {
        String card_string = getIntent().getStringExtra("type_of_card");
String extraIntent = getIntent().getStringExtra(ChooseCardType.ARG_ITEM_ID);
            AppInstance app = AppInstance.getInstance();
            int checkCardId = app.getCheckCardID();
            if (checkCardId == 0) {
                OtherCardsModel newCard = new OtherCardsModel();
                newCard.setMonth(CardDetailsModel.getMonth());
                newCard.setLastFourDigits(CardDetailsModel.getCardNumber());
                if (card_string.equals("1")) {
                    newCard.setCardType(R.drawable.ic_mastercard);
                }
                if (card_string.equals("2")) {
                    newCard.setCardType(R.drawable.ic_visa);
                }
                Operations.createCard(newCard);
                startActivity(new Intent(this, SavedPayments.class));
            }else {

            OtherCardsModel updateCard = new OtherCardsModel();
            updateCard.setId(checkCardId);
            updateCard.setMonth(CardDetailsModel.getMonth());
            updateCard.setLastFourDigits(CardDetailsModel.getCardNumber());
            if (card_string.equals("1")) {
                updateCard.setCardType(R.drawable.ic_mastercard);
            }
            if (card_string.equals("2")) {
                updateCard.setCardType(R.drawable.ic_visa);

            }
                Operations.updateCard(updateCard);
                startActivity(new Intent(this, SavedPayments.class));


        }
    }


    private void cardNumber() {

    }

    TextWatcher cardNumberwatcher = new TextWatcher() {
        int count = 0;


        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (count <= mEditText.getText().toString().length() && (mEditText.getText().toString().length() == 4)
                    || mEditText.getText().toString().length() == 9 || mEditText.getText().toString().length() == 14) {
                mEditText.setText(mEditText.getText().toString() + " ");
                int pos = mEditText.getText().length();
                mEditText.setSelection(pos);
            } else if (count >= mEditText.getText().toString().length()
                    && (mEditText.getText().toString().length() == 4
                    || mEditText.getText().toString().length() == 9
                    || mEditText.getText().toString().length() == 14)) {
                mEditText.setText(mEditText.getText().toString().substring(0, 14));
                int pos = mEditText.getText().length();
                mEditText.setSelection(pos);
            }
            count = mEditText.getText().toString().length();
            String str = mEditText.getText().toString().replace(" ", "");
            Toast toast = Toast.makeText(CardDetailsActivity.this, "" + str, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            if (str.length() > 15) {
                String sub = str.substring(12, str.length());
                CardDetailsModel.setCardNumber(sub);
            }


        }


    };

    TextWatcher expiration = new TextWatcher() {
        int count = 0;

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (count <= mExpirationDate.getText().toString().length() && (mExpirationDate.getText().toString().length() == 2)) {
                mExpirationDate.setText(mExpirationDate.getText().toString() + " / ");
                int pos = mExpirationDate.getText().length();
                mExpirationDate.setSelection(pos);
                ;


            }
            String str = mExpirationDate.getText().toString().replace(" / ", "");
            if (str.length() == 4) {

                String substring = str.substring(0, 2);
                Toast.makeText(CardDetailsActivity.this, substring, Toast.LENGTH_SHORT).show();
                CardDetailsModel.setMonth(substring);
            }
        }
    };
}


