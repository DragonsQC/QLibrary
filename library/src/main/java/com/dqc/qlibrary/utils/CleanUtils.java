package com.dqc.qlibrary.utils;

import android.os.Environment;

import com.dqc.qlibrary.QLibrary;

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
     */
    public static void cleanCacheDir() {
        FileUtils.deleteFile(QLibrary.getInstance().getContext().getCacheDir(), false);
    }

    /**
     * 清除/data/data/com.xxx.xxx/files下的内容
     */
    public static void cleanFiles() {
        FileUtils.deleteFile(QLibrary.getInstance().getContext().getFilesDir(), false);

    }

    /**
     * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases)
     */
    public static void cleanDB() {
        FileUtils.deleteFile(new File(QLibrary.getInstance().getContext().getFilesDir().getParent() + File.separator + "databases"), false);
    }

    /**
     * * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs)
     */
    public static void cleanSP() {
        FileUtils.deleteFile(new File(QLibrary.getInstance().getContext().getFilesDir().getParent() + File.separator + "shared_prefs"), false);
    }

    /**
     * 按名字清除本应用数据库
     *
     * @param dbName 数据库文件名
     */
    public static void cleanDBByName(String dbName) {
        QLibrary.getInstance().getContext().deleteDatabase(dbName);
    }


    /**
     * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
     */
    public static void cleanExternalCache() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            FileUtils.deleteFile(QLibrary.getInstance().getContext().getExternalCacheDir(), false);
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
     * @param filepath 文件路径...
     */
    public static void cleanApplicationData(String... filepath) {
        cleanCacheDir();
        cleanExternalCache();
        cleanDB();
        cleanSP();
        cleanFiles();
        for (String filePath : filepath) {
            cleanCustomCache(filePath);
        }
    }

}