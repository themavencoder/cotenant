package com.getmobileltd.cotenant.registration.chooseworkmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.registration.salaryrangemvp.SalaryRangeActivity;

public class ChooseWorkActivity extends AppCompatActivity implements ChooseWorkContractor.View {
    private Button mButton;
    private EditText mEditText;
    private ChooseWorkContractor.Presenter presenter;
    private AppInstance app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_work);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        init();
        presenter = new ChooseWorkPresenter(this);
        presenter.defaultSettings();


       mButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(ChooseWorkActivity.this, "" + mEditText.getText().toString(), Toast.LENGTH_SHORT).show();
               presenter.save(mEditText.getText().toString());
               app.setWork(mEditText.getText().toString());
               Toast.makeText(ChooseWorkActivity.this, mEditText.getText().toString(), Toast.LENGTH_SHORT).show();
               presenter.loadNextScreen();





           }
       });
    }

    private void init() {
        app = AppInstance.getInstance();
        mButton = findViewById(R.id.btn_choose_work);
        mEditText =findViewById(R.id.et_placeofWork);
        mEditText.addTextChangedListener(watcher);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String input = mEditText.getText().toString().trim();
            presenter.defaultSettings();
                if (input.length() > 4 && input.length() < 8) {
                    presenter.defaultSettings();
                    presenter.displayError();
                    return;

                }
                if (input.length() > 7) {
                    presenter.verify();
                    return;
                }


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void navigateToNextScreen() {

        startActivity(new Intent(this,SalaryRangeActivity.class));
    }

    @Override
    public void showError(String error) {
        mEditText.setError(error);

    }

    @Override
    public void enableButtonClick(boolean b) {
        mButton.setEnabled(b);
    }

    @Override
    public void enableButtonColor(int color) {
        mButton.setBackground(getResources().getDrawable(color));

    }
}
