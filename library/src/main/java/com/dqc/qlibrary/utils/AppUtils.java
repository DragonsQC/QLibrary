package com.dqc.qlibrary.utils;


import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.dqc.qlibrary.QLibrary;

import java.io.File;
import java.util.List;

/**
 * APP 相关信息工具类
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused")
public class AppUtils {

    /**
     * 获得 APP 当前版本号
     *
     * @return 当前版本号
     */
    public static int getVerCode() {
        int verCode = -1;
        try {
            String packageName = QLibrary.getInstance().getContext().getPackageName();
            verCode = QLibrary.getInstance().getContext().getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verCode;
    }

    /**
     * 获得 APP 当前版本信息
     *
     * @return 当前版本信息
     */
    public static String getVerName() {
        String verName = "";
        try {
            String packageName = QLibrary.getInstance().getContext().getPackageName();
            verName = QLibrary.getInstance().getContext().getPackageManager().getPackageInfo(packageName, 0).versionName;
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
     * @param file APK file
     */
    public static void installApk(File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        QLibrary.getInstance().getContext().startActivity(intent);
    }

    /**
     * 安装 apk
     *
     * @param uri APK uri
     */
    public static void installApk(Uri uri) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        QLibrary.getInstance().getContext().startActivity(intent);
    }

    /**
     * 卸载 app
     *
     * @param packageName 包名
     */
    public static void uninstallApk(String packageName) {
        Intent intent     = new Intent(Intent.ACTION_DELETE);
        Uri    packageURI = Uri.parse("package:" + packageName);
        intent.setData(packageURI);
        QLibrary.getInstance().getContext().startActivity(intent);
    }

    /**
     * 检测服务是否运行
     *
     * @param className 类名
     * @return 服务是否运行
     */
    public static boolean isServiceRunning(String className) {
        boolean isRunning = false;
        ActivityManager activityManager =
                (ActivityManager) QLibrary.getInstance().getContext().getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            return false;
        }
        List<ActivityManager.RunningServiceInfo> servicesList = activityManager.getRunningServices(Integer.MAX_VALUE);

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
     * @param className 类名
     * @return 是否停止运行的服务
     */
    public static boolean stopRunningService(String className) {
        Intent  intentService = null;
        boolean ret           = false;
        try {
            intentService = new Intent(QLibrary.getInstance().getContext(), Class.forName(className));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (intentService != null) {
            ret = QLibrary.getInstance().getContext().stopService(intentService);
        }
        return ret;
    }

    /**
     * 获得当前系统的可用内存
     *
     * @return 当前系统的可用内存
     */
    public static int getDeviceUsableMemory() {
        ActivityManager am = (ActivityManager) QLibrary.getInstance().getContext().getSystemService(Context.ACTIVITY_SERVICE);
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
    public PackageInfo getPackageInfo() {
        PackageManager manager = QLibrary.getInstance().getContext().getPackageManager();
        PackageInfo    info    = null;
        try {
            info = manager.getPackageInfo(QLibrary.getInstance().getContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return info;
    }
}
