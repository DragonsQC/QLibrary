package com.dqc.qlibrary.utils;

import com.dqc.qlibrary.library.codec.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用 Java 工具类集合
 */
public class QUtils {


    /**
     * ################################################## <br/>
     * ### <br/>
     * ### 文件相关工具类 <br/>
     * ### <br/>
     * ################################################## <br/>
     */
    public static class FileUtil {

        /**
         * 获取文件大小
         *
         * @param file File实例
         * @return long
         */
        public static long getFileSize(File file) {

            long size = 0;
            try {
                File[] fileList = file.listFiles();
                for (File aFileList : fileList) {
                    if (aFileList.isDirectory()) {
                        size = size + getFileSize(aFileList);

                    } else {
                        size = size + aFileList.length();

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return size;
        }

        /**
         * 删除文件/文件夹
         *
         * @param filePath       文件路径
         * @param isDeleteFolder 是否删除文件夹
         */
        public static void deleteFile(String filePath, boolean isDeleteFolder) {
            if (!StringUtil.isEmpty(filePath)) {
                try {
                    File file = new File(filePath);
                    if (file.exists()) { // 判断文件是否存在
                        if (file.isFile()) { // 判断是否是文件
                            file.delete();
                        } else if (file.isDirectory()) { // 否则如果它是一个目录
                            File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
                            for (File file1 : files) {
                                file1.delete();
                            }
                        }
                        if (isDeleteFolder) {
                            file.delete();
                        }
                    } else {
                        //文件不存在
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 新建文件夹
         *
         * @param folderPath 文件夹路径
         * @return 是否创建
         */
        public static boolean newCreateFolder(String folderPath) {
            File file = new File(folderPath);
            return !file.exists() && file.mkdirs();
        }

        /**
         * 复制单个文件
         *
         * @param sourcePath 源文件路径
         * @param targetPath 目标文件路径
         */
        public static void copyFile(String sourcePath, String targetPath) {
            File sourceFile = new File(sourcePath);
            File targetFile = new File(targetPath);
            try {
                if (sourceFile.exists()) {
                    // 新建文件输入流并对它进行缓冲
                    FileInputStream     input  = new FileInputStream(sourceFile);
                    BufferedInputStream inBuff = new BufferedInputStream(input);

                    // 新建文件输出流并对它进行缓冲
                    FileOutputStream     output  = new FileOutputStream(targetFile);
                    BufferedOutputStream outBuff = new BufferedOutputStream(output);

                    // 缓冲数组
                    byte[] b = new byte[1024 * 5];
                    int    len;
                    while ((len = inBuff.read(b)) != -1) {
                        outBuff.write(b, 0, len);
                    }
                    outBuff.flush();

                    inBuff.close();
                    outBuff.close();
                    output.close();
                    input.close();
                } else {
                    //文件不存在
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        /**
         * 格式化文件大小
         *
         * @param size 文件 length
         * @return 格式化后字符串
         */
        public static String formatFileSize(double size) {
            double kiloByte = size / 1024;
            if (kiloByte < 1) {
                return size + "Byte";
            }
            double megaByte = kiloByte / 1024;
            if (megaByte < 1) {
                BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
                return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
            }

            double gigaByte = megaByte / 1024;
            if (gigaByte < 1) {
                BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
                return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
            }

            double teraBytes = gigaByte / 1024;
            if (teraBytes < 1) {
                BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
                return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
            }
            BigDecimal result4 = new BigDecimal(teraBytes);
            return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
        }

    }


    /**
     * ################################################## <br/>
     * ### <br/>
     * ### 数字相关工具类 <br/>
     * ### <br/>
     * ################################################## <br/>
     */
    public static class MathUtil {

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
         * @return
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

    /**
     * ################################################## <br/>
     * ### <br/>
     * ### 小数计算精确类 <br/>
     * ### <br/>
     * ### double的计算不精确，会有类似0.0000000000000002的误差，正确的方法是使用BigDecimal或者用整型。
     * ### 整型的方法适合于货币精度已知的情况，比如12.11+1.10转成1211+110计算，最后再/100即可
     * ### 以下是摘抄的BigDecimal方法:
     * ################################################## <br/>
     */
    public static class DoubleUtil implements Serializable {
        private static final long    serialVersionUID = -3345205828566485102L;
        // 默认除法运算精度
        private static final Integer DEF_DIV_SCALE    = 2;

        /**
         * 提供精确的加法运算。
         *
         * @param value1 被加数
         * @param value2 加数
         * @return 两个参数的和
         */
        public static Double add(Number value1, Number value2) {
            BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
            BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
            return b1.add(b2).doubleValue();
        }

        /**
         * 提供精确的减法运算。
         *
         * @param value1 被减数
         * @param value2 减数
         * @return 两个参数的差
         */
        public static double sub(Number value1, Number value2) {
            BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
            BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
            return b1.subtract(b2).doubleValue();
        }

        /**
         * 提供精确的乘法运算。
         *
         * @param value1 被乘数
         * @param value2 乘数
         * @return 两个参数的积
         */
        public static Double mul(Number value1, Number value2) {
            BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
            BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
            return b1.multiply(b2).doubleValue();
        }

        /**
         * 提供（相对）精确的除法运算，当发生除不尽的情况时， 精确到小数点以后10位，以后的数字四舍五入。
         *
         * @param dividend 被除数
         * @param divisor  除数
         * @return 两个参数的商
         */
        public static Double div(Double dividend, Double divisor) {
            return div(dividend, divisor, DEF_DIV_SCALE);
        }

        /**
         * 提供（相对）精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
         *
         * @param dividend 被除数
         * @param divisor  除数
         * @param scale    表示表示需要精确到小数点以后几位。
         * @return 两个参数的商
         */
        public static Double div(Double dividend, Double divisor, Integer scale) {
            if (scale < 0) {
                throw new IllegalArgumentException(
                        "The scale must be a positive integer or zero");
            }
            BigDecimal b1 = new BigDecimal(Double.toString(dividend));
            BigDecimal b2 = new BigDecimal(Double.toString(divisor));
            return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        /**
         * 提供精确的小数位四舍五入处理。
         *
         * @param value 需要四舍五入的数字
         * @param scale 小数点后保留几位
         * @return 四舍五入后的结果
         */
        public static Double round(Double value, Integer scale) {
            if (scale < 0) {
                throw new IllegalArgumentException("The scale must be a positive integer or zero");
            }
            BigDecimal b   = new BigDecimal(Double.toString(value));
            BigDecimal one = new BigDecimal("1");
            return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }

    /**
     * ################################################## <br/>
     * ### <br/>
     * ### 字符串相关工具类 <br/>
     * ### require Apache Commons Codec <br/>
     * ### <br/>
     * ################################################## <br/>
     */
    public static class StringUtil {

        /**
         * Email验证
         *
         * @param email 待校验字符串
         * @return boolean
         */
        public static boolean isEmail(String email) {
            Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
            Matcher matcher      = emailPattern.matcher(email);
            return matcher.find();
        }

        /**
         * 判断非空，包括不为【""】、不为【"null"】、不为【null】
         *
         * @param s 待校验字符串
         * @return boolean
         */
        public static boolean isEmpty(String s) {
            return StringUtils.equals(s, null) || StringUtils.equals(s, "") || StringUtils.equals(s, "null");
        }

        /**
         * 判断字符串是否为null或全为空白字符
         *
         * @param s 待校验字符串
         * @return {@code true}: null或全空白字符<br> {@code false}: 不为null且不全空白字符
         */
        public static boolean isSpace(String s) {
            if (s == null) return true;
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
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\u4E00-\\u9FA5]+$");
            Matcher matcher = pattern.matcher(str);
            return matcher.matches();
        }

        /**
         * 比较两个字符串是否相同，区分大小写
         * .equals(null, null)   = true
         * .equals(null, "abc")  = false
         * .equals("abc", null)  = false
         * .equals("abc", "abc") = true
         * .equals("abc", "ABC") = false
         *
         * @param cs1
         * @param cs2
         * @return
         */
        public static boolean equals(CharSequence cs1, CharSequence cs2) {
            return StringUtils.equals(cs1, cs2);
        }

        /**
         * 判断是否为 URL
         *
         * @param url
         * @return
         */
        public static boolean isUrl(String url) {
            Pattern pattern = Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
            return pattern.matcher(url).matches();
        }

        /**
         * 格式化 Email 隐藏中间字符串
         *
         * @param email
         * @return
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
            if (isEmpty(s) || !Character.isLowerCase(s.charAt(0))) return s;
            return String.valueOf((char) (s.charAt(0) - 32)) + s.substring(1);
        }

        /**
         * 首字母小写
         *
         * @param s 待转字符串
         * @return 首字母小写字符串
         */
        public static String lowerFirstLetter(String s) {
            if (isEmpty(s) || !Character.isUpperCase(s.charAt(0))) return s;
            return String.valueOf((char) (s.charAt(0) + 32)) + s.substring(1);
        }

        /**
         * 反转字符串
         *
         * @param s 待反转字符串
         * @return 反转字符串
         */
        public static String reverse(String s) {
            if (isEmpty(s)) {
                return s;
            }
            int len = s.length();
            if (len <= 1) return s;
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
            if (isEmpty(s)) return s;
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
            if (isEmpty(s)) return s;
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

    /**
     * 时间相关工具类 <br/>
     * <p>
     * <table border="1" cellspacing="1" cellpadding="1" summary="Chart shows pattern letters, date/time component,
     * presentation, and examples.">
     * <tr>
     * <th align="left">字母</th>
     * <th align="left">日期或时间元素</th>
     * <th align="left">表示</th>
     * <th align="left">示例</th>
     * </tr>
     * <tr>
     * <td><code>G</code></td>
     * <td>Era 标志符</td>
     * <td>Text</td>
     * <td><code>AD</code></td>
     * </tr>
     * <tr>
     * <td><code>y</code> </td>
     * <td>年 </td>
     * <td>Year </td>
     * <td><code>1996</code>; <code>96</code> </td>
     * </tr>
     * <tr>
     * <td><code>M</code> </td>
     * <td>年中的月份 </td>
     * <td>Month </td>
     * <td><code>July</code>; <code>Jul</code>; <code>07</code> </td>
     * </tr>
     * <tr>
     * <td><code>w</code> </td>
     * <td>年中的周数 </td>
     * <td>Number </td>
     * <td><code>27</code> </td>
     * </tr>
     * <tr>
     * <td><code>W</code> </td>
     * <td>月份中的周数 </td>
     * <td>Number </td>
     * <td><code>2</code> </td>
     * </tr>
     * <tr>
     * <td><code>D</code> </td>
     * <td>年中的天数 </td>
     * <td>Number </td>
     * <td><code>189</code> </td>
     * </tr>
     * <tr>
     * <td><code>d</code> </td>
     * <td>月份中的天数 </td>
     * <td>Number </td>
     * <td><code>10</code> </td>
     * </tr>
     * <tr>
     * <td><code>F</code> </td>
     * <td>月份中的星期 </td>
     * <td>Number </td>
     * <td><code>2</code> </td>
     * </tr>
     * <tr>
     * <td><code>E</code> </td>
     * <td>星期中的天数 </td>
     * <td>Text </td>
     * <td><code>Tuesday</code>; <code>Tue</code> </td>
     * </tr>
     * <tr>
     * <td><code>a</code> </td>
     * <td>Am/pm 标记 </td>
     * <td>Text </td>
     * <td><code>PM</code> </td>
     * </tr>
     * <tr>
     * <td><code>H</code> </td>
     * <td>一天中的小时数（0-23） </td>
     * <td>Number </td>
     * <td><code>0</code> </td>
     * </tr>
     * <tr>
     * <td><code>k</code> </td>
     * <td>一天中的小时数（1-24） </td>
     * <td>Number </td>
     * <td><code>24</code> </td>
     * </tr>
     * <tr>
     * <td><code>K</code> </td>
     * <td>am/pm 中的小时数（0-11） </td>
     * <td>Number </td>
     * <td><code>0</code> </td>
     * </tr>
     * <tr>
     * <td><code>h</code> </td>
     * <td>am/pm 中的小时数（1-12） </td>
     * <td>Number </td>
     * <td><code>12</code> </td>
     * </tr>
     * <tr>
     * <td><code>m</code> </td>
     * <td>小时中的分钟数 </td>
     * <td>Number </td>
     * <td><code>30</code> </td>
     * </tr>
     * <tr>
     * <td><code>s</code> </td>
     * <td>分钟中的秒数 </td>
     * <td>Number </td>
     * <td><code>55</code> </td>
     * </tr>
     * <tr>
     * <td><code>S</code> </td>
     * <td>毫秒数 </td>
     * <td>Number </td>
     * <td><code>978</code> </td>
     * </tr>
     * <tr>
     * <td><code>z</code> </td>
     * <td>时区 </td>
     * <td>General time zone </td>
     * <td><code>Pacific Standard Time</code>; <code>PST</code>; <code>GMT-08:00</code> </td>
     * </tr>
     * <tr>
     * <td><code>Z</code> </td>
     * <td>时区 </td>
     * <td>RFC 822 time zone </td>
     * <td><code>-0800</code> </td>
     * </tr>
     * </table>
     * <pre>
     *                          HH:mm    15:44
     *                         h:mm a    3:44 下午
     *                        HH:mm z    15:44 CST
     *                        HH:mm Z    15:44 +0800
     *                     HH:mm zzzz    15:44 中国标准时间
     *                       HH:mm:ss    15:44:40
     *                     yyyy-MM-dd    2016-08-12
     *               yyyy-MM-dd HH:mm    2016-08-12 15:44
     *            yyyy-MM-dd HH:mm:ss    2016-08-12 15:44:40
     *       yyyy-MM-dd HH:mm:ss zzzz    2016-08-12 15:44:40 中国标准时间
     *  EEEE yyyy-MM-dd HH:mm:ss zzzz    星期五 2016-08-12 15:44:40 中国标准时间
     *       yyyy-MM-dd HH:mm:ss.SSSZ    2016-08-12 15:44:40.461+0800
     *     yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
     *   yyyy.MM.dd G 'at' HH:mm:ss z    2016.08.12 公元 at 15:44:40 CST
     *                         K:mm a    3:44 下午
     *               EEE, MMM d, ''yy    星期五, 八月 12, '16
     *          hh 'o''clock' a, zzzz    03 o'clock 下午, 中国标准时间
     *   yyyyy.MMMMM.dd GGG hh:mm aaa    02016.八月.12 公元 03:44 下午
     *     EEE, d MMM yyyy HH:mm:ss Z    星期五, 12 八月 2016 15:44:40 +0800
     *                  yyMMddHHmmssZ    160812154440+0800
     *     yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
     * EEEE 'DATE('yyyy-MM-dd')' 'TIME('HH:mm:ss')' zzzz    星期五 DATE(2016-08-12) TIME(15:44:40) 中国标准时间
     * </pre>
     * 注意：SimpleDateFormat不是线程安全的，线程安全需用{@code ThreadLocal<SimpleDateFormat>}
     */
    public static class DateUtil {
        /**
         * 将毫秒数时间戳格式化为对应模式时间
         *
         * @param millis  时间戳
         * @param pattern 模式，为null或""时默认指定模式：yyyy-MM-dd HH:mm:ss <br/>
         *                yy/yyyy：年（15/2015） <br/>
         *                M/MM/MMM：月份（5/05/Jul） <br/>
         *                d/dd：日期（5/05） <br/>
         *                D：当前年中的第几天（189） <br/>
         *                E/EEE：星期的英文（Tuesday/Tus） <br/>
         *                w：所在天是这个年的第几周（27） <br/>
         *                W：所在天是这个月的第几周（2） <br/>
         *                F：所在的周是这个月的第几周 <br/>
         *                H/HH：24小时制（0-23/00-23） <br/>
         *                h/hh：12小时制（1-12/01-12） <br/>
         *                m/mm：分钟（0-59/00-59） <br/>
         *                s/ss：秒钟（0-59/00-59） <br/>
         *                S：毫秒 <br/>
         *                a：AM/PM标识 <br/>
         *                G：公元标识（AD） <br/>
         *                z：太平洋夏令时标识简写（PDT） <br/>
         *                zzzz：太平洋夏令时标识全拼（Pacific Daylight Time） <br/>
         *                Z：当前时区（-0800） <br/>
         *                X：ISO时区 <br/>
         * @return 格式化后的时间
         */
        public static String millis2Str(long millis, String pattern) {
            if (StringUtil.isEmpty(pattern)) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }
            return new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(millis));
        }

        /**
         * 将时间字符串转为时间戳
         * <p>time格式为pattern</p>
         *
         * @param time    时间字符串
         * @param pattern 时间格式
         * @return 毫秒时间戳
         */
        public static long str2Millis(String time, String pattern) {
            try {
                return new SimpleDateFormat(pattern, Locale.getDefault()).parse(time).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return -1;
        }

        /**
         * 获得当前时间字符串
         *
         * @param pattern 模式，为null或""时默认指定模式：yyyy-MM-dd HH:mm:ss
         *                yy/yyyy：年（15/2015）
         *                M/MM/MMM：月份（5/05/Jul）
         *                d/dd：日期（5/05）
         *                D：当前年中的第几天（189）
         *                E/EEE：星期的英文（Tuesday/Tus）
         *                w：所在天是这个年的第几周（27）
         *                W：所在天是这个月的第几周（2）
         *                F：所在的周是这个月的第几周
         *                H/HH：24小时制（0-23/00-23）
         *                h/hh：12小时制（1-12/01-12）
         *                m/mm：分钟（0-59/00-59）
         *                s/ss：秒钟（0-59/00-59）
         *                S：毫秒
         *                a：AM/PM标识
         *                G：公元标识（AD）
         *                z：太平洋夏令时标识简写（PDT）
         *                zzzz：太平洋夏令时标识全拼（Pacific Daylight Time）
         *                Z：当前时区（-0800）
         *                X：ISO时区
         * @return String
         */
        public static String getCurrentMillis2Str(String pattern) {
            if (StringUtil.isEmpty(pattern)) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }
            return new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        }

        /**
         * 将时间字符串转为Date类型
         * <p>time格式为pattern</p>
         *
         * @param time    时间字符串
         * @param pattern 时间格式
         * @return Date类型
         */
        public static Date str2Date(String time, String pattern) {
            return new Date(str2Millis(time, pattern));
        }

        /**
         * 将Date类型转为时间字符串
         * <p>格式为pattern</p>
         *
         * @param date    Date类型时间
         * @param pattern 时间格式
         * @return 时间字符串
         */
        public static String date2String(Date date, String pattern) {
            return new SimpleDateFormat(pattern, Locale.getDefault()).format(date);
        }

        /**
         * 计算两个日期之间相差的天数
         *
         * @param smDate 较小的时间
         * @param bDate  较大的时间
         * @return 相差天数
         */
        public static int daysBetween(Date smDate, Date bDate) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                smDate = sdf.parse(sdf.format(smDate));
                bDate = sdf.parse(sdf.format(bDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(smDate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bDate);
            long time2        = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            return Integer.parseInt(String.valueOf(between_days));
        }
    }
}
