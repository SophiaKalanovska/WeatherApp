package com.example.sophiakalanovska.myapplication.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;

import com.example.sophiakalanovska.myapplication.API_Response.Weather;
import com.example.sophiakalanovska.myapplication.Details_Fragment;
import com.example.sophiakalanovska.myapplication.R;
import com.example.sophiakalanovska.myapplication.WeatherApplication;
import com.example.sophiakalanovska.myapplication.WeeklyForecastFragment;
import com.example.sophiakalanovska.myapplication.data.DataRepository;
import com.example.sophiakalanovska.myapplication.data.Day;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;

    private DataRepository.CallBack callBack =  callBack = new DataRepository.CallBack() {
        @Override
        public void recieveDays(List<Day> days) {

            WeeklyForecastFragment weeklyForecastFragment = WeeklyForecastFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container1, weeklyForecastFragment)
                    .addToBackStack(null)
                    .commit();

            Details_Fragment detail = Details_Fragment.newInstance(days.get(0));

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container2, detail)
                    .addToBackStack(null)
                    .commit();

        }
    }
            ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.weather_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        final Switch toggle = (Switch) findViewById(R.id.switch_b);
        toggle.setChecked(WeatherApplication.getSettings().isFahrenheit());
        toggle.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                         WeatherApplication.getSettings().setFahrenheit(isChecked);
                         WeatherApplication.getData().getDays();
                     }
                 }

                );



        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        WeeklyForecastFragment weeklyForecastFragment = WeeklyForecastFragment.newInstance();


        if ((findViewById(R.id.container2) == null)) {
            WeatherApplication.getData().getDays();
            fragmentTransaction.replace(R.id.container, weeklyForecastFragment);
            fragmentTransaction.commit();
        } else {

            WeatherApplication.getData().getDays();



        }


    }

//        fragmentTransaction.replace(R.id.container, weeklyForecastFragment);
//
//        fragmentTransaction.commit();


    public void openDetails(Day day) {
        Details_Fragment detail = Details_Fragment.newInstance(day);

        if ((findViewById(R.id.container2) == null)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, detail)
                    .addToBackStack(null)
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container2, detail)
                    .addToBackStack(null)
                    .commit();
        }


    }


    @Override
    protected void onStart() {
        super.onStart();
        if ((findViewById(R.id.container2) != null)) {
            WeatherApplication.getData().addCallBack(callBack);
        }
    }

    protected void onStop() {
        super.onStop();
        if ((findViewById(R.id.container2) != null)) {
            WeatherApplication.getData().removeCallBack(callBack);
        }
    }

}


