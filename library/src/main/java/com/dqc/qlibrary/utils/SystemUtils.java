package com.dqc.qlibrary.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import com.dqc.qlibrary.QLibrary;

import java.util.Locale;

import androidx.core.app.ActivityCompat;

/**
 * 系统/设备相关工具类
 * <p>
 * 需要权限 <uses-permission android:name="android.permission.READ_PHONE_STATE" />
 *
 * @author .
 */
@SuppressWarnings("unused")
public class SystemUtils {

    /**
     * 获取当前手机系统语言。
     *
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return 语言列表
     */
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
     *
     * @return 手机IMEI
     */
    public static String getIMEI() {
        TelephonyManager tm = (TelephonyManager) QLibrary.getInstance().getContext().getSystemService(Activity.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        if (ActivityCompat.checkSelfPermission(QLibrary.getInstance().getContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return Settings.System.getString(QLibrary.getInstance().getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        } else {
            return tm.getDeviceId();
        }
    }
}  