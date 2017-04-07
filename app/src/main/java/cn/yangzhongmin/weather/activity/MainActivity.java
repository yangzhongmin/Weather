package cn.yangzhongmin.weather.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;

import cn.yangzhongmin.weather.R;

/**
 * Created by yzm on 2017/4/6.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_main);

        ViewPager viewPage = new ViewPager(this);
        View view = getLayoutInflater().inflate(R.layout.layout_weather,null);
        viewPage.addView(view,0);


    }
}
