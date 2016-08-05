package com.dqc.qlibrary.utils;

import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Android 日志工具类
 * <p/>
 * require https://github.com/orhanobut/logger
 * <p/>
 *
 * @author DragonsQC
 */
public class QLog {

    public static void init(String tag) {
        Logger
                .init(tag);
    }

    /**
     * verbose 信息
     *
     * @param msg
     */
    public static void v(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.v(msg);
        }
    }

    /**
     * debug 调试信息
     *
     * @param o
     */
    public static void d(Object o) {
        if (BuildConfig.DEBUG) {
            Logger.d(o);
        }
    }

    /**
     * info 普通信息
     *
     * @param msg
     */
    public static void i(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.i(msg);
        }
    }

    /**
     * warning 警告信息
     *
     * @param msg
     */
    public static void w(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.w(msg);
        }
    }

    /**
     * error 错误信息
     *
     * @param msg
     */
    public static void e(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.e(msg);
        }
    }

    /**
     * error 错误信息
     *
     * @param msg
     */
    public static void e(Throwable throwable, String msg) {
        if (BuildConfig.DEBUG) {
            Logger.e(throwable, msg);
        }
    }

    /**
     * wtf
     *
     * @param msg
     */
    public static void wtf(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.wtf(msg);
        }
    }


    /**
     * json 格式字符串
     *
     * @param json
     */
    public static void json(String json) {
        if (BuildConfig.DEBUG) {
            Logger.json(json);
        }
    }

    /**
     * xml 格式
     *
     * @param xml
     */
    public static void xml(String xml) {
        if (BuildConfig.DEBUG) {
            Logger.xml(xml);
        }
    }

}