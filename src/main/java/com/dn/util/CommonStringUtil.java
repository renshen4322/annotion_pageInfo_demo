package com.dn.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @Date:2022/7/19 10:11
 * @Author: mark
 */
public class CommonStringUtil {
    /**
     * 流水号
     *
     * @return
     */
    public static String createNumber() {
        Calendar nowtime = new GregorianCalendar();
        String strDateTime = "[" + String.format("%04d", nowtime.get(Calendar.YEAR)) + "/" +
                String.format("%02d", nowtime.get(Calendar.MONTH)) + "/" +
                String.format("%02d", nowtime.get(Calendar.DATE)) + " " +
                String.format("%02d", nowtime.get(Calendar.HOUR)) + ":" +
                String.format("%02d", nowtime.get(Calendar.MINUTE)) + ":" +
                String.format("%02d", nowtime.get(Calendar.SECOND)) + "." +
                String.format("%03d", nowtime.get(Calendar.MILLISECOND)) + "]";
        String msg = "";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
        int random = (int) ((Math.random() * 9 + 2) * 100);
        msg = sdf.format(date) + random;
        return msg;
    }

    /**
     * 中国电信号段 133、149、153、173、177、180、181、189、199
     * 中国联通号段 130、131、132、145、155、156、166、175、176、185、186
     * 中国移动号段 134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198
     * 其他号段
     * 14号段以前为上网卡专属号段，如中国联通的是145，中国移动的是147等等。
     * 虚拟运营商
     * 电信：1700、1701、1702
     * 移动：1703、1705、1706
     * 联通：1704、1707、1708、1709、171
     * 卫星通信：1349
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        boolean isMatch = false;
        if (phone.length() != 11) {
            System.out.println(("手机号应为11位数"));
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            isMatch = m.matches();
            if (!isMatch) {
                System.out.println("请填入正确的手机号");
            }

        }
        return isMatch;
    }

    /**
     * 是否100的倍数
     *
     * @param n
     * @return
     */
    public static boolean CheckDivisibilityBy100(int n) {
        return (n % 100 == 0) ? true : false;
    }

    /**
     * 自定义进制（选择你想要的进制数，不能重复且最好不要0、1这些容易混淆的字符）
     */
    /********************* 生成6位唯一的邀请码，根据id***********************/
    private static final char[] r = new char[]{'q', 'w', 'e', '8', 's', '2', 'd', 'z', 'x', '9', 'c', '7', 'p', '5', 'k', '3', 'm', 'j', 'u', 'f', 'r', '4', 'v', 'y', 't', 'n', '6', 'b', 'g', 'h'};

    /**
     * 定义一个字符用来补全邀请码长度（该字符前面是计算出来的邀请码，后面是用来补全用的）
     */
    private static final char b = '9';

    /**
     * 进制长度
     */
    private static final int binLen = r.length;

    /**
     * 邀请码长度6位
     */
    private static final int s = 6;

    /**
     * 补位字符串
     */
    private static final String e = "pf2sgkrh";

    /********************* 生成8位唯一的数字，根据id***********************/
    /**
     * 自定义进制（选择你想要的进制数）
     */
    private static final char[] rp = new char[]{'2', '1', '3', '8', '7', '6', '5', '4', '9'};

    /**
     * 定义一个字符用来补全邀请码长度（该字符前面是计算出来的邀请码，后面是用来补全用的）
     */
    private static final char bp = '2';

    /**
     * 补位字符串
     */
    private static final String ep = "0000001";
    /**
     * 邀请码长度
     */
    private static final int sp = 8;
    /**
     * 进制长度
     */
    private static final int binPen = rp.length;

    /**
     * 同一个id生成的邀请码不唯一，如果想唯一则定义一个补位字符串就可以了
     * type: 1,生成唯一6位邀请码字母或字母加数字，2-创建宠物8位唯一码数字
     * id 主键id
     *
     * @param id
     * @param type
     * @return
     */
    public static String toSerialOnlyCode(long id, Integer type) {
        String str = "";
        if (type == 1) {
            str = onlySixCode(id).toUpperCase();
        } else if (type == 2) {
            char[] buf = new char[32];
            int charPos = 32;

            while ((id / binPen) > 0) {
                int ind = (int) (id % binPen);
                buf[--charPos] = rp[ind];
                id /= binPen;
            }
            buf[--charPos] = rp[(int) (id % binPen)];
            str = new String(buf, charPos, (32 - charPos));
            // 不够长度的自动补全
            if (str.length() < sp) {
                StringBuilder sb = new StringBuilder();
                sb.append(ep.subSequence(0, sp - str.length()));
                str += sb.toString();
            }
        }
        return str;
    }

    /**
     * 生成唯一6位邀请码字母或字母加数字
     *
     * @param id
     * @return
     */
    private static String onlySixCode(long id) {
        String str;
        char[] buf = new char[32];
        int charPos = 32;

        while ((id / binLen) > 0) {
            int ind = (int) (id % binLen);
            buf[--charPos] = r[ind];
            id /= binLen;
        }
        buf[--charPos] = r[(int) (id % binLen)];
        str = new String(buf, charPos, (32 - charPos));
        // 不够长度的自动补全
        if (str.length() < s) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.subSequence(0, s - str.length()));
            str += sb.toString();
        }
        return str;
    }


    /**
     * 随机的分割一个数为几份
     *
     * @param num       分割的数字
     * @param randomNum 份数-1
     * @return
     */
    public static List<Double> numberRandomBall(double num, int randomNum) {
        Random random = new Random();
        //拿到四个随机数，可以做个池什么的每次取3个来提升效率
        List<Double> r = new ArrayList<>();
        for (int i = 0; i < randomNum; i++) {
            r.add(random.nextDouble());
        }
        //排序
        r.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1 < o2 ? -1 : 1;
            }
        });
        //用这四个随机数来打断一个数，来取得四份分解之后的数
        List<Double> outList = new ArrayList<>();
        double last = 0D;
        for (int i = 0; i < randomNum; i++) {
            double c = (r.get(i) * num + 0.01);
            double t = getBigDecimal(c).doubleValue();
            double m = getBigDecimal(t - last).doubleValue();
            outList.add(m);
            last = t;
        }
        double result = getBigDecimal(num - last).doubleValue();
        outList.add(result);
        for (Double temp : outList) {
            if (temp <= 0) {
                outList.clear();
                outList = numberRandomBall(num, randomNum);
                break;
            }

        }
        return outList;
    }

    private static BigDecimal getBigDecimal(double d1) {
        BigDecimal bd = new BigDecimal(d1);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd;
    }

    /**
     * String ===> Date
     *
     * @param time
     * @return
     */
    public static Date getExchangeTime(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(time);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转String
     *
     * @param dt
     * @return
     */
    public static String getTimeChangeStr(Date dt) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(dt);//格式化数据
        return date;
    }

    /*
       获取当前时间之后几小时 hour
      */
    public static String getTimeByHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
    }

    /**
     * 某个时间延后n天
     *
     * @param time
     * @param dayTime
     * @return
     */
    public static String getTimeDelayedForDay(Date time, int dayTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(getTimeChangeStr(time));
        } catch (ParseException e) {

            e.printStackTrace();
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, dayTime);
        return sdf.format(ca.getTime());
    }

    /**
     * 验证时间是否冲突
     *
     * @param sBegin 开始时间1
     * @param sEnd   结束时间1
     * @param tBegin 开始时间2
     * @param tEnd   结束时间2
     * @return
     */
    public static boolean isConflict(Date sBegin, Date sEnd, Date tBegin, Date tEnd) {
        long sourceBegin = sBegin.getTime();
        long sourceEnd = sEnd.getTime();
        long targetBegin = tBegin.getTime();
        long targetEnd = tEnd.getTime();
        if (sourceBegin >= targetBegin && sourceBegin <= targetEnd) {
            return true;
        } else if (sourceEnd >= targetBegin && sourceEnd <= targetEnd) {
            return true;
        } else if (sourceBegin < targetBegin && sourceEnd > targetEnd) {
            return true;
        }
        return false;
    }
}
