package com.dn.test;

import com.alibaba.fastjson.JSONObject;
import com.dn.util.HTTPHelper;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.LinkedHashMap;

/**
 * ClassName:TestSignatureInfo
 * Package:com.dn.test
 * Description:
 *
 * @Date:2021/11/11 15:18
 * @Author: mark
 */
public class TestSignatureInfo {
    public static void main(String[] args) {
        // 应用ID
        String appId = "7438881477";
        // 应用密钥
        String appKey = "b417a06f8c790ced2918f173d7ade528";
        // 接口调用域名
        String host = "https://smlopenapi.esign.cn";
        // 个人账户ID
        String accountId = "2f13d46671ea48d3a0231cbeecbe25c6";

        String flowId="06ab7145ce384d3997b1346862be6218";

        // 请求签名鉴权-POST请求
       // testPost(appId, appKey, host);

        // 请求签名鉴权-GET请求
        testGet(appId, appKey, host, flowId);
    }

    /***
     * 请求签名鉴权-POST请求
     *
     * @param appId
     * @param appKey
     * @param host
     */
    public static void testPost(String appId, String appKey, String host) {
        // 个人创建账号接口地址
        String accountsApi = "/v1/accounts/createByThirdPartyUserId";
        // 个人创建账号接口请求地址
        String accountsApiUrl = host + accountsApi;

        try {
            // 构建请求Body体
            JSONObject reqBodyObj = new JSONObject();
            reqBodyObj.put("thirdPartyUserId", "229");
            reqBodyObj.put("name", "张三");
            reqBodyObj.put("idType", "CRED_PSN_CH_IDCARD");
            reqBodyObj.put("idNumber", "330621");
            reqBodyObj.put("mobile", "152****4800");
            reqBodyObj.put("email", "152****800@163.com");

            // 请求Body体数据
            String reqBodyData = reqBodyObj.toString();
            // 对请求Body体内的数据计算ContentMD5
            String contentMD5 = doContentMD5(reqBodyData);

            // 构建待签名字符串
            String method = "POST";
            String accept = "*/*";
            String contentType = "application/json; charset=UTF-8";
            String url = accountsApi;
            String date = "";
            String headers = "";

            StringBuffer sb = new StringBuffer();
            sb.append(method).append("\n").append(accept).append("\n").append(contentMD5).append("\n")
                    .append(contentType).append("\n").append(date).append("\n");
            if ("".equals(headers)) {
                sb.append(headers).append(url);
            } else {
                sb.append(headers).append("\n").append(url);
            }

            // 构建参与请求签名计算的明文
            String plaintext = sb.toString();
            // 计算请求签名值
            String reqSignature = doSignatureBase64(plaintext, appKey);

            // 获取时间戳(精确到毫秒)
            long timeStamp = timeStamp();

            // 构建请求头
            LinkedHashMap<String, String> header = new LinkedHashMap<String, String>();
            header.put("X-Tsign-Open-App-Id", appId);
            header.put("X-Tsign-Open-Auth-Mode", "Signature");
            header.put("X-Tsign-Open-Ca-Timestamp", String.valueOf(timeStamp));
            header.put("Accept", accept);
            header.put("Content-Type", contentType);
            header.put("X-Tsign-Open-Ca-Signature", reqSignature);
            header.put("Content-MD5", contentMD5);

            // 发送POST请求
            String result = HTTPHelper.sendPOST(accountsApiUrl, reqBodyData, header, "UTF-8");
            JSONObject resultObj = JSONObject.parseObject(result);
            System.out.println("请求返回信息： " + resultObj.toString());
        } catch (Exception e) {
            e.printStackTrace();
            String msg = MessageFormat.format("请求签名鉴权方式调用接口出现异常: {0}", e.getMessage());
            System.out.println(msg);
        }
    }

    /***
     * 请求签名鉴权-GET请求
     *
     * @param appId
     * @param appKey
     * @param host
     */
    public static void testGet(String appId, String appKey, String host, String flowId) {
        // 查询个人印章接口
       // String getPersonSealsApi = "/v1/accounts/" + accountId + "/seals?offset=1&size=10";
        String urlInfoApi = "/v1/signflows/"+ flowId +"/documents";
        // 查询个人印章接口请求地址
        String getPersonSealsApi_Url = host + urlInfoApi;

        try {
            // GET请求时ContentMD5为""
            String contentMD5 = "{}";

            // 构建待签名字符串
            String method = "GET";
            String accept = "*/*";
            String contentType = "application/json; charset=UTF-8";
            String url = urlInfoApi;
            String date = "";
            String headers = "";

            StringBuffer sb = new StringBuffer();
            sb.append(method).append("\n").append(accept).append("\n").append(contentMD5).append("\n")
                    .append(contentType).append("\n").append(date).append("\n");
            if ("".equals(headers)) {
                sb.append(headers).append(url);
            } else {
                sb.append(headers).append("\n").append(url);
            }

            // 构建参与请求签名计算的明文
            String plaintext = sb.toString();
            // 计算请求签名值
            String reqSignature = doSignatureBase64(plaintext, appKey);

            // 获取时间戳(精确到毫秒)
            long timeStamp = timeStamp();

            // 构建请求头
            LinkedHashMap<String, String> header = new LinkedHashMap<String, String>();
            header.put("X-Tsign-Open-App-Id", appId);
            header.put("X-Tsign-Open-Auth-Mode", "Signature");
            header.put("X-Tsign-Open-Ca-Timestamp", String.valueOf(timeStamp));
            header.put("Accept", accept);
            header.put("Content-Type", contentType);
            header.put("X-Tsign-Open-Ca-Signature", reqSignature);
            header.put("Content-MD5", contentMD5);

            // 发送GET请求
            String result = HTTPHelper.sendGet(getPersonSealsApi_Url, header, "UTF-8");
            JSONObject resultObj = JSONObject.parseObject(result);
            System.out.println("请求返回信息： " + resultObj.toString());
        } catch (Exception e) {
            e.printStackTrace();
            String msg = MessageFormat.format("请求签名鉴权方式调用接口出现异常: {0}", e.getMessage());
            System.out.println(msg);
        }
    }

    /***
     *
     * @param str 待计算的消息
     * @return MD5计算后摘要值的Base64编码(ContentMD5)
     * @throws Exception 加密过程中的异常信息
     */
    public static String doContentMD5(String str) throws Exception {
        byte[] md5Bytes = null;
        MessageDigest md5 = null;
        String contentMD5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md5.update(str.getBytes("UTF-8"));
            // 获取文件MD5的二进制数组（128位）
            md5Bytes = md5.digest();
            // 把MD5摘要后的二进制数组md5Bytes使用Base64进行编码（而不是对32位的16进制字符串进行编码）
            contentMD5 = new String(Base64.encodeBase64(md5Bytes), "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            String msg = MessageFormat.format("不支持此算法: {0}", e.getMessage());
            Exception ex = new Exception(msg);
            ex.initCause(e);
            throw ex;
        } catch (UnsupportedEncodingException e) {
            String msg = MessageFormat.format("不支持的字符编码: {0}", e.getMessage());
            Exception ex = new Exception(msg);
            ex.initCause(e);
            throw ex;
        }
        return contentMD5;
    }

    /***
     * 计算请求签名值
     *
     * @param message 待计算的消息
     * @param secret 密钥
     * @return HmacSHA256计算后摘要值的Base64编码
     * @throws Exception 加密过程中的异常信息
     */
    public static String doSignatureBase64(String message, String secret) throws Exception {
        String algorithm = "HmacSHA256";
        Mac hmacSha256;
        String digestBase64 = null;
        try {
            hmacSha256 = Mac.getInstance(algorithm);
            byte[] keyBytes = secret.getBytes("UTF-8");
            byte[] messageBytes = message.getBytes("UTF-8");
            hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length, algorithm));
            // 使用HmacSHA256对二进制数据消息Bytes计算摘要
            byte[] digestBytes = hmacSha256.doFinal(messageBytes);
            // 把摘要后的结果digestBytes转换成十六进制的字符串
            // String digestBase64 = Hex.encodeHexString(digestBytes);
            // 把摘要后的结果digestBytes使用Base64进行编码
            digestBase64 = new String(Base64.encodeBase64(digestBytes), "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            String msg = MessageFormat.format("不支持此算法: {0}", e.getMessage());
            Exception ex = new Exception(msg);
            ex.initCause(e);
            throw ex;
        } catch (UnsupportedEncodingException e) {
            String msg = MessageFormat.format("不支持的字符编码: {0}", e.getMessage());
            Exception ex = new Exception(msg);
            ex.initCause(e);
            throw ex;
        } catch (InvalidKeyException e) {
            String msg = MessageFormat.format("无效的密钥规范: {0}", e.getMessage());
            Exception ex = new Exception(msg);
            ex.initCause(e);
            throw ex;
        }
        return digestBase64;
    }

    /***
     * 获取时间戳(毫秒级)
     *
     * @return 毫秒级时间戳,如 1578446909000
     */
    public static long timeStamp() {
        long timeStamp = System.currentTimeMillis();
        return timeStamp;
    }
}
