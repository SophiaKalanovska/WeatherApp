package com.example.sophiakalanovska.myapplication.data;

import java.io.Serializable;

/**
 * Created by sophiakalanovska on 27/06/2017.
 */

public class Day implements Serializable{

    private Icon image;
    private String title;
    private String description;
    private int maxtemp;
    private int mintemp;
    private String date;
    private int humidity;
    private float pressure;
    private float wind;


    public Day(Icon image, String title, String description, int maxtemp, int mintemp, String date, int humidity, float pressure, float wind) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.maxtemp = maxtemp;
        this.mintemp = mintemp;
        this.date = date;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind = wind;
    }

    public Icon getImage(){
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxtemp() {return maxtemp;}

    public int getMintemp() {
        return mintemp;
    }

    public String getDate() {
        return date;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getWind() {
        return wind;
    }
}
