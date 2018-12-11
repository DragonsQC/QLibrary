package com.dqc.qlibrary.utils;

import android.app.Activity;
import android.view.View;

/**
 * 状态栏相关工具类
 */
public class StatusBarUtils {

    /**
     * 改变状态栏文字颜色（原生方式）
     *
     * @param activity Activity
     * @param isDark   是否黑色文字，反之白色文字
     */
    public static void setStatusBarTextColor(Activity activity, boolean isDark) {
        View decor = activity.getWindow().getDecorView();
        if (isDark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
}
