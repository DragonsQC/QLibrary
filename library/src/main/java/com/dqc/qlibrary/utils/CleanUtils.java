package com.dqc.qlibrary.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * 清除内/外缓存，
 * 清除数据库，
 * 清除SharedPreference，
 * 清除files和清除自定义目录
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public class CleanUtils {

    /**
     * 清除本应用内部缓存(/data/data/com.xxx.xxx/cache)
     *
     * @param context Context
     */
    public static void cleanCacheDir(Context context) {
        FileUtils.deleteFile(context.getCacheDir(), false);
    }

    /**
     * 清除/data/data/com.xxx.xxx/files下的内容
     *
     * @param context Context
     */
    public static void cleanFiles(Context context) {
        FileUtils.deleteFile(context.getFilesDir(), false);

    }

    /**
     * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases)
     *
     * @param context Context
     */
    public static void cleanDB(Context context) {
        FileUtils.deleteFile(
                new File(context.getFilesDir().getParent() + File.separator + "databases"),
                false);

    }

    /**
     * * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs)
     *
     * @param context Context
     */
    public static void cleanSP(Context context) {
        FileUtils.deleteFile(
                new File(context.getFilesDir().getParent() + File.separator + "shared_prefs"),
                false);
    }

    /**
     * 按名字清除本应用数据库
     *
     * @param context Context
     * @param dbName  数据库文件名
     */
    public static void cleanDBByName(Context context, String dbName) {
        context.deleteDatabase(dbName);
    }


    /**
     * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
     *
     * @param context Context
     */
    public static void cleanExternalCache(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            FileUtils.deleteFile(context.getExternalCacheDir(), false);
        }
    }

    /**
     * 清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除
     *
     * @param filePath 文件路径
     */
    public static void cleanCustomCache(String filePath) {
        FileUtils.deleteFile(new File(filePath), false);

    }

    /**
     * 清除本应用所有的数据
     *
     * @param context  Context
     * @param filepath 文件路径...
     */
    public static void cleanApplicationData(Context context, String... filepath) {
        cleanCacheDir(context);
        cleanExternalCache(context);
        cleanDB(context);
        cleanSP(context);
        cleanFiles(context);
        for (String filePath : filepath) {
            cleanCustomCache(filePath);
        }
    }

}