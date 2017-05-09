package com.ivanleoncz.android_dnssl;

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

        final String strUsername;
        final String strPassword;
        final String toastMessage;

        strUsername = username.getText().toString().trim();
        strPassword = password.getText().toString().trim();
        toastMessage = "Login Failed";

        Toast.makeText(getApplicationContext(),"Welcome!",Toast.LENGTH_LONG).show();
    }
}
