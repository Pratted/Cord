package com.cord.cord;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent LandingActivityIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(LandingActivityIntent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                finish();
            }
        }, 800);
    }
}
