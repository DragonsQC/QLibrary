package com.dqc.qlibrary.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused")
public class DateUtils {
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
        if (TextUtils.isEmpty(pattern)) {
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
        if (TextUtils.isEmpty(pattern)) {
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
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
        long time2       = cal.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(betweenDays));
    }

    /**
     * 根据毫秒时间戳来格式化字符串
     * 显示今天、昨天、前天.
     * 早于前天的显示传入的格式串；
     *
     * @param timeStamp 毫秒值
     * @param pattern   如果不是今天、昨天、前天，这格式化为传入格式
     * @return 今天 昨天 前天 或者 yyyy-MM-dd HH:mm:ss类型字符串
     */
    public static String format(long timeStamp, String pattern) {
        if (TextUtils.isEmpty(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf;
        Calendar         calendar = Calendar.getInstance();

        long curTimeMillis       = System.currentTimeMillis();
        int  todayHoursSeconds   = calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60;
        int  todayMinutesSeconds = calendar.get(Calendar.SECOND) * 60;
        int  todaySeconds        = calendar.get(Calendar.MINUTE);
        int  todayMillis         = (todayHoursSeconds + todayMinutesSeconds + todaySeconds) * 1000;
        long todayStartMillis    = curTimeMillis - todayMillis;
        if (timeStamp >= todayStartMillis) {
            sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
            return "今天 " + sdf.format(new Date(timeStamp));
        }
        int  oneDayMillis        = 24 * 60 * 60 * 1000;
        long yesterdayStartMilis = todayStartMillis - oneDayMillis;
        if (timeStamp >= yesterdayStartMilis) {
            sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
            return "昨天 " + sdf.format(new Date(timeStamp));
        }
        long yesterdayBeforeStartMilis = yesterdayStartMilis - oneDayMillis;
        if (timeStamp >= yesterdayBeforeStartMilis) {
            sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
            return "前天 " + sdf.format(new Date(timeStamp));
        }
        sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(new Date(timeStamp));
    }

}