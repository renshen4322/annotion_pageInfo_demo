package com.dn.test;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;

/**
 * ClassName:Test88
 * Package:com.dn.test
 * Description:
 *
 * @Date:2021/12/15 20:43
 * @Author: mark
 */
public class Test88 {
    public static void main(String[] args) {

        String result = "99{882425}";
        if(result.startsWith("{")){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
        String str=String.format("Hello %s，我是 %s，今年 %s 岁", "CSDN","小猪","12");
        System.out.println(str);

       BigDecimal decimal = new BigDecimal(2.456);
        decimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(decimal);// 2.46

        LocalDate localDate = LocalDate.parse("2022-01-24");
//        第一个参数：一周的第一天，不能为空
//        第二个参数：第一周的最小天数，从1到7
        WeekFields weekFields = WeekFields.ISO;
        int weekNumber = localDate.get(weekFields.weekOfWeekBasedYear());
        System.out.println("weekOfYear==="+weekNumber);


    }
}
