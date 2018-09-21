package com.dqc.qlibrary.utils;

import com.apkfuns.logutils.LogUtils;

/**
 * Android 日志工具类
 * <p/>
 * require LogUtils [https://github.com/pengwei1024/LogUtils]
 * <p/>
 * 基于 LogUtils，使用前请初始化，QLog.init。
 * 若需要替换原来已使用的原生Log包名替换为换为com.dqc.qlibrary.utils.QLog.Log
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused")
public class QLog {

    /**
     * @param allowLog       是否允许输出日志
     * @param tag            日志tag
     * @param showBorders    是否显示边界线
     */
    public static void init(boolean allowLog, String tag, boolean showBorders) {

        LogUtils.getLogConfig()
                .configAllowLog(allowLog)
                .configTagPrefix(tag)
                .configShowBorders(showBorders);

    }

    /**
     * verbose 信息
     *
     * @param o Object
     */
    public static void v(Object o) {
        LogUtils.v(o);
    }

    /**
     * debug 调试信息
     *
     * @param o Object
     */
    public static void d(Object o) {
        LogUtils.d(o);
    }

    /**
     * info 普通信息
     *
     * @param o Object
     */
    public static void i(Object o) {
        LogUtils.i(o);
    }

    /**
     * warning 警告信息
     *
     * @param o Object
     */
    public static void w(Object o) {
        LogUtils.w(o);
    }

    /**
     * error 错误信息
     *
     * @param o Object
     */
    public static void e(Object o) {
        LogUtils.e(o);
    }


    /**
     * json 格式字符串
     *
     * @param json String
     */
    public static void json(String json) {
        LogUtils.json(json);
    }

    /**
     * xml 格式
     *
     * @param xml String
     */
    public static void xml(String xml) {
        LogUtils.xml(xml);
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
            LogUtils.v(o);
        }

        /**
         * debug 调试信息
         *
         * @param o Object
         */
        public static void d(Object o) {
            LogUtils.d(o);
        }

        /**
         * info 普通信息
         *
         * @param o Object
         */
        public static void i(Object o) {
            LogUtils.i(o);
        }

        /**
         * warning 警告信息
         *
         * @param o Object
         */
        public static void w(Object o) {
            LogUtils.w(o);
        }

        /**
         * error 错误信息
         *
         * @param o Object
         */
        public static void e(Object o) {
            LogUtils.e(o);
        }


        /**
         * json 格式字符串
         *
         * @param json String
         */
        public static void json(String json) {
            LogUtils.json(json);
        }

        /**
         * xml 格式
         *
         * @param xml String
         */
        public static void xml(String xml) {
            LogUtils.xml(xml);
        }

    }

}