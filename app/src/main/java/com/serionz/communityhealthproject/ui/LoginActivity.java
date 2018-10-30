package com.serionz.communityhealthproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.serionz.communityhealthproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.user_name)
    TextInputEditText mUsername;

    @BindView(R.id.password)
    TextInputEditText mPassword;

    @BindView(R.id.login_button)
    Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initListeners();
    }

    private void initListeners() {
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateEntries() && authenticated()) {
                    Intent childListIntent = new Intent(getApplicationContext(), ChildListActivity.class);
                    startActivity(childListIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Login Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean authenticated() {
        return true;
    }

    private boolean validateEntries() {
        Boolean isValid = true;

        if (mUsername.getText() == null || mUsername.getText().toString().equals("")) {
            TextInputLayout mUsernameContainer = (TextInputLayout) mUsername.getParent().getParent();
            mUsernameContainer.setError(getString(R.string.username_required));
            isValid = false;
        }

        if (mPassword.getText() == null || mPassword.getText().toString().equals("")) {
            TextInputLayout mPasswordContainer = (TextInputLayout) mPassword.getParent().getParent();
            mPasswordContainer.setError(getString(R.string.password_required));
            isValid = false;
        }
        return isValid;
    }
}
