package com.dqc.qlibrary.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dqc.qlibrary.library.swipeback.SwipeBackLayout;

/**
 * 侧滑返回 Activity
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public abstract class BaseSwipeBackCompatActivity extends BaseAppCompatActivity {

    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwipeBackLayout = new SwipeBackLayout(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeBackLayout.attachActivity(this);
    }

}
