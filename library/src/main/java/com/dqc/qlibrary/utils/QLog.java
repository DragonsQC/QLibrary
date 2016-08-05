package com.dqc.qlibrary.utils;

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
    private static boolean mAllowLog = true;

    public static void init(boolean allowLog, String tag) {
        mAllowLog = allowLog;
        Logger
                .init(tag);
    }

    /**
     * verbose 信息
     *
     * @param msg
     */
    public static void v(String msg) {
        if (mAllowLog) {
            Logger.v(msg);
        }
    }

    /**
     * debug 调试信息
     *
     * @param o
     */
    public static void d(Object o) {
        if (mAllowLog) {
            Logger.d(o);
        }
    }

    /**
     * info 普通信息
     *
     * @param msg
     */
    public static void i(String msg) {
        if (mAllowLog) {
            Logger.i(msg);
        }
    }

    /**
     * warning 警告信息
     *
     * @param msg
     */
    public static void w(String msg) {
        if (mAllowLog) {
            Logger.w(msg);
        }
    }

    /**
     * error 错误信息
     *
     * @param msg
     */
    public static void e(String msg) {
        if (mAllowLog) {
            Logger.e(msg);
        }
    }

    /**
     * error 错误信息
     *
     * @param msg
     */
    public static void e(Throwable throwable, String msg) {
        if (mAllowLog) {
            Logger.e(throwable, msg);
        }
    }

    /**
     * wtf
     *
     * @param msg
     */
    public static void wtf(String msg) {
        if (mAllowLog) {
            Logger.wtf(msg);
        }
    }


    /**
     * json 格式字符串
     *
     * @param json
     */
    public static void json(String json) {
        if (mAllowLog) {
            Logger.json(json);
        }
    }

    /**
     * xml 格式
     *
     * @param xml
     */
    public static void xml(String xml) {
        if (mAllowLog) {
            Logger.xml(xml);
        }
    }

}