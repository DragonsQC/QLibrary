package com.dqc.qlibrary.utils;

import com.orhanobut.logger.Logger;

/**
 * Android 日志工具类
 * <p/>
 * require https://github.com/orhanobut/logger
 */
public class QLog {
    public static boolean DEBUG_MODE = true;

    /**
     * com.orhanobut.logger.Logger 日志工具
     * info 普通信息
     *
     * @param msg
     */
    public static void i(String msg) {
        if (DEBUG_MODE) {
            Logger.init().hideThreadInfo();
            Logger.i(msg);
        }
    }

    /**
     * com.orhanobut.logger.Logger 日志工具
     * error 错误信息
     *
     * @param msg
     */
    public static void e(String msg) {
        if (DEBUG_MODE) {
            Logger.init().hideThreadInfo();
            Logger.e(msg);
        }
    }

    /**
     * com.orhanobut.logger.Logger 日志工具
     * json格式字符串
     *
     * @param json
     */
    public static void json(String json) {
        if (DEBUG_MODE) {
            Logger.init().hideThreadInfo();
            Logger.json(json);
        }
    }

}