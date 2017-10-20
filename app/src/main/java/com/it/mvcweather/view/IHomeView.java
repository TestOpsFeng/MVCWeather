package com.it.mvcweather.view;

import com.it.mvcweather.adapter.MyPagerAdapter;
import com.it.mvcweather.been.NowData;

/**
 * Created by lenovo on 2017/10/18.
 */
public interface IHomeView {
    void showNowData(NowData nowData);
    void showViewPager(MyPagerAdapter pagerAdapter);
}
