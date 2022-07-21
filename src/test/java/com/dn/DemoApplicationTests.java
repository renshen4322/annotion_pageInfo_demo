package com.dn;

import com.dn.util.TypeConvertUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        String str = "platform_payinfo_payqueryinfo_202212";
        String t1 = str.split("_")[3];
        System.out.println(t1);
    }

    @Test
    public void DateplusDaystimeTest() {
        //获取当前年月日
        LocalDate localDate = LocalDate.now().plusDays(1);
        String st1 = localDate.toString();
        System.out.println("st1==============" + st1);
        LocalDate localDate2 = LocalDate.now().plusDays(2);
        String st2 = localDate2.toString();
        System.out.println("st1==============" + st2);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(date));

        Date dateTimes = new Date();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMM");
        String currMonth = dateFormat2.format(dateTimes);

        System.out.println("===========currMonth========" + currMonth);

        List<String> a = new ArrayList<>();
        a.add("test1");
        System.out.println("=============a=== " + a.size());

        int userSuccess = 1;
        if (userSuccess == 1) {
            //当月用户添加到redis中,set自动去重
            System.out.println("result===============" + "aaa");
        } else {
            System.out.println("result===============" + "bbbb");
        }


    }

    @Test
    public void testTow() {
        LocalDateTime ofTime = LocalDateTime.of(2019, 10, 1, 8, 8, 8);
        System.out.println("当前精确时间：" + ofTime);


        LocalTime localTime = LocalTime.of(12, 01, 01);
        System.out.println("当天时间：" + localTime);

        // 获取当前日期并格式化
        String localDate2 = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        System.out.println("当前日期：" + localDate2);

        LocalDate localDate = LocalDate.of(2022, 6, 1);
        // localDate.plusDays(1);
        System.out.println("当前日期：localDate== " + localDate);
        String formatetime = localDate + " 00:00:00";
        String TempQueryTime = GetAfterConvertDayTime(formatetime, Long.valueOf(30), "yyyy-MM-dd");
        System.out.println("============六一========:" + TempQueryTime);


    }

    public String GetAfterConvertDayTime(String strNowTime, Long addDays, String strForMat) {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep, formatter);

        LocalDateTime minunow = nowtime.plusDays(addDays);

        String strConvertNowTime = minunow.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    @Test
    public void testTree() {
        LocalDate sixOneDate = LocalDate.of(2022, 6, 1);
        String nextDate = sixOneDate.plusDays(2).format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        System.out.println(nextDate);
        Instant instant2 = sixOneDate.plusDays(30).atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant();
        Date thirtyDays = Date.from(instant2);
        System.out.println("thirtyDay=====" + thirtyDays); //7-01
        LocalDate currData = LocalDate.now();
        String LocalDate = currData.plusDays(1).format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        System.out.println("LocalDate=====" + LocalDate); //7-01

    }

    @Test
    public void test_TwoDatesDiffBeforeJava8()
            throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date firstDate = sdf.parse("2019-07-24");
        Date secondDate = sdf.parse("2019-07-30");

        long diffInMillis = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        System.out.println("diff=====" + diff);

        LocalDate currData = LocalDate.now();
        System.out.println("currData======" + currData);
    }

    @Test
    public void test999() {
        LocalDate date = LocalDate.now().plusDays(0);
        System.out.println(date);

        LocalDate currDate2 = LocalDate.of(2022, 6, 6);
        LocalDate currDate = LocalDate.now();

        // 当月第一天
        LocalDate firstDayOfMonth = currDate.with(TemporalAdjusters.firstDayOfMonth());

        // 当月最后一天
        LocalDate lastDayOfMonth = currDate.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("=====firstDayOfMonth==" + firstDayOfMonth);
        System.out.println("=====lastDayOfMonth====" + lastDayOfMonth);

        String strTableFix = String.valueOf(Integer.parseInt("1212800025") % 10);
        System.out.println("strTableFix====================" + strTableFix);

    }

    /**
     * 相差天数计算
     */
    public int differentDaysByMillisecond(Date date1, Date date2) {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }


    public Date getExchangeTime(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(time);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return date;
    }

    @Test
    public void TestDateInfo() {
        LocalDate lastDay = TypeConvertUtils.getLastDayOfCurrMonth();
        String lastMonthForCurr = lastDay.format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println(String.format("当前月的最后一天为：%s", lastDay));
        System.out.println(String.format("当前年月：%s", lastMonthForCurr));
        final Calendar c = Calendar.getInstance();
        System.out.println("date======" + c.getActualMaximum(Calendar.DATE));
    }

    // @Scheduled(cron = "0 59 23 28-31 * ?") //每月最后一天
    @Test
    public void execute() {
        final Calendar c = Calendar.getInstance();
        if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {
            //是最后一天
            System.out.println("是最后一天！");
        }
    }
    // @Scheduled(cron = "0 28 0 1 * ?") //每月第一天 0点28分跑
    @Test
    public void execute2() {
        LocalDate curdate = TypeConvertUtils.getFirstDayOfCurrMonth();
        System.out.println(curdate.toString());

        final Calendar c = Calendar.getInstance();
        System.out.println("c.get(Calendar.DATE)====" + c.get(Calendar.DATE));
        System.out.println("c.getActualMinimum(Calendar.DATE)===" + c.getActualMinimum(Calendar.DATE));
        if (c.get(Calendar.DATE) == c.getActualMinimum(Calendar.DATE)) {
            //是第一天
            System.out.println("是第一天！");
        }
    }

    @Test
    public void testNum() throws Exception {
        Double groupUsers = 3.0/6 * 100; // Double.valueOf((3/6) * 100);
        System.out.println(groupUsers);

        LocalDate currData = LocalDate.now().plusDays(0);
        Instant instant = currData.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant();
        Date sameDate = Date.from(instant);
        String apDate = TypeConvertUtils.getTimeChangeStr(sameDate,"yyyyMMdd");
        String strDate = TypeConvertUtils.getTimeChangeStr(sameDate,"yyyy-MM-dd");
        String strMonth = TypeConvertUtils.getTimeChangeStr(sameDate,"yyyy-MM");
        System.out.println("apDate====="+apDate);
        System.out.println("strDate====="+strDate);
        System.out.println("strMonth====="+strMonth);

        BigDecimal strTopUpAmt = new BigDecimal(899.15); //- dayTotalCashAmt;
        BigDecimal strCashAmt = new BigDecimal(189.15);
        BigDecimal diffTopCash = strTopUpAmt.subtract(strCashAmt).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("diffTopCash==="+diffTopCash);

        String shengQingNum = CreateShenQingNumPrefix("",apDate,9L);
        System.out.println(shengQingNum);
    }

    public  String CreateShenQingNumPrefix(String runtime,String strNowDate,Long maxnum) throws Exception {
        StringBuffer strUserId = new StringBuffer();

        try
        {
            //将当前最大号空位补领
            String strNewRedPackgeId = String.format("%08d",maxnum);

            if("dev".equals(runtime))
            {
                strUserId.append("D");
            }

            strUserId.append("TX");
            strUserId.append(strNowDate);
            strUserId.append(strNewRedPackgeId);

            return strUserId.toString();
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }
    }

    @Test
    public void Test90902(){
        LocalDateTime starttime = LocalDateTime.parse("2022-07-10" + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endtime = LocalDateTime.parse("2022-07-16" + " 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Duration duration = Duration.between(starttime, endtime);
        long days = duration.toDays() + 1;
        System.out.println(days);
    }
}
