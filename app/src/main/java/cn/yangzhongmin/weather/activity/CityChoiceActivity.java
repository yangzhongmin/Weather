package cn.yangzhongmin.weather.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.yangzhongmin.weather.R;

/**
 * Created by yzm on 2017/4/9.
 */

public class CityChoiceActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_citychoice);
    }
}
