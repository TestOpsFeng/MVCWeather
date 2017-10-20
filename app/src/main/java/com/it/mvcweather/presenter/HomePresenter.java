package com.it.mvcweather.presenter;

import android.content.Context;
import android.util.Log;

import com.it.mvcweather.adapter.MyPagerAdapter;
import com.it.mvcweather.been.NowData;
import com.it.mvcweather.model.HomeModel;
import com.it.mvcweather.model.IHomeModel;
import com.it.mvcweather.model.ValueCallBack;
import com.it.mvcweather.view.IHomeView;

/**
 * Created by lenovo on 2017/10/10.
 */
public class HomePresenter implements IHomePresenter{

    private IHomeView iHomeView;
    private IHomeModel iHomeModel;

    public HomePresenter(IHomeView iMainView) {
        this.iHomeView = iMainView;
        iHomeModel = new HomeModel();
    }

    @Override
    public void getNowData() {
        iHomeModel.getNowData(new ValueCallBack() {
            @Override
            public void getData(Object obj) {
                NowData nowData = (NowData) obj;
                Log.e("HomePresenter",nowData.getResults().get(0).getNow().getText());
                iHomeView.showNowData(nowData);
            }
        });
    }


    @Override
    public void setViewPager() {
        MyPagerAdapter pagerAdapter = new MyPagerAdapter((Context) iHomeView,iHomeModel);
        iHomeView.showViewPager(pagerAdapter);
    }

}
