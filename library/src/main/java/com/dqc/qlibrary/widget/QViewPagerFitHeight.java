package com.dqc.qlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * 自动适应高度 ViewPager，可设置是否滑动
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public class QViewPagerFitHeight extends ViewPager {

    private boolean isScroll = true;

    public QViewPagerFitHeight(Context context) {
        super(context);
    }

    public QViewPagerFitHeight(Context context, AttributeSet attrs) {
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if (h > height) {
                height = h;
            }
        }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
