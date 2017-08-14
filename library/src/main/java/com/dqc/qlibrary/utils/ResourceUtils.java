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
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.ColorInt;
import android.util.DisplayMetrics;
import android.util.Log;

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
     * @param src 源图片
     * @return 圆形图片
     */
    public static Bitmap toRound(final Bitmap src, @ColorInt final int color) {
        return toRound(src, color, false);
    }

    /**
     * 转为圆形图片
     *
     * @param src     源图片
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
        //canvas.drawARGB(0, 0, 0, 0);
        canvas.drawColor(color);
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
     * 创建 圆形图片 自定义边框颜色
     *
     * @param bitmap Bitmap
     * @param color  {@link Color}
     */
    public static Bitmap toRoundAndBorder(Bitmap bitmap, @ColorInt int color) {
        bitmap = toRound(bitmap, color);
        return addRoundeBorder(bitmap, color);
    }


    /**
     * 给 圆形图 添加 边框
     *
     * @param bitmap Bitmap
     * @param color  {@link Color}
     * @return
     */
    public static Bitmap addRoundeBorder(Bitmap bitmap, @ColorInt int color) {
        int    size    = bitmap.getWidth() < bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight();
        int    num     = 14;
        int    sizebig = size + num;
        Bitmap output  = Bitmap.createBitmap(sizebig, sizebig, Bitmap.Config.ARGB_8888);
        Canvas canvas  = new Canvas(output);

        final Paint paint   = new Paint();
        final float roundPx = sizebig / 2;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawBitmap(bitmap, num / 2, num / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));

        RadialGradient gradient = new RadialGradient(roundPx, roundPx, roundPx,
                new int[]{Color.WHITE, Color.WHITE, Color.parseColor("#AAAAAAAA")},
                new float[]{0.f, 0.97f, 1.0f}, Shader.TileMode.CLAMP);
        paint.setShader(gradient);
        canvas.drawCircle(roundPx, roundPx, roundPx, paint);

        return output;
    }

    /**
     * 保存 bitmap 到指定路径，保存格式为png
     *
     * @param bitmap
     * @param file   保存的文件，若存在则删除后保存；请传入后缀为“.png”的文件
     */
    public static void saveBitmap4PNG(Bitmap bitmap, File file) {
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            if (bitmap.compress(Bitmap.CompressFormat.PNG, 90, out)) {
                out.flush();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}