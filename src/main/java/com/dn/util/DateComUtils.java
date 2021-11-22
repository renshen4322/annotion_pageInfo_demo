package com.dn.util;

import com.dn.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @description:
 * @author: zhp
 * @create: 2021-06-11 10:35
 **/
@Slf4j
public class DateComUtils {
    //public static void main(String[] args) {

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
        //
        ////addDay(sdf,10);
        //
        //getWeekDay(sdf);
        //
        //getMonth(sdf);
        //
        //getLastMonthLastDay(sdfs);
        //
        //getLastMonthFirstDay(sdfs);
        //getThisMonthFirstDay(sdfs);
        //getThisweekFirstDay(sdfs);
        //getlastweekFirstDay(sdfs);
        //
        //DateTime parse = DateUtil.parse("2021-07-14 23:05:06", "yyyy-MM-dd HH:mm:ss");
        //String handleDate02 = handleDate02(parse.getTime());
        //System.out.println(handleDate02);

    //    System.out.println(secToTime(1160));
    //}

    /**
     * 秒转 分：秒  /时：分：秒  格式
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
        }else {
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

        log.info("当前时间: " + sdf.format(calendar.getTime()));


        //给当前时间加上天数days并输出，这里的第一个参数用以下三个都可以

        Calendar calendar1 = Calendar.getInstance();

        calendar1.add(Calendar.DAY_OF_YEAR, days);

        log.info("加了" + days + "天之后的时间: " + sdf.format(calendar1.getTime()));


        Calendar calendar2 = Calendar.getInstance();

        calendar2.add(Calendar.DAY_OF_MONTH, days);

        log.info("加了" + days + "之后的时间: " + sdf.format(calendar2.getTime()));


        Calendar calendar3 = Calendar.getInstance();

        calendar3.add(Calendar.DAY_OF_WEEK, days);

        log.info("加了" + days + "之后的时间: " + sdf.format(calendar3.getTime()));

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

        log.info("当前时间: " + sdf.format(calendar.getTime()));


        //本周一

        Calendar calendar1 = Calendar.getInstance();

        calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        log.info("本周一: " + sdf.format(calendar1.getTime()));

        //本周日

        Calendar calendar2 = Calendar.getInstance();

        //外国的星期天和我们的不在一周(外国是星期天到星期六为一个星期)

        calendar2.add(Calendar.DAY_OF_WEEK, 7);

        calendar2.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        log.info("本周日: " + sdf.format(calendar2.getTime()));


        //下周一

        Calendar calendar3 = Calendar.getInstance();

        calendar3.add(Calendar.DAY_OF_MONTH, 7);

        calendar3.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        log.info("下周一: " + sdf.format(calendar3.getTime()));

        //下周日

        Calendar calendar4 = Calendar.getInstance();

        calendar4.add(Calendar.DAY_OF_MONTH, 14);

        calendar4.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        log.info("下周日: " + sdf.format(calendar4.getTime()));


        //上周一

        Calendar calendar5 = Calendar.getInstance();

        calendar5.add(Calendar.DAY_OF_YEAR, -7);

        calendar5.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        log.info("上周一: " + sdf.format(calendar5.getTime()));

        //上周日

        Calendar calendar6 = Calendar.getInstance();

        calendar6.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        log.info("上周日: " + sdf.format(calendar6.getTime()));

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

        log.info("当前时间: " + sdf.format(calendar.getTime()));


        //当月一号

        Calendar calendar1 = Calendar.getInstance();

        calendar1.set(Calendar.DAY_OF_MONTH, 1);

        log.info("本月第一天: " + sdf.format(calendar1.getTime()));

        //当月最后一天

        Calendar calendar2 = Calendar.getInstance();

        maxCurrentMonthDay = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar2.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

        log.info("本月最后一天: " + sdf.format(calendar2.getTime()));


        //下个月一号

        Calendar calendar3 = Calendar.getInstance();

        maxCurrentMonthDay = calendar3.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar3.add(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

        calendar3.set(Calendar.DAY_OF_MONTH, 1);

        log.info("下月第一天: " + sdf.format(calendar3.getTime()));

        //下个月最后一天

        Calendar calendar4 = Calendar.getInstance();

        maxCurrentMonthDay = calendar4.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar4.add(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

        //第一个maxCurrentMonthDay获取的是当月的天数，第二个maxCurrentMonthDay获取的是下个月的天数

        maxCurrentMonthDay = calendar4.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar4.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

        log.info("下月第一天: " + sdf.format(calendar4.getTime()));


        //上个月一号

        Calendar calendar5 = Calendar.getInstance();

        maxCurrentMonthDay = calendar5.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar5.add(Calendar.DAY_OF_MONTH, -maxCurrentMonthDay);

        calendar5.set(Calendar.DAY_OF_MONTH, 1);

        log.info("上月第一天: " + sdf.format(calendar5.getTime()));

        //上个月最后一天

        Calendar calendar6 = Calendar.getInstance();

        maxCurrentMonthDay = calendar6.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar6.add(Calendar.DAY_OF_MONTH, -maxCurrentMonthDay);

        //第一个maxCurrentMonthDay获取的是当月的天数，第二个maxCurrentMonthDay获取的是上个月的天数

        maxCurrentMonthDay = calendar6.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar6.set(Calendar.DAY_OF_MONTH, maxCurrentMonthDay);

        log.info("上月第一天: " + sdf.format(calendar6.getTime()));
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

        log.info("上月第一天: " + simpleDateFormat.format(calendar5.getTime()));
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

        log.info("上月第一天: " + simpleDateFormat.format(calendar6.getTime()));
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
        log.info("本月第一天: " + simpleDateFormat.format(calendar1.getTime()));
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
        log.info("本周一: " + simpleDateFormat.format(calendar1.getTime()));
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
        log.info("上周一: " + simpleDateFormat.format(calendar5.getTime()));
        return simpleDateFormat.format(calendar5.getTime());
    }

    /**
     * 输入时间到当前时间相隔多少天
     *
     * @param date
     * @return
     */
    public static Integer getDays(Date date) {

        long datetime = date.getTime();//时间转换成毫秒值

        long todaytime = System.currentTimeMillis();//获取当前日期毫秒值

        long Difference = todaytime - datetime;//差值

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
     * 传入日期+几天
     *
     * @param date
     * @param day
     * @return
     */
    public static String addDay(String dateStr, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dateStr);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, day);//把日期往后增加一天.整数往后推,负数往前移动
            date = calendar.getTime();   //这个时间就是日期往后推一天的结果
            String putDate = sdf.format(date); //增加一天后的日期
            return putDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    /**
     * 周一 周二 转数字
     *
     * @param week
     * @return
     */
    public static Integer getWeekToNum(String week) {
        if (StringUtils.isNotBlank(week)) {
            switch (week) {
                case "周一": {
                    return 1;
                }
                case "周二": {
                    return 2;
                }
                case "周三": {
                    return 3;
                }
                case "周四": {
                    return 4;
                }
                case "周五": {
                    return 5;
                }
                case "周六": {
                    return 6;
                }
                case "周日": {
                    return 7;
                }
            }
        }
        return 1;
    }
    /**
     * 数字 转 周一 周二
     *
     * @param week
     * @return
     */
    public static String getNumToWeek(Integer week) {
        if (null!=week) {
            switch (week) {
                case 1: {
                    return "周一";
                }
                case 2: {
                    return "周二";
                }
                case 3: {
                    return "周三";
                }
                case 4: {
                    return "周四";
                }
                case 5: {
                    return  "周五";
                }
                case 6: {
                    return "周六";
                }
                case 7: {
                    return "周日";
                }
            }
        }
        return "周一";
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
     * 获取当月的 天数
     */
    public static int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;

    }

    /**
     * 获取当前月
     * @return 8 则为八月
     */
    public static int getThatMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 获取当月的天数
     */
    public static int getCurrentMonthDayByMonth() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;

    }
    /**
     * 根据年月日
     * 获取该日期对应月份天数
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
     * @param num 减去几个月
     * @return
     */
    public static Integer getLastMonthByMonthToDay(Integer num) {
        return getDaysOfMonth(getLastMonthByMonth(num));
    }

    /**
     * 获取当前年份
     * @return 2021
     */
    public static String getYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
    }

    /**
     * 获取当年月日
     * @return 2021-08-03
     */
    public static String getDay() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 获取当前时间年月日时分秒
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
     * @return true
     */
    public static boolean dateCompareNewDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime= null;
        Date endTime= null;
        try {
            startTime = format.parse(date);
            endTime= format.parse(getNewDate());
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
     * @return true
     */
    public static boolean dateCompareDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime= null;
        Date endTime= null;
        try {
            startTime = format.parse(date);
            endTime= format.parse(getNewDate());
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
     * @return 15:00:00
     */
    public static String dateConversion(String date) {
        return date.substring(6)+":00";
    }
}
