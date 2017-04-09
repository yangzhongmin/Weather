package cn.yangzhongmin.weather.tool;

import java.util.ArrayList;

/**
 * Created by yzm on 2017/4/9.
 */

public class CityList {

    public static ArrayList<City> cityList = new ArrayList<>();

    public static void addCity(City city){
        cityList.add(city);
    }

    public static void removeCity(City city){
        cityList.remove(city);
    }

    public static void removeCity(int index){
        cityList.remove(index);
    }

}
