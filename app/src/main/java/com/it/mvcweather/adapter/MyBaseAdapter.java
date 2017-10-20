package com.it.mvcweather.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2017/10/17.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> list;
    private LayoutInflater inflater;

    public MyBaseAdapter(Context context) {
        init(context, new ArrayList<T>());
    }

    public MyBaseAdapter(Context context, List<T> list) {
        init(context, list);
    }

    private void init(Context context, List<T> list) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    public abstract int getContentView();

    public abstract void onInitView(View convertView, int position);

    //通过文件名获取bitmap
    public Bitmap getBitmap(String photoName) {
        int resId = context.getResources().getIdentifier(photoName, "drawable", context.getPackageName());
        return BitmapFactory.decodeResource(context.getResources(), resId);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(getContentView(), null);
        }
        onInitView(convertView, position);
        return convertView;
    }

    @SuppressWarnings("unchecked")
    protected <E extends View> E get(View view, int viewId) {
        SparseArray<View> holder = (SparseArray<View>) view.getTag();
        if (holder == null) {
            holder = new SparseArray<>();
            view.setTag(holder);
        }
        View childView = holder.get(viewId);
        if (childView == null) {
            childView = view.findViewById(viewId);
            holder.put(viewId, childView);
        }
        return (E) childView;

    }

}
