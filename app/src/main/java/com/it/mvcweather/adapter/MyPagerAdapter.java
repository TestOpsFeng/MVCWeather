package com.it.mvcweather.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.it.mvcweather.been.DayData;
import com.it.mvcweather.been.TimeData;
import com.it.mvcweather.model.IHomeModel;
import com.it.mvcweather.model.ValueCallBack;

/**
 * Created by lenovo on 2017/10/20.
 */
public class MyPagerAdapter extends PagerAdapter {
    private final IHomeModel iHomeModel;
    private Context context;
    public MyPagerAdapter(Context context, IHomeModel iHomeModel) {
        this.context = context;
        this.iHomeModel = iHomeModel;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        final ListView listView;
        if(position ==0){
            listView = new ListView((Context) context);
            iHomeModel.getTimeData(new ValueCallBack() {
                @Override
                public void getData(Object obj) {
                    TimeData timeData = (TimeData) obj;
                    TimeAdapter adapter = new TimeAdapter(context, timeData.getResults().get(0).getHourly());
                    listView.setAdapter(adapter);
                    container.addView(listView);
                }
            });
        }else if(position == 1){
            listView = new ListView((Context) context);
            iHomeModel.getDayData(new ValueCallBack() {
                @Override
                public void getData(Object obj) {
                    DayData dayData = (DayData) obj;
                    DayAdapter adapter = new DayAdapter(context, dayData.getResults().get(0).getDaily());
                    listView.setAdapter(adapter);
                    container.addView(listView);
                }
            });
        }else {
            listView = null;
        }
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
