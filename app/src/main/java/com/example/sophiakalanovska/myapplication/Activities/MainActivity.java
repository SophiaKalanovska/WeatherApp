package com.example.sophiakalanovska.myapplication.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sophiakalanovska.myapplication.Details_Fragment;
import com.example.sophiakalanovska.myapplication.R;
import com.example.sophiakalanovska.myapplication.WeeklyForecastFragment;
import com.example.sophiakalanovska.myapplication.data.Day;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        WeeklyForecastFragment weeklyForecastFragment = WeeklyForecastFragment.newInstance();

        fragmentTransaction.add(R.id.container, weeklyForecastFragment);

        fragmentTransaction.commit();

    }



    public void openDetails(Day day){
        Details_Fragment detail = Details_Fragment.newInstance(day);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, detail)
                .addToBackStack(null)
                .commit();
    }
}


