package test.collyellow.coolweather.fragment;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.collyellow.coolweather.App;
import test.collyellow.coolweather.MyToast;
import test.collyellow.coolweather.R;
import test.collyellow.coolweather.adapter.WeatherFragmentRecyclerViewAdapter;
import test.collyellow.coolweather.bean.WeatherBean;
import test.collyellow.coolweather.databinding.WeatherFragmentBinding;
import test.collyellow.coolweather.service.RetrofitService;

/**
 * Created by collyellow on 2016/12/14.
 */

public class WeatherFragment extends Fragment {
    private int y;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    private WeatherFragmentBinding binding;
    private RetrofitService retrofitService;
    private String locationCity;
    private WeatherFragmentRecyclerViewAdapter adapter;
    private List<WeatherBean> lists = new ArrayList<>();

    public class Presenter {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.weather_fragment_location_ll:
                    MyToast.show("aaaaaaaaaaa");
                    break;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLocationClient = new LocationClient(App.context);     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数
        initLocation();
        mLocationClient.start();
        binding = DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false);
        binding.setPresenter(new Presenter());
        binding.setItem(new WeatherBean.ResultsBean.DailyBean());
        requstWeather();
        binding.weatherFragmentRecyclerview.setLayoutManager(new LinearLayoutManager(App.context));
        initData();
        return binding.getRoot();
    }

    private void requstWeather() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thinkpage.cn/v3/weather/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
        //key=ezkig1mno74bzpcm&location=beijing&language=zh-Hans&unit=c&start=0&days=5

    }

    private void initData() {
        adapter = new WeatherFragmentRecyclerViewAdapter(lists);
        binding.weatherFragmentRecyclerview.setAdapter(adapter);

//        Log.e("height","height = "+height);
        binding.weatherFragmentRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                binding.weatherFragmentRecyclerview.isAnimator = false;
                View childAt = binding.weatherFragmentRecyclerview.getChildAt(0);
                if (childAt.getY() < -childAt.getHeight() / 2) {
                    binding.weatherFragmentRecyclerview.isAnimator = true;
                }
                if (dy > 0) {
                    WeatherFragment.this.y += dy;
                    if (WeatherFragment.this.y > 200) {
                        WeatherFragment.this.y = 200;
                    }
                    int scale = (int) Math.abs((WeatherFragment.this.y * 1.0 / 200) * 255);
                    binding.title.setBackgroundColor(Color.argb((int) scale, 0, 0, 0));
                    int scale2 = scale / 3;
                    binding.weatherFragmentRecyclerview.setBackgroundColor(Color.argb(scale2, 0, 0, 0));
                } else {
                    WeatherFragment.this.y += dy;
                    if (WeatherFragment.this.y < 0) {
                        WeatherFragment.this.y = 0;
                    }
                    int scale = (int) Math.abs((WeatherFragment.this.y * 1.0 / 200) * 255);
                    binding.title.setBackgroundColor(Color.argb(scale, 0, 0, 0));
                    int scale2 = scale / 3;
                    binding.weatherFragmentRecyclerview.setBackgroundColor(Color.argb(scale2, 0, 0, 0));
                }
            }
        });
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(0);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    public class MyLocationListener implements BDLocationListener {


        @Override
        public void onReceiveLocation(BDLocation location) {
            String city = location.getCity();
            if (city != null) {
                binding.weatherFragmentRecyclerviewCity.setText(city);
                Call<WeatherBean> searchWeather = retrofitService.getSearchBooks("ezkig1mno74bzpcm", city, "zh-Hans", "c", 0, 5);
                searchWeather.enqueue(new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        Log.e("body", response.body().getResults().get(0).getDaily().get(0).getCode_day() + "===");
                        lists.clear();
                        lists.add(response.body());
                        binding.weatherFragmentRecyclerviewTest.setText(response.body().getResults().get(0).getDaily().get(0).getCode_day());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {

                    }
                });
            }
        }
    }
}
