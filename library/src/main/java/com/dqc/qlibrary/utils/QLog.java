package com.dqc.qlibrary.utils;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

/**
 * Android 日志工具类
 * <p/>
 * require xLog [https://github.com/elvishew/xLog]
 * <p/>
 *
 * @author DragonsQC
 */
public class QLog {

    public static void init(boolean allowLog, String tag) {
        XLog.init(allowLog ? LogLevel.ALL : LogLevel.NONE,
                new LogConfiguration.Builder()
                        .tag(tag)   // 指定 TAG，默认为 "X-LOG"
                        .t()        // 允许打印线程信息，默认禁止
                        .b()        // 允许打印日志边框，默认禁止
                        .st(1)      // 允许打印深度为1的调用栈信息，默认禁止
                        .build());
    }

    /**
     * verbose 信息
     *
     * @param o Object
     */
    public static void v(Object o) {
        XLog.v(o);
    }

    /**
     * debug 调试信息
     *
     * @param o Object
     */
    public static void d(Object o) {
        XLog.d(o);
    }

    /**
     * info 普通信息
     *
     * @param o Object
     */
    public static void i(Object o) {
        XLog.i(o);
    }

    /**
     * warning 警告信息
     *
     * @param o Object
     */
    public static void w(Object o) {
        XLog.w(o);
    }

    /**
     * error 错误信息
     *
     * @param o Object
     */
    public static void e(Object o) {
        XLog.e(o);
    }


    /**
     * json 格式字符串
     *
     * @param json String
     */
    public static void json(String json) {
        XLog.json(json);
    }

    /**
     * xml 格式
     *
     * @param xml String
     */
    public static void xml(String xml) {
        XLog.xml(xml);
    }

}