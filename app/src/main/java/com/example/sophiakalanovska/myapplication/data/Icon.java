package com.example.sophiakalanovska.myapplication.data;

import com.example.sophiakalanovska.myapplication.R;

/**
 * Created by sophiakalanovska on 28/06/2017.
 */

public enum Icon {
    Clear,
    Cloudy,
    Fog,
    Light_Clouds,
    Light_Rain,
    Rain,
    Storm,
    Snow;


    public static int smallIcon (Icon icon) {
        switch (icon) {
            case Clear:
                return R.drawable.ic_clear;
            case Cloudy:
                return R.drawable.ic_cloudy;
            case Fog:
                return R.drawable.ic_fog;
            case Light_Clouds:
                return R.drawable.ic_light_clouds;
            case Light_Rain:
                return R.drawable.ic_light_rain;
            case Rain:
                return R.drawable.ic_rain;
            case Storm:
                return R.drawable.ic_storm;
            case Snow:
                return R.drawable.ic_snow;

            default:
                throw new RuntimeException("Invalid icon");
        }


    }

    public static int bigIcon (Icon icon) {
        switch (icon){
            case Clear:
                return R.drawable.art_clear;
            case Cloudy:
                return R.drawable.art_clouds;
            case  Fog:
                return R.drawable.art_fog;
            case  Light_Clouds:
                return R.drawable.art_light_clouds;
            case  Light_Rain:
                return R.drawable.art_light_rain;
            case  Rain:
                return R.drawable.art_rain;
            case Storm:
                return  R.drawable.art_storm;
            case Snow:
                return  R.drawable.art_snow;

            default:
                throw new RuntimeException("Invalid icon");
        }


    }
}
