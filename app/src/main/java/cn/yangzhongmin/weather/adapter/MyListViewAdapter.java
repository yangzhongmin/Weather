package cn.yangzhongmin.weather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.yangzhongmin.weather.R;
import cn.yangzhongmin.weather.tool.Weather;

/**
 * Created by yzm on 2017/4/9.
 */

public class MyListViewAdapter extends BaseAdapter {

    private List<Weather> mList;
    private LayoutInflater mInflater;

    public MyListViewAdapter(Context context, ArrayList<Weather> list){
        this.mList = list.subList(1,list.size());
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.layout_weatheritem,null);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tv_date);
            viewHolder.tvTemp = (TextView) convertView.findViewById(R.id.tv_future_temp);
            viewHolder.ivWeatherA = (ImageView) convertView.findViewById(R.id.iv_weather_fa);
            viewHolder.ivWeatherB = (ImageView) convertView.findViewById(R.id.iv_weather_fb);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Weather weather = mList.get(position);
        viewHolder.tvDate.setText(weather.getDate()+" "+weather.getWeek());
        viewHolder.tvTemp.setText(weather.getTemperature());
        viewHolder.ivWeatherA.setImageResource(R.drawable.call_weather_icon_01);

        return convertView;
    }

    class ViewHolder{
        public TextView tvDate;
        public ImageView ivWeatherA;
        public ImageView ivWeatherB;
        public TextView tvTemp;
    }
}
