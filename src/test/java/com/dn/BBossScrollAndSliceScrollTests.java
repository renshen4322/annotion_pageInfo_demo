package com.dn;

import com.dn.service.DocumentCRUD;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class BBossScrollAndSliceScrollTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    DocumentCRUD documentCRUD;

    @Test
    public void delTestDemo(){
        documentCRUD.delTestDemo();
    }

    /**
     * 创建批量创建文档的客户端对象，单实例多线程安全
     */
    @Test
    public void testBulkAddDocuments(){
        documentCRUD.testBulkAddDocuments();
    }

    @Test
    public void testSimleScrollAPI(){
        documentCRUD.testSimleScrollAPI();
    }

    @Test
    public void testSimleScrollAPIHandler(){
        documentCRUD.testSimleScrollAPIHandler();
    }

    @Test
    public void testSimleScrollParallelAPIHandler(){
        documentCRUD.testSimleScrollParallelAPIHandler();
    }

    /**
     * 串行方式执行slice scroll操作
     */
    @Test
    public void testSimpleSliceScrollApi() {
        documentCRUD.testSimpleSliceScrollApi();
    }

    /**
     * 并行方式执行slice scroll操作
     */
    @Test
    public void testSimpleSliceScrollApiParral() {
        documentCRUD.testSimpleSliceScrollApiParral();
    }
    /**
     * 串行方式执行slice scroll Handler操作
     */
    @Test
    public void testSimpleSliceScrollApiHandler() {
        documentCRUD.testSimpleSliceScrollApiHandler();
    }
    /**
     * 并行方式执行slice scroll Handler操作
     */
    @Test
    public void testSimpleSliceScrollApiParralHandler() {

        documentCRUD.testSimpleSliceScrollApiParralHandler();
    }

    @Test
    public void testSearchAll(){
        ClientInterface clientInterface = ElasticSearchHelper.getRestClientUtil();
        ESDatas<Map> esDatas = clientInterface.searchAll("test_demo",Map.class);
        List<Map> dataList = esDatas.getDatas();
        log.info("TotalSize:"+esDatas.getTotalSize());
        if(dataList != null) {
            log.info("dataList.size:" + dataList.size());
        }
        else
        {
            log.info("dataList.size:0");
        }
    }

}
