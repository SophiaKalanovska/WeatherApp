package com.example.sophiakalanovska.myapplication;

import android.app.Application;

/**
 * Created by sophiakalanovska on 03/07/2017.
 */

public class WeatherApplication extends Application{

    public static final String PREFS_NAME = "MyPrefsFile";

    private static WeatherApplication instance;
    public void onCreate(){
        instance = this;

    }


    public static WeatherApplication getInstance(){

        return instance;
    }

}
