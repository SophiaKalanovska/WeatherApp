package com.example.sophiakalanovska.myapplication.data;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.sophiakalanovska.myapplication.API_Response.ApiResponse;
import com.example.sophiakalanovska.myapplication.API_Response.Forecast;
import com.example.sophiakalanovska.myapplication.ApiClient;
import com.example.sophiakalanovska.myapplication.Settings;
import com.example.sophiakalanovska.myapplication.WeatherApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sophiakalanovska on 28/06/2017.
 */

public class DataRepository {
    private static final String TAG = "DataRepository";
    private Settings settings;
    private List<CallBack> callBacks = new ArrayList<>();
    private List<Day> days = new ArrayList<>();

    public void addCallBack(CallBack callBack) {
        callBacks.add(callBack);
        if (!days.isEmpty()) {

            callBack.recieveDays(days);
        }
    }

    public void removeCallBack(CallBack callBack) {
        callBacks.remove(callBack);
    }

    public interface CallBack{
        public void recieveDays(List<Day> days);

    }
    private ApiClient apiClient;
    public DataRepository(Settings settings){
        this.settings = settings;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiClient.baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiClient = retrofit.create(ApiClient.class);

    }

    private List<Day> transform(ApiResponse response){
        List<Day> days = new ArrayList<Day>();
        List<Forecast> r  = response.getList();
        Converter conv = new Converter();

        for (int i = 0; i < response.getList().size(); i ++) {
            Date date;
            Forecast forecast = r.get(i);
            date = new Date (forecast.getTimeInSeconds()*1000) ;


            days.add(new Day(conv.convertIcon(forecast.getWeather().get(0).getMain()),
                    conv.convertDays(date.getDay()), forecast.getWeather().get(0).getDescription(),
                    Math.round(forecast.getTemp().getMax()), Math.round(forecast.getTemp().getMin()),
                    conv.convertMonths(date.getMonth()) +  " " + date.getDate(),
                    forecast.getHumidity(), forecast.getPressure(), forecast.getSpeed()));
        }
    return days;
    }

    public void getDays() {

        String units = (settings.isFahrenheit()? "imperial": "metric");
        apiClient.getForecast("Sofia", 7, "8be27535e8972fc0bbc15efb8f4a8bb8", units).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();
                 days = transform(apiResponse);
                for (int i = 0; i<callBacks.size(); i ++){
                    callBacks.get(i).recieveDays(days);
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });


    }
}
