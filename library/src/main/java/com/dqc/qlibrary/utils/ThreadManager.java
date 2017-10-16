package com.dqc.qlibrary.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import java.security.InvalidParameterException;

/**
 * 线程管理
 *
 * @author .
 */
@SuppressWarnings({"unused", "WeakerAccess", "SameParameterValue"})
public class ThreadManager {
    /**
     * 主线程
     */
    public static final  int       THREAD_UI         = 0;
    /**
     * background线程，用于一般的耗时操作
     */
    public static final  int       THREAD_BACKGROUND = 1;
    /**
     * data线程，用于数据库操作
     */
    public static final  int       THREAD_DATA       = 2;
    private static final int       THREAD_SIZE       = 3;
    /**
     * 线程信息数组
     */
    private static final Handler[] HANDLER_LIST      = new Handler[THREAD_SIZE];
    private static final String[]  THREAD_NAME_LIST  = {
            "thread_ui",
            "thread_background",
            "thread_data"
    };

    private ThreadManager() {
        HANDLER_LIST[THREAD_UI] = new Handler();
    }

    private static class ThreadManagerHolder {
        private static ThreadManager sManager = new ThreadManager();
    }

    public static ThreadManager getManager() {
        return ThreadManagerHolder.sManager;
    }

    /**
     * 派发任务
     *
     * @param index 线程类型
     */
    public void post(int index, Runnable r) {
        postDelayed(index, r, 0);
    }

    /**
     * 延迟派发任务
     *
     * @param index 线程类型
     */
    public void postDelayed(int index, Runnable r, long delayMillis) {
        Handler handler = getHandler(index);
        handler.postDelayed(r, delayMillis);
    }

    /**
     * 删除任务
     *
     * @param index 线程类型
     */
    public void removeCallbacks(int index, Runnable r) {
        Handler handler = getHandler(index);
        handler.removeCallbacks(r);
    }

    /**
     * 获取线程Handler
     *
     * @param index 线程类型
     */
    public Handler getHandler(int index) {
        if (index < 0 || index >= THREAD_SIZE) {
            throw new InvalidParameterException();
        }
        if (HANDLER_LIST[index] == null) {
            synchronized (HANDLER_LIST) {
                if (HANDLER_LIST[index] == null) {
                    HandlerThread thread = new HandlerThread(THREAD_NAME_LIST[index]);
                    if (index != THREAD_UI) {
                        //优先级要低于主线程
                        thread.setPriority(Thread.MIN_PRIORITY);
                    }
                    thread.start();
                    Handler handler = new Handler(thread.getLooper());
                    HANDLER_LIST[index] = handler;
                }
            }
        }
        return HANDLER_LIST[index];
    }

    /**
     * 判断是否运行在当前线程
     *
     * @param index 线程类型
     * @return true yes
     */
    public boolean runningOnCurrent(int index) {
        return getHandler(index).getLooper() == Looper.myLooper();
    }
}