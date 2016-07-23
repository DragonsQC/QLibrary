package com.dqc.qlibrary.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

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
     * @param context context
     * @param s       字符串
     */
    public static void superToastAdvanced(Context context, String s) {
        SuperToast.cancelAllSuperToasts();
        new SuperToast(context.getApplicationContext())
                .setText(s)
                .setTextSize(Style.TEXTSIZE_SMALL)
                .setColor(defaultColor)
                .setFrame(defaultFrame)
                .setDuration(defaultDuration)
                .setAnimations(defaultAnimations)
                .show();
    }

    /**
     * SuperToast 显示在默认位置
     *
     * @param context  context
     * @param s        字符串
     * @param duration 时长(ToastUtil.Duration)，-1为默认值
     * @param color    Toast颜色(ToastUtil.Background)，-1为默认值
     */
    public static void superToastAdvanced(Context context, String s, int duration, int color) {
        if (duration == -1) {
            duration = defaultDuration;
        }
        if (color == -1) {
            color = defaultColor;
        }
        SuperToast.cancelAllSuperToasts();
        new SuperToast(context.getApplicationContext())
                .setText(s)
                .setTextSize(Style.TEXTSIZE_SMALL)
                .setColor(color)
                .setFrame(defaultFrame)
                .setDuration(duration)
                .setAnimations(defaultAnimations)
                .show();
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
        new SuperToast(context.getApplicationContext())
                .setText(context.getApplicationContext().getString(resId))
                .setTextSize(Style.TEXTSIZE_SMALL)
                .setColor(defaultColor)
                .setFrame(defaultFrame)
                .setDuration(defaultDuration)
                .setAnimations(defaultAnimations)
                .show();

    }

    /**
     * SuperToast 显示在默认位置
     *
     * @param context  context
     * @param resId    资源id
     * @param duration 时长(ToastUtil.Duration)，-1为默认值
     * @param color    Toast颜色(ToastUtil.Background)，-1为默认值
     */
    public static void superToastAdvanced(Context context, int resId, int duration, int color) {
        if (duration == -1) {
            duration = defaultDuration;
        }
        if (color == -1) {
            color = defaultColor;
        }
        new SuperToast(context.getApplicationContext())
                .setText(context.getApplicationContext().getString(resId))
                .setTextSize(Style.TEXTSIZE_SMALL)
                .setColor(color)
                .setFrame(defaultFrame)
                .setDuration(duration)
                .setAnimations(defaultAnimations)
                .show();

    }

    /**
     * SuperToast 显示在屏幕中间
     * 时长默认值(ToastUtil.Duration)，
     * Toast颜色默认值(ToastUtil.Background)
     *
     * @param context context
     * @param s       字符串
     */
    public static void superToastAdvanced4Center(Context context, String s) {
        SuperToast.cancelAllSuperToasts();
        new SuperToast(context.getApplicationContext())
                .setText(s)
                .setTextSize(Style.TEXTSIZE_SMALL)
                .setGravity(Gravity.CENTER, 0, 0)
                .setColor(defaultColor)
                .setFrame(defaultFrame)
                .setDuration(defaultDuration)
                .setAnimations(defaultAnimations)
                .show();
    }


    /**
     * SuperToast 显示在屏幕中间
     *
     * @param context    context
     * @param s          字符串
     * @param duration   时长(ToastUtil.Duration)，-1为默认值
     * @param background Toast颜色(ToastUtil.Background)，-1为默认值
     */
    public static void superToastAdvanced4Center(Context context, String s, int duration, int background) {
        if (duration == -1) {
            duration = defaultDuration;
        }
        if (background == -1) {
            background = defaultColor;
        }
        SuperToast.cancelAllSuperToasts();
        new SuperToast(context.getApplicationContext())
                .setText(s)
                .setTextSize(Style.TEXTSIZE_SMALL)
                .setGravity(Gravity.CENTER, 0, 0)
                .setColor(background)
                .setFrame(defaultFrame)
                .setDuration(duration)
                .setAnimations(defaultAnimations)
                .show();
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
        new SuperToast(context.getApplicationContext())
                .setText(context.getApplicationContext().getString(resId))
                .setTextSize(Style.TEXTSIZE_SMALL)
                .setGravity(Gravity.CENTER, 0, 0)
                .setColor(defaultColor)
                .setFrame(defaultFrame)
                .setDuration(defaultDuration)
                .setAnimations(defaultAnimations)
                .show();
    }

    /**
     * SuperToast 显示在屏幕中间
     *
     * @param context  context
     * @param resId    资源id
     * @param duration 时长(ToastUtil.Duration)，-1为默认值
     * @param color    Toast颜色(ToastUtil.Background)，-1为默认值
     */
    public static void superToastAdvanced4Center(Context context, int resId, int duration, int color) {
        if (duration == -1) {
            duration = defaultDuration;
        }
        if (color == -1) {
            color = defaultColor;
        }
        SuperToast.cancelAllSuperToasts();
        new SuperToast(context.getApplicationContext())
                .setText(context.getApplicationContext().getString(resId))
                .setTextSize(Style.TEXTSIZE_SMALL)
                .setGravity(Gravity.CENTER, 0, 0)
                .setColor(color)
                .setFrame(defaultFrame)
                .setDuration(duration)
                .setAnimations(defaultAnimations)
                .show();
    }

    private static int defaultAnimations = Animations.SCALE;   //所有SuperToast的默认动画效果
    private static int defaultDuration   = Duration.SHORT;    //默认持续时间
    private static int defaultColor      = Background.BLUE; //默认背景颜色
    private static int defaultFrame      = Frame.STANDARD;   //默认样式

    /**
     * 初始化SuperToast 设置Animations，Duration，Background
     */
    public static void initSuperToast(int frame, int animations, int duration, int background) {
        ToastUtil.defaultFrame = frame;
        ToastUtil.defaultAnimations = animations;
        ToastUtil.defaultDuration = duration;
        ToastUtil.defaultColor = background;
    }

    /**
     * SuperToast 动画
     */
    public static class Animations {
        public static final int FADE  = Style.ANIMATIONS_FADE;    //淡出
        public static final int FLY   = Style.ANIMATIONS_FLY;  //从右飞入
        public static final int SCALE = Style.ANIMATIONS_SCALE;  //缩放
        public static final int POP   = Style.ANIMATIONS_POP;  //从下往上

    }

    /**
     * SuperToast 显示时长
     */
    public static class Duration {
        public static final int VERY_SHORT = Style.DURATION_VERY_SHORT;
        public static final int SHORT      = Style.DURATION_SHORT;
        public static final int MEDIUM     = Style.DURATION_MEDIUM;
        public static final int LONG       = Style.DURATION_LONG;
        public static final int VERY_LONG  = Style.DURATION_VERY_LONG;
    }

    /**
     * SuperToast 背景颜色
     */
    public static class Background {
        public static final int RED         = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_RED);
        public static final int PINK        = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_PINK);
        public static final int PURPLE      = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_PURPLE);
        public static final int DEEP_PURPLE = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_DEEP_PURPLE);
        public static final int INDIGO      = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_INDIGO);
        public static final int BLUE        = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_BLUE);
        public static final int LIGHT_BLUE  = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_LIGHT_BLUE);
        public static final int CYAN        = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_CYAN);
        public static final int TEAL        = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_TEAL);
        public static final int GREEN       = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_GREEN);
        public static final int LIGHT_GREEN = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_LIGHT_GREEN);
        public static final int LIME        = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_LIME);
        public static final int YELLOW      = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_YELLOW);
        public static final int AMBER       = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_AMBER);
        public static final int ORANGE      = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_ORANGE);
        public static final int DEEP_ORANGE = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_DEEP_ORANGE);
        public static final int BROWN       = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_BROWN);
        public static final int GREY        = PaletteUtils.getSolidColor(PaletteUtils.GREY);
        public static final int BLUE_GREY   = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_BLUE_GREY);
    }

    /**
     * SuperToast 样式
     */
    public static class Frame {
        public static final int STANDARD = Style.TYPE_STANDARD;
        public static final int KITKAT   = Style.FRAME_KITKAT;
        public static final int LOLLIPOP = Style.FRAME_LOLLIPOP;
    }
}