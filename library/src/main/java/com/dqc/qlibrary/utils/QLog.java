package com.dqc.qlibrary.utils;

import com.apkfuns.logutils.LogUtils;
import com.dqc.qlibrary.BuildConfig;

/**
 * Android 日志工具类
 *
 * @author DragonsQC
 */
public class QLog {

    public static void init(boolean configAllowLog,String configTagPrefix) {
        LogUtils.getLogConfig()
                .configAllowLog(configAllowLog)
                .configTagPrefix(configTagPrefix)
                .configShowBorders(true);
    }

    /**
     * 日志工具
     * <p/>
     * verbose 信息
     *
     * @param o
     */
    public static void v(Object o) {
        if (BuildConfig.DEBUG) {
            LogUtils.v(o);
        }
    }

    /**
     * 日志工具
     * <p/>
     * debug 调试信息
     *
     * @param o
     */
    public static void d(Object o) {
        if (BuildConfig.DEBUG) {
            LogUtils.d(o);
        }
    }

    /**
     * 日志工具
     * <p/>
     * info 普通信息
     *
     * @param o
     */
    public static void i(Object o) {
        if (BuildConfig.DEBUG) {
            LogUtils.i(o);
        }
    }

    /**
     * 日志工具
     * <p/>
     * warning 警告信息
     *
     * @param o
     */
    public static void w(Object o) {
        if (BuildConfig.DEBUG) {
            LogUtils.w(o);
        }
    }

    /**
     * 日志工具
     * <p/>
     * error 错误信息
     *
     * @param o
     */
    public static void e(Object o) {
        if (BuildConfig.DEBUG) {
            LogUtils.e(o);
        }
    }

    /**
     * 日志工具
     * <p/>
     * json格式字符串
     *
     * @param json
     */
    public static void json(String json) {
        if (BuildConfig.DEBUG) {
            LogUtils.json(json);
        }
    }

}