package com.dn.util.httpHelper;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.List;

/**
 * 定义了HTTP Pool 的工厂类用来生成httpclient对象
 * 该对象为静态代理模式
 * @author DELL
 *
 */
public class PoolingHttpClientFactory 
{
	//连接池创建最大连接数
	private int httpMaxConnectionTotal = 500;
	
	//连接池创建最大路由数
	private int httpMaxConnecitonRoute = 500;
	
	//连接池类
	private PoolingHttpClientConnectionManager poolConnManager = null;
	
	//连接参数类
	private RequestConfig requestConfig = null;
	
	//定义了工厂的单例模式
	private static PoolingHttpClientFactory httpPoolFactory = new PoolingHttpClientFactory();
	
	//定义实例化的类
	public static PoolingHttpClientFactory getInstance() 
	{
        if (httpPoolFactory == null) 
        {
        	httpPoolFactory = new PoolingHttpClientFactory();
        }
        
        return httpPoolFactory;
    }
	
	/**
	 * 在构造函数中实例化连接池类
	 */
	private PoolingHttpClientFactory()
	{
		//创建连接池类
		poolConnManager = createConnectionManager();
		
		//创建连接池参数类
		requestConfig = createConnectionConfig(5000,50000,5000);
	}
	
	//用来创建连接池类
	private PoolingHttpClientConnectionManager createConnectionManager()
	{
		//定义了用于支持 http 和 https协议的请求信息
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();

        //实例化连接池类
        PoolingHttpClientConnectionManager poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        
        //设置连接池的参数信息
        if(httpMaxConnectionTotal != 0)
        {
            poolConnManager.setMaxTotal(httpMaxConnectionTotal);
        }
        
        if(httpMaxConnecitonRoute != 0)
        {
            poolConnManager.setDefaultMaxPerRoute(httpMaxConnecitonRoute);
        }
        
        return poolConnManager;
    }
	
	//生成请求的配置类
	private RequestConfig createConnectionConfig(int connectionTimeOut,int ScoketTimeOut,int RequestTimeOut)
	{
		RequestConfig requestConfig = RequestConfig.custom()
		        .setConnectTimeout(connectionTimeOut)    // 请求超时时间
		        .setSocketTimeout(ScoketTimeOut)    // 等待数据超时时间
		        .setConnectionRequestTimeout(RequestTimeOut)  // 连接超时时间
		        .build();
		
		return requestConfig;
	}
	
	//创建httpCLient对象
	public CloseableHttpClient CreateHttpClient(List<Header> headers)
	{
		CloseableHttpClient httpClient;
		if (headers != null) {
			httpClient = HttpClients.custom()
					.setDefaultHeaders(headers)
					.setConnectionManager(poolConnManager)
					.setDefaultRequestConfig(requestConfig)
					.build();
		}
		else {
			httpClient = HttpClients.custom()
					.setConnectionManager(poolConnManager)
					.setDefaultRequestConfig(requestConfig)
					.build();
		}

		
		return httpClient;
	}

	//外部来设置最大连接数
	public void setHttpMaxConnectionTotal(int httpMaxConnectionTotal) 
	{
		this.httpMaxConnectionTotal = httpMaxConnectionTotal;
	}

	//外部来设置最大路由数
	public void setHttpMaxConnecitonRoute(int httpMaxConnecitonRoute) 
	{
		this.httpMaxConnecitonRoute = httpMaxConnecitonRoute;
	}
}
