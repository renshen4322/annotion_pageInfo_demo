package com.dn.test;

import com.alibaba.fastjson.JSON;
import com.dn.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:TestClass1
 * Package:com.dn.test
 * Description:
 *
 * @Date:2021/11/8 21:38
 * @Author: mark
 */
public class TestClass1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("疾病史：哮喘；癫痫");
        list.add("2");
        list.add("3");
       // list.add("[\"过敏源名称4\"]");

        System.out.println(JSON.toJSONString(list));
        System.out.println(StringUtils.strip(list.toString(),"[]"));

    }
}
