package com.dqc.qlibrary;

import android.app.Application;

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

    /**
     * @param application Application
     * @param isDebug     isDebug
     * @param appName     APP名(英文)
     * @param showThreadInfo QLog 日志是否显示线程信息
     * @param methodOffset Qlog 日志 内部方法偏移量
     * @param logDepth    QLog 日志方法打印深度
     */
    public static void init(Application application, boolean isDebug, String appName,
                            boolean showThreadInfo, int methodOffset, int logDepth) {

        //侧滑返回注册
        application.registerActivityLifecycleCallbacks(ParallaxHelper.getInstance());

        //AndroidBootstrap Typeface 初始化
        TypefaceProvider.registerDefaultIconSets();

        //xUtil 初始化
        org.xutils.x.Ext.init(application);
        //xUtil debug
        org.xutils.x.Ext.setDebug(isDebug);

        //Log debug
        QLog.init(isDebug, showThreadInfo, methodOffset, appName, logDepth);

        //SPUtil 初始化
        SPUtils.init(appName);
    }

}