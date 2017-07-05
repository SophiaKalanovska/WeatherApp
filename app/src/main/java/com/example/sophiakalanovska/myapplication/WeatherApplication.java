package com.example.sophiakalanovska.myapplication;

import android.app.Application;

import com.example.sophiakalanovska.myapplication.data.DataRepository;

/**
 * Created by sophiakalanovska on 03/07/2017.
 */

public class WeatherApplication extends Application{

    public static final String PREFS_NAME = "MyPrefsFile";
    public static DataRepository data ;
    private static Settings settings;
    private static WeatherApplication instance;



    public void onCreate(){
        instance = this;
        settings = new Settings();
        data = new DataRepository(settings);

    }


    public static WeatherApplication getInstance(){

        return instance;
    }


    public static Settings getSettings(){
        return settings;
    }

    public static DataRepository getData(){
        return data;
    }






}
