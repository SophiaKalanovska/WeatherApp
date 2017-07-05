package com.example.sophiakalanovska.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sophiakalanovska.myapplication.data.Day;
import com.example.sophiakalanovska.myapplication.data.Icon;

/**
 * A simple {@link Fragment} subclass.
 */
public class Details_Fragment extends Fragment {

    ActionBar ab ;

    public static Details_Fragment newInstance(Day day) {
        Details_Fragment f = new Details_Fragment();
        Bundle args = new Bundle();
        args.putSerializable("day", day);
        f.setArguments(args);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View secoundView = inflater.inflate(R.layout.detail, container, false);


        // Get a support ActionBar corresponding to this toolbar

       ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.drawable.ic_sun_logo);


        TextView txtToday = (TextView) secoundView.findViewById(R.id.textdate);
        TextView txtTitleDetail = (TextView) secoundView.findViewById(R.id.textTitleDetail);
        TextView txtmaxTempratureToday = (TextView) secoundView.findViewById(R.id.textmaxdetail);
        TextView txtminTempratureToday = (TextView) secoundView.findViewById(R.id.textmindetail);
        TextView textDesc = (TextView) secoundView.findViewById(R.id.textDesc);
        ImageView image = (ImageView) secoundView.findViewById(R.id.imageViewDesc);
        TextView hum = (TextView) secoundView.findViewById(R.id.humidity);
        TextView press = (TextView) secoundView.findViewById(R.id.pressure);
        TextView wind = (TextView) secoundView.findViewById(R.id.wind);


        Day day = (Day) getArguments().get("day");

        txtToday.setText("" + day.getDate());
        txtTitleDetail.setText(day.getTitle());
        txtmaxTempratureToday.setText(getString(R.string.maxtemp, "" + day.getMaxtemp()));
        txtminTempratureToday.setText(getString(R.string.mintemp, "" + day.getMintemp()));
        image.setImageResource(Icon.bigIcon(day.getImage()));
        textDesc.setText(day.getDescription());
        hum.setText(getString(R.string.humidity, day.getHumidity()));
        press.setText(getString(R.string.pressure, "" + day.getPressure()));
        wind.setText(getString(R.string.wind, "" + day.getWind()));

        return secoundView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            getActivity().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setLogo(R.drawable.ic_logo);
    }
}

