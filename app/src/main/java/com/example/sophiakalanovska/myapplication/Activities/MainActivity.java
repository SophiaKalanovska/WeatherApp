package com.example.sophiakalanovska.myapplication.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.sophiakalanovska.myapplication.R;
import com.example.sophiakalanovska.myapplication.RecyclerAdapter;
import com.example.sophiakalanovska.myapplication.Settings;
import com.example.sophiakalanovska.myapplication.WeatherApplication;
import com.example.sophiakalanovska.myapplication.data.Icon;
import com.example.sophiakalanovska.myapplication.data.DataRepository;
import com.example.sophiakalanovska.myapplication.data.Day;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.DayClickListener {

    private Toolbar toolbar;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        settings = new Settings();
        data = new DataRepository(settings);
        toolbar = (Toolbar) findViewById(R.id.weather_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        final Switch toggle = (Switch) findViewById(R.id.switch_b);
        toggle.setChecked(settings.isFahrenheit());
        toggle.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            settings.setFahrenheit(isChecked);
                            data.getDays(callBack);
                     }
                 }

                );


        recyclerview = (RecyclerView) findViewById(R.id.sixdays);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        txtToday = (TextView) findViewById(R.id.textToday);
        txtmaxTempratureToday = (TextView) findViewById(R.id.maxtemperatureToday);
        txtminTempratureToday = (TextView) findViewById(R.id.mintemperatureToday);
        textDescription = (TextView) findViewById(R.id.textDescription);
        image = (ImageView) findViewById(R.id.imageView);

        callBack = new DataRepository.CallBack() {
            @Override
            public void recieveDays(List<Day> days) {
                MainActivity.this.days = days;
                textDescription.setText(days.get(0).getDescription());
                image.setImageResource(Icon.bigIcon(days.get(0).getImage()));
                txtToday.setText(getString(R.string.today, days.get(0).getDate()));
                txtmaxTempratureToday.setText(getString(R.string.maxtemp, days.get(0).getMaxtemp()));
                txtminTempratureToday.setText(getString(R.string.maxtemp, days.get(0).getMintemp()));
                recyclerAdapter = new RecyclerAdapter(days.subList(1, days.size()), MainActivity.this, MainActivity.this);
                recyclerview.setAdapter(recyclerAdapter);

            }
        };
        data.getDays(callBack);


        View btnNextScreen = findViewById(R.id.weather_today);
        btnNextScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                onDayClicked(days.get(0));

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onDayClicked(Day day) {
        Intent intent = new Intent(this, SecondScreenActivity.class);
        intent.putExtra("day", day);
        startActivity(intent);
    }


    @Override
    protected void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }
}


