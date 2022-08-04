package com.dn.util.httpHelper;

import com.dn.normalexception.NormalException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * httpclient 工厂的消费类
 * @author DELL
 *
 */
public class PoolingHttpUtil 
{
	public static String doGet(String url, List<PoolingHttpHeader> headers)  throws NormalException {
		//返回的对象
		String retStr = "";

		//定义了响应类
		CloseableHttpResponse httpResponse = null;

		List<Header> headerList = null;
		if (headers != null) {
			headerList = headers.stream().map(poolingHttpHeader ->
					new BasicHeader(poolingHttpHeader.name,poolingHttpHeader.content)).collect(Collectors.toList());
		}

		try
		{
			//从工厂中取出一个 HTTPClient
			CloseableHttpClient httpClient = PoolingHttpClientFactory.getInstance().CreateHttpClient(headerList);

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
	 * 公共的Get方式请求和响应
	 * @param url
	 * @return
	 */
	public static String doGet(String url) throws NormalException
	{  
		 return doGet(url, null);
    }


	public static String doPost(String url,String param) throws NormalException
	{
		return doPost(url, param, null);
	}

	/**
	 * 公共的Post方式请求和响应
	 * @param url
	 * @return
	 */
	public static String doPost(String url,String param, List<PoolingHttpHeader> headers) throws NormalException
	{  
		 //返回的对象
		 String retStr = "";
		 
		 //定义了响应类
		 CloseableHttpResponse httpResponse = null;

		List<Header> headerList = null;
		if (headers != null) {
			headerList = headers.stream().map(poolingHttpHeader ->
					new BasicHeader(poolingHttpHeader.name,poolingHttpHeader.content)).collect(Collectors.toList());
		}

		 try 
		 { 
			 //从工厂中取出一个 HTTPClient
			 CloseableHttpClient httpClient = PoolingHttpClientFactory.getInstance().CreateHttpClient(headerList);
			 
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

	/**
	 * 公共的Post方式请求和响应
	 * @param url
	 * @return
	 */
	public static String doPost(String url,Map<String,String> params, List<PoolingHttpHeader> headers) throws NormalException
	{
		//返回的对象
		String retStr = "";

		//定义了响应类
		CloseableHttpResponse httpResponse = null;

		List<Header> headerList = null;
		if (headers != null) {
			headerList = headers.stream().map(poolingHttpHeader ->
					new BasicHeader(poolingHttpHeader.name,poolingHttpHeader.content)).collect(Collectors.toList());
		}

		try
		{
			//从工厂中取出一个 HTTPClient
			CloseableHttpClient httpClient = PoolingHttpClientFactory.getInstance().CreateHttpClient(headerList);


			List<NameValuePair> list = new ArrayList<>();
			Iterator<String> it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				String val = params.get(key);
				NameValuePair item = new BasicNameValuePair(key, val);
				list.add(item);
			}

			//实例化httpget请求类
			HttpPost httpPost = new HttpPost(url);

			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);

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

    /**
	 * 实名认证身份证号码校验post请求
	 * */
	public static String postForm(String appCode, String url, Map<String, String> params) throws IOException
	{
		OkHttpClient client = new OkHttpClient.Builder().build();

		FormBody.Builder formbuilder = new FormBody.Builder();

		Iterator<String> it = params.keySet().iterator();

		while (it.hasNext())
		{
			String key = it.next();
			formbuilder.add(key, params.get(key));
		}

		FormBody body = formbuilder.build();

		Request request = new Request.Builder().url(url).addHeader("Authorization", "APPCODE " + appCode).post(body).build();

		Response response = client.newCall(request).execute();

		//System.out.println("返回状态码" + response.code() + ",message:" + response.message());

		String result = response.body().string();

		return result;
	}

	public static String doGetCommon(String url) throws NormalException
	{
		return doGetCommon(url, null);
	}

	public static String doGetCommon(String url, List<PoolingHttpHeader> headers) throws NormalException
	{
		//返回的对象
		String retStr = "";

		//定义了响应类
		CloseableHttpResponse httpResponse = null;

		List<Header> headerList = null;
		if (headers != null) {
			headerList = headers.stream().map(poolingHttpHeader ->
					new BasicHeader(poolingHttpHeader.name,poolingHttpHeader.content)).collect(Collectors.toList());
		}

		try
		{
			RequestConfig requestConfig = RequestConfig.custom()
					// 设置连接超时时间(单位毫秒)
					.setConnectTimeout(5000)
					// 设置请求超时时间(单位毫秒)
					.setConnectionRequestTimeout(5000)
					// socket读写超时时间(单位毫秒)
					.setSocketTimeout(5000)
					// 设置是否允许重定向(默认为true)
					.setRedirectsEnabled(true)
					.setCookieSpec(CookieSpecs.STANDARD).build();


			//从工厂中取出一个 HTTPClient
			CloseableHttpClient httpClient = PoolingHttpClientFactory.getInstance().CreateHttpClient(headerList);

			//实例化httpget请求类
			HttpGet httpGet = new HttpGet(url);

			// 将上面的配置信息 运用到这个Get请求里
			httpGet.setConfig(requestConfig);

			//执行httpget请求
			httpResponse = httpClient.execute(httpGet);

			// 验证请求是否成功
			if (httpResponse.getStatusLine().getStatusCode() > 0)
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
