package com.ivanleoncz.android_dnssl;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
import android.widget.TextView;


public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String link = "https://stackoverflow.com/questions/2012497/accepting-a-certificate-for-https-on-android/40112598#40112598";
        String hyperLink = "<a href=" + link + "> Press here for more info! </a>";
        String username = null;
        TextView tvLink = null;
        TextView tvWelcome = null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        username = getIntent().getStringExtra("username");
        tvLink = (TextView) findViewById(R.id.message_link);
        tvWelcome = (TextView) findViewById(R.id.message_welcome);

        tvWelcome.setText(username);
        tvLink.setMovementMethod(LinkMovementMethod.getInstance());
        tvLink.setText(Html.fromHtml(hyperLink));
        tvLink.setLinkTextColor(Color.parseColor("#005ce6"));

    }
}
