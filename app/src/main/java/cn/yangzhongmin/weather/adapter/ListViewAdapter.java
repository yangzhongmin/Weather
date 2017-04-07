package cn.yangzhongmin.weather.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import cn.yangzhongmin.weather.R;

/**
 * Created by yzm on 2017/4/7.
 */

public class ListViewAdapter extends ArrayAdapter{


    public ListViewAdapter(Context context, String cityName) {
        super(context, R.layout.layout_futureweather);
    }
}
