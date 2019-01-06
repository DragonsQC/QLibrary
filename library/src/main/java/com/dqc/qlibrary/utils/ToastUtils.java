package com.dqc.qlibrary.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.dqc.qlibrary.QLibrary;

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
     * @param charSequence 字符串
     * @param duration     时长
     */
    public static void showDefault(@NonNull CharSequence charSequence, int duration) {
        Toast.makeText(QLibrary.getInstance().getContext(), charSequence, duration).show();
    }

    /**
     * 系统 Toast 默认显示位置，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param charSequence 字符串
     */
    public static void showDefault(@NonNull CharSequence charSequence) {
        Toast.makeText(QLibrary.getInstance().getContext(), charSequence, Toast.LENGTH_SHORT).show();
    }

    /**
     * 系统 Toast 默认显示位置
     *
     * @param rseId    资源id
     * @param duration 时长
     */
    public static void showDefault(@StringRes int rseId, int duration) {
        Toast.makeText(QLibrary.getInstance().getContext(), rseId, duration).show();
    }

    /**
     * 系统 Toast 默认显示位置，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param rseId 资源id
     */
    public static void showDefault(@StringRes int rseId) {
        Toast.makeText(QLibrary.getInstance().getContext(), rseId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 系统 Toast 显示在屏幕中间
     *
     * @param charSequence 字符串
     * @param duration     时长
     */
    public static void showCenter(@NonNull CharSequence charSequence, int duration) {
        Toast toast = Toast.makeText(QLibrary.getInstance().getContext(), charSequence, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕中间，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param charSequence 字符串
     */
    public static void showCenter(@NonNull CharSequence charSequence) {
        Toast toast = Toast.makeText(QLibrary.getInstance().getContext(), charSequence, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕中间
     *
     * @param rseId    资源id
     * @param duration 时长
     */
    public static void showCenter(@StringRes int rseId, int duration) {
        Toast toast = Toast.makeText(QLibrary.getInstance().getContext(), rseId, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕中间，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param rseId 资源id
     */
    public static void showCenter(@StringRes int rseId) {
        Toast toast = Toast.makeText(QLibrary.getInstance().getContext(), rseId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕顶部
     *
     * @param charSequence 字符串
     * @param duration     时长
     */
    public static void showTop(@NonNull CharSequence charSequence, int duration) {
        Toast toast = Toast.makeText(QLibrary.getInstance().getContext(), charSequence, duration);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕顶部，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param charSequence 字符串
     */
    public static void showTop(@NonNull CharSequence charSequence) {
        Toast toast = Toast.makeText(QLibrary.getInstance().getContext(), charSequence, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕顶部
     *
     * @param rseId    资源id
     * @param duration 时长
     */
    public static void showTop(@StringRes int rseId, int duration) {
        Toast toast = Toast.makeText(QLibrary.getInstance().getContext(), rseId, duration);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    /**
     * 系统 Toast 显示在屏幕顶部，默认显示时长 Toast.LENGTH_SHORT
     *
     * @param rseId 资源id
     */
    public static void showTop(@StringRes int rseId) {
        Toast toast = Toast.makeText(QLibrary.getInstance().getContext(), rseId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

}