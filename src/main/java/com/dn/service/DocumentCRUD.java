package com.dn.service;

import com.alibaba.fastjson.JSON;
import com.dn.dto.DemoSearchResult;
import com.dn.model.Demo;
import org.frameworkset.elasticsearch.ElasticSearchException;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ClassName:DocumentCRUD
 * Package:com.dn.service
 * Description:
 *
 * @Date:2022/5/1 13:56
 * @Author: mark
 */
@Service
public class DocumentCRUD {
    private final Logger logger = LoggerFactory.getLogger(DocumentCRUD.class);
    @Autowired
    private BBossESStarter bbossESStarter;
    //DSL config file path
    private final String mappath = "esmapper/demo.xml";


    private final String mappath2 = "esmapper/gateway.xml";

    private ClientInterface clientInterface;//bboss dsl工具

    public void dropIndice() {
        ClientInterface clientUtil = bbossESStarter.getConfigRestClient(mappath2);

        //To determine whether the indice demo exists, it returns true if it exists and false if it does not
        boolean exist = clientUtil.existIndiceType("demo", "demo");

        //Delete mapping if the indice demo already exists
        if (exist) {
            String r = clientUtil.dropIndice("demo");
            logger.debug("clientUtil.dropIndice(\"demo\") response:" + r);

        }
    }

    public void SearchDocumentId() {
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        //Get the document object according to the document id, and return the Demo object
        Demo demo = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "jm2BiIABPEdR77RHLJ3g",//document id
                Demo.class);

        logger.info("Print the modified result:getDocument---documentId1--------------------");
        logger.info(JSON.toJSONString(demo));

    }

    public void dropAndCreateDemoIndice() {
        //Create a client tool to load configuration files(获取加载读取dsl xml配置文件的api接口实例，可以在代码里面直接通过dsl的配置名称引用dsl即可）, single instance multithreaded security
        ClientInterface clientUtil = bbossESStarter.getConfigRestClient(mappath);
        try {
            //To determine whether the indice demo exists, it returns true if it exists and false if it does not
            boolean exist = clientUtil.existIndiceType("demo", "demo");
            //Delete mapping if the indice demo already exists
            if (exist) {
                String r = clientUtil.dropIndice("demo");
                logger.debug("clientUtil.dropIndice(\"demo\") response:" + r);
            }
            //Create index demo
            clientUtil.createIndiceMapping("demo",//The indice name
                    "createDemoIndice");//Index mapping DSL script name, defined createDemoIndice in esmapper/demo.xml

            String demoIndice = clientUtil.getIndice("demo");//Gets the newly created indice structure
            logger.info("after createIndiceMapping clientUtil.getIndice(\"demo\") response:" + demoIndice);
        } catch (ElasticSearchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void addAndUpdateDocument() {
        //Build a create/modify/get/delete document client object, single instance multi-thread security
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        //Build an object as index document
        Demo demo = new Demo();
        demo.setDemoId(1L);//Specify the document id, the unique identity, and mark with the @ESId annotation. If the demoId already exists, modify the document; otherwise, add the document
        demo.setAgentStartTime(new Date());
        demo.setAgentStartTimeZh(new Date());
        demo.setApplicationName("prvider-annotoion-pageInfo");
        demo.setContentBody("this is content body1");
        demo.setName("mark");
        demo.setOrderId("NFZF1504587180728144530000");
        demo.setContrastStatus(2);
        //Add the document and force refresh
        //Add the document and force refresh
        String response = clientUtil.addDocument("demo",//indice name
                "demo",//idnex type
                demo, "refresh=true");
        logger.debug("Print the result：addDocument-------------------------");
        logger.debug(response);


        demo = new Demo();
        demo.setDemoId(2L);//Specify the document id, the unique identity, and mark with the @ESId annotation. If the demoId already exists, modify the document; otherwise, add the document
        demo.setApplicationName("blackcatdemo2");
        demo.setContentBody("this is content body2");
        demo.setName("zhangxueyou");
        demo.setOrderId("NFZF15045871807281445364228");
        demo.setContrastStatus(3);
        demo.setAgentStartTime(new Date());
        demo.setAgentStartTimeZh(new Date());

        //Add the document and force refresh
        response = clientUtil.addDocument("demo",//indice name
                "demo",//idnex type
                demo, "refresh=true");

        //Get the document object according to the document id, and return the Demo object
        demo = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "2",//document id
                Demo.class);
        logger.info(JSON.toJSONString(demo));


    }

    public void updateDemoDocuments() {
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        //update document
        Demo demo = new Demo();
        demo.setDemoId(2L);//Specify the document id, the unique identity, and mark with the @ESId annotation. If the demoId already exists, modify the document; otherwise, add the document
        demo.setApplicationName("blackcatmarktest");
        demo.setContentBody("this is modify content 张学友");
        demo.setName("张学友\t");
        demo.setOrderId("NFZF15045871807281445364228");
        demo.setContrastStatus(1);
        demo.setAgentStartTime(new Date());
        demo.setAgentStartTimeZh(new Date());
        //Execute update and force refresh
        String response = clientUtil.updateDocument("demo",//index name
                "demo", "j22BiIABPEdR77RHLp1m", demo);


        //Get the modified document object according to the document id and return the json message string
        response = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "j22BiIABPEdR77RHLp1m");//document id
        logger.info("Print updateDocument:getDocument---documentId3----------------------");
        logger.info(response);

    }

    public void testBulkAddDocuments() {
        //创建批量创建文档的客户端对象，单实例多线程安全
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
        List<Demo> demos = new ArrayList<Demo>();
        Demo demo = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20002; i++) {
            demo = new Demo();//定义第一个对象
            demo.setDemoId((long) i);
            demo.setAgentStartTime(new Date());
            demo.setApplicationName("blackcatdemo" + i);
            demo.setContentBody("this is content body" + i);
            if (i % 2 == 0) {
                demo.setName("刘德华喜欢唱歌" + i);
            } else {
                demo.setName("张学友不喜欢唱歌" + i);
            }

            demo.setOrderId("NFZF15045871807281445364228");
            demo.setContrastStatus(2);
            demos.add(demo);//添加第一个对象到list中
        }
        //批量添加或者修改2万个文档，将两个对象添加到索引表demo中，批量添加2万条记录耗时1.8s，
        String response = clientUtil.addDocuments("demo",//索引表
                "demo",//索引类型
                demos, "refresh=true");//为了测试效果,启用强制刷新机制，实际线上环境去掉最后一个参数"refresh=true"
        long end = System.currentTimeMillis();
        System.out.println("BulkAdd 20002 Documents elapsed:" + (end - start) + "毫秒");
        start = System.currentTimeMillis();
        //scroll查询2万条记录：0.6s，参考文档：https://my.oschina.net/bboss/blog/1942562
        ESDatas<Demo> datas = clientUtil.scroll("demo/_search", "{\"size\":1000,\"query\": {\"match_all\": {}}}", "1m", Demo.class);
        end = System.currentTimeMillis();
        System.out.println("scroll SearchAll 20002 Documents elapsed:" + (end - start) + "毫秒");
        int max = 6;
        Map params = new HashMap();
        params.put("sliceMax", max);//最多6个slice，不能大于share数
        params.put("size", 1000);//每页1000条记录

        datas = clientUtil.scrollSlice("demo/_search", "scrollSliceQuery", params, "1m", Demo.class);
        //scroll上下文有效期1分钟
        //scrollSlice 并行查询2万条记录：0.1s，参考文档：https://my.oschina.net/bboss/blog/1942562
        start = System.currentTimeMillis();
        datas = clientUtil.scrollSliceParallel("demo/_search", "scrollSliceQuery", params, "1m", Demo.class);
        end = System.currentTimeMillis();
        System.out.println("scrollSlice SearchAll 20002 Documents elapsed:" + (end - start) + "毫秒");
        if (datas != null) {
            System.out.println("scrollSlice SearchAll datas.getTotalSize():" + datas.getTotalSize());
            if (datas.getDatas() != null) {
                System.out.println("scrollSlice SearchAll datas.getDatas().size():" + datas.getDatas().size());
            }
        }
        long count = clientUtil.countAll("demo");

        System.out.println("addDocuments-------------------------" + count);
        //System.out.println(response);
        //获取第一个文档
        response = clientUtil.getDocument("demo",//索引表
                "demo",//索引类型
                "2");//w
//    System.out.println("getDocument-------------------------");
//    System.out.println(response);
        //获取第二个文档
        demo = clientUtil.getDocument("demo",//索引表
                "demo",//索引类型
                "3",//文档id
                Demo.class);
    }

    public void deleteDocuments() {
        //Build a create/modify/get/delete document client object, single instance multi-thread security
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        //Batch delete documents
        clientUtil.deleteDocuments("demo",//indice name
                "demo",//idnex type
                new String[]{"2", "3"});//Batch delete document ids
    }

    /**
     * Use slice parallel scoll query all documents of indice demo by 2 thread tasks. DEFAULT_FETCHSIZE is 5000
     */
    public void searchDemoByDocumentId() {
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        // ESDatas<Demo> esDatas = clientUtil.searchAllParallel("demo", Demo.class, 2);
        //Get the document object according to the document id, and return the Demo object
        Demo demo = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "j22BiIABPEdR77RHLp1m",//document id
                Demo.class);
        logger.info("searchAllPararrel==:" + JSON.toJSONString(demo));
    }


    /**
     * Search the documents
     */
    public void addGateWay() throws Exception {
        //Create a load DSL file client instance to retrieve documents, single instance multithread security
        ClientInterface clientUtil = bbossESStarter.getConfigRestClient("esmapper/gateway.xml");
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            //Set the values of applicationName1 and applicationName2 variables
            params.put("applicationName1", "mark1");
            params.put("applicationName2", "test2");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //Set the time range, and accept the long value as the time parameter

//            params.put("startTime", dateFormat.parse(new Date().toString()).getTime());
//
//            params.put("endTime", new Date().getTime());
            String response = clientUtil.addDocument("gateway",//indice name
                    "gateway",//idnex type
                    params, "refresh=true");
            logger.info("Print the result：addDocument--------gateway-----------------");
            logger.info(response);
        } catch (Exception ex) {
            logger.error("gateway error" + ex.getMessage());
        }

    }

    public String searchMapParamsResult() {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
        //Execute the query
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("applicationName1", "prvider-annotoion-pageInfo");
        params.put("applicationName2", "blackcatmarktest");
        String template = clientUtil.executeHttp("/demo/_search", "searchDatas", params, ClientInterface.HTTP_POST);
        logger.info("template============" + template);
        return template;
    }

    public DemoSearchResult SearchAllDemoResult() throws Exception {
        DemoSearchResult demoSearchResult = new DemoSearchResult();
        try {
            ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
            ESDatas<Demo> esDatas = clientUtil.searchAllParallel("demo", Demo.class, 2);

            //Gets a list of result objects and returns max up to 1000 records (specified in DSL)
            List<Demo> demos = esDatas.getDatas();
            logger.info(JSON.toJSONString("demos=============" + demos));


            String json = com.frameworkset.util.SimpleStringUtil.object2json(demos);
            logger.info("demos json====" + json);
            //Gets the total number of records
            long totalSize = esDatas.getTotalSize();

            demoSearchResult.setDemos(demos);
            demoSearchResult.setTotalSize(totalSize);
            logger.info("demoSearchResult" + JSON.toJSONString(demoSearchResult));
        } catch (Exception ex) {
            throw new Exception("错误=====" + ex.getMessage());
        }
        return demoSearchResult;
    }

}
