package com.it.mvcweather.model;

import android.util.Log;

import com.google.gson.Gson;
import com.it.mvcweather.been.DayData;
import com.it.mvcweather.been.NowData;
import com.it.mvcweather.been.TimeData;
import com.it.mvcweather.utils.Constant;
import com.it.mvcweather.utils.HttpCallBack;
import com.it.mvcweather.utils.OkHttpManager;
import com.squareup.okhttp.Request;

/**
 * Created by lenovo on 2017/10/10.
 */
public class HomeModel implements IHomeModel {

    //获取当前天气信息
    @Override
    public void getNowData(final ValueCallBack callBack) {
        String url = Constant.NOWDATA;
        OkHttpManager.getInstance().getRequest(url, new HttpCallBack() {
            @Override
            public void Success(String json) {
                NowData nowData = new Gson().fromJson(json, NowData.class);
                callBack.getData(nowData);
                Log.e("HomeModel", "onSuccess" + json);
            }

            @Override
            public void Failure(Request request) {
                Log.e("HomeModel", "��������ʧ��");
            }
        });
    }
    //获取24小时天气信息
    @Override
    public void getTimeData(final ValueCallBack callBack) {
        String url = Constant.TIMEDATA;
        OkHttpManager.getInstance().getRequest(url, new HttpCallBack() {
            @Override
            public void Success(String json) {
                TimeData timeData = new Gson().fromJson(json, TimeData.class);
                callBack.getData(timeData);
                Log.e("HomeModel1", "onSuccess" + json);
            }

            @Override
            public void Failure(Request request) {
                Log.e("HomeModel", "��������ʧ��");
            }
        });
    }

    //获取逐日数据
    @Override
    public void getDayData(final ValueCallBack callBack) {
        String url = Constant.DAYDATA;
        OkHttpManager.getInstance().getRequest(url, new HttpCallBack() {
            @Override
            public void Success(String json) {
                DayData dayData = new Gson().fromJson(json, DayData.class);
                callBack.getData(dayData);
                Log.e("HomeModel2", "onSuccess" + json);
            }

            @Override
            public void Failure(Request request) {
                Log.e("HomeModel", "��������ʧ��");
            }
        });
    }
}
