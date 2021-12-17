package com.dn.test;

import com.alibaba.fastjson.JSON;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName:ListGroupBy
 * Package:com.dn.test
 * Description:
 *
 * @Date:2021/11/20 14:05
 * @Author: mark
 */
public class ListGroupBy {
    public static void main(String[] args) {
        List<Score> scoreList = new ArrayList<>();
        scoreList.add(new Score("001", "2018", 100.0));
        scoreList.add(new Score("001", "2019", 59.5));
        scoreList.add(new Score("001", "2019", 99.0));
        scoreList.add(new Score("002", "2018", 99.6));
        //根据scoreYear字段进行分组
        Map<String, List<Score>> map = scoreList.stream().collect(
                Collectors.groupingBy(
                        score -> score.getScoreYear()
                ));
        System.out.println(JSON.toJSONString(map));

        Map<String, List<Score>> map2 = scoreList.stream().collect(
                Collectors.groupingBy(
                        score -> score.getScoreYear() + '-' + score.getStudentId()
                ));

        System.out.println(JSON.toJSONString(map2));


        System.out.println("当前时间: " + dayToString(new Date()));

        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String number = "No" + sdf.format(new Date());
        System.out.println("number=====" + number+"==="+number.length());


    }

    public static String currTime() {
        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        return sdfs.format(calendar.getTime());
    }

    public static String dayToString(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(date);
    }

}
