package com.dn.test;

import com.alibaba.fastjson.JSON;
import com.dn.util.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        String str ="\"signResult\": \"MIIHfwYJKoZIhvcNAQcCoIIHcDCCB2wCAQExDzANBglghkgBZQMEAgEFADALBgkqhkiG9w0BBwGgggVAMIIFPDCCBKWgAwIBAgIIdMQAEgBo9kUwDQYJKoZIhvcNAQELBQAwYTENMAsGA1UEBh4EAEMATjEPMA0GA1UECB4GbVlsX3cBMQ8wDQYDVQQHHgZnbV3eXgIxGzAZBgNVBAoeEm1ZbF93AWVwW1eLpIvBTi1fwzERMA8GA1UEAx4IAFoASgBDAEEwHhcNMjExMDE5MDk1NDI0WhcNMjIxMDE5MDk1NDI0WjB2MQswCQYDVQQGEwJDTjELMAkGA1UECAwCemoxCzAJBgNVBAcMAmh6MRYwFAYDVQQUDA0wNTcxLTg1Nzg1MjIzMTUwMwYDVQQDDCzmtYvor5UgX+S4iua1t+S9s+WSjOWBpeW6t+euoeeQhuaciemZkOWFrOWPuDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJpnxrsUVfR2/1aKZ76+VzAENkJ2wYRg+uYXxcD1rA38XMwPyguFTJzvQn8TJIaC3JiUorsdKtNEWslIVDWpd1zDyIKDVjAWdWgPznE1nGdNJb+bN32vYtte+6ny6DcJCbfa3SjSQg0pdWJ5G4wCdDstOqYeIgqkuLhHNlILlGQj5sX8r5w4vmBWNkuFzc7ti7i0V5zbp5lAOwooiPCN3V+TH+0m+yrA8aRPOa8xZS4OXarve+NWZX0DPOmLwKrPlfO+IFPPZK+zgn/e+psZCXN2hqJlFwf5LX4oQ19ShrbXnOueDbqbkzPPBoBZV8liu2CDhGXSBN08SrGvvc23k7kCAwEAAaOCAmIwggJeMAwGA1UdEwQFMAMBAQAwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMA4GA1UdDwEB/wQEAwIAyDBqBgNVHSAEYzBhMF8GCSqBHIbvPQEBATBSMFAGCCsGAQUFBwIBFkRodHRwczovL3d3dy56amNhLmNvbS5jbi93ZWIvd2Vicy9kb3dubG9hZHMvb3RoZXIvQ1AmQ1BTL1pKQ0FfY3AxLnBkZjARBglghkgBhvhCAQEEBAMCAIAwHQYHKoEchu89BQQSOTEzMTAwMDBNQTdBR1g1RTJKMB8GA1UdIwQYMBaAFNt6lKCLL8GEvVA50PHjqj9GRGkJMIGmBgNVHR8EgZ4wgZswgZiggZWggZKGgY9sZGFwOi8vbGRhcC56amNhLmNvbS5jbi9DTj1aSkNBZ3JvdXA2ODcsQ049WkpDQSwgT1U9Q1JMRGlzdHJpYnV0ZVBvaW50cywgbz16amNhP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3Q/YmFzZT9vYmplY3RjbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludDCBlwYIKwYBBQUHAQEEgYowgYcwgYQGCCsGAQUFBzAChnhsZGFwOi8vbGRhcC56amNhLmNvbS5jbi9DTj1aSkNBLENOPVpKQ0EsIE9VPWNBQ2VydGlmaWNhdGVzLCBvPXpqY2E/Y0FDZXJ0aWZpY2F0ZT9iYXNlP29iamVjdENsYXNzPWNlcnRpZmljYXRpb25BdXRob3JpdHkwHQYDVR0OBBYEFN+URrpw59KQI+CL4gDa6xYkVablMA0GCSqGSIb3DQEBCwUAA4GBAB93HEWcMuwoK+aX0C2hhKJvR3cjz1UG6dS71JD7RtwUuZdytzIb8LT06hTDwBoAP7F5RLv+jpky4HstQSMDeIxl/BLtscFJRbjJuHgL6q2EAFeOTj4oVZiBOcE55YdGMWb8FeW//A+CLXZtoqVddRqhZUgZjmSCOjGUP/UGMM8EMYICAzCCAf8CAQEwbTBhMQ0wCwYDVQQGHgQAQwBOMQ8wDQYDVQQIHgZtWWxfdwExDzANBgNVBAceBmdtXd5eAjEbMBkGA1UECh4SbVlsX3cBZXBbV4uki8FOLV/DMREwDwYDVQQDHggAWgBKAEMAQQIIdMQAEgBo9kUwDQYJYIZIAWUDBAIBBQCgaTAYBgkqhkiG9w0BCQMxCwYJKoZIhvcNAQcBMBwGCSqGSIb3DQEJBTEPFw0yMTExMTMxMjA0NDhaMC8GCSqGSIb3DQEJBDEiBCCcmAHqnjg6wOoeZTs9zX27h8iD/BjE2B0TvxVsKKRLqDANBgkqhkiG9w0BAQEFAASCAQAjCJqlqLDF+6XkME/KEVVtaW1LYOFSNv3I2MiC5Vh43WJ9w/eg4ZLOkw3h33jqLBMLs7t0xC6af054i6G3BcIoitC+gC78hU8aaSHQIG1ggJP7fJzZOZXEgnp3e5vbpH0CCYAGSIBuNuw+DCeNubk/2f7z+vm64izi3Dplz4UUKPNMmbYdmD78NSXg/TOyEIW/FIq5VckiZ1OR75WvCFuKTQWhP+CBpSTjEezMEussVjQLnjqe6DJd4GXB24s0rOyHSq8ANlFCPl/UWWQGfRiaGZx7KK4yrOfcZV9gKJ+l1uTHNV8Xd70GsQ1mar7HKaKX651KPjnfDCb2cArgZfOD\\n\"";
        System.out.println("str.length()=="+str.length());

        String json = "[\"解答专业\", \"耐心细致\", \"医术精湛\"]";
        System.out.println(json.replaceAll("\\\\",""));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 起始日期
            Date d1 = sdf.parse("2018-2-25");
            // 结束日期
            Date d2 = sdf.parse("2018-3-5");
            Date tmp = d1;
            Calendar dd = Calendar.getInstance();
            dd.setTime(d1);
            // 打印2018年2月25日到2018年3月5日的日期
            while (tmp.getTime() < d2.getTime()) {
                tmp = dd.getTime();
                System.out.println(sdf.format(tmp));
                // 天数加上1
                dd.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


      System.out.println("================          "+getRate2(2,9));

    }

    public static String getRate(Integer detailTotalNumber, Integer totalNumber) {
        Double bfTotalNumber = Double.valueOf(detailTotalNumber);
        Double zcTotalNumber = Double.valueOf(totalNumber);
        double percent = bfTotalNumber/zcTotalNumber;
        //获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(0);
        return nt.format(percent);
    }
    public static String getRate2(int a, int b) {
        if (a == 0 || b == 0) {
            return "-";
        } else {
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format((float) a / (float) b * 100);
        }
    }

}
