package com.dqc.qlibrary.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

/**
 * Android Toast 工具类
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused")
public class ToastUtils {

    /**
     * 系统 Toast 默认显示位置
     *
     * @param context      context
     * @param charSequence 字符串
     * @param duration     时长
     */
    public static void showDefault(@NonNull Context context, @NonNull CharSequence charSequence, int duration) {
        Toast.makeText(context.getApplicationContext(), charSequence, duration).show();
    }

    /**
     * 系统 Toast 默认显示位置，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param context      context
     * @param charSequence 字符串
     */
    public static void showDefault(@NonNull Context context, @NonNull CharSequence charSequence) {
        Toast.makeText(context.getApplicationContext(), charSequence, Toast.LENGTH_SHORT).show();
    }

    /**
     * 系统 Toast 默认显示位置
     *
     * @param context  context
     * @param rseId    资源id
     * @param duration 时长
     */
    public static void showDefault(@NonNull Context context, @StringRes int rseId, int duration) {
        Toast.makeText(context.getApplicationContext(), rseId, duration).show();
    }

    /**
     * 系统 Toast 默认显示位置，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param context context
     * @param rseId   资源id
     */
    public static void showDefault(@NonNull Context context, @StringRes int rseId) {
        Toast.makeText(context.getApplicationContext(), rseId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 系统 Toast 显示在屏幕中间
     *
     * @param context      context
     * @param charSequence 字符串
     * @param duration     时长
     */
    public static void showCenter(@NonNull Context context, @NonNull CharSequence charSequence, int duration) {
        Toast toast = Toast.makeText(context.getApplicationContext(), charSequence, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕中间，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param context      context
     * @param charSequence 字符串
     */
    public static void showCenter(@NonNull Context context, @NonNull CharSequence charSequence) {
        Toast toast = Toast.makeText(context.getApplicationContext(), charSequence, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕中间
     *
     * @param context  context
     * @param rseId    资源id
     * @param duration 时长
     */
    public static void showCenter(@NonNull Context context, @StringRes int rseId, int duration) {
        Toast toast = Toast.makeText(context.getApplicationContext(), rseId, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕中间，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param context context
     * @param rseId   资源id
     */
    public static void showCenter(@NonNull Context context, @StringRes int rseId) {
        Toast toast = Toast.makeText(context.getApplicationContext(), rseId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕顶部
     *
     * @param context      context
     * @param charSequence 字符串
     * @param duration     时长
     */
    public static void showTop(@NonNull Context context, @NonNull CharSequence charSequence, int duration) {
        Toast toast = Toast.makeText(context.getApplicationContext(), charSequence, duration);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕顶部，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param context      context
     * @param charSequence 字符串
     */
    public static void showTop(@NonNull Context context, @NonNull CharSequence charSequence) {
        Toast toast = Toast.makeText(context.getApplicationContext(), charSequence, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕顶部
     *
     * @param context  context
     * @param rseId    资源id
     * @param duration 时长
     */
    public static void showTop(@NonNull Context context, @StringRes int rseId, int duration) {
        Toast toast = Toast.makeText(context.getApplicationContext(), rseId, duration);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕顶部，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param context context
     * @param rseId   资源id
     */
    public static void showTop(@NonNull Context context, @StringRes int rseId) {
        Toast toast = Toast.makeText(context.getApplicationContext(), rseId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

}