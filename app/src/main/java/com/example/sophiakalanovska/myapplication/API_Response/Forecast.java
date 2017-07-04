package com.example.sophiakalanovska.myapplication.API_Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sophiakalanovska on 30/06/2017.
 */

public class Forecast {
    @SerializedName("dt")
    private long timeInSeconds;
    private Temp temp;
    private float pressure;
    private int humidity;
    private List<Weather> weather;
    private float speed;
    private int deg;
    private int clouds;

    public long getTimeInSeconds() {
        return timeInSeconds;
    }

    public Temp getTemp() {
        return temp;
    }

    public float getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public float getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }

    public int getClouds() {
        return clouds;
    }
}
