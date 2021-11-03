package com.dn.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * ClassName:HttpUtils
 * Package:com.dn.util
 * Description:
 *
 * @Date:2021/10/29 11:58
 * @Author: mark
 */
@Slf4j
public class HttpUtils {
    public static   String post(String url, String jsonParam) {
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    return str;
                } catch (Exception e) {
                    log.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            log.error("post请求提交失败:" + url, e);
        }
        return jsonResult;
    }
}
