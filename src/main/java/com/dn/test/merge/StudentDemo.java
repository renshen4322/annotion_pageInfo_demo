package com.dn.test.merge;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentDemo {
    public static void main(String[] args) {
        List<StudentOne> list = new ArrayList<StudentOne>();


        StudentOne one = new StudentOne("第一", "北京", 12);
        StudentOne two = new StudentOne("第二", "上海", 15);
        StudentOne three = new StudentOne("第三", "南京", 9);

        list.add(one);
        list.add(two);
        list.add(three);

        List<StudentTwo> newList = list.stream().map(e -> new StudentTwo(e.getName(), e.getCity(),e.getAge())).collect(Collectors.toList());
        newList.stream().forEach(c -> {
                System.out.println(c.getName()+"---"+c.getCity());
        });
        List<Map<String, Object>> dbList = new ArrayList<>();
        Map map1 = new HashMap<>();
        map1.put("id", "1");
        map1.put("assort_no", "11111");
        map1.put("name", "test");
        map1.put("leve1", "high");
        map1.put("leve1Desc", "高风险");
        dbList.add(map1);

        Map map2 = new HashMap<>();
        map2.put("id", "2");
        map2.put("assort_no", "11111");
        map2.put("name", "test");
        map2.put("leve1", "low");
        map2.put("leve1Desc", "低风险1");
        dbList.add(map2);


        Map map3 = new HashMap<>();
        map3.put("id", "3");
        map3.put("assort_no", "11222");
        map3.put("name", "test2");
        map3.put("leve1", "low");
        map3.put("leve1Desc", "低风险2");
        dbList.add(map3);

        Map map4 = new HashMap<>();
        map4.put("id", "4");
        map4.put("assort_no", "11111");
        map4.put("name", "test");
        map4.put("leve1", "low");
        map4.put("leve1Desc", "低风险3");
        dbList.add(map4);

        Map map5 = new HashMap<>();
        map5.put("id", "5");
        map5.put("assort_no", "11111");
        map5.put("name", "test");
        map5.put("leve1", "high");
        map5.put("leve1Desc", "高风险5");
        dbList.add(map5);

        for (Map<String, Object> m : dbList) {
            List high = new ArrayList<String>();
            List low = new ArrayList<String>();
            for (Map<String, Object> mm : dbList) {
                if (mm.get("assort_no").toString().equals(m.get("assort_no").toString())) {
                    if ("high".equals(mm.get("leve1").toString())) {
                        high.add(mm.get("leve1Desc").toString());
                    } else if ("low".equals(mm.get("leve1").toString())) {
                        low.add(mm.get("leve1Desc").toString());
                    }
                }
            }
            m.put("high", high);
            m.put("low", low);
        }

        dbList.forEach(m -> {
            System.out.println(JSON.toJSON(m));
        });

        Map<String, Object> mapResult=new HashMap<>();
        for (Map<String, Object> m : dbList) {
            mapResult.put(m.get("assort_no").toString(),m);
        }
        System.out.println("========================去重后==========================");
        mapResult.forEach((k,v) -> {
            System.out.println(JSON.toJSON(v));
        });

    }
}
