package cn.yangzhongmin.weather.tool;

/**
 * Created by yzm on 2017/4/6.
 */

public class Weather {

    private String temperature;
    private String weather;
    private String weather_id_fa;
    private String weather_id_fb;
    private String week;
    private String date;
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName= cityName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather_id_fa() {
        return weather_id_fa;
    }

    public void setWeather_id_fa(String weather_id_fa) {
        this.weather_id_fa = weather_id_fa;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeather_id_fb() {
        return weather_id_fb;
    }

    public void setWeather_id_fb(String weather_id_fb) {
        this.weather_id_fb = weather_id_fb;
    }
}
