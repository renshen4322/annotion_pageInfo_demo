package com.dn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName:ReplaceUtils
 * Package:com.dn.util
 * Description:
 *
 * @Date:2021/11/18 14:17
 * @Author: mark
 */
public class ReplaceUtils {
    public static void main(String[] args) {
        //1.获取模板
        String str = "欢迎用户:${user},您的密码${password}";
        System.out.println("替换前的字符:" + str);
        //2.截取关键字符 ${user} ${password}
        String spliteStr = getContentInfo(str);
        //3.查找准备进行替换的参数 阿呆,123456
        String spliteRepliceStr = checkStr(spliteStr);
        //4.替换模板中的内容
        String replaceStr = ReplaceStr(str, spliteStr, spliteRepliceStr);
        System.out.println("替换后的字符:" + replaceStr);

    }

    /**
     * 替换${}符号中的数据
     *
     * @param str   例如:欢迎用户:${user},您的密码${password}
     * @param param user,password
     * @param data  阿呆,123456
     * @return 替换后的字符串
     */
    private static String ReplaceStr(String str, String param, String data) {
        //将要替换的参数转成数组
        String[] params = param.split(",");
        String[] datas = data.split(",");
        //替换原字符串
        for (int i = 0; i < params.length; i++) {
            str = str.replace("${" + params[i] + "}", datas[i]);
        }
        return str;
    }


    /**
     * 模拟取出数据
     * @param spliteStr
     * @return 阿呆,123456
     */
    private static String checkStr(String spliteStr) {
        String[] strings = spliteStr.split(",");
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            switch (string) {
                case "user":
                    String username = "阿呆";
                    stringBuffer.append(username + ",");
                    break;
                case "password":
                    String password = "123456";
                    stringBuffer.append(password + ",");
                    break;
            }

        }
        //替换的数据 以,分割
        String nowStr = stringBuffer.toString();
        return nowStr;
    }


    /**
     * 获取表达式中${}中的值
     *
     * @param content
     * @return
     */
    static Pattern regex = Pattern.compile("\\$\\{([^}]*)\\}");

    /**
     * 查找${}中的参数
     * @param content
     * @return
     */
    public static String getContentInfo(String content) {
        Matcher matcher = regex.matcher(content);
        StringBuilder sql = new StringBuilder();
        while (matcher.find()) {
            sql.append(matcher.group(1) + ",");
        }
        if (sql.length() > 0) {
            sql.deleteCharAt(sql.length() - 1);
        }
        return sql.toString();
    }

}
