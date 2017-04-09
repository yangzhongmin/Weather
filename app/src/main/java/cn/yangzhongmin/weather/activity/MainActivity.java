package cn.yangzhongmin.weather.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.yangzhongmin.weather.R;
import cn.yangzhongmin.weather.adapter.MyPagerAdapter;
import cn.yangzhongmin.weather.tool.CityList;
import cn.yangzhongmin.weather.tool.GetView;

/**
 * Created by yzm on 2017/4/6.
 */

public class MainActivity extends Activity implements View.OnClickListener{

    private List<View> mViewList = new ArrayList<>();
    private ViewPager mViewPager;
    private ImageButton mImgBtnChoiceCity;
    private ImageView mIVLocation;
    private TextView mTVCityName;

    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_main);

        initView();

        mImgBtnChoiceCity.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshView();
    }

    private void refreshView() {

        GetView getView = new GetView();

        for(int i=0;i<CityList.cityList.size();i++){
            View view = getView.getViewPage(this,CityList.cityList.get(i));
            mViewList.add(view);
        }

        mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_weather_info);
        mImgBtnChoiceCity = (ImageButton) findViewById(R.id.ibt_city_choice);
        mTVCityName = (TextView) findViewById(R.id.tv_city_name);
        mIVLocation = (ImageView) findViewById(R.id.iv_location);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibt_city_choice:
                Intent intent = new Intent(this, CityChoiceActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}