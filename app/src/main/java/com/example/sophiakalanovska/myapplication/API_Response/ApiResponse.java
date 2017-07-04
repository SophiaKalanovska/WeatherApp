package com.example.sophiakalanovska.myapplication.API_Response;

import java.util.List;

/**
 * Created by sophiakalanovska on 30/06/2017.
 */

public class ApiResponse {
    private City city;

    public City getCity() {
        return city;
    }

    public String getCod() {
        return cod;
    }

    public float getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<Forecast> getList() {
        return list;
    }

    private String cod;
    private float message;
    private int cnt;
    private List<Forecast> list;

}
