package com.dqc.qlibrary.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.DisplayMetrics;

import com.dqc.qlibrary.QLibrary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Android 资源相关工具类
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused")
public class ResourceUtils {
    private static DisplayMetrics sDisplayMetrics;

    /**
     * 获取 Assets 下的图片资源
     *
     * @param fileName 文件路径
     * @return .
     */
    public static Drawable getDrawable4Assets(String fileName) {
        Drawable drawable = null;
        try {
            InputStream is = QLibrary.getInstance().getContext().getAssets().open(fileName);
            drawable = Drawable.createFromStream(is, null);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drawable;
    }

    /**
     * 获取 Assets 下的图片资源
     *
     * @param fileName String
     * @return .
     */
    public static Bitmap getBitmap4Assets(String fileName) {

        Bitmap                bitmap = null;
        BitmapFactory.Options opt    = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            InputStream is = QLibrary.getInstance().getContext().getAssets().open(fileName);
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
     * @param resId 资源ID
     * @return .
     */
    public static Bitmap getBitmap4Res(int resId) {

        Bitmap                bitmap = null;
        BitmapFactory.Options opt    = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            InputStream is = QLibrary.getInstance().getContext().getResources().openRawResource(resId);
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
     * @param sourcePath       源文件路径
     * @param targetPathString 目标路径
     */
    public static void copyAssetsFile(String sourcePath, String targetPathString) {
        InputStream  inputStream;
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(targetPathString);
            inputStream = QLibrary.getInstance().getContext().getAssets().open(sourcePath);
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
     * @param uri Uri
     * @return .
     */
    public static Bitmap getBitmap4Uri(Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(QLibrary.getInstance().getContext().getContentResolver(), uri);
        } catch (Exception e) {
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
     */
    private static synchronized void initDisplayMetrics() {
        sDisplayMetrics = QLibrary.getInstance().getContext().getResources().getDisplayMetrics();
    }

    /**
     * get screen width
     *
     * @return .
     */
    public static int getDisplayWidth() {
        initDisplayMetrics();
        return sDisplayMetrics.widthPixels;
    }

    /**
     * get screen height
     *
     * @return .
     */
    public static int getDisplayHeight() {
        initDisplayMetrics();
        return sDisplayMetrics.heightPixels;
    }

    /**
     * get screen density
     *
     * @return .
     */
    public static float getDensity() {
        initDisplayMetrics();
        return sDisplayMetrics.density;
    }

}