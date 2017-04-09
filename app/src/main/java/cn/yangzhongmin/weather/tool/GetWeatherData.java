package cn.yangzhongmin.weather.tool;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by yzm on 2017/4/6.
 */

public class GetWeatherData {

    private static String jsonString;

    public static ArrayList<Weather> recodeJsonData(String cityName) {
        jsonString = GetJsonString.requestByCityName(cityName);
        ArrayList<Weather> weatherForFutureList;

        weatherForFutureList = recodeJson(jsonString);

        Log.i("yzm-jsonString-cityName", jsonString);

        return weatherForFutureList;

    }

    public static ArrayList<Weather> recodeJsonData(double locationX, double locationY) {
        jsonString = GetJsonString.requestByLocation(locationX, locationY);
        ArrayList<Weather> weatherForFutureList;

        weatherForFutureList = recodeJson(jsonString);

        Log.i("yzm-jsonString-location", jsonString);
        return weatherForFutureList;
    }

    private static ArrayList<Weather> recodeJson(String jsonString) {
        JSONObject jsonObject;
        JSONObject tempObject;
        ArrayList<Weather> list = new ArrayList<>();

        try {
            jsonObject = new JSONObject(jsonString).getJSONObject("result");

            //获取实时天气
            Weather weather = new Weather();
            tempObject = jsonObject.getJSONObject("sk");
            weather.setTemperature(tempObject.getString("temp"));
            list.add(weather);

            //获取当天的天气情况
            Weather weatherToday = new Weather();

            tempObject = jsonObject.getJSONObject("today");
            String date = tempObject.getString("date_y");
            String today = date.substring(0,4)+date.substring(5,7)+date.substring(8,10);
            Log.i("yzm-today-time",today);

            weatherToday.setTemperature(tempObject.getString("temperature"));
            weatherToday.setDate(tempObject.getString("date_y").substring(5));
            weatherToday.setWeek("今天");
            weatherToday.setWeather(tempObject.getString("weather"));
            weatherToday.setTime(tempObject.getString("city"));

            tempObject = tempObject.getJSONObject("weather_id");
            weatherToday.setWeather_id_fa(tempObject.getString("fa"));
            weatherToday.setWeather_id_fb(tempObject.getString("fb"));

            list.add(weatherToday);

            //获取未来几天的天气情况
            jsonObject = jsonObject.getJSONObject("future");

            for(int i=1;i<6;i++){
                date = "day_"+(Integer.parseInt(today)+i);

                tempObject = jsonObject.getJSONObject(date);

                Weather futureWeather = new Weather();
                futureWeather.setTemperature(tempObject.getString("temperature"));
                futureWeather.setWeather(tempObject.getString("weather"));

                date = tempObject.getString("date");
                futureWeather.setDate(date.substring(4, 6) + "月" + date.substring(6) + "日");

                if (i == 1)
                    futureWeather.setWeek("明天");
                else
                    futureWeather.setWeek(tempObject.getString("week"));

                tempObject = tempObject.getJSONObject("weather_id");
                futureWeather.setWeather_id_fa(tempObject.getString("fa"));
                futureWeather.setWeather_id_fb(tempObject.getString("fb"));

                list.add(futureWeather);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("yzm-recodeJson-Future", "json 解析异常");
        }

        return list;
    }
}
