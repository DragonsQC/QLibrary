package com.dqc.qlibrary.utils;


import com.dqc.qlibrary.library.codec.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用工具类集合
 *
 * @author DragonsQC
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
         * @return
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
     * double的计算不精确，会有类似0.0000000000000002的误差，正确的方法是使用BigDecimal或者用整型。
     * 整型的方法适合于货币精度已知的情况，比如12.11+1.10转成1211+110计算，最后再/100即可
     * 以下是摘抄的BigDecimal方法:
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
         * @param email
         * @return
         */
        public static boolean isEmail(String email) {
            Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
            Matcher matcher      = emailPattern.matcher(email);
            return matcher.find();
        }

        /**
         * 判断非空，包括不为【""】、不为【"null"】、不为【null】
         *
         * @param string
         * @return
         */
        public static boolean isEmpty(String string) {
            return StringUtils.equals(string, null) || StringUtils.equals(string, "") || StringUtils.equals(string, "null");
        }

        /**
         * 匹配[中文]、[英文]
         *
         * @param str
         * @return
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

    }

    /**
     * ################################################## <br/>
     * ### <br/>
     * ### 时间相关工具类 <br/>
     * ### <br/>
     * ################################################## <br/>
     */
    public static class DateUtil {
        /**
         * 将毫秒数时间戳格式化为对应模式时间
         *
         * @param timeMillis 时间戳
         * @param patterns   模式，为null或""时默认指定模式：yyyy-MM-dd HH:mm:ss <br/>
         *                   yy/yyyy：年（15/2015） <br/>
         *                   M/MM/MMM：月份（5/05/Jul） <br/>
         *                   d/dd：日期（5/05） <br/>
         *                   D：当前年中的第几天（189） <br/>
         *                   E/EEE：星期的英文（Tuesday/Tus） <br/>
         *                   w：所在天是这个年的第几周（27） <br/>
         *                   W：所在天是这个月的第几周（2） <br/>
         *                   F：所在的周是这个月的第几周 <br/>
         *                   H/HH：24小时制（0-23/00-23） <br/>
         *                   h/hh：12小时制（1-12/01-12） <br/>
         *                   m/mm：分钟（0-59/00-59） <br/>
         *                   s/ss：秒钟（0-59/00-59） <br/>
         *                   S：毫秒 <br/>
         *                   a：AM/PM标识 <br/>
         *                   G：公元标识（AD） <br/>
         *                   z：太平洋夏令时标识简写（PDT） <br/>
         *                   zzzz：太平洋夏令时标识全拼（Pacific Daylight Time） <br/>
         *                   Z：当前时区（-0800） <br/>
         *                   X：ISO时区 <br/>
         * @return
         */
        public static String formatDateTimeMillis2Str(String timeMillis, String patterns) {
            if (StringUtil.isEmpty(patterns)) {
                patterns = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(patterns);
            return sdf.format(new java.util.Date(Long.parseLong(timeMillis)));
        }

        /**
         * 获得当前时间字符串
         *
         * @param patterns 模式，为null或""时默认指定模式：yyyy-MM-dd HH:mm:ss
         *                 yy/yyyy：年（15/2015）
         *                 M/MM/MMM：月份（5/05/Jul）
         *                 d/dd：日期（5/05）
         *                 D：当前年中的第几天（189）
         *                 E/EEE：星期的英文（Tuesday/Tus）
         *                 w：所在天是这个年的第几周（27）
         *                 W：所在天是这个月的第几周（2）
         *                 F：所在的周是这个月的第几周
         *                 H/HH：24小时制（0-23/00-23）
         *                 h/hh：12小时制（1-12/01-12）
         *                 m/mm：分钟（0-59/00-59）
         *                 s/ss：秒钟（0-59/00-59）
         *                 S：毫秒
         *                 a：AM/PM标识
         *                 G：公元标识（AD）
         *                 z：太平洋夏令时标识简写（PDT）
         *                 zzzz：太平洋夏令时标识全拼（Pacific Daylight Time）
         *                 Z：当前时区（-0800）
         *                 X：ISO时区
         * @return
         */
        public static String getCurrentDate2Str(String patterns) {
            if (StringUtil.isEmpty(patterns)) {
                patterns = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(patterns);
            return sdf.format(new java.util.Date(System.currentTimeMillis()));
        }

        /**
         * 字符串格式时间转换为 Date 时间类型
         *
         * @param strDate       字符串时间
         * @param strDateFormat 字符串的时间格式，例：yyyy-MM-dd HH:mm:ss
         * @return
         */
        public static Date strDate2Date(String strDate, String strDateFormat) {
            DateFormat format = new SimpleDateFormat(strDateFormat);
            Date       date   = null;
            try {
                date = format.parse(strDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }

        /**
         * 计算两个日期之间相差的天数
         *
         * @param smDate 较小的时间
         * @param bDate  较大的时间
         * @return 相差天数
         * @throws ParseException
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
