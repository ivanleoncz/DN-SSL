package com.ivanleoncz.android_dnssl;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
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
        password.setTypeface(Typeface.DEFAULT);
        password.setTransformationMethod(new PasswordTransformationMethod());

    }

    public void login(View view) {

        Log.d("LoginActivity","processing login");

        String usernameStr;
        String passwordStr;
        final String toastFailed;

        usernameStr = username.getText().toString().trim();
        passwordStr = password.getText().toString().trim();
        toastFailed = "Login Failed";
        Log.d("LoginActivity","username: " + usernameStr);
        Log.d("LoginActivity","password: " + passwordStr);

        VolleyWorker volleyWorker = new VolleyWorker(this,usernameStr, passwordStr);

        volleyWorker.login(new VolleyWorker.LoginCallback() {

            String user;
            Intent intent;
            Bundle bundle;

            @Override
            public void onSuccess(String result) {
                if (result.equals("not_found")) {
                    Log.d("LoginActivity","Login NOK...");
                    Toast.makeText(getApplicationContext(),toastFailed,Toast.LENGTH_LONG).show();
                } else {
                    Log.d("LoginActivity","Login OK!");
                    JsonParser jp = new JsonParser(result);
                    jp.parser();
                    user = jp.username;
                    intent = new Intent(LoginActivity.this, MessageActivity.class);
                    bundle = new Bundle();
                    bundle.putSerializable("username",user);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_right_enter, R.anim.left_right_exit);
                }
            }

        }

        );

    }
}
