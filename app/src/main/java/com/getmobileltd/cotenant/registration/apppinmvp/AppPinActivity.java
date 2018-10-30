package com.getmobileltd.cotenant.registration.apppinmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.TestActivity;
import com.getmobileltd.cotenant.registration.aboutyoumvp.Data;
import com.getmobileltd.cotenant.registration.entercodemvp.EnterCodeActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AppPinActivity extends AppCompatActivity implements AppPinContract.View {
    private Button mButton;
    private AppPinContract.Presenter presenter;
    private EditText enterPassword, confirmPassword;
    private String password1, password2;
    ImageView positive1, positive2;
    private String firstName, lastName, phoneNumber, emailAddrsss, gender;
    private ApiService mApiService;
    private Data data;
    private AppInstance app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_pin);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        init();
        mApiService = ApiUtils.getApiService();

        presenter = new AppPinPresenter(this);
       presenter.defaultSettings();
        app = AppInstance.getInstance();

        firstName = app.getFirstName();
        lastName = app.getLastName();
        phoneNumber = app.getPhone_number();
        emailAddrsss =app.getEmailAddress();
        gender = app.getGender();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data = new Data(emailAddrsss,presenter.appPassword(),firstName,lastName,gender,phoneNumber);
              //  Toast.makeText(getApplicationContext(), emailAddrsss + presenter.appPassword() + firstName + lastName + gender+  phoneNumber, Toast.LENGTH_SHORT).show();
                insertUser(data);
               // Toast.makeText(AppPinActivity.this, presenter.appPassword(), Toast.LENGTH_SHORT).show();

            }
        });






    }


    private void insertUser(Data data) {
            ApiService mApiService = Client.getClient().create(ApiService.class);
        Call<CreateUserResponse> call = mApiService.createUser(data);

        call.enqueue(new Callback<CreateUserResponse>() {
            @Override
            public void onResponse(Call<CreateUserResponse> call, Response<CreateUserResponse> response) {
                if (response.body().getStatus().equals("success")) {
                    Toast.makeText(AppPinActivity.this, "Successful" + response.body().getCode(), Toast.LENGTH_SHORT).show();
                    int id = response.body().getData().getId();
                    app.setUser_id(id);
                    presenter.loadNextScreen();

                }
                 else {
                    Toast.makeText(AppPinActivity.this, "Error with code " + response.body().getCode(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CreateUserResponse> call, Throwable t) {
                Toast.makeText(AppPinActivity.this, "" +
                        "Failure with " + t.getCause(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        mButton = findViewById(R.id.btn_choose_pin);
       enterPassword = findViewById(R.id.enter_password);
       confirmPassword = findViewById(R.id.confirm_password);
       enterPassword.addTextChangedListener(watcher);
       confirmPassword.addTextChangedListener(watcher);
        positive1 = findViewById(R.id.positivechecked1);
        positive2 = findViewById(R.id.positivechecked2);


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
    public void navigateNextScreen() {
        startActivity(new Intent(AppPinActivity.this, EnterCodeActivity.class));


    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showTickVisibility(int value) {
        positive1.setVisibility(value);
        positive2.setVisibility(value);
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
           /* EditText editText = (EditText) getCurrentFocus();
            if (editText != null && editText.length() > 0) {
                View next = editText.focusSearch(View.FOCUS_RIGHT);
                if (next != null) {
                    next.requestFocus();
                }

            }
*/
            while (!enterPassword.getText().toString().isEmpty() || !confirmPassword.getText().toString().isEmpty()) {
                if (enterPassword.getText().toString().equals(confirmPassword.getText().toString())) {
                    presenter.verifyEntries();
                    presenter.savePassword(enterPassword.getText().toString());
                    app.setPassword(presenter.appPassword());
                    return;
                }
                if (!(enterPassword.getText().toString().equals(confirmPassword.getText().toString()))) {
                    presenter.defaultSettings();
                    return;
                }
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
