package com.dqc.qlibrary;

import android.app.Application;
import android.content.Context;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.dqc.qlibrary.utils.QLog;
import com.dqc.qlibrary.utils.SPUtils;
import com.github.anzewei.parallaxbacklayout.ParallaxHelper;

/**
 * QLibrary 初始化
 *
 * @author DragonsQC
 */

@SuppressWarnings("unused")
public class QLibrary {

    private static QLibrary sInstance;

    public static QLibrary getInstance() {
        if (sInstance == null) {
            sInstance = new QLibrary();
        }
        return sInstance;
    }

    private Context mContext = null;

    public Context getContext() {
        if (mContext == null) {
            QLog.e("请调用 QLibrary.getInstance().init() 初始化");
        }
        return mContext;
    }

    /**
     * @param application Application
     * @param isDebug     isDebug
     * @param appName     APP名(英文)
     * @param logDepth    QLog 日志方法打印深度
     */
    public void init(Application application, boolean isDebug, String appName, int logDepth) {

        mContext = application.getApplicationContext();

        //侧滑返回注册
        application.registerActivityLifecycleCallbacks(ParallaxHelper.getInstance());

        //AndroidBootstrap Typeface 初始化
        TypefaceProvider.registerDefaultIconSets();

        //xUtil 初始化
        org.xutils.x.Ext.init(application);
        //xUtil debug
        org.xutils.x.Ext.setDebug(isDebug);

        //Log debug
        QLog.init(isDebug, appName, logDepth);

        //SPUtil 初始化
        SPUtils.init(appName);
    }

}