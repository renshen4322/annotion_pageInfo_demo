package com.dn.config;

import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author mark 推荐使用
 * @ClassName: RestTemplatePoolConfig
 * @description
 * @date 2021-10-20
 */
@Configuration
public class RestTemplatePoolConfig {

    /**
     * 代码初始化时 StringHttpMessageConverter 在 MessageConverters 集合中的 index=1 的位置
     * restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        // 使用 utf-8 编码集的 conver 替换默认的 conver（默认的 string conver 的编码集为"ISO-8859-1"）
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();
        while (iterator.hasNext()) {
            HttpMessageConverter<?> converter = iterator.next();
            if (converter instanceof StringHttpMessageConverter) {
                iterator.remove();
            }
        }
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }


    @Bean
    public HttpClientConnectionManager poolingConnectionManager() {
        PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
        // 连接池最大连接数
        poolingConnectionManager.setMaxTotal(2000);
        // 每个主机的并发
        poolingConnectionManager.setDefaultMaxPerRoute(200);
        return poolingConnectionManager;
    }

    /**
     *         // evictExpiredConnections() 清除失效连接
     *         // connectionManager.closeExpiredConnections(); connectionManager.closeIdleConnections(maxIdleTimeMs, TimeUnit.MILLISECONDS);
     *         // 30秒清除一次空闲连接，每次都会执行 evictExpiredConnections() 清除失效连接
     * @return
     */
    @Bean
    public HttpClientBuilder httpClientBuilder() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
                //设置HTTP连接管理器
                .setConnectionManager(poolingConnectionManager())
                .evictIdleConnections(30, TimeUnit.SECONDS);
        return httpClientBuilder;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClientBuilder().build());
        // 获取连接耗时 默认 -1
        clientHttpRequestFactory.setConnectionRequestTimeout(50000);
        // 连接超时，毫秒 默认 -1
        clientHttpRequestFactory.setConnectTimeout(10000000);
        // 读写超时，毫秒 默认 -1
        clientHttpRequestFactory.setReadTimeout(10000000);//10_000
        return clientHttpRequestFactory;
    }

}