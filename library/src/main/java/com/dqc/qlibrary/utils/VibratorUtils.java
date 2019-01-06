package com.dqc.qlibrary.utils;

import android.app.Service;
import android.os.Vibrator;

import com.dqc.qlibrary.QLibrary;

/**
 * Android 手机震动工具类
 * <p>
 * 需要权限【android.permission.VIBRATE】
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public class VibratorUtils {

    /**
     * @param milliseconds 震动的时长，单位是毫秒
     */
    public static void vibrate(long milliseconds) {
        Vibrator vib = (Vibrator) QLibrary.getInstance().getContext().getSystemService(Service.VIBRATOR_SERVICE);
        if (vib == null) {
            return;
        }
        vib.vibrate(milliseconds);
    }

    /**
     * @param pattern  自定义震动模式 。数组中数字的含义依次是[静止时长，震动时长，静止时长，震动时长。。。]时长的单位是毫秒
     * @param isRepeat 是否反复震动，如果是true，反复震动，如果是false，只震动一次
     */
    public static void vibrate(long[] pattern, boolean isRepeat) {
        Vibrator vib = (Vibrator) QLibrary.getInstance().getContext().getSystemService(Service.VIBRATOR_SERVICE);
        if (vib == null) {
            return;
        }
        vib.vibrate(pattern, isRepeat ? 1 : -1);
    }

}  