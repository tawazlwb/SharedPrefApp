package com.ikheiry.sharedprefapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ikheiry.sharedprefapp.configuration.SharedPrefsConfig;

public class SuccessActivity extends AppCompatActivity {

    private SharedPrefsConfig prefsConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        prefsConfig = new SharedPrefsConfig(getApplicationContext());
    }

    public void userLogOut(View view) {
        prefsConfig.writeLoginStatus(false);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
