package com.dn.util;

import java.io.IOException;

/**
 * ClassName:Converter
 * Package:com.dn.util
 * Description:
 * html url转pdf
 * @Date:2021/10/26 17:16
 * @Author: mark
 */
public class Converter {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String result = Html2pdfUtil.parseHtml2Pdf("https://cloud.tencent.com/developer");
        long all = System.currentTimeMillis()- start;
        System.out.println("pdf生成地址:"+result+",用时:"+all/1000+"秒");
    }
}
