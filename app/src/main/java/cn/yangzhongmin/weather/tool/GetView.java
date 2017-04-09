package cn.yangzhongmin.weather.tool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.yangzhongmin.weather.R;
import cn.yangzhongmin.weather.adapter.MyListViewAdapter;

/**
 * Created by yzm on 2017/4/7.
 */

public class GetView {

    private View view;

    private TextView tvCurrentTemp;
    private TextView tvCurrentWeather;
    private TextView tvTodayTemp;

    private ListView lvWeatherList;

    private ArrayList<Weather> futureWeatherList;

    public View getViewPage(Context context, City city){

        view = LayoutInflater.from(context).inflate(R.layout.layout_weather,null);

        initView();
        initViewData(context,city);

        return view;
    }

    private void initViewData(Context context, City city) {

        futureWeatherList = city.getWeatherListForFuture();

        tvCurrentTemp.setText(futureWeatherList.get(0).getTemperature());
        tvCurrentWeather.setText(futureWeatherList.get(1).getWeather());
        tvTodayTemp.setText(futureWeatherList.get(1).getTemperature());

        MyListViewAdapter adapter = new MyListViewAdapter(context,futureWeatherList);
        lvWeatherList.setAdapter(adapter);
    }

    private void initView() {

        tvCurrentTemp = (TextView) view.findViewById(R.id.tv_current_temp);
        tvCurrentWeather = (TextView) view.findViewById(R.id.tv_current_weather);
        tvTodayTemp = (TextView) view.findViewById(R.id.tv_today_temp);

        lvWeatherList = (ListView) view.findViewById(R.id.lv_weather_list);
    }


}
