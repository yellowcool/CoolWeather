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

import test.collyellow.coolweather.App;
import test.collyellow.coolweather.R;
import test.collyellow.coolweather.adapter.WeatherFragmentRecyclerViewAdapter;
import test.collyellow.coolweather.databinding.WeatherFragmentBinding;

/**
 * Created by collyellow on 2016/12/14.
 */

public class WeatherFragment extends Fragment {
    private int y;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final WeatherFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false);
        binding.weatherFragmentRecyclerview.setLayoutManager(new LinearLayoutManager(App.context));
        binding.weatherFragmentRecyclerview.setAdapter(new WeatherFragmentRecyclerViewAdapter());
        binding.weatherFragmentRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int height = binding.title.getHeight();
                if (dy > 0) {
                    y += dy;
                    Log.e("yyyy", "yyyy = " + y);
                    if (y > height) {
                        y = height;
                    }
                    int scale = (int) Math.abs((y * 1.0 / height) * 255);

                    Log.e("scale", "scale = " + scale);
                    binding.title.setBackgroundColor(Color.argb((int) scale, 0, 0, 0));
                    int scale2 = scale / 3;
                    binding.weatherFragmentRecyclerview.setBackgroundColor(Color.argb(scale2, 0, 0, 0));
                }
                else {
                    binding.title.setBackgroundColor(Color.argb(0, 0, 0, 0));
                    binding.weatherFragmentRecyclerview.setBackgroundColor(Color.argb(0, 0, 0, 0));
                }
            }
        });
        return binding.getRoot();
    }
}
