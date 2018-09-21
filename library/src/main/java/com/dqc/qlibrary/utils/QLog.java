package com.dqc.qlibrary.utils;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Android 日志工具类
 * <p/>
 * require logger [https://github.com/orhanobut/logger]
 * <p/>
 * 基于 logger，使用前请初始化，QLog.init。
 * 若需要替换原来已使用的原生Log包名替换为换为com.dqc.qlibrary.utils.QLog.Log
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused")
public class QLog {

    /**
     * @param allowLog       是否允许输出日志
     * @param showThreadInfo 是否显示线程信息
     * @param methodOffset   内部方法偏移量
     * @param tag            日志tag
     * @param depth          栈信息深度
     */
    public static void init(boolean allowLog,
                            boolean showThreadInfo,
                            int methodOffset,
                            String tag,
                            int depth) {

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(showThreadInfo)
                .methodCount(depth)
                .methodOffset(methodOffset)
                .tag(tag)
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    /**
     * verbose 信息
     *
     * @param s message
     */
    public static void v(String s) {
        Logger.v(s);
    }

    /**
     * debug 调试信息
     *
     * @param s message
     */
    public static void d(String s) {
        Logger.d(s);
    }

    /**
     * debug 调试信息
     *
     * @param o Object
     */
    public static void d(Object o) {
        Logger.d(o);
    }

    /**
     * info 普通信息
     *
     * @param s message
     */
    public static void i(String s) {
        Logger.i(s);
    }

    /**
     * warning 警告信息
     *
     * @param s message
     */
    public static void w(String s) {
        Logger.w(s);
    }

    /**
     * error 错误信息
     *
     * @param s message
     */
    public static void e(String s) {
        Logger.e(s);
    }


    /**
     * json 格式字符串
     *
     * @param json String
     */
    public static void json(String json) {
        Logger.json(json);
    }

    /**
     * xml 格式
     *
     * @param xml String
     */
    public static void xml(String xml) {
        Logger.xml(xml);
    }

    /**
     * 兼容性方法，可以直接将原生Log的包名替换为com.dqc.qlibrary.utils.QLog.Log
     */
    public static class Log {
        /**
         * verbose 信息
         *
         * @param s message
         */
        public static void v(String s) {
            Logger.v(s);
        }

        /**
         * debug 调试信息
         *
         * @param s message
         */
        public static void d(String s) {
            Logger.d(s);
        }

        /**
         * debug 调试信息
         *
         * @param o Object
         */
        public static void d(Object o) {
            Logger.d(o);
        }

        /**
         * info 普通信息
         *
         * @param s message
         */
        public static void i(String s) {
            Logger.i(s);
        }

        /**
         * warning 警告信息
         *
         * @param s message
         */
        public static void w(String s) {
            Logger.w(s);
        }

        /**
         * error 错误信息
         *
         * @param s message
         */
        public static void e(String s) {
            Logger.e(s);
        }


        /**
         * json 格式字符串
         *
         * @param json String
         */
        public static void json(String json) {
            Logger.json(json);
        }

        /**
         * xml 格式
         *
         * @param xml String
         */
        public static void xml(String xml) {
            Logger.xml(xml);
        }

    }

}