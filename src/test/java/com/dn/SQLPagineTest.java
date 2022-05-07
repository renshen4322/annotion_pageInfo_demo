package com.dn;

import com.dn.model.Demo;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.sql.SQLResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:ESJdbcTest
 * Package:com.tinge.xingchao.xcelasticsearch
 * Description:
 *
 * @Date:2022/5/6 16:05
 * @Author: mark
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SQLPagineTest {

    /**
     * 代码中的sql检索，返回Map类型集合，亦可以返回自定义的对象集合
     */
    @Test
    public void testMapQuery() {
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        SQLResult<Map> sqlResult = clientUtil.fetchQuery(Map.class, "{\"query\": \"SELECT * FROM demo\",\"fetch_size\": 1}");

        do {
            List<Map> datas = sqlResult.getDatas();
            if (datas == null || datas.size() == 0) {
                break;
            } else {
                System.out.println(datas.size());//处理数据
                sqlResult = sqlResult.nextPage();//获取下一页数据

            }

        } while (true);

    }

    /**
     * 配置文件中的sql dsl检索,返回Map类型集合，亦可以返回自定义的对象集合
     */
    @Test
    public void testMapSQLQueryFromDSL() {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/demo.xml");//初始化一个加载sql配置文件的es客户端接口
        //设置sql查询的参数
        Map params = new HashMap();
        params.put("status", 2);
        params.put("fetchSize", 2);
        SQLResult<Map> sqlResult = clientUtil.fetchQuery(Map.class, "sqlPagineQuery", params);

        do {
            List<Map> datas = sqlResult.getDatas();
            if (datas == null || datas.size() == 0) {
                break;
            } else {
                System.out.println(datas.size());//处理数据
                sqlResult = sqlResult.nextPage();//获取下一页数据

            }

        } while (true);

    }

    /**
     * 代码中的sql检索，返回DocObject 类型集合
     */
    @Test
    public void testObjectListQuery() {
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();

        SQLResult<Demo> sqlResult = clientUtil.fetchQuery(Demo.class, "{\"query\": \"SELECT * FROM test_demo \",\"fetch_size\": 500}");

        do {
            List<Demo> datas = sqlResult.getDatas();
            if (datas == null || datas.size() == 0) {
                break;
            } else {
                System.out.println(datas.size());//处理数据
                sqlResult = sqlResult.nextPage();//获取下一页数据

            }

        } while (true);


    }


}
