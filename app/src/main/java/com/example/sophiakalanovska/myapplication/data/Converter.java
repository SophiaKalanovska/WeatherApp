package com.example.sophiakalanovska.myapplication.data;

/**
 * Created by sophiakalanovska on 03/07/2017.
 */

public class Converter {

    public String convertDays(int i){
        switch (i) {

            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";

            default:
                throw new RuntimeException("Invalid day");


        }
    }


    public String convertMonths(int i){
        switch (i) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";

            default:
                throw new RuntimeException("Invalid month");


        }
    }


    public Icon convertIcon(String i){
        switch (i) {
            case "Thunderstorm":
                return Icon.Storm;
            case "Drizzle":
                return Icon.Light_Rain;
            case "Rain":
                return Icon.Rain;
            case "Snow":
                return Icon.Snow;
            case "Atmosphere":
                return Icon.Fog;
            case "Clear":
                return Icon.Clear;
            case "Clouds":
                return Icon.Cloudy ;
            default:
                return Icon.Light_Clouds;


        }
    }

}
