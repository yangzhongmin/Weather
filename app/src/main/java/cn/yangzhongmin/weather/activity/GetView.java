package cn.yangzhongmin.weather.activity;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import cn.yangzhongmin.weather.R;
import cn.yangzhongmin.weather.adapter.ListViewAdapter;

/**
 * Created by yzm on 2017/4/7.
 */

public class GetView {

    private View view;

    private TextView tvCurrentTemp;
    private TextView tvCurrentWeather;
    private TextView tvTodayTemp;

    private TextView tvTime0;
    private ImageView ivWeatherByTime0;
    private TextView tvTempByTime0;

    private TextView tvTime1;
    private ImageView ivWeatherByTime1;
    private TextView tvTempByTime1;

    private TextView tvTime2;
    private ImageView ivWeatherByTime2;
    private TextView tvTempByTime2;

    private TextView tvTime3;
    private ImageView ivWeatherByTime3;
    private TextView tvTempByTime3;

    private TextView tvTime4;
    private ImageView ivWeatherByTime4;
    private TextView tvTempByTime4;

    private TextView tvTime5;
    private ImageView ivWeatherByTime5;
    private TextView tvTempByTime5;

    private ListView lvWeatherList;


    public View getViewPage(Context context, String cityName){

        initView();

        ListViewAdapter adapter = new ListViewAdapter(context,cityName);

        /*
        需要补充根据城市名称或者根据位置获取天气信息的代码
        并根据获得的天气信息设置view内容
         */

        lvWeatherList.setAdapter(adapter);

        return view;
    }

    private void initView() {
        view = LinearLayout.inflate(context,R.layout.layout_weather,null);

        tvCurrentTemp = (TextView) view.findViewById(R.id.tv_current_temp);
        tvCurrentWeather = (TextView) view.findViewById(R.id.tv_current_weather);
        tvTodayTemp = (TextView) view.findViewById(R.id.tv_today_temp);

        tvTime0 = (TextView) view.findViewById(R.id.tv_time0);
        ivWeatherByTime0 = (ImageView) view.findViewById(R.id.iv_weather_by_time0);
        tvTempByTime0 = (TextView) view.findViewById(R.id.tv_temp_by_time0);

        tvTime1 = (TextView) view.findViewById(R.id.tv_time1);
        ivWeatherByTime1 = (ImageView) view.findViewById(R.id.iv_weather_by_time1);
        tvTempByTime1 = (TextView) view.findViewById(R.id.tv_temp_by_time1);

        tvTime2 = (TextView) view.findViewById(R.id.tv_time2);
        ivWeatherByTime2 = (ImageView) view.findViewById(R.id.iv_weather_by_time2);
        tvTempByTime2 = (TextView) view.findViewById(R.id.tv_temp_by_time2);

        tvTime3 = (TextView) view.findViewById(R.id.tv_time3);
        ivWeatherByTime3 = (ImageView) view.findViewById(R.id.iv_weather_by_time3);
        tvTempByTime3 = (TextView) view.findViewById(R.id.tv_temp_by_time3);

        tvTime4 = (TextView) view.findViewById(R.id.tv_time4);
        ivWeatherByTime4 = (ImageView) view.findViewById(R.id.iv_weather_by_time4);
        tvTempByTime4 = (TextView) view.findViewById(R.id.tv_temp_by_time4);

        tvTime5 = (TextView) view.findViewById(R.id.tv_time5);
        ivWeatherByTime5 = (ImageView) view.findViewById(R.id.iv_weather_by_time5);
        tvTempByTime5 = (TextView) view.findViewById(R.id.tv_temp_by_time5);


        lvWeatherList = (ListView) view.findViewById(R.id.lv_weather_list);
    }
}
