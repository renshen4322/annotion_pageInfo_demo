package com.dn;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:ElasticsearchSqlTest
 * Package:com.tinge.xingchao.xcelasticsearch
 * Description:
 *
 * @Date:2022/5/7 14:36
 * @Author: mark
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ElasticsearchSqlTest {

    /**
     * 基于第三方Elasticsearch-sql插件的查询功能的使用
     * 需要安装插件  /_nlpcn/sql 是固定写法
     * ./bin/elasticsearch-plugin install
     * https://github.com/NLPchina/elasticsearch-sql/releases/download/7.7.0.0/elasticsearch-sql-7.7.0.0.zip
     * ** Elasticsearch-SQL插件功能测试方法
     */
    @Test
    public void testESSQL(){
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        ESDatas<Map> esDatas =  //ESDatas包含当前检索的记录集合，最多10条记录，由sql中的limit属性指定
                clientUtil.searchList("/_nlpcn/sql",//sql请求
                        "select * from test_demo limit 0,10", //elasticsearch-sql支持的sql语句
                        Map.class);//返回的文档封装对象类型
        //获取结果对象列表
        List<Map> demos = esDatas.getDatas();
        //获取总记录数
        long totalSize = esDatas.getTotalSize();
        System.out.println(demos.size());
    }

    /**
     * Elasticsearch-SQL插件功能测试方法  7以下： /_sql
     * 通过配置文件管理sql语句案例7以上： /_nlpcn/sql 是固定写法
     */
    @Test
    public void testESSQLFromConf(){
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/sql.xml");
        ESDatas<Map> esDatas =  //ESDatas包含当前检索的记录集合，最多10条记录，由sql中的limit属性指定
                clientUtil.searchList("/_nlpcn/sql",//sql请求
                        "testESSQL", //elasticsearch-sql支持的sql语句
                        Map.class);//返回的文档封装对象类型

        //获取结果对象列表
        List<Map> demos = esDatas.getDatas();
        //获取总记录数
        long totalSize = esDatas.getTotalSize();
        log.info(JSON.toJSONString(demos));
    }

    /**  /_nlpcn/sql 是固定写法
     * 带参数的配置文件案例
     * Elasticsearch-SQL插件功能测试方法，带参数sql
     */
    @Test
    public void testESSQLFromConfParams(){
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/sql.xml");
        Map params = new HashMap();
        params.put("status","2");
        ESDatas<Map> esDatas =  //ESDatas包含当前检索的记录集合，最多10条记录，由sql中的limit属性指定
                clientUtil.searchList("/_nlpcn/sql",//sql请求
                        "testESSQLWithParams", //elasticsearch-sql支持的sql语句
                        params, //检索参数
                        Map.class);//返回的文档封装对象类型
        //获取结果对象列表
        List<Map> demos = esDatas.getDatas();
        //获取总记录数
        long totalSize = esDatas.getTotalSize();
        log.info(JSON.toJSONString(demos));
        System.out.println(totalSize);
    }

    /**
     * Elasticsearch-SQL插件功能:sql转dsl
     */
    @Test
    public void testESSQLTranslate(){
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        String dsl =  //将sql转换为dsl
                clientUtil.executeHttp("/_nlpcn/sql",//sql转dsl请求
                        "select * from test_demo limit 0,10 ",ClientInterface.HTTP_POST);//返回的转换的结果
        //获取总记录数
        System.out.println(dsl);
    }

}
