package com.dqc.qlibrary.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dqc.qlibrary.library.slide.SlideBackActivity;

/**
 * 侧滑返回 Activity
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public abstract class BaseSwipeBackCompatActivity extends SlideBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

}
