package test.collyellow.coolweather.holder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by collyellow on 2016/12/14.
 */

public class WeatherFragmentRecyclerHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T binding;

    public WeatherFragmentRecyclerHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public T getBinding() {
        return binding;
    }
}
