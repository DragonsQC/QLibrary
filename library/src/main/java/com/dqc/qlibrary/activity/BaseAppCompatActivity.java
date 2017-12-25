package com.dqc.qlibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dqc.qlibrary.R;
import com.jaeger.library.StatusBarUtil;

/**
 * BaseAppCompatActivity
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    private boolean        mIsCreateTransition   = true;
    private boolean        mIsFinishTransition   = true;
    private TransitionMode mCreateTransitionMode = TransitionMode.RIGHT;
    private TransitionMode mFinishTransitionMode = TransitionMode.RIGHT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (mIsCreateTransition) {
            switch (mCreateTransitionMode) {
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
        super.onCreate(savedInstanceState);
    }

    @Override
    public void finish() {
        super.finish();
        if (mIsFinishTransition) {
            switch (mFinishTransitionMode) {
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
     * 设置 Activity 是否有切换动画，默认true
     *
     * @param isCreateTransition 是否显示创建时的切换动画
     * @param isFinishTransition 是否显示结束时的切换动画
     */
    public void setTransition(boolean isCreateTransition, boolean isFinishTransition) {
        mIsCreateTransition = isCreateTransition;
        mIsFinishTransition = isFinishTransition;
    }

    /**
     * 设置 Activity 切换的过度动画模式，不设置时默认为TransitionMode.RIGHT
     * <p>
     * 设置值 {@link TransitionMode}
     *
     * @param createTransitionMode 创建时切换动画
     * @param finishTransitionMode 结束时切换动画
     */
    public void setTransitionMode(TransitionMode createTransitionMode, TransitionMode finishTransitionMode) {
        mCreateTransitionMode = createTransitionMode;
        mFinishTransitionMode = finishTransitionMode;

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
