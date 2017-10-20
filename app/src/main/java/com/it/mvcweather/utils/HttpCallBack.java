package com.it.mvcweather.utils;

import com.squareup.okhttp.Request;

/**
 * Created by lenovo on 2017/10/10.
 */
public interface HttpCallBack {
    void Success(String request);
    void Failure(Request response);
}
