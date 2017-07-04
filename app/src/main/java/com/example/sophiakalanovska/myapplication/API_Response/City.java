package com.example.sophiakalanovska.myapplication.API_Response;

/**
 * Created by sophiakalanovska on 30/06/2017.
 */

public class City {
    private int id;
    private String name;
    private  Coordinates coord;
    private String country;
    private int population;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }
}
