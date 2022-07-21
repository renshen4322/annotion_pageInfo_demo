package com.dn.util;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @date 2020/5/7 18:30
 * 用于系统公共逻辑处理类比如 获取日期 生成公共的响应类等
 */
public class SysPubCommons
{
    /**
     * 获取当前系统时间
     * @param strForMat
     * @return
     * @throws Exception
     */
    public static String GetCurrentTime(String strForMat)
    {
        LocalDateTime now = LocalDateTime.now();

        String strNowTime = now.format(DateTimeFormatter.ofPattern(strForMat));

        return strNowTime;
    }

    /**
     * 获取当前系统时间
     * @param strForMat
     * @return
     * @throws Exception
     */
    public static String GetCurrentTime(String strNowTime,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        String strNowConvertTime = nowtime.format(DateTimeFormatter.ofPattern(strForMat));

        return strNowConvertTime;
    }

    /**
     * 获取当前系统时间戳
     * @return
     * @throws Exception
     */
    public static int GetCurrentTimeInt()
    {
        LocalDateTime now = LocalDateTime.now();

        int iNowTime = (int)now.toEpochSecond(ZoneOffset.of("+8"));

        return iNowTime;
    }


    /**
     * 获取当前系统时间戳
     * @return
     * @throws Exception
     */
    public static int GetCurrentTimeInt(String strNowTime)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        int iNowTime = (int)nowtime.toEpochSecond(ZoneOffset.of("+8"));

        return iNowTime;
    }

    /**
     * 获取当前系统时间戳
     * @return
     * @throws Exception
     */
    public static long GetCurrentTimeMillInt()
    {
        LocalDateTime now = LocalDateTime.now();

        long iNowTime = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        return iNowTime;
    }

    /**
     * 将时间戳转为日期
     * @param signtime
     * @param strForMat
     * @return
     */
    public static String ConvertSignTimeToDate(int signtime,String strForMat)
    {
        LocalDateTime now = LocalDateTime.ofInstant(Instant.ofEpochSecond(signtime), ZoneId.of("+8"));

        String strNowTime = now.format(DateTimeFormatter.ofPattern(strForMat));

        return strNowTime;
    }

    /**
     * 将某个时间转换为固定格式(按照日期)
     * @param strNowTime
     * @param strForMat
     * @return
     */
    public static String GetBeforeConvertTime(String strNowTime,Long addDay,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        LocalDateTime minunow = nowtime.minusDays(addDay);

        String strConvertNowTime = minunow.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    /**
     * 将某个时间转换为固定格式(按照日期)
     * @param strNowTime
     * @param strForMat
     * @return
     */
    public static String GetAfterConvertTime(String strNowTime,Long addDay,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        LocalDateTime minunow = nowtime.plusDays(addDay);

        String strConvertNowTime = minunow.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    /**
     * 将某个时间转换为固定格式(按照日期)
     * @param strNowTime
     * @param strForMat
     * @return
     */
    public static String GetBeforeConvertHourTime(String strNowTime,Long addHour,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        LocalDateTime minunow = nowtime.minusHours(addHour);

        String strConvertNowTime = minunow.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    /**
     * 将某个时间转换为固定格式(按照日期)
     * @param strNowTime
     * @param strForMat
     * @return
     */
    public static String GetAfterConvertHourTime(String strNowTime,Long addHour,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        LocalDateTime minunow = nowtime.plusHours(addHour);

        String strConvertNowTime = minunow.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    /**
     * 将某个时间转换为固定格式(按照日期)
     * @param strNowTime
     * @param strForMat
     * @return
     */
    public static String GetConvertTime(String strNowTime,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        String strConvertNowTime = nowtime.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }


    /**
     * 将某个时间转换为固定格式(按照日期)
     * @param strNowTime
     * @param strForMat
     * @return
     */
    public static String GetConvertTimeEx(String strNowTime,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        String strConvertNowTime = nowtime.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    public static String timePastSomeSecond(String otime,int second) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date dt = sdf.parse(otime);

            Calendar newTime = Calendar.getInstance();

            newTime.setTime(dt);

            newTime.add(Calendar.SECOND, second);

            Date dt1 = newTime.getTime();

            String retval = sdf.format(dt1);

            return retval;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return otime;
    }

        /**
     * 定义公共的对象Json格式(重载函数)
     * @param strStatus
     * @param strMsg
     * @return
     */
    public static PubRespJsonObj GetJsonObj(String strStatus,String strMsg)
    {
        PubRespJsonObj jsonObj = new PubRespJsonObj();

        jsonObj.setResult(strStatus);
        jsonObj.setMsg(strMsg);

        return jsonObj;
    }

    /**
     * 定义公共的对象Json格式(重载函数)
     * @param strStatus
     * @param strMsg
     * @param strNormal
     * @return
     */
    public static PubRespJsonObj GetJsonObj(String strStatus,String strMsg,String strNormal)
    {
        PubRespJsonObj jsonObj = new PubRespJsonObj();

        jsonObj.setResult(strStatus);
        jsonObj.setMsg(strMsg);
        jsonObj.setNormalinfo(strNormal);

        return jsonObj;
    }

    /**
     * 定义公共的对象Json格式(重载函数)返回单个对象
     * @param strStatus
     * @param strMsg
     * @return
     */
    public static PubRespJsonObj GetJsonObj(String strStatus,String strMsg,Object obj)
    {
        PubRespJsonObj jsonObj = new PubRespJsonObj();

        jsonObj.setResult(strStatus);
        jsonObj.setMsg(strMsg);
        jsonObj.setData(obj);

        return jsonObj;
    }

    /**
     * 定义公共的对象Json格式(重载函数)
     * @param strStatus
     * @param strMsg
     * @return
     */
    public static PubRespJsonObj GetJsonObj(String strStatus,String strMsg,String strNormal,Object obj)
    {
        PubRespJsonObj jsonObj = new PubRespJsonObj();

        jsonObj.setResult(strStatus);
        jsonObj.setMsg(strMsg);
        jsonObj.setNormalinfo(strNormal);
        jsonObj.setData(obj);

        return jsonObj;
    }


    /**
     * 获取客户端真实的IP地址
     * @param request
     * @return
     */
    public static String GetRemoteAdress(HttpServletRequest request)
    {
        //获取客户端的IP地址
        String remoteAddr = request.getHeader("x-forwarded-for");

        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr))
        {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }
        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr))
        {
            remoteAddr = request.getHeader("X-Real-Ip");
        }
        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr))
        {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }
        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr))
        {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr))
        {
            remoteAddr = request.getRemoteAddr();
        }


        if(remoteAddr.indexOf(',') != -1)
        {
            String[] AddrArray = remoteAddr.split(",");

            if(AddrArray != null)
            {
                if(AddrArray.length > 0)
                {
                    remoteAddr = AddrArray[0];
                }
            }
        }

        if(remoteAddr == null)
        {
            remoteAddr = "127.0.0.1";
        }

        return remoteAddr;
    }

    /**
     * 生成验证码
     * @param maxleng
     * @return
     */
    public static String CreateYanZhengMa(int maxleng)
    {
        String strYZM = "";

        StringBuffer strYZMBuffer = new StringBuffer();

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for(int i = 0; i < maxleng; i++)
        {
            int iValue = random.nextInt(0, 10);

            strYZMBuffer.append(iValue);
        }

        strYZM = strYZMBuffer.toString();

        return strYZM;
    }

    /**
     * 根据随机种子获取随机数
     * @param min
     * @param max
     * @return
     */
    public static int CreateRandom(int min,int max)
    {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        int iValue = random.nextInt(min, max);

        return iValue;
    }

    /**
     * 生成N位随机数
     * @param maxleng
     * @return
     */
    public static String CreateJWTRadom(int maxleng)
    {
        String strJWT = "";

        StringBuffer strYZMBuffer = new StringBuffer();

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for(int i = 0; i < maxleng; i++)
        {
            int iValue = random.nextInt(0, 10);

            strYZMBuffer.append(iValue);
        }

        strJWT = strYZMBuffer.toString();

        return strJWT;
    }


    /**
     * 将手机号中间4位替换成*
     * @param strMobilePhone
     * @return
     */
    public static String DealMobilPhone(String strMobilePhone)
    {
        String strNewPhone = "";

        if(strMobilePhone == null || "".equals(strMobilePhone))
        {
            return strNewPhone;
        }
        else
        {
            strNewPhone = strMobilePhone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");

            return strNewPhone;
        }
    }


    /**
     * 对请求的URL进行编码处理
     * @param strurl
     * @return
     */
    public static String UrlEncode(String strurl)
    {
        String retUrlStr = "";

        try
        {
            retUrlStr = URLEncoder.encode(strurl, "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            return retUrlStr;
        }

        return retUrlStr;
    }

    /**
     * 对请求的URL进行编码处理
     * @param strurl
     * @return
     */
    public static String UrlDcode(String strurl)
    {
        String retUrlStr = "";

        try
        {
            retUrlStr = URLDecoder.decode(strurl, "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            return retUrlStr;
        }

        return retUrlStr;
    }

    public static String getFixPintuanTicketCode(String pintuanTypeCode){
        switch (pintuanTypeCode){
            case "20210620104" : return "PTQ2100001";   //钻石2000
            case "20210620103" : return "PTQ2100002";   //黄金1500
            case "20210620102" : return "PTQ2100003";    //白银800
            case "20210620101" : return "PTQ2100004";    //青铜400
            case "20210620100" : return "PTQ2100005";    //新人200
            default: return "0";
        }
    }
}
