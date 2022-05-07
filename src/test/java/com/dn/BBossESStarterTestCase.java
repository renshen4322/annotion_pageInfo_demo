package com.dn;


import com.tinge.xingchao.xcelasticsearch.service.DocumentCRUD;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchException;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.client.ClientUtil;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.frameworkset.elasticsearch.entity.MetaMap;
import org.frameworkset.elasticsearch.template.ESInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:BBossESStarterTestCase
 * Package:com.dn
 * * Description: 增删改
 *
 * @Date:2022/5/1 16:58
 * @Author: mark
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BBossESStarterTestCase {

    @Autowired
    private BBossESStarter bbossESStarter;
    @Autowired
    DocumentCRUD documentCRUD;

    private Logger logger = LoggerFactory.getLogger(BBossESStarterTestCase.class);//日志


    private ClientInterface clientInterface;//bboss dsl工具

    @Test
    public void dropAndCreateArticleIndice() {
        try {
            //创建一个加载配置文件esmapper/span_query.xml的rest client接口实例
            clientInterface = bbossESStarter.getConfigRestClient("esmapper/span_query.xml");//bboss读取xml
            /*检查索引是否存在，存在就删除重建*/
            if (clientInterface.existIndice("article")) {
                clientInterface.dropIndice("article");
            }
            clientInterface.createIndiceMapping("article", "createArticleIndice");
            logger.info("创建索引 article 成功");
        } catch (ElasticSearchException e) {
            logger.error("创建索引 article 失败", e);
        }
    }

    @Test
    public void insertIndiceData() {
        try {
            clientInterface = bbossESStarter.getConfigRestClient("esmapper/span_query.xml");//bboss读取xml
            ClientInterface restClient = ElasticSearchHelper.getRestClientUtil();//插入数据用RestClient
            ESInfo esInfo = clientInterface.getESInfo("bulkInsertArticleData");//获取插入数据
            StringBuilder recipedata = new StringBuilder();
            recipedata.append(esInfo.getTemplate().trim())
                    .append("\n");//换行符不能省
            restClient.executeHttp("article/_bulk?refresh", recipedata.toString(), ClientUtil.HTTP_POST);
        } catch (ElasticSearchException e) {
            logger.error("article 插入数据失败", e);
        }
        long recipeCount = clientInterface.countAll("article");
        logger.info("article 当前条数：{}", recipeCount);
    }

    @Test
    public void testSpanTermQuery() {
        try {
            //创建一个加载配置文件esmapper/span_query.xml的rest client接口实例
            clientInterface = bbossESStarter.getConfigRestClient("esmapper/span_query.xml");
            //封装请求参数
            Map<String, String> queryParams = new HashMap<>(5);
            queryParams.put("spanTermValue", "red");
            //Bboss执行查询DSL
            ESDatas<MetaMap> metaMapESDatas = clientInterface.searchList("article/_search?search_type=dfs_query_then_fetch",
                    "testSpanTermQuery",//DSL模板ID
                    queryParams,//查询参数
                    MetaMap.class);//文档信息

            //ES返回结果遍历
            metaMapESDatas.getDatas().forEach(metaMap -> {
                logger.info("\n文档_source:{}", metaMap);
            });
        } catch (ElasticSearchException e) {
            logger.error("testSpanTermQuery 执行失败 ", e);
        }
    }

    @Test
    public void deleteDemoIndeice() {
        documentCRUD.dropDemoIndice();
    }

    @Test
    public void addDemoDocument() {
        documentCRUD.addDemoDocument();
    }

    @Test
    public void SearchDocumentId(){
        documentCRUD.SearchDocumentId();
    }

    @Test
    public void testCreateDemoIndice(){
       documentCRUD.dropAndCreateDemoIndice();
    }


    @Test
    public void updateDemoDocuments(){
        documentCRUD.updateDemoDocuments();
    }


    @Test
    public void searchDemoByDocumentId() {
        documentCRUD.searchDemoByDocumentId();
    }

    @Test
    public void searchByMapParamInfo() {

        documentCRUD.searchMapParamsResult();
    }
    @Test
    public void SearchAllDemoResult() throws Exception {
        documentCRUD.SearchAllDemoResult();
    }


    @Test
    public void addGateWay() throws Exception {
        documentCRUD.addGateWay();
    }

    @Test
    public void testBbossESStarter() throws Exception {
//        System.out.println(bbossESStarter);

        //验证环境,获取es状态
//        String response = serviceApiUtil.restClient().executeHttp("_cluster/state?pretty",ClientInterface.HTTP_GET);

//        System.out.println(response);
        //判断索引类型是否存在，false表示不存在，正常返回true表示存在
        boolean exist = bbossESStarter.getRestClient().existIndiceType("twitter", "tweet");

        log.info("=====" + exist);
        //判读索引是否存在，false表示不存在，正常返回true表示存在
        exist = bbossESStarter.getRestClient().existIndice("twitter");
        log.info("==twitter===" + exist);
        exist = bbossESStarter.getRestClient().existIndice("agentinfo");
        log.info("==agentinfo===" + exist);

    }



}
