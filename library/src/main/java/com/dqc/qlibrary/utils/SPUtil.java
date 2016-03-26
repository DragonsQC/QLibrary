package com.dqc.qlibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Android SharedPreferences 工具类
 *
 * @author DragonsQC
 */
public class SPUtil {

    private static String SP_NAME = "SPUtil";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public static void init(String appName) {
        SP_NAME = appName;
    }

    public static void putBoolen(Context context, String key, boolean val) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(key, val);
        editor.apply();
    }

    public static void putInt(Context context, String key, int val) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt(key, val);
        editor.apply();
    }

    public static void putFloat(Context context, String key, float val) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putFloat(key, val);
        editor.apply();
    }

    public static void putLong(Context context, String key, long val) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putLong(key, val);
        editor.apply();
    }

    public static void putString(Context context, String key, String val) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(key, val);
        editor.apply();
    }

    public static boolean getBoolen(Context context, String key, boolean defaultVal) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultVal);
    }

    public static int getInt(Context context, String key, int defaultVal) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defaultVal);
    }

    public static float getFloat(Context context, String key, float defaultVal) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, defaultVal);
    }

    public static long getLong(Context context, String key, long defaultVal) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, defaultVal);
    }

    public static String getString(Context context, String key, String defaultVal) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultVal);
    }

    /**
     * 返回所有键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getAll();
    }

    /**
     * 删除指定数据
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 删除所有数据
     *
     * @param context
     */
    public static void clearAll(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 检查key对应的数据是否存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

}