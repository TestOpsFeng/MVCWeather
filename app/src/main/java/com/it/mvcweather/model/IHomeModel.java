package com.it.mvcweather.model;

/**
 * Created by lenovo on 2017/10/10.
 */
public interface IHomeModel {
    void getNowData(ValueCallBack valueCallBack);

    void getTimeData(ValueCallBack valueCallBack);

    void getDayData(ValueCallBack valueCallBack);
}
