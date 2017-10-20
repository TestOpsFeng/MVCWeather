package com.it.mvcweather.view;

import com.it.mvcweather.been.DayData;
import com.it.mvcweather.been.NowData;
import com.it.mvcweather.been.TimeData;

/**
 * Created by lenovo on 2017/10/18.
 */
public interface IHomeView {
    void showNowData(NowData nowData);
    void showTimePager(TimeData timeData);
    void showDayPager(DayData dayData);
}
