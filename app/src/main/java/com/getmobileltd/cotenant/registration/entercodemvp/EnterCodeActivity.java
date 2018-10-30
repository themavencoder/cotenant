package com.getmobileltd.cotenant.registration.entercodemvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.aboutyoumvp.AboutYouActivity;
import com.getmobileltd.cotenant.registration.apppinmvp.Client;
import com.getmobileltd.cotenant.registration.comfortablegendermvp.ComfortableGenderActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnterCodeActivity extends AppCompatActivity implements EnterCodeContract.View {
    private Button mEnterbutton;
    private EditText mFirstCode, mSecondCode, mThirdCode, mFourthCode;
    private ImageView positiveChecked;
    private EnterCodeContract.Presenter presenter;
    private AppInstance app;
    private EnterCodeModel model;
    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_enter_code);
        presenter = new EnterCodePresenter(this);
        init();
       // presenter.defaultSettings();


        mEnterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                app = AppInstance.getInstance();
            String savedcode = presenter.showSavedCode();
            String code = String.valueOf(savedcode);
                model = new EnterCodeModel(app.getEmailAddress(),code);
                verifyEntry(model);


            }
        });
    }

    private void verifyEntry(EnterCodeModel model) {
        ApiService mApiService = Client.getClient().create(ApiService.class);
        Call<EnterCodeResponse> call = mApiService.createUser(model);
        call.enqueue(new Callback<EnterCodeResponse>() {
            @Override
            public void onResponse(Call<EnterCodeResponse> call, Response<EnterCodeResponse> response) {
                if (response.body().getCode() == 200) {
                    Toast.makeText(EnterCodeActivity.this, "Successfully verified" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EnterCodeActivity.this, ComfortableGenderActivity.class));
                }
                 else {
                    Toast.makeText(EnterCodeActivity.this, ""+response.body().getMessage() , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EnterCodeResponse> call, Throwable t) {

            }
        });
    }

    private void init() {
        mEnterbutton = findViewById(R.id.entercode_nextbutton);
        mFirstCode = findViewById(R.id.entercode_firstcode);
        mSecondCode = findViewById(R.id.entercode_secondcode);
        mThirdCode = findViewById(R.id.entercode_thirdcode);
        mFourthCode = findViewById(R.id.entercode_fourthcode);
        positiveChecked = findViewById(R.id.entercode_positivechecked);
        mFirstCode.addTextChangedListener(watch);
        mSecondCode.addTextChangedListener(watch);
        mThirdCode.addTextChangedListener(watch);
        mFourthCode.addTextChangedListener(watch);
        Client client = new Client();
        apiService = client.getClient().create(ApiService.class);

    }

    @Override
    public void enableButtonClick(boolean b) {
        mEnterbutton.setEnabled(b);

    }

    @Override
    public void enableButtonColor(int color) {
        mEnterbutton.setBackground(getResources().getDrawable(color));

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT);

    }

    @Override
    public void disablePositiveChecked() {
        positiveChecked.setVisibility(View.INVISIBLE);

    }

    @Override
    public void enablePositiveChecked() {
        positiveChecked.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    public void navigateTonextScreen() {
        setContentView(R.layout.phonenumber_verified);
        setContentView(R.layout.few_more_questions);
        LinearLayout linearLayout = findViewById(R.id.tapanywheretoContinue);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ComfortableGenderActivity.class));
            }
        });

    }

    TextWatcher watch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            presenter.saveCode(mFirstCode.getText().toString(), mSecondCode.getText().toString(), mThirdCode.getText().toString(), mFourthCode.getText().toString());

            EditText text = (EditText) getCurrentFocus();
            if (text != null && text.length() > 0) {
                View next = text.focusSearch(View.FOCUS_RIGHT);
                if (next != null) {
                    next.requestFocus();
                }
            }
            if (mFirstCode.getText().toString().isEmpty() && mSecondCode.getText().toString().isEmpty() && mThirdCode.getText().toString().isEmpty() && mFourthCode.getText().toString().isEmpty()) {

            presenter.defaultSettings();
        } else {
                presenter.verifyCode();


            }
        }

        @Override
        public void afterTextChanged(Editable editable) {


        }
    };

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }




}
