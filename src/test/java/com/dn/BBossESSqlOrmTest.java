package com.dn;

import com.alibaba.fastjson.JSON;
import com.tinge.xingchao.xcelasticsearch.entity.Demo;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.sql.SQLRestResponse;
import org.frameworkset.elasticsearch.entity.sql.SQLRestResponseHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:BBossDataTest
 * Package:com.dn
 * Description:
 *
 * @Date:2022/5/6 10:15
 * @Author: mark
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BBossESSqlOrmTest {


    /**
     * 代码中的sql检索，返回Map类型集合，亦可以返回自定义的对象集合
     */
    @Test
    public void testDemoQuery(){
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        List<Map> json = clientUtil.sql(Map.class,"{\"query\": \"SELECT * FROM demo where demoId=1 \"}");
        log.info(JSON.toJSONString(json));
    }

    /**
     * 代码中的sql检索，返回Map类型集合，亦可以返回自定义的对象集合
     */
    @Test
    public void testMapQuery(){
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        List<Map> json = clientUtil.sql(Map.class,"{\"query\": \"SELECT * FROM test_demo limit 5\"}");
       log.info(JSON.toJSONString(json));
    }

    /**
     * 配置文件中的sql dsl检索,返回Map类型对象，亦可以返回自定义的对象
     */
    @Test
    public void testMapObjectSQLQueryFromDSL(){
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/demo.xml");//初始化一个加载sql配置文件的es客户端接口
        //设置sql查询的参数
        Map params = new HashMap();
        params.put("demoId",1);
        params.put("name","mark");
        Map json = clientUtil.sqlObject(Map.class,"sqlQuery",params);
        log.info(JSON.toJSONString(json));

    }

    /**
     * 配置文件中的sql dsl检索,返回Map类型对象，亦可以返回自定义的对象
     */
    @Test
    public void testMapObjectSQLQueryByStatus(){
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/demo.xml");//初始化一个加载sql配置文件的es客户端接口
        //设置sql查询的参数
        Map params = new HashMap();
        params.put("demoId",2);
        Map json = clientUtil.sqlObject(Map.class,"sqlQueryByDemoId",params);
        log.info(JSON.toJSONString(json));

    }

    /**
     * 代码中的sql检索，返回DocObject 类型集合
     */
    @Test
    public void testObjectListQuery(){
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        List<Demo> json = clientUtil.sql(Demo.class,"{\"query\": \"SELECT * FROM demo\"}");
        System.out.println(json);
    }

    /**
     * 配置文件中的sql dsl检索,返回DocObject 类型集合
     */
    @Test
    public void testObjectSQLQueryFromDSL(){
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/Demo.xml");//初始化一个加载sql配置文件的es客户端接口
        //设置sql查询的参数
        Map params = new HashMap();
        params.put("status",2);
        List<Demo> json = clientUtil.sql(Demo.class,"sqlQueryByStatus",params);
        System.out.println(json.size()+"=="+json);

    }

    /**
     * 代码中的sql检索，返回DocObject 类型对象
     */
    @Test
    public void testObjectQuery(){
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        Demo json = clientUtil.sqlObject(Demo.class,"{\"query\": \"SELECT * FROM demo where demoId = 1\"}");
        System.out.println(json);
    }

    /**
     * sql转换为dsl
     * http
     */
    @Test
    public void testTranslate(){
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        String json = clientUtil.executeHttp("/_xpack/sql/translate",
                "{\"query\": \"SELECT * FROM demo limit 5\",\"fetch_size\": 5}",
                ClientInterface.HTTP_POST
        );
        log.info(json);

    }

    /**
     * 低阶的检索方法
     */
    @Test
    public void testSQLRestResponse(){
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        SQLRestResponse sqlRestResponse = clientUtil.executeHttp("/_xpack/sql",
                "{\"query\": \"SELECT * FROM demo where demoId = 1\"}",
                ClientInterface.HTTP_POST,
                new SQLRestResponseHandler());
       log.info(JSON.toJSONString(sqlRestResponse));
    }

}
