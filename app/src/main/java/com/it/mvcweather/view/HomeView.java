package com.it.mvcweather.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.mvcweather.R;
import com.it.mvcweather.adapter.DayAdapter;
import com.it.mvcweather.adapter.MyBaseAdapter;
import com.it.mvcweather.adapter.MyPagerAdapter;
import com.it.mvcweather.been.NowData;
import com.it.mvcweather.presenter.HomePresenter;
import com.it.mvcweather.presenter.IHomePresenter;
import com.it.mvcweather.utils.NormalUtils;


public class HomeView extends Activity implements IHomeView {
    private TextView tv_city;
    private TextView tv_temperature;
    private ImageView iv_weather;
    private ViewPager viewpager;
    private IHomePresenter presenter;
    private TabLayout tab_layout;
    private MyBaseAdapter timeAdapter;
    private DayAdapter dayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findWidget();
        presenter = new HomePresenter(this);
        presenter.getNowData();
        presenter.setViewPager();
    }

    @Override
    public void showViewPager(MyPagerAdapter pagerAdapter) {
        viewpager.setAdapter(pagerAdapter);
        tab_layout.setupWithViewPager(viewpager);
        tab_layout.getTabAt(0).setText("Time");
        tab_layout.getTabAt(1).setText("Day");
    }

    private void findWidget() {
        tv_city = (TextView) findViewById(R.id.tv_city);
        tv_temperature = (TextView) findViewById(R.id.tv_temperature);
        iv_weather = (ImageView) findViewById(R.id.iv_weather);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);

    }

    @Override
    public void showNowData(NowData nowData) {
        String name = nowData.getResults().get(0).getLocation().getName();
        tv_city.setText(name);
        tv_temperature.setText(nowData.getResults().get(0).getNow().getTemperature());
        String photoName = "p" + nowData.getResults().get(0).getNow().getCode();
        iv_weather.setImageBitmap(NormalUtils.BitmapUtil(this, photoName));
    }


}