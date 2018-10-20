package com.getmobileltd.cotenant.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.apppinmvp.Client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailAddress, mPassword;
    private Button mButton;
    private LoginBody mLoginBody;
    private ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        buttonClick();


    }

    private void init() {
        mEmailAddress = findViewById(R.id.login_emailaddress);
        mPassword = findViewById(R.id.login_password);
        mButton = findViewById(R.id.login_button);
    }

    private void loginUser(LoginBody loginBody) {
        mApiService = Client.getClient().create(ApiService.class);
        Call<LoginResponse> call = mApiService.startLogin(loginBody);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getCode() == 200) {
                    Toast.makeText(LoginActivity.this, "Login successful but yet to verify account", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode() == 404) {
                    Toast.makeText(LoginActivity.this, "Incorrect login details", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Sent to the server but can't read response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failed. Problem with API", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void buttonClick() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailAddress.getText().toString();
                String password = mPassword.getText().toString();
                mLoginBody = new LoginBody(email, password);
                loginUser(mLoginBody);

            }
        });
    }
}
