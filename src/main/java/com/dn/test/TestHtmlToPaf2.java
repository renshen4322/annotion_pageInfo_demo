package com.dn.test;

import com.dn.util.Html2pdfUtil;

import java.io.File;

/**
 * ClassName:TestHtmlToPaf2
 * Package:com.dn.test
 * Description:
 *
 * @Date:2021/11/12 15:16
 * @Author: mark
 */
public class TestHtmlToPaf2 {
    public static void main(String[] args) {
        // 准备HTML模板代码
        String s = "</body>\n" +
                "</html>\n";
        String htmlTemplate = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\"></meta>\n" +
                "<title>测试页面</title>\n" +
                "</head>\n" +
                "<body style=\"font-family: SimSun;\">\n"+
                "<p class=\"test\">协议编号:ZRXY-201707021</p>\n"+
                "<p><strong>债权转让</strong><strong>协议</strong></p>\n"+
                "<p><strong>甲方（转让方）：123</strong></p>\n"+
                "<p style=\"color:red;\">地址：天津市</p>\n"+
                "<p>姓名：张三</p>\n"+
                "<p>身份证号：2222222222</p>\n"+
                "<p><strong>乙方（受让方）：详见附表1</strong></p>\n"+
                "<p><strong>丙方（</strong><strong>居间</strong><strong>服务方）：</strong><strong>XXXX网络科技有限公司</strong></p>\n"+
                "<p><strong>注册号：2588888888</strong></p>\n" +
                "<p>地址： 天津市滨海高新区</p>\n" +
                "<p>法定代表人：王五</p>\n" +
                "<p> </p>\n"+
                "<p><strong>鉴于：</strong></p>\n"+
                "<p>现甲乙丙三方本着互惠互利的原则，经过平等协商就乙方受让甲方债权相关事宜特签订本《债权转让协议》（以下简称“本协议”），并承诺共同遵守。</p>\n"+
                "<p><strong>2.1转让的债权资产详情</strong></p>\n"+
                "<table border=\"none;\" style=\"width:90%;border-collapse:collapse;\">\n"+
                "<tbody>\n"+
                "	<tr>\n"+
                "		<td>\n"+
                "		<p><strong>转让的债权资产本金金额</strong></p>\n"+
                "		</td>\n"+
                "		<td>13593.86</td>\n"+
                "		<td>\n"+
                "		<p><strong>债权转让垫付利息</strong></p>\n"+
                "		</td>\n"+
                "		<td>28.61</td>\n"+
                "		<td>\n"+
                "		<p><strong>债权资产转让日期</strong></p>\n"+
                "		</td>\n"+
                "		<td>2017-07-02</td>\n"+
                "	</tr>\n"+
                "	<tr>\n"+
                "		<td>\n"+
                "		<p><strong>借款利率</strong></p>\n"+
                "		</td>\n"+
                "		<td>12.80<strong>%</strong></td>\n"+
                "		<td>\n"+
                "		<p><strong>还款方式</strong></p>\n"+
                "		</td>\n"+
                "		<td colspan=\"3\">一次性还本付息</td>\n"+
                "	</tr>\n"+
                "	<tr>\n"+
                "		<td>\n"+
                "		<p><strong>原担保措施</strong></p>\n"+
                "		</td>\n"+
                "		<td colspan=\"6\">\n"+
                "		<p><strong>债务人正常还款</strong></p>\n"+
                "		</td>\n"+
                "	</tr>\n"+
                "	<tr>\n"+
                "		<td>\n"+
                "		<p><strong>手续费</strong></p>\n"+
                "		</td>\n"+
                "			<td colspan=\"6\">0.00</td>\n"+
                "		</tr>\n"+
                "		<tr>\n"+
                "			<td>\n"+
                "			<p><strong>债权资产转让价款</strong></p>\n"+
                "			</td>\n"+
                "			<td colspan=\"6\">13622.47</td>\n"+
                "		</tr>\n"+
                "	</tbody>\n"+
                "</table>\n" +"</body>\n"+
                "</html>\n";
        System.err.println(htmlTemplate); // HTML模板完整内容
        File file = new File("C:/Intel/a/测试.pdf"); // 创建文件对象
        try {
            Html2pdfUtil.html2pdf(htmlTemplate, file); // 调用封装好的工具类
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.err.println("转换完成");
        }

    }
}
