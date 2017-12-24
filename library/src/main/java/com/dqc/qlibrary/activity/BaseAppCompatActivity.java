package com.dqc.qlibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.dqc.qlibrary.R;
import com.jaeger.library.StatusBarUtil;

import java.lang.reflect.Field;

/**
 * BaseAppCompatActivity
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public abstract class BaseAppCompatActivity extends AppCompatActivity implements SlidingPaneLayout.PanelSlideListener {

    /**
     * 是否滑动返回，默认true
     * <p>
     * 通过 {@link com.dqc.qlibrary.activity.BaseAppCompatActivity#setSwipeBack} 设置
     */
    private boolean isSwipeBack = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (toggleOverridePendingTransition()) {
            switch (getOverridePendingTransitionMode()) {
                case LEFT:
                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                    break;
                case RIGHT:
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);
                    break;
                case TOP:
                    overridePendingTransition(R.anim.top_in, R.anim.top_out);
                    break;
                case BOTTOM:
                    overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                    break;
                case SCALE:
                    overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
                    break;
                case FADE:
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    break;
                default:
                    break;
            }
        }
        if (isSwipeBack) {
            initSwipeBackFinish();
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void finish() {
        super.finish();
        if (toggleOverridePendingTransition()) {
            switch (getOverridePendingTransitionMode()) {
                case LEFT:
                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                    break;
                case RIGHT:
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);
                    break;
                case TOP:
                    overridePendingTransition(R.anim.top_in, R.anim.top_out);
                    break;
                case BOTTOM:
                    overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                    break;
                case SCALE:
                    overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
                    break;
                case FADE:
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    break;
                default:
                    break;
            }
        }
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

    /**
     * 设置时候滑动返回
     *
     * @param isSwipeBack boolean
     */
    public void setSwipeBack(boolean isSwipeBack) {
        this.isSwipeBack = isSwipeBack;
    }

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

    /**
     * toggle overridePendingTransition
     */
    protected abstract boolean toggleOverridePendingTransition();

    /**
     * get the overridePendingTransition mode
     */
    protected abstract TransitionMode getOverridePendingTransitionMode();

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

    /**
     * overridePendingTransition mode
     */
    public enum TransitionMode {
        LEFT, RIGHT, TOP, BOTTOM, SCALE, FADE
    }
}
