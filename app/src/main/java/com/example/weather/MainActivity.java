package com.example.weather;







//key    e255f161ee4f8644baf4c8f540a96533
//key    e255f161ee4f8644baf4c8f540a96533


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends SingleFragmentActivity implements WeatherFragment.Callbacks{
    @Override
    protected Fragment createFragment() {
        return WeatherFragment.newInstance();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    protected int getFragmentId() {
        return R.id.fragment_container;
    }

    public void onWeatherSelected(WeatherItem weatherItem){   //平板中选中天气
        if(findViewById(R.id.detail_container)==null){
            Intent intent = WeatherDetailActivity.newIntent(this,weatherItem);
            startActivity(intent);
        }else{
            Fragment newDetail = WeatherDetailFragment.newInstance(weatherItem);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container,newDetail)
                    .commit();
        }
    }
}
