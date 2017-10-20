package com.it.mvcweather.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.mvcweather.R;
import com.it.mvcweather.been.DayData;

import java.util.List;

/**
 * Created by lenovo on 2017/10/17.
 *     第一页viewpager的适配器
 */
public class DayAdapter extends MyBaseAdapter {

    private List<DayData.ResultsBean.DailyBean> list;
    @SuppressWarnings("unchecked")
    public <T> DayAdapter(Context context, List<T> list) {
        super(context, list);
        this.list = (List<DayData.ResultsBean.DailyBean>) list;
    }

    @Override
    public int getContentView() {
        return R.layout.list_day;
    }

    @Override
    public void onInitView(View convertView, int position) {
        TextView tv_day = (TextView) get(convertView, R.id.tv_day);
        TextView tv_temperature = (TextView) get(convertView, R.id.tv_temperature);
        ImageView iv_weather = (ImageView) get(convertView, R.id.iv_weather);
        tv_day.setText(list.get(position).getDate());
        tv_temperature.setText(list.get(position).getLow() + "°~" + list.get(position).getHigh() + "°");
        String photoName = "sp" + list.get(position).getCode_day();
        Bitmap bitmap = getBitmap(photoName);
        iv_weather.setImageBitmap(bitmap);
    }
}
