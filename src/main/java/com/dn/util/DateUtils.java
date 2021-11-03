package com.dn.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * 时间工具类
 *
 * @author xinan
 */
@Slf4j
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String HH_MM = "HH:mm";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 获取时间差
     *
     * @param d1
     * @param d2
     * @return 天
     */
    public static int calculateTimeDiff(Date d1, Date d2) {
        long time1 = d1.getTime();
        long time2 = d2.getTime();
        int day = (int)( (time2 - time1) / (24 * 60 * 60 * 1000));
        return day;
    }

    /**
     * 指定时间添加天数
     *
     * @param paramDate 输入时间
     * @param paramInt  增加的天数
     * @return
     */
    public static Date addDays(Date paramDate, int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        int i = localCalendar.get(6);
        localCalendar.set(6, i + paramInt);
        return localCalendar.getTime();
    }

    /**
     * 获取指定日期所在周的第一天和最后一天
     *
     * @param paramDate
     * @return
     */
    public static Date[] getDayBeforeAndAfter(Date paramDate) {
        Date[] days = new Date[2];
        Calendar cal = Calendar.getInstance();
        cal.setTime(paramDate);
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        days[0] = cal.getTime();
        cal.add(Calendar.DAY_OF_WEEK, 6);
        days[1] = cal.getTime();
        return days;
    }
    /**
     * 秒转 分：秒  /时：分：秒  格式
     *
     * @param time
     * @return
     */
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0) {
            return "00:00";
        } else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99) {
                    return "99:59:59";
                }
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr = "0" + Integer.toString(i);
        } else {
            retStr = "" + i;
        }
        return retStr;

    }

    /**
     * 增加天数
     *
     * @param sdf
     */

    public static void addDay(SimpleDateFormat sdf, int days) {


        //获取Calendar实例，java封装的表现，private类Calendar的构造函数，通过静态方法创建对象

        Calendar calendar = Calendar.getInstance();

        //获取当前时间并格式化


        //给当前时间加上天数days并输出，这里的第一个参数用以下三个都可以

        Calendar calendar1 = Calendar.getInstance();

        calendar1.add(Calendar.DAY_OF_YEAR, days);



        Calendar calendar2 = Calendar.getInstance();

        calendar2.add(Calendar.DAY_OF_MONTH, days);



        Calendar calendar3 = Calendar.getInstance();

        calendar3.add(Calendar.DAY_OF_WEEK, days);


    }

    /**
     * 获取当前星期、前一星期、后一星期的第一天和最后一天
     *
     * @param sdf
     */

    public static void getWeekDay(SimpleDateFormat sdf) {

        //获取Calendar实例，java封装的表现，private类Calendar的构造函数，通过静态方法创建对象

        Calendar calendar = Calendar.getInstance();

        //获取当前时间并格式化



        //本周一

        Calendar calendar1 = Calendar.getInstance();

        calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);


        //本周日

        Calendar calendar2 = Calendar.getInstance();

        //外国的星期天和我们的不在一周(外国是星期天到星期六为一个星期)

        calendar2.add(Calendar.DAY_OF_WEEK, 7);

        calendar2.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);



        //下周一

        Calendar calendar3 = Calendar.getInstance();

        calendar3.add(Calendar.DAY_OF_MONTH, 7);

        calendar3.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);


        //下周日

        Calendar calendar4 = Calendar.getInstance();

        calendar4.add(Calendar.DAY_OF_MONTH, 14);

        calendar4.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);



        //上周一

        Calendar calendar5 = Calendar.getInstance();

        calendar5.add(Calendar.DAY_OF_YEAR, -7);

        calendar5.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);


        //上周日

        Calendar calendar6 = Calendar.getInstance();

        calendar6.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);


    }

    /**
     * 获取当前月、前一月、后一月的第一天和最后一天
     *
     * @param sdf
     */

    public static void getMonth(SimpleDateFormat sdf) {

        //定义当前月的总天数，比如30,31,28,29

        int maxCurrentMonthDay = 0;

        Calendar calendar = Calendar.getInstance();



        //当月一号

        Calendar calendar1 = Calendar.getInstance();

        calendar1.set(Calendar.DAY_OF_MONTH, 1);


        //当月最后一天

        Calendar calendar2 = Calendar.getInstance();

        maxCurrentMonthDay = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar2.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);



        //下个月一号

        Calendar calendar3 = Calendar.getInstance();

        maxCurrentMonthDay = calendar3.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar3.add(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

        calendar3.set(Calendar.DAY_OF_MONTH, 1);


        //下个月最后一天

        Calendar calendar4 = Calendar.getInstance();

        maxCurrentMonthDay = calendar4.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar4.add(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

        //第一个maxCurrentMonthDay获取的是当月的天数，第二个maxCurrentMonthDay获取的是下个月的天数

        maxCurrentMonthDay = calendar4.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar4.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);



        //上个月一号

        Calendar calendar5 = Calendar.getInstance();

        maxCurrentMonthDay = calendar5.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar5.add(Calendar.DAY_OF_MONTH, -maxCurrentMonthDay);

        calendar5.set(Calendar.DAY_OF_MONTH, 1);


        //上个月最后一天

        Calendar calendar6 = Calendar.getInstance();

        maxCurrentMonthDay = calendar6.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar6.add(Calendar.DAY_OF_MONTH, -maxCurrentMonthDay);

        //第一个maxCurrentMonthDay获取的是当月的天数，第二个maxCurrentMonthDay获取的是上个月的天数

        maxCurrentMonthDay = calendar6.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar6.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

    }

    /**
     * 上个月一号
     *
     * @param simpleDateFormat
     * @return
     */
    public static String getLastMonthFirstDay(SimpleDateFormat simpleDateFormat) {
        //定义当前月的总天数，比如30,31,28,29

        int maxCurrentMonthDay = 0;
        //上个月一号

        Calendar calendar5 = Calendar.getInstance();

        maxCurrentMonthDay = calendar5.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar5.add(Calendar.DAY_OF_MONTH, -maxCurrentMonthDay);

        calendar5.set(Calendar.DAY_OF_MONTH, 1);

        return simpleDateFormat.format(calendar5.getTime());
    }

    /**
     * 上个月最后一天
     *
     * @param simpleDateFormat
     * @return
     */
    public static String getLastMonthLastDay(SimpleDateFormat simpleDateFormat) {
        int maxCurrentMonthDay = 0;
        //上个月最后一天

        Calendar calendar6 = Calendar.getInstance();

        maxCurrentMonthDay = calendar6.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar6.add(Calendar.DAY_OF_MONTH, -maxCurrentMonthDay);

        //第一个maxCurrentMonthDay获取的是当月的天数，第二个maxCurrentMonthDay获取的是上个月的天数

        maxCurrentMonthDay = calendar6.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar6.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

        return simpleDateFormat.format(calendar6.getTime());
    }

    /**
     * 当月一号
     *
     * @param simpleDateFormat
     * @return
     */
    public static String getThisMonthFirstDay(SimpleDateFormat simpleDateFormat) {
        //当月一号
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        return simpleDateFormat.format(calendar1.getTime());
    }

    /**
     * 本周一
     *
     * @param simpleDateFormat
     * @return
     */
    public static String getThisweekFirstDay(SimpleDateFormat simpleDateFormat) {
        //本周一
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return simpleDateFormat.format(calendar1.getTime());
    }

    /**
     * 上周一
     *
     * @param simpleDateFormat
     * @return
     */
    public static String getlastweekFirstDay(SimpleDateFormat simpleDateFormat) {
        //上周一
        Calendar calendar5 = Calendar.getInstance();
        calendar5.add(Calendar.DAY_OF_YEAR, -7);
        calendar5.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return simpleDateFormat.format(calendar5.getTime());
    }
    /**
     * 输入时间到当前时间相隔多少天
     *
     * @param date
     * @return
     */
    public static Integer getDays(Date date) {
        if (Objects.isNull(date)) {
            return 0;
        }
        //时间转换成毫秒值
        long datetime = date.getTime();
        //获取当前日期毫秒值
        long todaytime = System.currentTimeMillis();
        //差值
        long Difference = todaytime - datetime;
        Integer days = Math.toIntExact(Difference / 1000 / 60 / 60 / 24);
        return days;
    }


    /**
     * 通过日期获取对应的周几
     *
     * @param date
     * @return
     */
    public static String getWeekday(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (i < 0) {
            i = 0;
        }
        return weekDays[i];
    }

    /**
     * @param time
     * @return
     */
    public static String handleDate01(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(time);
            Date old = sdf.parse(sdf.format(date));
            Date now = sdf.parse(sdf.format(new Date()));
            long oldTime = old.getTime();
            long nowTime = now.getTime();

            long day = (nowTime - oldTime) / (24 * 60 * 60 * 1000);

            if (day < 1) {  //今天
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                return format.format(date);
            } else if (day == 1) {     //昨天
                //SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                return "昨天 " /*+ format.format(date)*/;
            } else {    //可依次类推
                SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
                return format.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param time
     * @return
     */
    public static String handleDate02(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(time);
            Date old = sdf.parse(sdf.format(date));
            Date now = sdf.parse(sdf.format(new Date()));
            long oldTime = old.getTime();
            long nowTime = now.getTime();

            long day = (nowTime - oldTime) / (24 * 60 * 60 * 1000);

            if (day < 1) {  //今天
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                return format.format(date);
            } else if (day == 1) {     //昨天
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                return "昨天 " + format.format(date);
            } else if (day >= 2 && day < 7) {    //可依次类推
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                String f = format.format(date);
                return getWeekday(date) + " " + f;
            } else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                return format.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断指定日期是否小于当前日期
     *
     * @param date 2021-08-03  new Date(2021-08-05)
     * @return true
     */
    public static boolean afterDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //把String转为LocalDate
        LocalDate localTime = LocalDate.parse(date, dtf);
        //判断当前日期是否大于指定日期
        return LocalDate.now().isAfter(localTime);
    }

    /**
     * 判断指定日期是否大于当前日期
     *
     * @param date
     * @return
     */
    public static boolean lessThanDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //把String转为LocalDate
        LocalDate localTime = LocalDate.parse(date, dtf);
        //判断当前日期是否小于指定日期
        return !LocalDate.now().isAfter(localTime);
    }

    /**
     * 通过数字获取本周的日期
     *
     * @return
     */
    public static String getDate(Integer num) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.MONDAY);//以周一为首日
        cld.setTimeInMillis(System.currentTimeMillis());//当前时间
        switch (num) {
            case 1: {
                cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//周一
                break;
            }
            case 2: {
                cld.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);//周二
                break;
            }
            case 3: {
                cld.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);//周三
                break;
            }
            case 4: {
                cld.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);//周四
                break;
            }
            case 5: {
                cld.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);//周五
                break;
            }
            case 6: {
                cld.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);//周六
                break;
            }
            case 7: {
                cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//周日
                break;
            }
        }

        return df.format(cld.getTime());
    }

    /**
     * 根据年月日
     * 获取该日期对应月份天数
     *
     * @param date
     * @return
     */
    public static Integer getDaysOfMonth(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当月减几个月的月份
     *
     * @param num
     * @return
     */
    public static String getLastMonthByMonth(Integer num) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - num); // 设置为当前月减几个月的月份
        date = calendar.getTime();
        String accDate = format.format(date);
        return accDate;
    }

    /**
     * 获取当月减几个月的月份的天数
     *
     * @param num 减去几个月
     * @return
     */
    public static Integer getLastMonthByMonthToDay(Integer num) {
        return getDaysOfMonth(getLastMonthByMonth(num));
    }

    /**
     * 获取当前年份
     *
     * @return 2021
     */
    public static String getYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
    }

    /**
     * 获取当年月日
     *
     * @return 2021-08-03
     */
    public static String getDay() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 获取当前时间年月日时分秒
     *
     * @return 2021-08-06 15:00:00
     */
    public static String getNewDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        //获取当前时间并格式化
        return format.format(calendar.getTime());
    }


    /**
     * 校验传入时间是否比当前时间大
     *
     * @return true
     */
    public static boolean dateCompareNewDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = format.parse(date);
            endTime = format.parse(getNewDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (startTime.getTime() > endTime.getTime()) {
            return true;//
        }
        return false;
    }

    /**
     * 校验传入时间是否大于当天
     *
     * @return true
     */
    public static boolean dateCompareDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = format.parse(date);
            endTime = format.parse(getNewDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (startTime.getTime() > endTime.getTime()) {
            return true;//
        }
        return false;
    }

    /**
     * 指定格式时间转换 14:00-15:00
     *
     * @return 15:00:00
     */
    public static String dateConversion(String date) {
        return date.substring(6) + ":00";
    }


    /**
     * 日期格式为天的日期
     *
     * @param date
     * @return
     */
    public static Date formatDay(Date date) {
        return dateTime(YYYY_MM_DD, parseDateToStr(YYYY_MM_DD, date));
    }

    /**
     * 当前日期 和 时间范围判断
     *
     * @param date
     * @param startDate
     * @param endDate
     * @return -1 小于  0 等于 1大于
     */
    public static int betweenDateRange(Date date, Date startDate, Date endDate) {
        long dateTime = date.getTime();
        long taskVisitStartTime = startDate.getTime();
        long taskVisitEndTime = endDate.getTime();
        if (dateTime < taskVisitStartTime) {
            return -1;
        }
        if (dateTime >= taskVisitStartTime && dateTime <= taskVisitEndTime) {
            return 0;
        }
        if (dateTime > taskVisitEndTime) {
            return 1;
        }
        return -1;
    }

    /**
     * 当日则只显示时分，当日-1则显示昨天，当日-2至当日-6则显示星期N，当日-7开始显示年月日
     *
     * @param inputDate
     * @return
     */
    public static String geSpecialDate(Date inputDate) {
        return geSpecialDate(inputDate, false);
    }

    /**
     * 如当日则只显示时分，当日-1则显示昨天+时分，当日-2至当日-6则显示星期N+时分，当日-7开始显示年月日
     *
     * @param inputDate
     * @return
     */
    public static String geSpecialDateTime(Date inputDate) {
        return geSpecialDate(inputDate, true);
    }

    /**
     * 如当日则只显示时分，当日-1则显示昨天+时分，当日-2至当日-6则显示星期N+时分，当日-7开始显示年月日
     *
     * @param inputDateStr yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String geSpecialDateTime(String inputDateStr) {
        return geSpecialDate(dateTime(YYYY_MM_DD_HH_MM_SS, inputDateStr), true);
    }

    /**
     * 当日则只显示时分，当日-1则显示昨天，当日-2至当日-6则显示星期N，当日-7开始显示年月日
     *
     * @param inputDate
     * @param yesterdayTime 当日-1则显示昨天 格式：是否待时分
     * @return
     */
    public static String geSpecialDate(Date inputDate, boolean yesterdayTime) {
        if (Objects.isNull(inputDate)) {
            return StringUtils.EMPTY;
        }
        String hhmm = DateUtils.parseDateToStr(HH_MM, inputDate);
        Date targetDate = dateTime(YYYY_MM_DD, dateTime(inputDate));
        Date currentDate = dateTime(YYYY_MM_DD, dateTime(new Date()));
        int diff = calculateTimeDiff(targetDate, currentDate);
        int diffDays = Math.abs(diff);
        if (diffDays == 0) {
            //格式：时分
            return hhmm;
        } else if (diffDays == 1) {
            //格式：昨天
            return "昨天" + (yesterdayTime ? " " + hhmm : "");
        } else if (diffDays >= 2 && diffDays <= 6) {
            //格式：周几
            return dateToWeek(inputDate) + (yesterdayTime ? " " + hhmm : "");
        } else {
            //格式：年月日
            return dateTime(inputDate);
        }
    }

    /**
     * 输入日期是周几
     *
     * @param datetime
     * @return
     */
    public static String dateToWeek(Date datetime) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(datetime);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }


}
