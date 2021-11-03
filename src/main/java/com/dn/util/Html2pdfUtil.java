package com.dn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ClassName:Html2pdfUtil
 * Package:com.dn.util
 * Description:
 *
 * @Date:2021/10/26 17:13
 * @Author: mark
 */
public class Html2pdfUtil {
    public static String parseHtml2Pdf(String url) throws IOException {
        System.out.println(url);
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("/Intel/phantomjs-2.1.1-windows/bin/phantomjs /Intel/phantomjs-2.1.1-windows/bin/html2pdf.js "+url);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while ((tmp = br.readLine()) != null) {
            sbf.append(tmp);
        }
        String resultstr = sbf.toString();
        System.out.println("resultstr:"+resultstr);
        String[] arr = resultstr.split("\\$");
        String result = "";
        for(String s : arr){
            if(s.endsWith("pdf"))result = s;
        }
        return result;
    }
}
