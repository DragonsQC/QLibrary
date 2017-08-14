package com.dqc.qlibrary.utils;


import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.io.File;
import java.util.List;

/**
 * APP 相关信息工具类
 */
@SuppressWarnings("WeakerAccess,unused")
public class AppUtils {

    /**
     * 获得 APP 当前版本号
     *
     * @param context Context
     * @return 当前版本号
     */
    public static int getVerCode(Context context) {
        int verCode = -1;
        try {
            String packageName = context.getApplicationContext().getPackageName();
            verCode = context.getApplicationContext().getPackageManager()
                    .getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verCode;
    }

    /**
     * 获得 APP 当前版本信息
     *
     * @param context Context
     * @return 当前版本信息
     */
    public static String getVerName(Context context) {
        String verName = "";
        try {
            String packageName = context.getApplicationContext().getPackageName();
            verName = context.getApplicationContext().getPackageManager()
                    .getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

    /**
     * 获得 APP 运行的最大内存
     *
     * @return 最大内存
     */
    public static long getMaxMemory() {
        return Runtime.getRuntime().maxMemory() / 1024;
    }

    /**
     * 安装 apk
     *
     * @param context Context
     * @param file    APK file
     */
    public static void installApk(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 安装 apk
     *
     * @param context Context
     * @param uri     APK uri
     */
    public static void installApk(Context context, Uri uri) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 卸载 app
     *
     * @param context     Context
     * @param packageName 包名
     */
    public static void uninstallApk(Context context, String packageName) {
        Intent intent     = new Intent(Intent.ACTION_DELETE);
        Uri    packageURI = Uri.parse("package:" + packageName);
        intent.setData(packageURI);
        context.startActivity(intent);
    }

    /**
     * 检测服务是否运行
     *
     * @param context   Context
     * @param className 类名
     * @return 服务是否运行
     */
    public static boolean isServiceRunning(Context context, String className) {
        boolean isRunning = false;
        ActivityManager activityManager =
                (ActivityManager) context.getApplicationContext()
                        .getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            return false;
        }
        List<ActivityManager.RunningServiceInfo> servicesList =
                activityManager.getRunningServices(Integer.MAX_VALUE);

        for (ActivityManager.RunningServiceInfo si : servicesList) {
            if (className.equals(si.service.getClassName())) {
                isRunning = true;
            }
        }
        return isRunning;
    }

    /**
     * 停止运行的服务
     *
     * @param context   Context
     * @param className 类名
     * @return 是否停止运行的服务
     */
    public static boolean stopRunningService(Context context, String className) {
        Intent  intent_service = null;
        boolean ret            = false;
        try {
            intent_service = new Intent(context, Class.forName(className));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (intent_service != null) {
            ret = context.stopService(intent_service);
        }
        return ret;
    }

    /**
     * 获得当前系统的可用内存
     *
     * @param context Context
     * @return 当前系统的可用内存
     */
    public static int getDeviceUsableMemory(Context context) {
        ActivityManager am = (ActivityManager) context.getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        if (am == null) {
            return -1;
        }
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(mi);
        return (int) (mi.availMem / (1024 * 1024));
    }

    /**
     * 获取手机系统 SDK 版本
     *
     * @return 返回API版本号
     */
    public static int getSDKVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获得当前APP PackageInfo 对象
     *
     * @return PackageInfo 对象
     */
    public PackageInfo getPackageInfo(Context context) {
        PackageManager manager = context.getApplicationContext().getPackageManager();
        PackageInfo    info    = null;
        try {
            info = manager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return info;
    }
}
