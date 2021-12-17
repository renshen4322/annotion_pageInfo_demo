package com.dn.test;

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
    }
}
