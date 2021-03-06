package test.collyellow.coolweather.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Scroller;

import test.collyellow.coolweather.App;

/**
 * Created by collyellow on 2016/12/15.
 */

public class MyRecyclerView extends RecyclerView {
    public boolean isAnimator = false;
    private LinearLayoutManager manager;
    private Scroller scroller = new Scroller(App.context);
private int ddy = 0;
    private LayoutManager layoutManager;

    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                layoutManager = getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    manager = (LinearLayoutManager) layoutManager;
                    int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                    if (firstVisibleItemPosition == 0) {
                        animator();
                        Log.e("ddddd","ddddddddddddddddddd");
                        ddy = 0;
                    }
                }
                break;
        }
        return super.onTouchEvent(e);
    }

    private void animator() {
        if (isAnimator) {
         /*   ValueAnimator valueAnimator = ValueAnimator.ofInt(400);
            valueAnimator.setDuration(500);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                                @Override
                                                public void onAnimationUpdate(ValueAnimator valueAnimator) {

                                                    int animatedValue = (int) valueAnimator.getAnimatedValue();

                                                    //调用RecyclerView的scrollBy执行滑动
                                                    scrollBy(0, animatedValue-ddy);
                                                    ddy = animatedValue;
                                                    Log.e("TAG", "animatedValue:" + animatedValue+"----------------"+ddy);
                                                }
                                            }
            );
            valueAnimator.start();*/
            Log.e("animator","111111111111111111");
            layoutManager.smoothScrollToPosition(this,null,1);
        } else {
//            manager.scrollToPositionWithOffset(0, 0);
            layoutManager.smoothScrollToPosition(this,null,0);
            Log.e("animator","0000000000000000000000");
        }
    }

}
