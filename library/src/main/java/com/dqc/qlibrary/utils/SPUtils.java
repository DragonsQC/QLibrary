package com.dqc.qlibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.dqc.qlibrary.QLibrary;

import java.util.Map;

/**
 * Android SharedPreferences 工具类
 * <p/>
 * 建议在 Application 中初始化设置spName，默认为
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused")
public class SPUtils {

    private static String                   SP_NAME = "SPUtils";
    private static SharedPreferences        sharedPreferences;
    private static SharedPreferences.Editor editor;

    /**
     * 初始化 spName，建议在Application中调用一次即可。
     */
    public static void init(String spName) {
        SP_NAME = spName;
    }

    /**
     * 默认使用init初始化的spName
     */
    public static void putBoolen(String key, boolean val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putBoolen(String spName, String key, boolean val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static void putInt(String key, int val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putInt(String spName, String key, int val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static void putFloat(String key, float val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putFloat(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putFloat(String spName, String key, float val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putFloat(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static void putLong(String key, long val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putLong(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putLong(String spName, String key, long val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putLong(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static void putString(String key, String val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putString(String spName, String key, String val) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static boolean getBoolen(String key, boolean defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static boolean getBoolen(String spName, String key, boolean defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultVal);
    }

    /**
     * 默认使用init初始化的spName
     */
    public static int getInt(String key, int defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static int getInt(String spName, String key, int defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defaultVal);
    }

    /**
     * 默认使用init初始化的spName
     */
    public static float getFloat(String key, float defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static float getFloat(String spName, String key, float defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, defaultVal);
    }

    /**
     * 默认使用init初始化的spName
     */
    public static long getLong(String key, long defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static long getLong(String spName, String key, long defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, defaultVal);
    }

    /**
     * 默认使用init初始化的spName
     */
    public static String getString(String key, String defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static String getString(String spName, String key, String defaultVal) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultVal);
    }

    /**
     * 返回所有键值对，默认使用init初始化的spName
     */
    public static Map<String, ?> getAll(Context context) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getAll();
    }

    /**
     * 返回所有键值对，自定义spName
     */
    public static Map<String, ?> getAll(String spName) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getAll();
    }

    /**
     * 删除指定数据，默认使用init初始化的spName
     */
    public static void remove(String key) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 删除指定数据，自定义spName
     */
    public static void remove(String spName, String key) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 删除所有数据，默认使用init初始化的spName
     */
    public static void clearAll(Context context) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 删除所有数据，自定义spName
     */
    public static void clearAll(String spName) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 检查key对应的数据是否存在，默认使用init初始化的spName
     */
    public static boolean contains(String key) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

    /**
     * 检查key对应的数据是否存在，自定义spName
     */
    public static boolean contains(String spName, String key) {
        sharedPreferences = QLibrary.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

}