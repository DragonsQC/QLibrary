package com.dqc.qlibrary.utils;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Android Snackbar 工具类
 */
@SuppressWarnings("WeakerAccess,unused")
public class SnackbarUtils {

    /**
     * 显示一个 Snackbar 显示时长{@link Snackbar#LENGTH_SHORT}
     *
     * @param view The view to find a parent from.
     * @param text The text to show.  Can be formatted text.
     */
    public static void showS(@NonNull View view, @NonNull CharSequence text) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * 显示一个 Snackbar 显示时长{@link Snackbar#LENGTH_SHORT}
     *
     * @param view  The view to find a parent from.
     * @param resId The resource id of the string resource to use. Can be formatted text.
     */
    public static void showS(@NonNull View view, @StringRes int resId) {
        Snackbar.make(view, resId, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * 显示一个 Snackbar 显示时长{@link Snackbar#LENGTH_LONG}
     *
     * @param view The view to find a parent from.
     * @param text The text to show.  Can be formatted text.
     */
    public static void showL(@NonNull View view, @NonNull CharSequence text) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
    }

    /**
     * 显示一个 Snackbar 显示时长{@link Snackbar#LENGTH_LONG}
     *
     * @param view  The view to find a parent from.
     * @param resId The resource id of the string resource to use. Can be formatted text.
     */
    public static void showL(@NonNull View view, @StringRes int resId) {
        Snackbar.make(view, resId, Snackbar.LENGTH_LONG).show();
    }

    /**
     * 显示一个 Snackbar
     *
     * @param view     The view to find a parent from.
     * @param text     The text to show.  Can be formatted text.
     * @param duration How long to display the message.
     *                 Either {@link Snackbar#LENGTH_SHORT} or {@link Snackbar#LENGTH_LONG}
     */
    public static void show(@NonNull View view,
                            @NonNull CharSequence text,
                            @BaseTransientBottomBar.Duration int duration) {
        Snackbar.make(view, text, duration).show();
    }

    /**
     * 显示一个 Snackbar
     *
     * @param view     The view to find a parent from.
     * @param resId    The resource id of the string resource to use. Can be formatted text.
     * @param duration How long to display the message.
     *                 Either {@link Snackbar#LENGTH_SHORT} or {@link Snackbar#LENGTH_LONG}
     */
    public static void show(@NonNull View view,
                            @StringRes int resId,
                            @BaseTransientBottomBar.Duration int duration) {
        Snackbar.make(view, resId, duration).show();
    }

    /**
     * 显示一个 Snackbar 显示时长{@link Snackbar#LENGTH_SHORT}
     * <p>
     * 有回调事件
     *
     * @param view       The view to find a parent from.
     * @param text       The text to show.  Can be formatted text.
     * @param actionText Text to display for the action
     * @param listener   callback to be invoked when the action is clicked
     */
    public static void showS(@NonNull View view,
                             @NonNull CharSequence text,
                             @NonNull CharSequence actionText,
                             @NonNull final View.OnClickListener listener) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).setAction(actionText, listener).show();
    }

    /**
     * 显示一个 Snackbar 显示时长{@link Snackbar#LENGTH_SHORT}
     * <p>
     * 有回调事件
     *
     * @param view        The view to find a parent from.
     * @param resId       The resource id of the string resource to use. Can be formatted text.
     * @param actionResId String resource to display for the action
     * @param listener    callback to be invoked when the action is clicked
     */
    public static void showS(@NonNull View view,
                             @StringRes int resId,
                             @StringRes int actionResId,
                             @NonNull final View.OnClickListener listener) {
        Snackbar.make(view, resId, Snackbar.LENGTH_SHORT).setAction(actionResId, listener).show();
    }

    /**
     * 显示一个 Snackbar 显示时长{@link Snackbar#LENGTH_LONG}
     * <p>
     * 有回调事件
     *
     * @param view       The view to find a parent from.
     * @param text       The text to show.  Can be formatted text.
     * @param actionText Text to display for the action
     * @param listener   callback to be invoked when the action is clicked
     */
    public static void showL(@NonNull View view,
                             @NonNull CharSequence text,
                             @NonNull CharSequence actionText,
                             @NonNull final View.OnClickListener listener) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).setAction(actionText, listener).show();
    }

    /**
     * 显示一个 Snackbar 显示时长{@link Snackbar#LENGTH_LONG}
     * <p>
     * 有回调事件
     *
     * @param view        The view to find a parent from.
     * @param resId       The resource id of the string resource to use. Can be formatted text.
     * @param actionResId String resource to display for the action
     * @param listener    callback to be invoked when the action is clicked
     */
    public static void showL(@NonNull View view,
                             @StringRes int resId,
                             @StringRes int actionResId,
                             @NonNull final View.OnClickListener listener) {
        Snackbar.make(view, resId, Snackbar.LENGTH_LONG).setAction(actionResId, listener).show();
    }

    /**
     * 显示一个 Snackbar
     * <p>
     * 有回调事件
     *
     * @param view       The view to find a parent from.
     * @param text       The text to show.  Can be formatted text.
     * @param duration   How long to display the message.
     *                   Either {@link Snackbar#LENGTH_SHORT} or {@link Snackbar#LENGTH_LONG}
     * @param actionText Text to display for the action
     * @param listener   callback to be invoked when the action is clicked
     */
    public static void show(@NonNull View view,
                            @NonNull CharSequence text,
                            @BaseTransientBottomBar.Duration int duration,
                            @NonNull CharSequence actionText,
                            @NonNull final View.OnClickListener listener) {
        Snackbar.make(view, text, duration).setAction(actionText, listener).show();
    }

    /**
     * 显示一个 Snackbar
     * <p>
     * 有回调事件
     *
     * @param view        The view to find a parent from.
     * @param resId       The resource id of the string resource to use. Can be formatted text.
     * @param duration    How long to display the message.
     *                    Either {@link Snackbar#LENGTH_SHORT} or {@link Snackbar#LENGTH_LONG}
     * @param actionResId String resource to display for the action
     * @param listener    callback to be invoked when the action is clicked
     */
    public static void show(@NonNull View view,
                            @StringRes int resId,
                            @BaseTransientBottomBar.Duration int duration,
                            @StringRes int actionResId,
                            @NonNull final View.OnClickListener listener) {
        Snackbar.make(view, resId, duration).setAction(actionResId, listener).show();
    }

}
