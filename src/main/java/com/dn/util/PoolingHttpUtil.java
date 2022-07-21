package com.dn.util;

import com.dn.normalexception.NormalException;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * httpclient 工厂的消费类
 * @author DELL
 *
 */
public class PoolingHttpUtil 
{
	/**
	 * 公共的Get方式请求和响应
	 * @param url
	 * @return
	 */
	public static String doGet(String url) throws NormalException
	{  
		 //返回的对象
		 String retStr = "";
		 
		 //定义了响应类
		 CloseableHttpResponse httpResponse = null;
		 
		 try 
		 { 
			 //从工厂中取出一个 HTTPClient
			 CloseableHttpClient httpClient = PoolingHttpClientFactory.getInstance().CreateHttpClient();
			 
			 //实例化httpget请求类
			 HttpGet httpGet = new HttpGet(url);
			 
			 //执行httpget请求
			 httpResponse = httpClient.execute(httpGet);
			 
			 // 验证请求是否成功  
             if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) 
             { 
            	 //根据响应的刘转换成String类型的值返回
            	 retStr = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
             }
             else
             {
            	 throw new NormalException("http响应失败:" + url);
             }
		 } 
		 catch (ClientProtocolException e) 
         {  
            throw new NormalException(e.getMessage());
         }
		 catch (IOException e)
		 {  
			throw new NormalException(e.getMessage());  
         }
		 finally
		 {
			 if(httpResponse != null)
			 {
				 try 
				 {
					httpResponse.close();
				 } 
				 catch (IOException e) 
				 {
					 throw new NormalException(e.getMessage());
				 }
			 }
		 }
		 
         return retStr;  
    }
	
	/**
	 * 公共的Post方式请求和响应
	 * @param url
	 * @return
	 */
	public static String doPost(String url,String param) throws NormalException
	{  
		 //返回的对象
		 String retStr = "";
		 
		 //定义了响应类
		 CloseableHttpResponse httpResponse = null;
		 
		 try 
		 { 
			 //从工厂中取出一个 HTTPClient
			 CloseableHttpClient httpClient = PoolingHttpClientFactory.getInstance().CreateHttpClient();
			 
			 //实例化httpget请求类
			 HttpPost httpPost = new HttpPost(url);
			 
			 // 封装post请求数据
    		 StringEntity entity = new StringEntity(param, "utf-8");

    		 //new UrlEncodedFormEntity()
    		
    		 entity.setContentType("application/x-www-form-urlencoded");
    		
    		 httpPost.setEntity(entity);
			 
			 //执行httpget请求
			 httpResponse = httpClient.execute(httpPost);
			 
			 // 验证请求是否成功  
             if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) 
             { 
            	 //根据响应的刘转换成String类型的值返回
            	 retStr = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
             }
             else
             {
            	 throw new NormalException("http响应失败:" + url);
             }
		 } 
		 catch (ClientProtocolException e) 
         {  
            throw new NormalException(e.getMessage());
         }
		 catch (IOException e)
		 {  
			throw new NormalException(e.getMessage());  
         }
		 finally
		 {
			 if(httpResponse != null)
			 {
				 try 
				 {
					httpResponse.close();
				 } 
				 catch (IOException e) 
				 {
					 throw new NormalException(e.getMessage());
				 }
			 }
		 }
		 
         return retStr;  
    }
}
