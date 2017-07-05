package com.example.sophiakalanovska.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.sophiakalanovska.myapplication.Activities.MainActivity;
import com.example.sophiakalanovska.myapplication.data.DataRepository;
import com.example.sophiakalanovska.myapplication.data.Day;
import com.example.sophiakalanovska.myapplication.data.Icon;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;


public class WeeklyForecastFragment extends Fragment implements RecyclerAdapter.DayClickListener {


    private RecyclerView recyclerview;
    private RecyclerAdapter recyclerAdapter;
    private Settings settings;
    private DataRepository data;
    private DataRepository.CallBack callBack;
    private TextView txtToday;
    private TextView txtmaxTempratureToday;
    private TextView txtminTempratureToday;
    private TextView textDescription;
    private ImageView image;
    private List<Day> days;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    // Restore preferences


    public static WeeklyForecastFragment newInstance() {


        WeeklyForecastFragment fragment = new WeeklyForecastFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.weekly_forcast, container, false);
        settings = WeatherApplication.getSettings();
        data = WeatherApplication.getData();




        recyclerview = (RecyclerView) rootView.findViewById(R.id.sixdays);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WeatherApplication.getInstance());
        recyclerview.setLayoutManager(layoutManager);
        txtToday = (TextView) rootView.findViewById(R.id.textToday);
        txtmaxTempratureToday = (TextView) rootView.findViewById(R.id.maxtemperatureToday);
        txtminTempratureToday = (TextView) rootView.findViewById(R.id.mintemperatureToday);
        textDescription = (TextView) rootView.findViewById(R.id.textDescription);
        image = (ImageView) rootView.findViewById(R.id.imageView);

        callBack = new DataRepository.CallBack() {

            @Override
            public void recieveDays(List<Day> days) {

                WeeklyForecastFragment.this.days = days;
                textDescription.setText(days.get(0).getDescription());
                image.setImageResource(Icon.bigIcon(days.get(0).getImage()));
                txtToday.setText(getString(R.string.today, days.get(0).getDate()));
                txtmaxTempratureToday.setText(getString(R.string.maxtemp, days.get(0).getMaxtemp()));
                txtminTempratureToday.setText(getString(R.string.maxtemp, days.get(0).getMintemp()));
                recyclerAdapter = new RecyclerAdapter(days.subList(1, days.size()), getContext(), WeeklyForecastFragment.this);
                recyclerview.setAdapter(recyclerAdapter);

                }
        };


        View btnNextScreen = rootView.findViewById(R.id.weather_today);
        btnNextScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                onDayClicked(days.get(0));

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(getContext()).addApi(AppIndex.API).build();
        // Inflate the layout for this fragment


        return rootView;
    }

    @Override
    public void onDayClicked(Day day) {
        ((MainActivity) getActivity()).openDetails(day);

    }

    @Override
    public void onStart() {
        super.onStart();
        data.addCallBack(callBack);
    }

    @Override
    public void onStop() {
        super.onStop();
        data.removeCallBack(callBack);
    }


}
