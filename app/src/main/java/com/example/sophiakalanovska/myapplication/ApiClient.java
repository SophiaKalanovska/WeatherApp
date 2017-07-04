package com.example.sophiakalanovska.myapplication;

import com.example.sophiakalanovska.myapplication.API_Response.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sophiakalanovska on 30/06/2017.
 */

public interface ApiClient {
    public String baseUrl = "http://api.openweathermap.org/data/2.5/";


    @GET("forecast/daily")
     Call <ApiResponse> getForecast(@Query("q") String cityName, @Query("cnt") int count, @Query("appid") String apikey, @Query("units") String units );


}
