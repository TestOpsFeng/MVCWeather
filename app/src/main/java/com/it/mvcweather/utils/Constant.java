package com.it.mvcweather.utils;

import android.location.Location;

import com.it.mvcweather.App;

/**
 * Created by lenovo on 2017/10/16.
 */
public class Constant {
    private static Location location = NormalUtils.getLocation(App.getContext());
    
    //北京24小时天气TimeData（付费接口）
    public static final String TIMEDATA = "https://api.seniverse.com/v3/weather/hourly.jso" +
            "n?key=miyyhb4jhyyi7xzf&location="+ getLocation() +"&language=zh-Hans&unit=c&start=0&hours=24";

    //北京当前天气NowData
    public static String NOWDATA = "https://api.seniverse.com/v3/weather/now.json?k" +
            "ey=miyyhb4jhyyi7xzf&location="+getLocation() +"&language=zh-Hans&unit=c";

    //北京逐日（3天）天气ForecastData
    public static String FORECASTDATA = "https://api.seniverse.com/v3/weather/daily.json" +
            "?key=miyyhb4jhyyi7xzf&location="+getLocation() +"&language=zh-Hans&unit=c&start=0&days=3";

    public static String DAYDATA = "https://api.seniverse.com/v3/weather/daily.json?key=miyyhb4jhyyi7xzf&location="+getLocation() +"&language=zh-Hans&unit=c&start=0&days=5";
    private static String getLocation(){
        String s;
        if(location != null){
            s = location.getLatitude() + ":" + location.getLongitude();
        }else {
            s = "beijing";
        }
        return s;
    }
}
