package com.dqc.qlibrary.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * 可设置是否滑动的 ViewPager
 */
public class QViewPager extends ViewPager {

    private boolean isScroll = true;

    public QViewPager(Context context) {
        super(context);
    }

    public QViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param isScroll 是否滑动（true 滑动，false 禁止）
     */
    public void setScroll(boolean isScroll) {
        this.isScroll = isScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isScroll && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isScroll && super.onInterceptTouchEvent(ev);
    }
    
}
