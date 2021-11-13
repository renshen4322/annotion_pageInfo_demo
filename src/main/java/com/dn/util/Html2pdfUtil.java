package com.dn.util;

import com.itextpdf.text.pdf.BaseFont;
import org.springframework.core.io.ClassPathResource;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

/**
 * ClassName:Html2pdfUtil
 * Package:com.dn.util
 * Description:
 *
 * @Date:2021/10/26 17:13
 * @Author: mark
 */
public class Html2pdfUtil {

    public static void html2pdf(String htmlContent, File pdfFile) throws Exception {
       /* OutputStream os = new FileOutputStream(pdfFile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        // 中文
        ITextFontResolver fontResolver = renderer.getFontResolver();
        ClassPathResource resource = new ClassPathResource("static/fonts/simsun.ttc"); // 下面有截图
        System.err.println(resource.toString());
        fontResolver.addFont(resource.getURL().toString(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        renderer.layout();
        renderer.createPDF(os);
        os.close();*/
    }

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
