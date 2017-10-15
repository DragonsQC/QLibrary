package com.dqc.qlibrary.utils;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * 字符串相关工具类
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused")
public class StringUtils {

    private static Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    private static Pattern chEnPattern  = Pattern.compile("^[a-zA-Z0-9\\u4E00-\\u9FA5]+$");
    private static Pattern isUrlPattern = Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~/])+$");


    /**
     * Email验证
     *
     * @param email 待校验字符串
     * @return boolean
     */
    public static boolean isEmail(String email) {
        return emailPattern.matcher(email).find();
    }

    /**
     * 判断字符串是否为null或全为空白字符
     *
     * @param s 待校验字符串
     * @return {@code true}: null或全空白字符<br> {@code false}: 不为null且不全空白字符
     */
    public static boolean isSpace(String s) {
        if (s == null) {
            return true;
        }
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 匹配[中文]、[英文]
     *
     * @param str 需匹配的字符串
     * @return boolean
     */
    public static boolean matchChEn(String str) {
        return chEnPattern.matcher(str).matches();
    }

    /**
     * 比较两个字符串是否相同，区分大小写
     * .equals(null, null)   = true
     * .equals(null, "abc")  = false
     * .equals("abc", null)  = false
     * .equals("abc", "abc") = true
     * .equals("abc", "ABC") = false
     *
     * @param cs1 字符串1
     * @param cs2 字符串2
     * @return .
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        return TextUtils.equals(cs1, cs2);
    }

    /**
     * 判断是否为 URL
     *
     * @param url URL
     * @return boolean
     */
    public static boolean isUrl(String url) {
        return isUrlPattern.matcher(url).matches();
    }

    /**
     * 格式化 Email 隐藏中间字符串
     *
     * @param email Email
     * @return .
     */
    public static String formatEmailShowSafe(String email) {
        return email.substring(0, 2) + "*****" + email.substring(email.lastIndexOf("@"), email.length());
    }

    /**
     * 首字母大写
     *
     * @param s 待转字符串
     * @return 首字母大写字符串
     */
    public static String upperFirstLetter(String s) {
        if (TextUtils.isEmpty(s) || !Character.isLowerCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) - 32)) + s.substring(1);
    }

    /**
     * 首字母小写
     *
     * @param s 待转字符串
     * @return 首字母小写字符串
     */
    public static String lowerFirstLetter(String s) {
        if (TextUtils.isEmpty(s) || !Character.isUpperCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) + 32)) + s.substring(1);
    }

    /**
     * 反转字符串
     *
     * @param s 待反转字符串
     * @return 反转字符串
     */
    public static String reverse(String s) {
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int    mid   = len >> 1;
        char[] chars = s.toCharArray();
        char   c;
        for (int i = 0; i < mid; ++i) {
            c = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = c;
        }
        return new String(chars);
    }

    /**
     * 转化为半角字符
     *
     * @param s 待转字符串
     * @return 半角字符串
     */
    public static String toDBC(String s) {
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] == 12288) {
                chars[i] = ' ';
            } else if (65281 <= chars[i] && chars[i] <= 65374) {
                chars[i] = (char) (chars[i] - 65248);
            } else {
                chars[i] = chars[i];
            }
        }
        return new String(chars);
    }

    /**
     * 转化为全角字符
     *
     * @param s 待转字符串
     * @return 全角字符串
     */
    public static String toSBC(String s) {
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] == ' ') {
                chars[i] = (char) 12288;
            } else if (33 <= chars[i] && chars[i] <= 126) {
                chars[i] = (char) (chars[i] + 65248);
            } else {
                chars[i] = chars[i];
            }
        }
        return new String(chars);
    }

}