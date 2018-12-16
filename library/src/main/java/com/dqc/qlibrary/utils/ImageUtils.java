package com.dqc.qlibrary.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import androidx.annotation.ColorInt;

/**
 * 图片相关工具类
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused,SameParameterValue")
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
        if (recycle && !src.isRecycled()) {
            src.recycle();
        }
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
        if (recycle && !src.isRecycled()) {
            src.recycle();
        }
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
        return addRoundBorder(bitmap, color);
    }

    /**
     * 添加 圆形  边框
     *
     * @param bitmap Bitmap
     * @param color  {@link Color}
     * @return .
     */
    public static Bitmap addRoundBorder(final Bitmap bitmap, @ColorInt final int color) {
        int    size    = bitmap.getWidth() < bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight();
        int    num     = 14;
        int    sizebig = size + num;
        Bitmap output  = Bitmap.createBitmap(sizebig, sizebig, Bitmap.Config.ARGB_8888);
        Canvas canvas  = new Canvas(output);

        final Paint paint   = new Paint();
        final float roundPx = sizebig / 2;

        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawBitmap(bitmap, num / 2, num / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));

        //RadialGradient gradient = new RadialGradient(roundPx, roundPx, roundPx,
        //        new int[]{Color.WHITE, Color.WHITE, Color.parseColor("#AAAAAAAA")},
        //        new float[]{0.f, 0.97f, 1.0f}, Shader.TileMode.CLAMP);
        RadialGradient gradient = new RadialGradient(roundPx, roundPx, roundPx,
                Color.WHITE, color, Shader.TileMode.CLAMP);
        paint.setShader(gradient);
        canvas.drawCircle(roundPx, roundPx, roundPx, paint);

        return output;
    }

    /**
     * 添加颜色边框（方形）
     *
     * @param src         源图片
     * @param borderWidth 边框宽度
     * @param color       边框的颜色值 {@link Color}
     * @return 带颜色边框图
     */
    public static Bitmap addBorder(final Bitmap src, final int borderWidth, @ColorInt final int color) {
        return addBorder(src, borderWidth, color, false);
    }

    /**
     * 添加颜色边框（方形）
     *
     * @param src         源图片
     * @param borderWidth 边框宽度
     * @param color       边框的颜色值 {@link Color}
     * @param recycle     是否回收
     * @return 带颜色边框图
     */
    public static Bitmap addBorder(final Bitmap src, final int borderWidth, @ColorInt final int color,
                                   final boolean recycle) {
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
        if (recycle && !src.isRecycled()) {
            src.recycle();
        }
        return ret;
    }

    /**
     * 保存图片
     *
     * @param src     源图片
     * @param file    要保存到的文件
     * @param format  格式
     * @param quality 压缩率0-100，100:不压缩
     * @param recycle 是否回收
     * @return {@code true}: 成功<br>{@code false}: 失败
     */
    public static boolean save(final Bitmap src,
                               final File file,
                               final Bitmap.CompressFormat format,
                               final int quality,
                               final boolean recycle) {
        if (src == null || file == null) {
            return false;
        }
        if (!file.getParentFile().exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.getParentFile().mkdirs();
        }
        OutputStream os  = null;
        boolean      ret = false;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            ret = src.compress(format, quality, os);
            if (recycle && !src.isRecycled()) {
                src.recycle();
            }
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
