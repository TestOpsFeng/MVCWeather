package com.it.mvcweather.been;

/**
 * Created by lenovo on 2017/10/18.
 */
public class CityData {
    private String name;
    private double latitude;//Î³¶È
    private double longitude;//¾­¶È

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
