package com.ikheiry.sharedprefapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ikheiry.sharedprefapp.configuration.SharedPrefsConfig;

public class MainActivity extends AppCompatActivity {

    private SharedPrefsConfig prefsConfig;
    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefsConfig = new SharedPrefsConfig(getApplicationContext());

        userName = findViewById(R.id.user_name);
        password = findViewById(R.id.password);

        if(prefsConfig.readLoginStatus()){
            startActivity(new Intent(this, SuccessActivity.class));
            finish();
        }
    }

    public void loginUser(View view) {
        String username = userName.getText().toString();
        String userpassword = password.getText().toString();

        if(username.equals(getResources().getString(R.string.user_name)) && userpassword.equals(getResources().getString(R.string.user_password))){
            startActivity(new Intent(this, SuccessActivity.class));
            prefsConfig.writeLoginStatus(true);
            finish();
        }
        else{
            Toast.makeText(this, "Login failed, try again...", Toast.LENGTH_SHORT).show();
            userName.setText("");
            password.setText("");
        }
    }
}
