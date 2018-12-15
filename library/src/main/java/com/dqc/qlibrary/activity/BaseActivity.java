package com.dqc.qlibrary.activity;

import android.content.Intent;
import android.os.Bundle;

import com.github.anzewei.parallaxbacklayout.ParallaxBack;
import com.github.anzewei.parallaxbacklayout.ParallaxHelper;

import androidx.appcompat.app.AppCompatActivity;
import qiu.niorgai.StatusBarCompat;

/**
 * BaseActivity
 *
 * @author DragonsQC
 */
@SuppressWarnings("unused")
@ParallaxBack
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 默认支持滑动返回，调用此方法禁用
     */
    public void disableBack() {
        ParallaxHelper.disableParallaxBack(this);
    }

    //<editor-fold defaultstate="collapsed" desc="StatusBar 相关方法群" >

    /**
     * 设置状态栏颜色
     * <p>
     * setStatusBarXXX 方法只会实现最后一次的调用
     *
     * @param color Color
     */
    public void setStatusBarColor(int color) {
        StatusBarCompat.setStatusBarColor(this, color);
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
        StatusBarCompat.setStatusBarColor(this, color, alpha);
    }

    /**
     * 设置透明状态栏
     * <p>
     * setStatusBarXXX 方法只会实现最后一次的调用
     */
    public void setStatusBarTransparent() {
        StatusBarCompat.translucentStatusBar(this);
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
