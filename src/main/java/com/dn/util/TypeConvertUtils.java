package com.dn.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 定义double与BigDecimal转换的助手类
 * mark
 */
public class TypeConvertUtils {


    /**
     * BigDecimal转double
     *
     * @param decimal
     * @return
     */
    public static Double getBigDecimalToDouble(BigDecimal decimal) {
        BigDecimal big = new BigDecimal(String.valueOf(decimal));
        double d = big.doubleValue();
        return d;
    }

    /**
     * doublel转BigDecimal
     *
     * @param d
     * @return
     */
    public static BigDecimal getDoubleToBigDecimal(Double d) {
        BigDecimal big = new BigDecimal(Double.toString(d));
        return big;
    }

    /**
     * BigDecimal乘以整数
     *
     * @param itemQuantity
     * @param itemPrice
     * @return
     */
    public static BigDecimal calculateCost(Integer itemQuantity, BigDecimal itemPrice) {
        BigDecimal itemCost = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        itemCost = itemPrice.multiply(new BigDecimal(itemQuantity));
        totalCost = totalCost.add(itemCost);
        return totalCost;
    }

    public static BigDecimal keepTwoNumberDecimal(Double d) {
        BigDecimal bd = new BigDecimal(d);
        BigDecimal af = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return af;
    }

    public static Double keepTwoNumberDouble (Double d) {
        BigDecimal bd = new BigDecimal(d);
        Double af = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return af;
    }

    /**
     * String ===> Date
     *
     * @param time
     * @return
     */
    public static Date getExchangeTime(Date time, String strForMat) {
        SimpleDateFormat formatter = new SimpleDateFormat(strForMat);
        Date date = null;
        try {
            date = formatter.parse(String.valueOf(time));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转String
     *
     * @param dt
     * @return
     */
    public static String getTimeChangeStr(Date dt,String strForMat) {
        SimpleDateFormat formatter = new SimpleDateFormat(strForMat);
        String date = formatter.format(dt);//格式化数据
        return date;
    }

    /**
     * LocalDate转Date
     * @param localDate
     * @return
     */
    public static Date localDate2Date(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());

    }

    /**
     * Date转LocalDate
     * @param date
     */
    public static LocalDate date2LocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    }

    /**
     * Date转换为LocalDateTime
     * @param date
     */
    public static LocalDateTime date2LocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    /**
     * LocalDateTime转换为Date
     * @param localDateTime
     */
    public static Date localDateTime2Date( LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    /**
     * 相差天数计算
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }

    /**
     * 当月最后一天日期
     * @return
     */
    public static LocalDate getLastDayOfCurrMonth(){
        LocalDate currDate = LocalDate.now();
        LocalDate lastDayOfMonth = currDate.with(TemporalAdjusters.lastDayOfMonth());
        return lastDayOfMonth;
    }

}
