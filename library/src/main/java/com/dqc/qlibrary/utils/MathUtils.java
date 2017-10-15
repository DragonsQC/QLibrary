package com.dqc.qlibrary.utils;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * 数字等公式相关工具类
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused")
public class MathUtils {

    /**
     * 获得mix~max之间的随机数
     *
     * @param min 最小数（包含）
     * @param max 最大数（包含）
     * @return 返回一个包括最小数和最大数的随机数
     */
    public static int random(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }


    /**
     * 格式化距离，传入距离单位为 m，根据长度格式化为显示为 m、km
     *
     * @return .
     */
    public static String formatDistance(double m) {
        DecimalFormat df;
        String        formatStr;
        if (m < 1000) {
            df = new DecimalFormat("#");
            formatStr = df.format(m) + "m";
        } else {
            df = new DecimalFormat("#.0");
            formatStr = df.format(m / 1000) + "km";
        }
        return formatStr;
    }
}