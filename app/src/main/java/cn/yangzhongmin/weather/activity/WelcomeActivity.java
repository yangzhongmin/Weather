package cn.yangzhongmin.weather.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import cn.yangzhongmin.weather.R;
import cn.yangzhongmin.weather.tool.City;
import cn.yangzhongmin.weather.tool.CityList;

/**
 * Created by yzm on 2017/4/9.
 */

public class WelcomeActivity extends Activity {

    private double latitude = 40;
    private double longitude = 116;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);

        initLocation();
        initCityList();

        mHandler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                },2000
        );

   }

    private void initCityList() {
        MyAsyncTask asyncTask = new MyAsyncTask();
        MyAsyncTask2 asyncTask2 = new MyAsyncTask2();

        asyncTask.execute("上海");
        Log.i("location-x-y",longitude+", "+latitude);
        asyncTask2.execute(longitude,latitude);
    }

    private void initLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,}, 1);
            return;
        }

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);//高精度
        criteria.setAltitudeRequired(false);//不要求海拔
        criteria.setBearingRequired(false);//不要求方位
        criteria.setCostAllowed(false);//不允许有花费
        criteria.setPowerRequirement(Criteria.POWER_LOW);//低功耗

        //从可用的位置提供器中，匹配以上标准的最佳提供器
        String provider = locationManager.getBestProvider(criteria, true);

        //获得最后一次变化的位置
        Location location = locationManager.getLastKnownLocation(provider);

        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }

    }

}

class MyAsyncTask extends AsyncTask<String,Void,Void> {

    @Override
    protected Void doInBackground(String... params) {
        City locationCity = new City(params[0]);
        CityList.cityList.add(locationCity);
        return null;
    }
}

class MyAsyncTask2 extends AsyncTask<Double,Void,Void> {

    @Override
    protected Void doInBackground(Double... params) {
        City locationCity = new City(params[0],params[1]);
        CityList.cityList.add(locationCity);
        return null;
    }
}