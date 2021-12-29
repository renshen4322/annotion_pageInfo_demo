package com.dn.test.merge;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Data
public class BillsNums {
    private String id;
    private String name;
    private int nums;
    private int sums;



    public static void main(String[] args) {

        List<BillsNums> billsNumsList = new ArrayList<>();
        BillsNums billsNums = new BillsNums();
        billsNums.setId("1001");
        billsNums.setName("aa");
        billsNums.setNums(2);
        billsNums.setSums(100);
        billsNumsList.add(billsNums);

        BillsNums billsNums2 = new BillsNums();
        billsNums2.setId("1001");
        billsNums2.setName("aa");
        billsNums2.setNums(3);
        billsNums2.setSums(100);
        billsNumsList.add(billsNums2);
        BillsNums billsNums3= new BillsNums();

        billsNums3.setId("1002");
        billsNums3.setName("aa");
        billsNums3.setNums(6);
        billsNums3.setSums(800);
        billsNumsList.add(billsNums3);

        List<BillsNums> result = merge2(billsNumsList);
        System.out.println("result:" + JSON.toJSONString(result, true));

    }

    public static List<BillsNums> merge(List<BillsNums> list) {
        Map<String, BillsNums> map = new HashMap<>();
        list.stream()
                .forEach(billsNums -> {
                    BillsNums last = map.get(billsNums.getId());
                    if(null != last){
                        billsNums.setName(billsNums.getName());
                        billsNums.setSums(billsNums.getSums() + last.getSums());
                        billsNums.setNums(billsNums.getNums() + last.getNums());
                        map.put(billsNums.getId(), billsNums );
                    }else{
                        map.put(billsNums.getId(), billsNums);
                    }
                });
        return map.values().stream().collect(Collectors.toList());

    }

    /**
     * 将id进行合并nums, sums 相加道回合并后的集合使用Java8的流进行处理
     */
    public static List<BillsNums> merge2(List<BillsNums> list) {
        List<BillsNums> result = list.stream()
                // 表示id为key， 接着如果有重复的，那么从BillsNums对象o1与o2中筛选出一个，这里选择o1，
                // 并把id重复，需要将nums和sums与o1进行合并的o2, 赋值给o1，最后返回o1
                .collect(Collectors.toMap(BillsNums::getId, a -> a, (o1,o2)-> {
                    o1.setNums(o1.getNums() + o2.getNums());
                    o1.setSums(o1.getSums() + o2.getSums());
                    return o1;
                })).values().stream().collect(Collectors.toList());
        return result ;
    }


}
