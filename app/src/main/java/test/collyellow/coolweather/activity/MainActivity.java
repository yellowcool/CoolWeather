package test.collyellow.coolweather.activity;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import test.collyellow.coolweather.R;
import test.collyellow.coolweather.adapter.MainActivityViewPagerAdapter;
import test.collyellow.coolweather.databinding.ActivityMainBinding;
import test.collyellow.coolweather.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<Fragment> fragments = new ArrayList<>();
    private MainActivityViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
        adapter = new MainActivityViewPagerAdapter(getSupportFragmentManager(),fragments);
        binding.mainActivityViewpager.setAdapter(adapter);
    }

    private void initData() {
        fragments.add(new WeatherFragment());
        fragments.add(new WeatherFragment());
        fragments.add(new WeatherFragment());
    }
}
