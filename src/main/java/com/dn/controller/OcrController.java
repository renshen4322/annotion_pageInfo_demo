package com.dn.controller;

import com.alibaba.fastjson.JSON;
import com.dn.model.TestReq;
import com.dn.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static com.dn.util.Base64Utils.ImageToBase64;

/**
 * ClassName:OcrController
 * Package:com.dn.controller
 * Description:
 *
 * @Date:2021/10/20 18:19
 * @Author: mark
 */
@RestController
@Slf4j
@RequestMapping("/ocr")
public class OcrController {
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/query", method = RequestMethod.POST)
    //  @WebLog(channel = "web", name = "ocr识别", action = "/query", saveFlag = false)
    public String TestOcrInfo() {
        String path = "src/main/resources/2021_1.jpg";
        String str = "";
        String needStr = path.substring(path.lastIndexOf(".") + 1);
        if (needStr.equals("pdf")) {
            str = "data:application/pdf;base64,";
        } else {
            str = "data:image/" + needStr + ";base64,";
        }
        //image -> base64
        String base64 = ImageToBase64(path);
        System.out.println(base64);
        String baseStrBase64 = str + base64;
        log.info("==========baseStrBase64=========" + baseStrBase64);
        String url = "https://zsys-test.zuoshouyisheng.com/ocr_structure";
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        Map<String, String> params = new HashMap<>();
        params.put("image_data", baseStrBase64);
        // params.put("user_id", "0000");
        params.put("action", "medical_image");
        params.put("image_info ", "0");
        // url = url + "?" + params.keySet().stream()
        //.map(k -> k + "={" + k + "}")
        // .collect(Collectors.joining("&"));
        String body = "";
        HttpEntity entity = new HttpEntity(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        body = responseEntity.getBody();
        log.info(body);
        return body;


    }

    @RequestMapping(value = "/testSaas", method = RequestMethod.POST)
    public Object testSsas() {
        String url = "http://47.117.115.45:9501/hospital/getToken";
        Map<String, String> params = new HashMap<>();
        params.put("mobile", "15000427585");
        params.put("server_hospital", "7");
        TestReq testReq = TestReq.builder() //上下二种方式都可
                .mobile("15000427585")
                .server_hospital("7").build();
        String mapJson = JSON.toJSONString(params);
        log.info("mapJson==="+mapJson);
        String postStr = HttpUtils.post(url,mapJson);

        return postStr;
    }


    @RequestMapping(value = "/query2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String StrTestOCL() {

        String path = "src/main/resources/zdzm.jpg";
        String str = "";
        String needStr = path.substring(path.lastIndexOf(".") + 1);
        if (needStr.equals("pdf")) {
            str = "data:application/pdf;base64,";
        } else {
            str = "data:image/" + needStr + ";base64,";
        }
        //image -> base64
        String base64 = ImageToBase64(path);
        System.out.println(base64);
        String baseStrBase64 = str + base64;
        log.info("==========baseStrBase64=========" + baseStrBase64);

        DefaultHttpClient client = new DefaultHttpClient();
        String url = "https://zsys-test.zuoshouyisheng.com/ocr_structure";

        Map<String, String> params = new HashMap<>();
        params.put("image_data", baseStrBase64);
        params.put("action", "medical_image");
        params.put("image_info ", "0");
        String mapJson = JSON.toJSONString(params);
        HttpPost post = new HttpPost(url);
        String result = "";
        try {
            StringEntity s = new StringEntity(mapJson);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(res.getEntity());// 返回json格式：
                System.out.println("==================================");
                log.info(result);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/query3", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String StrTestOCL2() {

        String path = "src/main/resources/zdzm.jpg";
        String str = "";
        String needStr = path.substring(path.lastIndexOf(".") + 1);
        if (needStr.equals("pdf")) {
            str = "data:application/pdf;base64,";
        } else {
            str = "data:image/" + needStr + ";base64,";
        }
        //image -> base64
        String base64 = ImageToBase64(path);
        System.out.println(base64);
        String baseStrBase64 = str + base64;
        log.info("==========baseStrBase64=========" + baseStrBase64);

        DefaultHttpClient client = new DefaultHttpClient();
        String url = "https://zsys-test.zuoshouyisheng.com/ocr_structure";

        Map<String, String> params = new HashMap<>();
        params.put("image_data", baseStrBase64);
        params.put("action", "medical_image");
        params.put("image_info ", "0");
        String mapJson = JSON.toJSONString(params);
        String result = HttpUtils.post(url,mapJson);
        return result;
    }

}