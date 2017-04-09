package cn.yangzhongmin.weather.tool;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by yzm on 2017/4/6.
 */

public class GetJsonString {

    final static String API_KEY = "edf71bae6fbc355f09fe437603f56ee9";


    public static String requestByCityName(String cityName) {
        String URL = "http://v.juhe.cn/weather/index";
        String httpUrl = URL + "?cityname="+cityName+"&key="+API_KEY;

        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(httpUrl);
            InputStream is = url.openStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("yzm-requestByCityName","获取json数据失败");
        }
        return result;
    }

    public static String requestByLocation(double locationX, double locationY) {
        String URL = "http://v.juhe.cn/weather/geo";
        String httpUrl = URL + "?lon="+locationX+"&lat="+locationY+"&key="+API_KEY;

        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(httpUrl);
            InputStream is = url.openStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("yzm-requestByLocation","获取json数据失败");
        }
        return result;
    }
}
