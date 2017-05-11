package com.ivanleoncz.android_dnssl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username = null;
    EditText password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        password.setTransformationMethod(new PasswordTransformationMethod());

    }

    public void login(View view) {

        final String usernameStr;
        final String passwordStr;
        final String toastFailed;

        usernameStr = username.getText().toString().trim();
        passwordStr = password.getText().toString().trim();
        toastFailed = "Login Failed";

        VolleyWorker volleyWorker = new VolleyWorker(usernameStr, passwordStr);

        volleyWorker.login(new VolleyWorker.LoginCallback() {

            Intent intent;

            @Override
            public void onSuccess(String result) {
                if (result.equals("nok")) {
                    Toast.makeText(getApplicationContext(),toastFailed,Toast.LENGTH_LONG).show();
                } else {
                    intent = new Intent(LoginActivity.this, MessageActivity.class);
                    startActivity(intent);
                }
            }

        }

        );

    }
}
