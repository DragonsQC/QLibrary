package com.dqc.qlibrary.activity;

import android.os.Bundle;

import com.dqc.qlibrary.library.swipeback.SwipeBackActivityBase;
import com.dqc.qlibrary.library.swipeback.SwipeBackActivityHelper;
import com.dqc.qlibrary.library.swipeback.SwipeBackLayout;
import com.dqc.qlibrary.library.swipeback.Utils;

/**
 * 侧滑返回 Activity
 */
@SuppressWarnings("WeakerAccess,unused")
public abstract class BaseSwipeBackCompatActivity extends BaseAppCompatActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }

}
