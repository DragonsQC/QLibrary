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
    public static boolean DEBUG_MODE = true;

    /**
     * com.orhanobut.logger.Logger 日志工具
     * <p/>
     * verbose 信息
     *
     * @param msg
     */
    public static void v(String msg) {
        if (DEBUG_MODE) {
            Logger.init().methodCount(1).hideThreadInfo();
            Logger.v(msg);
        }
    }

    /**
     * com.orhanobut.logger.Logger 日志工具
     * <p/>
     * debug 调试信息
     *
     * @param msg
     */
    public static void d(String msg) {
        if (DEBUG_MODE) {
            Logger.init().methodCount(1).hideThreadInfo();
            Logger.d(msg);
        }
    }

    /**
     * com.orhanobut.logger.Logger 日志工具
     * <p/>
     * info 普通信息
     *
     * @param msg
     */
    public static void i(String msg) {
        if (DEBUG_MODE) {
            Logger.init().methodCount(1).hideThreadInfo();
            Logger.i(msg);
        }
    }

    /**
     * com.orhanobut.logger.Logger 日志工具
     * <p/>
     * warning 警告信息
     *
     * @param msg
     */
    public static void w(String msg) {
        if (DEBUG_MODE) {
            Logger.init().methodCount(1).hideThreadInfo();
            Logger.w(msg);
        }
    }

    /**
     * com.orhanobut.logger.Logger 日志工具
     * <p/>
     * error 错误信息
     *
     * @param msg
     */
    public static void e(String msg) {
        if (DEBUG_MODE) {
            Logger.init().methodCount(1).hideThreadInfo();
            Logger.e(msg);
        }
    }

    /**
     * com.orhanobut.logger.Logger 日志工具
     * <p/>
     * json格式字符串
     *
     * @param json
     */
    public static void json(String json) {
        if (DEBUG_MODE) {
            Logger.init().methodCount(1).hideThreadInfo();
            Logger.json(json);
        }
    }

}