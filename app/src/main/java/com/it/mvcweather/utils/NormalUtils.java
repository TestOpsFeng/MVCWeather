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
        //��ȡ����λ�ù�����
        LocationManager locationManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
        //��ȡ���п��õ�λ���ṩ��
        List<String> providers = locationManager.getProviders(true);
        String locationProvider;
        if(providers.contains(LocationManager.GPS_PROVIDER)){
            //�����GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        }else if(providers.contains(LocationManager.NETWORK_PROVIDER)){
            //�����Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        }else{
            Toast.makeText(ctx, "û�п��õ�λ���ṩ��", Toast.LENGTH_SHORT).show();
            return null;
        }
        //��ȡLocation
        Location location = locationManager.getLastKnownLocation(locationProvider);
        if(location!=null){
            //��Ϊ��,��ʾ����λ�þ�γ��
//            String locationStr = "ά�ȣ�" + location.getLatitude() +"\n"
//                    + "���ȣ�" + location.getLongitude();
            return location;
        }
        return null;
    }
}
