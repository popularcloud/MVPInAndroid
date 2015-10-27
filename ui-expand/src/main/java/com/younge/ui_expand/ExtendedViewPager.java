package com.younge.ui_expand;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ExtendedViewPager extends ViewPager {

    boolean mScrollable = true;

    public ExtendedViewPager(Context context) {
        super(context);
    }

    public ExtendedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param scrollable 是否允许滚动
     */
    public void setScrollable(boolean scrollable) {
        mScrollable = scrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (mScrollable)
            return super.onTouchEvent(arg0);
        else
            return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (mScrollable)
            return super.onInterceptTouchEvent(arg0);
        else
            return false;
    }
}
