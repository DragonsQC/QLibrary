package com.dqc.qlibrary.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * 清除内/外缓存，
 * 清除数据库，
 * 清除SharedPreference，
 * 清除files和清除自定义目录
 */
public class CleanUtils {
    /**
     * 清除本应用内部缓存(/data/data/com.xxx.xxx/cache)
     *
     * @param context Context
     */
    public static void cleanCacheDir(Context context) {
        deleteFilesByDir(context.getCacheDir());
    }

    /**
     * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases)
     *
     * @param context Context
     */
    public static void cleanDatabases(Context context) {
        deleteFilesByDir(new File("/data/data/" + context.getPackageName() + "/databases"));
    }

    /**
     * * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs)
     *
     * @param context Context
     */
    public static void cleanSharedPreference(Context context) {
        deleteFilesByDir(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
    }

    /**
     * 按名字清除本应用数据库
     *
     * @param context Context
     * @param dbName  数据库文件名
     */
    public static void cleanDatabaseByName(Context context, String dbName) {
        context.deleteDatabase(dbName);
    }

    /**
     * 清除/data/data/com.xxx.xxx/files下的内容
     *
     * @param context Context
     */
    public static void cleanFiles(Context context) {
        deleteFilesByDir(context.getFilesDir());
    }

    /**
     * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
     *
     * @param context Context
     */
    public static void cleanExternalCache(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            deleteFilesByDir(context.getExternalCacheDir());
        }
    }

    /**
     * 清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除
     *
     * @param filePath 文件路径
     */
    public static void cleanCustomCache(String filePath) {
        deleteFilesByDir(new File(filePath));
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
        cleanDatabases(context);
        cleanSharedPreference(context);
        cleanFiles(context);
        for (String filePath : filepath) {
            cleanCustomCache(filePath);
        }
    }

    /**
     * 删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理
     *
     * @param directory 文件夹
     */
    private static void deleteFilesByDir(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File item : directory.listFiles()) {
                //noinspection ResultOfMethodCallIgnored
                item.delete();
            }
        }
    }
}