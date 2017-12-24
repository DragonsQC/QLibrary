package com.dqc.qlibrary.activity;

import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

/**
 * 侧滑返回 Activity
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public abstract class BaseSwipeBackCompatActivity extends BaseAppCompatActivity implements SlidingPaneLayout.PanelSlideListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initSwipeBackFinish();
        super.onCreate(savedInstanceState);

    }

    /**
     * 初始化滑动返回
     */
    private void initSwipeBackFinish() {
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(this);
        //通过反射改变mOverhangSize的值为0，这个mOverhangSize值为菜单到右边屏幕的最短距离，
        //默认是32dp，现在给它改成0
        try {
            //属性
            Field fOverHang = SlidingPaneLayout.class.getDeclaredField("mOverhangSize");
            fOverHang.setAccessible(true);
            fOverHang.set(slidingPaneLayout, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        slidingPaneLayout.setPanelSlideListener(this);
        slidingPaneLayout.setSliderFadeColor(getResources().getColor(android.R.color.transparent));

        View leftView = new View(this);
        leftView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        slidingPaneLayout.addView(leftView, 0);

        ViewGroup decor      = (ViewGroup) getWindow().getDecorView();
        ViewGroup decorChild = (ViewGroup) decor.getChildAt(0);
        decorChild.setBackgroundColor(getResources().getColor(android.R.color.white));
        decor.removeView(decorChild);
        decor.addView(slidingPaneLayout);
        slidingPaneLayout.addView(decorChild, 1);
    }

}
