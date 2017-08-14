package com.dqc.qlibrary.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.ColorInt;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Android 资源相关工具类
 */
public class ResourceUtils {
    private static DisplayMetrics sDisplayMetrics;

    /**
     * 获取Drawable下的图片资源
     *
     * @param context  Context
     * @param fileName String
     * @return
     */
    public static Drawable getAssets4Drawable(Context context, String fileName) {
        Drawable drawable = null;
        try {
            InputStream is = context.getApplicationContext().getAssets().open(fileName);
            drawable = Drawable.createFromStream(is, null);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drawable;
    }

    /**
     * 获取Assets下的图片资源
     *
     * @param context  Context
     * @param fileName String
     * @return
     */
    public static Bitmap getBitmap4Assets(Context context, String fileName) {

        Bitmap                bitmap = null;
        BitmapFactory.Options opt    = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        if (android.os.Build.VERSION.SDK_INT < 21) {
            opt.inPurgeable = true;
            opt.inInputShareable = true;
        }
        try {
            InputStream is = context.getApplicationContext().getAssets().open(fileName);
            bitmap = BitmapFactory.decodeStream(is, null, opt);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     * 获取Res下的图片资源
     *
     * @param context
     * @param resId
     * @return
     */
    public static Bitmap getBitmap4Res(Context context, int resId) {

        Bitmap                bitmap = null;
        BitmapFactory.Options opt    = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        if (android.os.Build.VERSION.SDK_INT < 21) {
            opt.inPurgeable = true;
            opt.inInputShareable = true;
        }
        try {
            InputStream is = context.getApplicationContext().getResources().openRawResource(resId);
            bitmap = BitmapFactory.decodeStream(is, null, opt);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     * copy assets 下的文件
     *
     * @param context
     * @param sourcePath
     * @param targetPathString
     */
    public static void copyAssetsFile(Context context, String sourcePath, String targetPathString) {
        InputStream  inputStream;
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(targetPathString);
            inputStream = context.getApplicationContext().getAssets().open(sourcePath);
            byte[] buffer = new byte[1024];
            int    length = inputStream.read(buffer);
            while (length > 0) {
                outputStream.write(buffer, 0, length);
                length = inputStream.read(buffer);
            }
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取对应Uri的图片资源
     *
     * @param context
     * @param uri
     * @return
     */
    public static Bitmap getBitmap4Uri(Context context, Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(context.getApplicationContext().getContentResolver(), uri);
        } catch (Exception e) {
            Log.e("[Android]", e.getMessage());
            Log.e("[Android]", "目录为：" + uri);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5F);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param spValue sp值
     * @return px值
     */
    public static int sp2px(float spValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param pxValue px值
     * @return sp值
     */
    public static int px2sp(float pxValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * init display metrics
     *
     * @param context
     */
    private static synchronized void initDisplayMetrics(Context context) {
        sDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    /**
     * get screen width
     *
     * @param context
     * @return
     */
    public static int getDisplayWidth(Context context) {
        initDisplayMetrics(context.getApplicationContext());
        return sDisplayMetrics.widthPixels;
    }

    /**
     * get screen height
     *
     * @param context
     * @return
     */
    public static int getDisplayHeight(Context context) {
        initDisplayMetrics(context.getApplicationContext());
        return sDisplayMetrics.heightPixels;
    }

    /**
     * get screen density
     *
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        initDisplayMetrics(context.getApplicationContext());
        return sDisplayMetrics.density;
    }


    /**
     * 转为圆形图片
     *
     * @param src   源图片
     * @param color 背景颜色
     * @return 圆形图片
     */
    public static Bitmap toRound(final Bitmap src, @ColorInt final int color) {
        return toRound(src, color, false);
    }

    /**
     * 转为圆形图片
     *
     * @param src     源图片
     * @param color   背景颜色
     * @param recycle 是否回收
     * @return 圆形图片
     */
    public static Bitmap toRound(final Bitmap src, @ColorInt final int color, final boolean recycle) {
        int    width  = src.getWidth();
        int    height = src.getHeight();
        int    radius = Math.min(width, height) >> 1;
        Bitmap ret    = Bitmap.createBitmap(width, height, src.getConfig());
        Paint  paint  = new Paint();
        Canvas canvas = new Canvas(ret);
        Rect   rect   = new Rect(0, 0, width, height);
        paint.setAntiAlias(true);
        paint.setColor(color);
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
        bitmap = toRound(bitmap, color);
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