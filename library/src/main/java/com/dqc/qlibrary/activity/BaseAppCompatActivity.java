package com.dqc.qlibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dqc.qlibrary.R;
import com.jaeger.library.StatusBarUtil;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

/**
 * BaseAppCompatActivity
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public abstract class BaseAppCompatActivity extends AppCompatActivity implements BGASwipeBackHelper.Delegate {

    private BGASwipeBackHelper mSwipeBackHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回」
        initSwipeBack();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        // 正在滑动返回的时候取消返回按钮事件
        if (mSwipeBackHelper.isSliding()) {
            return;
        }
        mSwipeBackHelper.backward();
    }

    //<editor-fold defaultstate="collapsed" desc="侧滑返回 相关方法群" >

    /**
     * 初始化滑动返回。在 super.onCreate(savedInstanceState) 之前调用该方法
     */
    private void initSwipeBack() {
        mSwipeBackHelper = new BGASwipeBackHelper(this, this);

        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回」
        // 下面几项可以不配置，这里只是为了讲述接口用法。

        // 设置滑动返回是否可用。默认值为 true
        mSwipeBackHelper.setSwipeBackEnable(true);
        // 设置是否仅仅跟踪左侧边缘的滑动返回。默认值为 true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(true);
        // 设置是否是微信滑动返回样式。默认值为 true
        mSwipeBackHelper.setIsWeChatStyle(true);
        // 设置阴影资源 id。默认值为 R.drawable.bga_sbl_shadow
        mSwipeBackHelper.setShadowResId(R.drawable.bga_sbl_shadow);
        // 设置是否显示滑动返回的阴影效果。默认值为 true
        mSwipeBackHelper.setIsNeedShowShadow(true);
        // 设置阴影区域的透明度是否根据滑动的距离渐变。默认值为 true
        mSwipeBackHelper.setIsShadowAlphaGradient(true);
        // 设置触发释放后自动滑动返回的阈值，默认值为 0.3f
        mSwipeBackHelper.setSwipeBackThreshold(0.3f);
        // 设置底部导航条是否悬浮在内容上，默认值为 false
        mSwipeBackHelper.setIsNavigationBarOverlap(false);
    }

    /**
     * 是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，
     * 如果某个界面不想支持滑动返回则重写该方法返回 false 即可
     *
     * @return boolean
     */
    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    /**
     * 正在滑动返回
     *
     * @param slideOffset 从 0 到 1
     */
    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {
    }

    /**
     * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    @Override
    public void onSwipeBackLayoutCancel() {
    }

    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    @Override
    public void onSwipeBackLayoutExecuted() {
        mSwipeBackHelper.swipeBackward();
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="StatusBar 相关方法群" >

    /**
     * 设置状态栏颜色
     * <p>
     * setStatusBarXXX 方法只会实现最后一次的调用
     *
     * @param color Color
     */
    public void setStatusBarColor(int color) {
        StatusBarUtil.setColor(this, color);
    }

    /**
     * 设置状态栏颜色和透明度
     * <p>
     * setStatusBarXXX 方法只会实现最后一次的调用
     *
     * @param color Color
     * @param alpha 状态栏的透明度 0~255
     */
    public void setStatusBarColor(int color, int alpha) {
        StatusBarUtil.setColor(this, color, alpha);
    }

    /**
     * 设置透明状态栏
     * <p>
     * setStatusBarXXX 方法只会实现最后一次的调用
     */
    public void setStatusBarTransparent() {
        StatusBarUtil.setTransparent(this);
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="startActivity 相关方法群" >

    /**
     * startActivity
     *
     * @param clazz Activity.class
     */
    public void goTo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with flags
     *
     * @param clazz Activity.class
     * @param flags FLAG_ACTIVITY
     */
    public void goTo(Class<?> clazz, int flags) {
        Intent intent = new Intent(this, clazz);
        intent.addFlags(flags);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz  Activity.class
     * @param bundle data
     */
    public void goTo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity with bundle and flags
     *
     * @param clazz  Activity.class
     * @param bundle data
     * @param flags  FLAG_ACTIVITY
     */
    public void goTo(Class<?> clazz, Bundle bundle, int flags) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        intent.addFlags(flags);
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz Activity.class
     */
    public void goToThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with flags then finish
     *
     * @param clazz Activity.class
     * @param flags FLAG_ACTIVITY
     */
    public void goToThenKill(Class<?> clazz, int flags) {
        Intent intent = new Intent(this, clazz);
        intent.addFlags(flags);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz  Activity.class
     * @param bundle data
     */
    public void goToThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle and flags then finish
     *
     * @param clazz  Activity.class
     * @param bundle data
     * @param flags  FLAG_ACTIVITY
     */
    public void goToThenKill(Class<?> clazz, Bundle bundle, int flags) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        intent.addFlags(flags);
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz       Activity.class
     * @param requestCode RequestCode
     */
    public void goToForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle flags
     *
     * @param clazz       Activity.class
     * @param requestCode RequestCode
     * @param flags       FLAG_ACTIVITY
     */
    public void goToForResult(Class<?> clazz, int requestCode, int flags) {
        Intent intent = new Intent(this, clazz);
        intent.addFlags(flags);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz       Activity.class
     * @param requestCode RequestCode
     * @param bundle      data
     */
    public void goToForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle and flags
     *
     * @param clazz       Activity.class
     * @param requestCode RequestCode
     * @param bundle      data
     * @param flags       FLAG_ACTIVITY
     */
    public void goToForResult(Class<?> clazz, int requestCode, Bundle bundle, int flags) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        intent.addFlags(flags);
        startActivityForResult(intent, requestCode);
    }

    //</editor-fold>
}
