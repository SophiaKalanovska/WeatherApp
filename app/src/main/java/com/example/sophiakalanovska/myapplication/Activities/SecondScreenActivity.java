package com.example.sophiakalanovska.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sophiakalanovska.myapplication.R;
import com.example.sophiakalanovska.myapplication.data.Icon;
import com.example.sophiakalanovska.myapplication.data.Day;

/**
 * Created by sophiakalanovska on 28/06/2017.
 */

public class SecondScreenActivity extends AppCompatActivity {


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);


        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.toolbarChild);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.drawable.ic_sun_logo);


        TextView txtToday = (TextView) findViewById(R.id.textdate);
        TextView txtTitleDetail = (TextView) findViewById(R.id.textTitleDetail);
        TextView txtmaxTempratureToday = (TextView) findViewById(R.id.textmaxdetail);
        TextView txtminTempratureToday = (TextView) findViewById(R.id.textmindetail);
        TextView textDesc = (TextView) findViewById(R.id.textDesc);
        ImageView image = (ImageView) findViewById(R.id.imageViewDesc);
        TextView hum = (TextView) findViewById(R.id.humidity);
        TextView press = (TextView) findViewById(R.id.pressure);
        TextView wind = (TextView) findViewById(R.id.wind);


        Intent intent = getIntent();


        Day day = (Day) intent.getSerializableExtra("day");

        txtToday.setText("" + day.getDate());
        txtTitleDetail.setText(day.getTitle());
        txtmaxTempratureToday.setText(getString(R.string.maxtemp,""+ day.getMaxtemp()));
        txtminTempratureToday.setText(getString(R.string.mintemp,""+ day.getMintemp()));
        image.setImageResource(Icon.bigIcon(day.getImage()));
        textDesc.setText(day.getDescription());
        hum.setText(getString(R.string.humidity, day.getHumidity()));
        press.setText(getString(R.string.pressure, "" + day.getPressure()));
        wind.setText(getString(R.string.wind,""+ day.getWind()));


    }


}


