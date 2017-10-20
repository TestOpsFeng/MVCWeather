package com.it.mvcweather.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.widget.Toast;

import java.util.List;

/**
 * Created by lenovo on 2017/10/18.
 */
public class NormalUtils {
    public static Bitmap BitmapUtil(Context context,String photoName){
        int resId = context.getResources().getIdentifier(photoName, "drawable", context.getPackageName());
        return BitmapFactory.decodeResource(context.getResources(), resId);
    }
    public static Location getLocation(Context ctx) {
        //获取地理位置管理器
        LocationManager locationManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);
        String locationProvider;
        if(providers.contains(LocationManager.GPS_PROVIDER)){
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        }else if(providers.contains(LocationManager.NETWORK_PROVIDER)){
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        }else{
            Toast.makeText(ctx, "没有可用的位置提供器", Toast.LENGTH_SHORT).show();
            return null;
        }
        //获取Location
        Location location = locationManager.getLastKnownLocation(locationProvider);
        if(location!=null){
            //不为空,显示地理位置经纬度
//            String locationStr = "维度：" + location.getLatitude() +"\n"
//                    + "经度：" + location.getLongitude();
            return location;
        }
        return null;
    }
}
