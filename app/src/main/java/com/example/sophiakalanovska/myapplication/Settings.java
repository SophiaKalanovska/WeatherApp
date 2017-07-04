package com.example.sophiakalanovska.myapplication;

import android.content.SharedPreferences;

/**
 * Created by sophiakalanovska on 03/07/2017.
 */

public class Settings {

    private final SharedPreferences sharedPreferences = WeatherApplication.getInstance().getSharedPreferences(WeatherApplication.PREFS_NAME, 0);

    public void setFahrenheit(boolean isFahrenheit){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("F˚", isFahrenheit);
        editor.commit();

    }
    public boolean isFahrenheit(){
       return sharedPreferences.getBoolean("F˚", false);
    }
}
