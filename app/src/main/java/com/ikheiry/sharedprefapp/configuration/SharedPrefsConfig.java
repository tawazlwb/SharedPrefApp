package com.ikheiry.sharedprefapp.configuration;

import android.content.Context;
import android.content.SharedPreferences;

import com.ikheiry.sharedprefapp.R;

public class SharedPrefsConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPrefsConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preferences), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preferences), status);
        editor.commit();
    }

    public boolean readLoginStatus(){
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preferences), status);
        return status;
    }
}
