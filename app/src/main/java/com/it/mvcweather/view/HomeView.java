package com.it.mvcweather.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.it.mvcweather.R;
import com.it.mvcweather.adapter.DayAdapter;
import com.it.mvcweather.adapter.MyBaseAdapter;
import com.it.mvcweather.adapter.TimeAdapter;
import com.it.mvcweather.been.DayData;
import com.it.mvcweather.been.NowData;
import com.it.mvcweather.been.TimeData;
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
    private MyPagerAdapter myPagerAdapter;
    private DayAdapter dayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findWidget();
        presenter = new HomePresenter(this);
        presenter.getNowData();
        presenter.getDayData();
        presenter.getTimeData();
    }

    private void findWidget() {
        tv_city = (TextView) findViewById(R.id.tv_city);
        tv_temperature = (TextView) findViewById(R.id.tv_temperature);
        iv_weather = (ImageView) findViewById(R.id.iv_weather);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);

        tab_layout.addTab(tab_layout.newTab().setText("Time"));
        tab_layout.addTab(tab_layout.newTab().setText("Day"));
        tab_layout.addTab(tab_layout.newTab().setText("Life"));
        tab_layout.addTab(tab_layout.newTab().setText("City"));
        tab_layout.addTab(tab_layout.newTab().setText("More"));

    }

    @Override
    public void showNowData(NowData nowData) {
        String name = nowData.getResults().get(0).getLocation().getName();
        tv_city.setText(name);
        tv_temperature.setText(nowData.getResults().get(0).getNow().getTemperature());
        String photoName = "p" + nowData.getResults().get(0).getNow().getCode();
        iv_weather.setImageBitmap(NormalUtils.BitmapUtil(this, photoName));
    }

    public void showTimePager(TimeData timeData){
        timeAdapter = new TimeAdapter(HomeView.this, timeData.getResults().get(0).getHourly());
        myPagerAdapter = new MyPagerAdapter();
        viewpager.setAdapter(myPagerAdapter);
        tab_layout.setupWithViewPager(viewpager);
    }

    @Override
    public void showDayPager(DayData dayData) {
        dayAdapter = new DayAdapter(HomeView.this,dayData.getResults().get(0).getDaily());
    }

    private class MyPagerAdapter extends PagerAdapter{

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ListView listView = new ListView(HomeView.this);
            if(position ==0){
                listView.setAdapter(timeAdapter);
            }else if(position == 1){
                listView.setAdapter(dayAdapter);
            }

            container.addView(listView);
            return listView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}