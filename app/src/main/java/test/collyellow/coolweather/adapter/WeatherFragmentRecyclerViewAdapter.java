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
    private static int TYPE_ONE = 0;
    private static int TYPE_SECONDE = 1;
    private static int TYPE_THIRD = 2;
    private static int TYPE_DEFALT = 3;
    private ViewDataBinding binding;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else if (position == 1) {
            return TYPE_SECONDE;
        } else if (position == 2) {
            return TYPE_THIRD;
        }else {
            return TYPE_DEFALT;
        }
    }

    @Override
    public WeatherFragmentRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(App.context), R.layout.weather_fragment_recycler_header_one, parent, false);
        } else if (viewType == TYPE_SECONDE) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(App.context), R.layout.weather_fragment_recycler_header_seconde, parent, false);
        } else if (viewType == TYPE_THIRD) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(App.context), R.layout.weather_fragment_recycler_header_tride, parent, false);
        } else {
            binding = DataBindingUtil.inflate(LayoutInflater.from(App.context), R.layout.weather_fragment_recycler_items, parent, false);
        }
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
