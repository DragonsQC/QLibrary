package com.dqc.qlibrary.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.SuperToast;

/**
 * Android Toast 工具类
 * <p/>
 * require https://github.com/JohnPersano/SuperToasts <br/>
 *
 * @author DragonsQC
 */
public class ToastUtil {

    /**
     * 系统 Toast 默认显示位置
     *
     * @param context      context
     * @param charSequence 字符串
     * @param duration     时长
     */
    public static void showDefault(Context context, CharSequence charSequence, int duration) {
        Toast.makeText(context.getApplicationContext(), charSequence, duration).show();
    }

    /**
     * 系统 Toast 默认显示位置
     *
     * @param context  context
     * @param rseId    资源id
     * @param duration 时长
     */
    public static void showDefault(Context context, int rseId, int duration) {
        Toast.makeText(context.getApplicationContext(), rseId, duration).show();
    }

    /**
     * 系统 Toast 显示在屏幕中间
     *
     * @param context      context
     * @param charSequence 字符串
     * @param duration     时长
     */
    public static void showCenter(Context context, CharSequence charSequence, int duration) {
        Toast toast = Toast.makeText(context.getApplicationContext(), charSequence, duration);
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
    public static void showCenter(Context context, int rseId, int duration) {
        Toast toast = Toast.makeText(context.getApplicationContext(), rseId, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * SuperToast 显示在默认位置，
     * 时长默认值(ToastUtil.Duration)，
     * Toast颜色默认值(ToastUtil.Background)
     *
     * @param context      context
     * @param charSequence 字符串
     */
    public static void superToastAdvanced(Context context, CharSequence charSequence) {
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(context.getApplicationContext());
        superToast.setDuration(defaultDuration);
        superToast.setText(charSequence);
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setAnimations(defaultAnimations);
        superToast.setBackground(defaultBackground);
        superToast.show();
    }

    /**
     * SuperToast 显示在默认位置
     *
     * @param context      context
     * @param charSequence 字符串
     * @param duration     时长(ToastUtil.Duration)，-1为默认值
     * @param background   Toast颜色(ToastUtil.Background)，-1为默认值
     */
    public static void superToastAdvanced(Context context, CharSequence charSequence, int duration, int background) {
        if (duration == -1) {
            duration = defaultDuration;
        }
        if (background == -1) {
            background = defaultBackground;
        }
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(context.getApplicationContext());
        superToast.setDuration(duration);
        superToast.setText(charSequence);
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setAnimations(defaultAnimations);
        superToast.setBackground(background);
        superToast.show();
    }

    /**
     * SuperToast 显示在默认位置
     * 时长默认值(ToastUtil.Duration)，
     * Toast颜色默认值(ToastUtil.Background)
     *
     * @param context context
     * @param resId   资源id
     */
    public static void superToastAdvanced(Context context, int resId) {
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(context.getApplicationContext());
        superToast.setDuration(defaultDuration);
        superToast.setText(context.getString(resId));
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setAnimations(defaultAnimations);
        superToast.setBackground(defaultBackground);
        superToast.show();

    }

    /**
     * SuperToast 显示在默认位置
     *
     * @param context    context
     * @param resId      资源id
     * @param duration   时长(ToastUtil.Duration)，-1为默认值
     * @param background Toast颜色(ToastUtil.Background)，-1为默认值
     */
    public static void superToastAdvanced(Context context, int resId, int duration, int background) {
        if (duration == -1) {
            duration = defaultDuration;
        }
        if (background == -1) {
            background = defaultBackground;
        }
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(context.getApplicationContext());
        superToast.setDuration(duration);
        superToast.setText(context.getString(resId));
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setAnimations(defaultAnimations);
        superToast.setBackground(background);
        superToast.show();

    }

    /**
     * SuperToast 显示在屏幕中间
     * 时长默认值(ToastUtil.Duration)，
     * Toast颜色默认值(ToastUtil.Background)
     *
     * @param context      context
     * @param charSequence 字符串
     */
    public static void superToastAdvanced4Center(Context context, CharSequence charSequence) {
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(context.getApplicationContext());
        superToast.setDuration(defaultDuration);
        superToast.setText(charSequence);
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setAnimations(defaultAnimations);
        superToast.setBackground(defaultBackground);
        superToast.setGravity(Gravity.CENTER, 0, 0);
        superToast.show();
    }


    /**
     * SuperToast 显示在屏幕中间
     *
     * @param context      context
     * @param charSequence 字符串
     * @param duration     时长(ToastUtil.Duration)，-1为默认值
     * @param background   Toast颜色(ToastUtil.Background)，-1为默认值
     */
    public static void superToastAdvanced4Center(Context context, CharSequence charSequence, int duration, int background) {
        if (duration == -1) {
            duration = defaultDuration;
        }
        if (background == -1) {
            background = defaultBackground;
        }
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(context.getApplicationContext());
        superToast.setDuration(duration);
        superToast.setText(charSequence);
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setAnimations(defaultAnimations);
        superToast.setBackground(background);
        superToast.setGravity(Gravity.CENTER, 0, 0);
        superToast.show();
    }

    /**
     * SuperToast 显示在屏幕中间
     * 时长默认值(ToastUtil.Duration)，
     * Toast颜色默认值(ToastUtil.Background)
     *
     * @param context context
     * @param resId   资源id
     */
    public static void superToastAdvanced4Center(Context context, int resId) {
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(context.getApplicationContext());
        superToast.setDuration(defaultDuration);
        superToast.setText(context.getApplicationContext().getResources().getString(resId));
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setAnimations(defaultAnimations);
        superToast.setBackground(defaultBackground);
        superToast.setGravity(Gravity.CENTER, 0, 0);
        superToast.show();
    }

    /**
     * SuperToast 显示在屏幕中间
     *
     * @param context    context
     * @param resId      资源id
     * @param duration   时长(ToastUtil.Duration)，-1为默认值
     * @param background Toast颜色(ToastUtil.Background)，-1为默认值
     */
    public static void superToastAdvanced4Center(Context context, int resId, int duration, int background) {
        if (duration == -1) {
            duration = defaultDuration;
        }
        if (background == -1) {
            background = defaultBackground;
        }
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(context.getApplicationContext());
        superToast.setDuration(duration);
        superToast.setText(context.getApplicationContext().getResources().getString(resId));
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setAnimations(defaultAnimations);
        superToast.setBackground(background);
        superToast.setGravity(Gravity.CENTER, 0, 0);
        superToast.show();
    }

    private static SuperToast.Animations defaultAnimations = SuperToast.Animations.SCALE;   //所有SuperToast的默认动画效果
    private static int                   defaultDuration   = 2000;
    private static int                   defaultBackground = SuperToast.Background.BLUE; //默认背景颜色

    /**
     * 初始化SuperToast 设置Animations，Duration，Background
     */
    public static void initSuperToast(SuperToast.Animations animations, int duration, int background) {
        defaultAnimations = animations;
        defaultDuration = duration;
        defaultBackground = background;
    }

    /**
     * SuperToast 动画
     */
    public static class Animations {
        public static final SuperToast.Animations FADE  = SuperToast.Animations.FADE;    //淡出
        public static final SuperToast.Animations FLYIN = SuperToast.Animations.FLYIN;  //从右飞入
        public static final SuperToast.Animations SCALE = SuperToast.Animations.SCALE;  //缩放
        public static final SuperToast.Animations POPUP = SuperToast.Animations.POPUP;  //从下往上

        public static SuperToast.Animations randomAnimations() {
            SuperToast.Animations anim;
            int                   i = QUtils.MathUtil.random(1, 4);
            switch (i) {
                case 1:
                    anim = SuperToast.Animations.FADE;
                    break;
                case 2:
                    anim = SuperToast.Animations.FLYIN;
                    break;
                case 3:
                    anim = SuperToast.Animations.SCALE;
                    break;
                case 4:
                    anim = SuperToast.Animations.POPUP;
                    break;
                default:
                    anim = SuperToast.Animations.FLYIN;
                    break;
            }
            return anim;
        }

    }

    /**
     * SuperToast 显示时长
     */
    public static class Duration {
        public static final int VERY_SHORT = 1500;
        public static final int SHORT      = 2000;
        public static final int MEDIUM     = 2750;
        public static final int LONG       = 3500;
        public static final int EXTRA_LONG = 4500;
    }

    /**
     * SuperToast 背景颜色
     */
    public static class Background {
        public static final int BLACK  = SuperToast.Background.BLACK;
        public static final int BLUE   = SuperToast.Background.BLUE;
        public static final int GRAY   = SuperToast.Background.GRAY;
        public static final int GREEN  = SuperToast.Background.GREEN;
        public static final int ORANGE = SuperToast.Background.ORANGE;
        public static final int PURPLE = SuperToast.Background.PURPLE;
        public static final int RED    = SuperToast.Background.RED;
        public static final int WHITE  = SuperToast.Background.WHITE;
    }
}