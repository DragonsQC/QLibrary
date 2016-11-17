package com.dqc.qlibrary.utils;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

/**
 * Android 日志工具类
 * <p/>
 * require xLog [https://github.com/elvishew/xLog]
 * <p/>
 * 基于xLog，使用前请初始化，QLog.init。
 * 若需要替换原来已使用的原生Log包名替换为换为com.dqc.qlibrary.utils.QLog.Log
 *
 * @author DragonsQC
 */
public class QLog {

    /**
     * 默认打印调用栈信息为2，若需要修改请调用3个参数的初始化方法
     *
     * @param allowLog 是否允许输出日志
     * @param tag      日志tag
     */
    public static void init(boolean allowLog, String tag) {
        XLog.init(allowLog ? LogLevel.ALL : LogLevel.NONE,
                new LogConfiguration.Builder()
                        .tag(tag)   // 指定 TAG，默认为 "X-LOG"
                        .b()        // 允许打印日志边框，默认禁止
                        .st(2)      // 允许打印深度为2的调用栈信息，默认禁止
                        .build());
    }

    /**
     * @param allowLog 是否允许输出日志
     * @param tag      日志tag
     * @param depth    栈信息深度
     */
    public static void init(boolean allowLog, String tag, int depth) {
        XLog.init(allowLog ? LogLevel.ALL : LogLevel.NONE,
                new LogConfiguration.Builder()
                        .tag(tag)   // 指定 TAG，默认为 "X-LOG"
                        .b()        // 允许打印日志边框，默认禁止
                        .st(depth)
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

    /**
     * 兼容性方法，可以直接将原生Log的包名替换为com.dqc.qlibrary.utils.QLog.Log
     */
    public static class Log {
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

}