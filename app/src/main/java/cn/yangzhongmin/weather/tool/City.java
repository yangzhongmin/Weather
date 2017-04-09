package cn.yangzhongmin.weather.tool;

import java.util.ArrayList;

/**
 * Created by yzm on 2017/4/6.
 * City类用来封装数据，包括：
 * 城市名称，城市最近六天的天气数据
 */

public class City {

    private String cityName;

    private ArrayList<Weather> weatherListForFuture;

    public City(String cityName){
        this.cityName = cityName;
        weatherListForFuture = GetWeatherData.recodeJsonData(cityName);
    }

    public City(double locationX, double locationY){
        weatherListForFuture = GetWeatherData.recodeJsonData(locationX, locationY);
        this.cityName = weatherListForFuture.get(1).getCityName();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ArrayList<Weather> getWeatherListForFuture() {
        return weatherListForFuture;
    }

    public void setWeatherListForFuture(ArrayList<Weather> weatherListForFuture) {
        this.weatherListForFuture = weatherListForFuture;
    }
}
