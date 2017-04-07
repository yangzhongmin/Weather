package cn.yangzhongmin.weather.bean;

import java.util.ArrayList;

/**
 * Created by yzm on 2017/4/6.
 * City类用来封装数据，包括：
 * 城市名称，城市最近六天的天气数据
 */

public class City {

    String cityName;
    ArrayList<Weather> weatherList = new ArrayList<>();

}
