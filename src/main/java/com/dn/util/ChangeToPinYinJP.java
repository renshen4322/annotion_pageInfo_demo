package com.dn.util;

import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.springframework.stereotype.Component;

/**
 * ClassName:ChangeToPinYinJP
 * Package:com.dn.util
 * Description:
 *
 * @Date:2021/11/4 14:00
 * @Author: mark
 */
@Component
public class ChangeToPinYinJP {

    /**
     * 转换为有声调的拼音字符串
     * @param pinYinStr 汉字
     * @return 有声调的拼音字符串
     */
    public static String changeToMarkPinYin(String pinYinStr){

        String tempStr = null;

        try
        {
            tempStr =  PinyinHelper.convertToPinyinString(pinYinStr,  " ", PinyinFormat.WITH_TONE_MARK);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return tempStr;

    }


    /**
     * 转换为数字声调字符串
     * @param pinYinStr 需转换的汉字
     * @return 转换完成的拼音字符串
     */
    public String changeToNumberPinYin(String pinYinStr){

        String tempStr = null;

        try
        {
            tempStr = PinyinHelper.convertToPinyinString(pinYinStr, " ", PinyinFormat.WITH_TONE_NUMBER);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return tempStr;

    }

    /**
     * 转换为不带音调的拼音字符串
     * @param pinYinStr 需转换的汉字
     * @return 拼音字符串
     */
    public static String changeToTonePinYin(String pinYinStr){

        String tempStr = null;

        try
        {
            tempStr =  PinyinHelper.convertToPinyinString(pinYinStr, " ", PinyinFormat.WITHOUT_TONE);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return tempStr;

    }

    /**
     * 转换为每个汉字对应拼音首字母字符串
     * @param pinYinStr 需转换的汉字
     * @return 拼音字符串
     */
    public static char changeToFirstPinYin(String pinYinStr){

        String tempStr = null;

        try
        {
            tempStr = PinyinHelper.getShortPinyin(pinYinStr);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Character.valueOf(tempStr.charAt(0));

    }

    /**
     * 检查汉字是否为多音字
     * @param pinYinStr 需检查的汉字
     * @return true 多音字，false 不是多音字
     */
    public static boolean checkPinYin(char pinYinStr){

        boolean check  = false;
        try
        {
            check = PinyinHelper.hasMultiPinyin(pinYinStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    /**
     * 简体转换为繁体
     * @param pinYinStr
     * @return
     */
    public static String changeToTraditional(String pinYinStr){

        String tempStr = null;
        try
        {
            tempStr = ChineseHelper.convertToTraditionalChinese(pinYinStr);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return tempStr;

    }

    /**
     * 繁体转换为简体
     * @param pinYinSt
     * @return
     */
    public static String changeToSimplified(String pinYinSt){

        String tempStr = null;

        try
        {
            tempStr = ChineseHelper.convertToSimplifiedChinese(pinYinSt);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return tempStr;

    }

}
