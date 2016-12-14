package test.collyellow.coolweather.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import test.collyellow.coolweather.App;
import test.collyellow.coolweather.BR;
import test.collyellow.coolweather.R;
import test.collyellow.coolweather.holder.WeatherFragmentRecyclerHolder;

/**
 * Created by collyellow on 2016/12/14.
 */

public class WeatherFragmentRecyclerViewAdapter extends RecyclerView.Adapter<WeatherFragmentRecyclerHolder> {
    @Override
    public WeatherFragmentRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(App.context), R.layout.weather_fragment_recycler_items, parent, false);
        return new WeatherFragmentRecyclerHolder(binding);
    }

    @Override
    public void onBindViewHolder(WeatherFragmentRecyclerHolder holder, int position) {
        holder.getBinding().setVariable(BR.item, "aaa");
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
