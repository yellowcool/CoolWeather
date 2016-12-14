package test.collyellow.coolweather.behavoir;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import test.collyellow.coolweather.view.MyLinearLayout;

/**
 * Created by collyellow on 2016/12/14.
 */

public class MyBehavoir extends CoordinatorLayout.Behavior {
    public MyBehavoir(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof MyLinearLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float y = dependency.getY();
        int height = dependency.getHeight();
        child.setY(y + height);
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
