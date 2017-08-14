package com.dqc.qlibrary.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.ColorInt;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 图片相关工具类
 */

public class ImageUtils {

    /**
     * 转为圆形图片
     *
     * @param src 源图片
     * @return 圆形图片
     */
    public static Bitmap toRound(final Bitmap src) {
        return toRound(src, false);
    }

    /**
     * 转为圆形图片
     *
     * @param src     源图片
     * @param recycle 是否回收
     * @return 圆形图片
     */
    public static Bitmap toRound(final Bitmap src, final boolean recycle) {
        int    width  = src.getWidth();
        int    height = src.getHeight();
        int    radius = Math.min(width, height) >> 1;
        Bitmap ret    = Bitmap.createBitmap(width, height, src.getConfig());
        Paint  paint  = new Paint();
        Canvas canvas = new Canvas(ret);
        Rect   rect   = new Rect(0, 0, width, height);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(width >> 1, height >> 1, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(src, rect, rect, paint);
        if (recycle && !src.isRecycled()) src.recycle();
        return ret;
    }

    /**
     * 转为圆角图片
     *
     * @param src    源图片
     * @param radius 圆角的度数
     * @return 圆角图片
     */
    public static Bitmap toRoundCorner(final Bitmap src, final float radius) {
        return toRoundCorner(src, radius, false);
    }

    /**
     * 转为圆角图片
     *
     * @param src     源图片
     * @param radius  圆角的度数
     * @param recycle 是否回收
     * @return 圆角图片
     */
    public static Bitmap toRoundCorner(final Bitmap src, final float radius, final boolean recycle) {
        int    width  = src.getWidth();
        int    height = src.getHeight();
        Bitmap ret    = Bitmap.createBitmap(width, height, src.getConfig());
        Paint  paint  = new Paint();
        Canvas canvas = new Canvas(ret);
        Rect   rect   = new Rect(0, 0, width, height);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(new RectF(rect), radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(src, rect, rect, paint);
        if (recycle && !src.isRecycled()) src.recycle();
        return ret;
    }

    /**
     * 创建 圆形图片 并添加 自定义颜色边框
     *
     * @param bitmap Bitmap
     * @param color  {@link Color}
     */
    public static Bitmap toRoundAndBorder(Bitmap bitmap, final int borderWidth, @ColorInt int color) {
        bitmap = toRound(bitmap);
        return addRoundeBorder(bitmap, borderWidth, color);
    }


    /**
     * 添加颜色边框
     *
     * @param src         源图片
     * @param borderWidth 边框宽度
     * @param color       边框的颜色值
     * @return 带颜色边框图
     */
    public static Bitmap addRoundeBorder(final Bitmap src, final int borderWidth, @ColorInt final int color) {
        return addRoundeBorder(src, borderWidth, color, false);
    }

    /**
     * 添加颜色边框
     *
     * @param src         源图片
     * @param borderWidth 边框宽度
     * @param color       边框的颜色值
     * @param recycle     是否回收
     * @return 带颜色边框图
     */
    public static Bitmap addRoundeBorder(final Bitmap src, final int borderWidth, @ColorInt  final int color, final boolean recycle) {
        int    doubleBorder = borderWidth << 1;
        int    newWidth     = src.getWidth() + doubleBorder;
        int    newHeight    = src.getHeight() + doubleBorder;
        Bitmap ret          = Bitmap.createBitmap(newWidth, newHeight, src.getConfig());
        Canvas canvas       = new Canvas(ret);
        //noinspection SuspiciousNameCombination
        canvas.drawBitmap(src, borderWidth, borderWidth, null);
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        // setStrokeWidth是居中画的，所以要两倍的宽度才能画，否则有一半的宽度是空的
        paint.setStrokeWidth(doubleBorder);
        Rect rect = new Rect(0, 0, newWidth, newHeight);
        canvas.drawRect(rect, paint);
        if (recycle && !src.isRecycled()) src.recycle();
        return ret;
    }


    /**
     * 保存图片
     *
     * @param src    源图片
     * @param file   要保存到的文件
     * @param format 格式
     * @return {@code true}: 成功<br>{@code false}: 失败
     */
    public static boolean save(final Bitmap src, final File file, final Bitmap.CompressFormat format) {
        return save(src, file, format, false);
    }

    /**
     * 保存图片
     *
     * @param src     源图片
     * @param file    要保存到的文件
     * @param format  格式
     * @param recycle 是否回收
     * @return {@code true}: 成功<br>{@code false}: 失败
     */
    public static boolean save(final Bitmap src, final File file, final Bitmap.CompressFormat format, final boolean recycle) {
        if (src == null || file == null) {
            return false;
        }
        System.out.println(src.getWidth() + ", " + src.getHeight());
        OutputStream os  = null;
        boolean      ret = false;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            ret = src.compress(format, 100, os);
            if (recycle && !src.isRecycled()) src.recycle();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
}
