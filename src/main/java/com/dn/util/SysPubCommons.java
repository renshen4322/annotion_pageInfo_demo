package com.dn.util;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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

    public static final String PATTERN_YEAR = "yyyy";
    public static final String PATTERN_YEARMONTH = "yyyyMM";
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATETIME_AA = "yyyy-MM-dd hh:mm:ssaa";
    public static final String SIGN_SIGN_DATATIME = "yyyyMMddHHmmss";
    public static final String PATTERN_DATETIME_ = "yyyy/MM/dd HH:mm:ss";

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
     * 将某个系统日期转换为时间戳
     * @return
     * @throws Exception
     */
    public static int GetCurrentTimeInt(String strConvertTime)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strConvertTime,formatter);

        int iNowTime = (int)nowtime.toEpochSecond(ZoneOffset.of("+8"));

        return iNowTime;
    }

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
    public static String GetBeforeConvertMonthTime(String strNowTime,Long addMonth,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        LocalDateTime minunow = nowtime.minusMonths(addMonth);

        String strConvertNowTime = minunow.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    /**
     * 将某个时间转换为固定格式(按照日期)
     * @param strNowTime
     * @param strForMat
     * @return
     */
    public static String GetAfterConvertDayTime(String strNowTime,Long addDays,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        LocalDateTime minunow = nowtime.plusDays(addDays);

        String strConvertNowTime = minunow.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    /**
     * 将某个时间转换为固定格式(按照日期)
     * @param strNowTime
     * @param strForMat
     * @return
     */
    public static String GetAfterConvertMinuteTime(String strNowTime,Long addMinutes,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        LocalDateTime minunow = nowtime.plusMinutes(addMinutes);

        String strConvertNowTime = minunow.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    public static String changeFormat(String dateStr, String pattern, String newPattern) {
        String dateStrNew = "";
        try {
            Date date = new SimpleDateFormat(pattern).parse(dateStr);
            dateStrNew = formatDate(date, newPattern);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStrNew;
    }

    /**
     * 格式化日期时间
     *
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * yyyyMMddHHmmss 日期格式化指定格式
     * */
    public static String GetConvertFormatTime(String strNowTime,String strForMat)
    {
        String strNowTimeTmep = strNowTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        LocalDateTime nowtime = LocalDateTime.parse(strNowTimeTmep,formatter);

        String strConvertNowTime = nowtime.format(DateTimeFormatter.ofPattern(strForMat));

        return strConvertNowTime;
    }

    /**
     * 获取闭区间内随机数返回int类型
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机数
     */
    public static int getRandomIntInRange(int min, int max)
    {
        return ThreadLocalRandom.current().ints(min, (max + 1)).limit(1).findFirst().getAsInt();
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
     * 获取闭区间内随机数返回int类型
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机数
     */
    public static int GetRandomIntInRange(int min, int max)
    {
        return ThreadLocalRandom.current().ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意三个参数的时间格式要一致
     * @param nowTime
     * @param startTime
     * @param endTime
     * @return 在时间段内返回true，不在返回false
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }
}
