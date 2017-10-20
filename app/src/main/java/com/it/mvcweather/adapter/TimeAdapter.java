package com.it.mvcweather.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.mvcweather.R;
import com.it.mvcweather.been.TimeData;

import java.util.List;

/**
 * Created by lenovo on 2017/10/17.
 *     第一页viewpager的适配器
 */
public class TimeAdapter extends MyBaseAdapter {

    private List<TimeData.ResultsBean.HourlyBean> list;

    @SuppressWarnings("unchecked")
    public <T> TimeAdapter(Context context, List<T> list) {
        super(context, list);

        this.list = (List<TimeData.ResultsBean.HourlyBean>) list;
    }

    @Override
    public int getContentView() {
        return R.layout.list_time;
    }

    @Override
    public void onInitView(View convertView, int position) {
        for (int i = 0; i < list.size(); i++) {
            Log.e("onInit",list.get(i).getText() + "--------------\n");

        }
        TextView tv_time = (TextView) get(convertView, R.id.tv_time);
        TextView tv_temperature = (TextView) get(convertView, R.id.tv_temperature);
        ImageView iv_weather = (ImageView) get(convertView, R.id.iv_weather);
        if(position == 0){
            tv_time.setText("Now");
        }else {
            String time = list.get(position).getTime();
            time = time.substring(11, 16);
            tv_time.setText(time);
        }
        tv_temperature.setText(list.get(position).getTemperature() + "°");
        String photoName = "sp" + list.get(position).getCode();
        Bitmap bitmap = getBitmap(photoName);
        iv_weather.setImageBitmap(bitmap);
    }
}
