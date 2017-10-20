package com.it.mvcweather.utils;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by lenovo on 2017/10/13.
 */
public class OkHttpManager {

    private Gson mGson;
    private OkHttpClient mOkHttpClient;
    private static OkHttpManager mOkHttpManager;
    private Handler mHandler = new Handler(Looper.getMainLooper());


    private OkHttpManager() {
        mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        mOkHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
        mOkHttpClient.setWriteTimeout(10, TimeUnit.SECONDS);
        mGson = new Gson();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static OkHttpManager getInstance() {
        if (mOkHttpManager == null) {
            mOkHttpManager = new OkHttpManager();
        }
        return mOkHttpManager;
    }

    //����get����
    public void getRequest(String url, HttpCallBack callBack) {
        Request request = new Request.Builder().get().url(url).build();
        doRequest(request, callBack);
    }

    //ִ���������
    private void doRequest(Request request, final HttpCallBack callBack) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Request request, IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.Failure(request);
                    }
                });
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                final String json = response.body().string();

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.Success(json);
                    }
                });
            }
        });
    }
}
