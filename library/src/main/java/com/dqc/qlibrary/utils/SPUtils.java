package com.dqc.qlibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

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

    private static String SP_NAME = "SPUtils";
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
    public static void putBoolen(Context context, String key, boolean val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putBoolen(Context context, String spName, String key, boolean val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static void putInt(Context context, String key, int val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putInt(Context context, String spName, String key, int val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static void putFloat(Context context, String key, float val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putFloat(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putFloat(Context context, String spName, String key, float val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putFloat(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static void putLong(Context context, String key, long val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putLong(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putLong(Context context, String spName, String key, long val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putLong(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static void putString(Context context, String key, String val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(key, val);
        editor.apply();
    }

    /**
     * 自定义spName
     */
    public static void putString(Context context, String spName, String key, String val) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(key, val);
        editor.apply();
    }

    /**
     * 默认使用init初始化的spName
     */
    public static boolean getBoolen(Context context, String key, boolean defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static boolean getBoolen(Context context, String spName, String key, boolean defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultVal);
    }

    /**
     * 默认使用init初始化的spName
     */
    public static int getInt(Context context, String key, int defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static int getInt(Context context, String spName, String key, int defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defaultVal);
    }

    /**
     * 默认使用init初始化的spName
     */
    public static float getFloat(Context context, String key, float defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static float getFloat(Context context, String spName, String key, float defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, defaultVal);
    }

    /**
     * 默认使用init初始化的spName
     */
    public static long getLong(Context context, String key, long defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static long getLong(Context context, String spName, String key, long defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, defaultVal);
    }

    /**
     * 默认使用init初始化的spName
     */
    public static String getString(Context context, String key, String defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultVal);
    }

    /**
     * 自定义spName
     */
    public static String getString(Context context, String spName, String key, String defaultVal) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultVal);
    }

    /**
     * 返回所有键值对，默认使用init初始化的spName
     */
    public static Map<String, ?> getAll(Context context) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getAll();
    }

    /**
     * 返回所有键值对，自定义spName
     */
    public static Map<String, ?> getAll(Context context, String spName) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.getAll();
    }

    /**
     * 删除指定数据，默认使用init初始化的spName
     */
    public static void remove(Context context, String key) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 删除指定数据，自定义spName
     */
    public static void remove(Context context, String spName, String key) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 删除所有数据，默认使用init初始化的spName
     */
    public static void clearAll(Context context) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 删除所有数据，自定义spName
     */
    public static void clearAll(Context context, String spName) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 检查key对应的数据是否存在，默认使用init初始化的spName
     */
    public static boolean contains(Context context, String key) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

    /**
     * 检查key对应的数据是否存在，自定义spName
     */
    public static boolean contains(Context context, String spName, String key) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

}