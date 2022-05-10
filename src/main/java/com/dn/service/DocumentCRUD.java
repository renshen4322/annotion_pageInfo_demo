package com.dn.service;

import com.alibaba.fastjson.JSON;
import com.dn.dto.DemoSearchResult;
import com.dn.model.Demo;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchException;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.frameworkset.elasticsearch.scroll.HandlerInfo;
import org.frameworkset.elasticsearch.scroll.ScrollHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
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
@Slf4j
public class DocumentCRUD {
    private final Logger logger = LoggerFactory.getLogger(DocumentCRUD.class);
    @Autowired
    private BBossESStarter bbossESStarter;
    //DSL config file path
    private final String mappath = "esmapper/demo.xml";


    private final String mappath2 = "esmapper/gateway.xml";

    private ClientInterface clientInterface;//bboss dsl工具

    public void dropDemoIndice() {
        ClientInterface clientUtil = bbossESStarter.getConfigRestClient(mappath);

        //To determine whether the indice demo exists, it returns true if it exists and false if it does not
        boolean exist = clientUtil.existIndice("demo");

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
                "1",//document id
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

    public void addDemoDocument() {
        //Build a create/modify/get/delete document client object, single instance multi-thread security
        ClientInterface clientUtil = bbossESStarter.getRestClient();
      /*  boolean exist = clientUtil.existIndiceType("demo", "demo");
        //Delete mapping if the indice demo already exists
        if (exist) {
            String r = clientUtil.dropIndice("demo");
            logger.debug("clientUtil.dropIndice(\"demo\") response:" + r);
        }*/
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
        demo = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "1",//document id
                Demo.class);
        logger.info(JSON.toJSONString(demo));

        demo = new Demo();
        demo.setDemoId(2L);//Specify the document id, the unique identity, and mark with the @ESId annotation. If the demoId already exists, modify the document; otherwise, add the document
        demo.setApplicationName("blackcatdemo2");
        demo.setContentBody("this is content body2");
        demo.setName("张学友");
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

        demo = new Demo();
        demo.setDemoId(3L);//Specify the document id, the unique identity, and mark with the @ESId annotation. If the demoId already exists, modify the document; otherwise, add the document
        demo.setApplicationName("demo3");
        demo.setContentBody("this is content body3");
        demo.setName("李雪主");
        demo.setOrderId("NFZF15045871807281445364228");
        demo.setContrastStatus(2);
        demo.setAgentStartTime(new Date());
        demo.setAgentStartTimeZh(new Date());

        //Add the document and force refresh
        response = clientUtil.addDocument("demo",//indice name
                "demo",//idnex type
                demo, "refresh=true");

        //Get the document object according to the document id, and return the Demo object
        demo = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "3",//document id
                Demo.class);
        logger.info(JSON.toJSONString(demo));

        demo = new Demo();
        demo.setDemoId(4L);//Specify the document id, the unique identity, and mark with the @ESId annotation. If the demoId already exists, modify the document; otherwise, add the document
        demo.setApplicationName("demo4");
        demo.setContentBody("this is content body4");
        demo.setName("李天一");
        demo.setOrderId("NFZF15045871807281445364228");
        demo.setContrastStatus(2);
        demo.setAgentStartTime(new Date());
        demo.setAgentStartTimeZh(new Date());

        //Add the document and force refresh
        response = clientUtil.addDocument("demo",//indice name
                "demo",//idnex type
                demo, "refresh=true");

        //Get the document object according to the document id, and return the Demo object
        demo = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "4",//document id
                Demo.class);
        logger.info(JSON.toJSONString(demo));

        demo = new Demo();
        demo.setDemoId(5L);//Specify the document id, the unique identity, and mark with the @ESId annotation. If the demoId already exists, modify the document; otherwise, add the document
        demo.setApplicationName("demo5");
        demo.setContentBody("this is content body5");
        demo.setName("程明");
        demo.setOrderId("NFZF15045871807281445364228");
        demo.setContrastStatus(1);
        demo.setAgentStartTime(new Date());
        demo.setAgentStartTimeZh(new Date());

        //Add the document and force refresh
        response = clientUtil.addDocument("demo",//indice name
                "demo",//idnex type
                demo, "refresh=true");

        //Get the document object according to the document id, and return the Demo object
        demo = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "5",//document id
                Demo.class);
        logger.info(JSON.toJSONString(demo));


    }

    public void updateDemoDocuments() {
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        //update document
        Demo demo = new Demo();
        demo.setDemoId(2L);//Specify the document id, the unique identity, and mark with the @ESId annotation. If the demoId already exists, modify the document; otherwise, add the document
        demo.setApplicationName("blackcatmarktest");
        demo.setContentBody(" content 张学友");
        demo.setName("张学友\t");
        demo.setOrderId("NFZF15045871807281445364228");
        demo.setContrastStatus(1);
        demo.setAgentStartTime(new Date());
        demo.setAgentStartTimeZh(new Date());
        //Execute update and force refresh
        String response = clientUtil.updateDocument("demo",//index name
                "demo", "2", demo,"refresh=true" );
        //Get the modified document object according to the document id and return the json message string
        response = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "2");//document id
        logger.info("Print updateDocument:getDocument---documentId3----------------------");
        logger.info(response);

    }

    public void delTestDemo() {
        ClientInterface clientUtil = bbossESStarter.getConfigRestClient("esmapper/demo.xml");
        //To determine whether the indice demo exists, it returns true if it exists and false if it does not
        boolean exist = clientUtil.existIndice("test_demo");
        //Delete mapping if the indice demo already exists
        if (exist) {
            String r = clientUtil.dropIndice("test_demo");
            logger.debug("clientUtil.dropIndice(\"test_demo\") response:" + r);
        }
    }

    /**
     * 创建批量创建文档的客户端对象，单实例多线程安全
     */
    public void testBulkAddDocuments() {
        //创建批量创建文档的客户端对象，单实例多线程安全
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/demo.xml");
        List<Demo> demos = new ArrayList<Demo>();
        Demo demo = null;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 2002; i++) {
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
        String response = clientUtil.addDocuments("test_demo",//索引表
                //索引类型
                demos, "refresh=true");//为了测试效果,启用强制刷新机制，实际线上环境去掉最后一个参数"refresh=true"
        long end = System.currentTimeMillis();
        System.out.println("BulkAdd 2000 Documents elapsed:" + (end - start) + "毫秒");
        start = System.currentTimeMillis();
        //scroll查询2w条记录：0.6s，参考文档：https://my.oschina.net/bboss/blog/1942562
        ESDatas<Demo> datas = clientUtil.scroll("test_demo/_search", "{\"size\":100,\"query\": {\"match_all\": {}}}", "1m", Demo.class);
        end = System.currentTimeMillis();
        System.out.println("scroll SearchAll 2000 Documents test_demo elapsed:" + (end - start) + "毫秒");

    }

    public void testSimleScrollAPI(){
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
        //scroll分页检索
        Map params = new HashMap();
        params.put("size", 500);//每页10000条记录
        //scroll上下文有效期1分钟,每次scroll检索的结果都会合并到总得结果集中；数据量大时存在oom内存溢出风险，大数据量时可以采用handler函数来处理每次scroll检索的结果(后面介绍)
        ESDatas<Map> response = clientUtil.scroll("test_demo/_search","scrollQuery","1m",params,Map.class);
        List<Map> datas = response.getDatas();
        long realTotalSize = datas.size();
        long totalSize = response.getTotalSize();
        log.info("test_demo===="+datas.get(0).values());
        logger.info("totalSize:"+totalSize);
        logger.info("realTotalSize:"+realTotalSize);
        logger.info("countAll:"+clientUtil.countAll("test_demo"));
    }

    //串行
    public void testSimleScrollAPIHandler(){
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
        //scroll分页检索

        Map params = new HashMap();
        params.put("size", 500);//每页5000条记录
        //采用自定义handler函数处理每个scroll的结果集后，response中只会包含总记录数，不会包含记录集合
        //scroll上下文有效期1分钟；大数据量时可以采用handler函数来处理每次scroll检索的结果，规避数据量大时存在的oom内存溢出风险
        ESDatas<Map> response = clientUtil.scroll("test_demo/_search", "scrollQuery", "1m", params, Map.class, new ScrollHandler<Map>() {
            @Override
            public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果
                List<Map> datas = response.getDatas();
                long totalSize = response.getTotalSize();
                logger.info("totalSize:"+totalSize+",datas.size:"+datas.size());
            }
        });

       logger.info("response realzie:"+response.getTotalSize());

    }

   //并行
    public void testSimleScrollParallelAPIHandler(){
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
        //scroll分页检索
        Map params = new HashMap();
        params.put("size", 500);//每页5000条记录
        //采用自定义handler函数处理每个scroll的结果集后，response中只会包含总记录数，不会包含记录集合
        //scroll上下文有效期1分钟
        ESDatas<Map> response = clientUtil.scrollParallel("test_demo/_search", "scrollQuery", "1m", params, Map.class, new ScrollHandler<Map>() {
            @Override
            public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果
                List<Map> datas = response.getDatas();
                long totalSize = response.getTotalSize();
                System.out.println("totalSize:"+totalSize+",datas.size:"+datas.size());
            }
        });

        System.out.println("response realzie:"+response.getTotalSize());

    }

    /**
     * 串行方式执行slice scroll操作
     */
    public void testSimpleSliceScrollApi() {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");

        //scroll slice分页检索,max对应并行度，一般设置为与索引表的shards数一致
        int max = 6;

        Map params = new HashMap();
        params.put("sliceMax", max);//建议不要大于索引表的shards数
        params.put("size", 100);//每页100条记录
        //scroll上下文有效期1分钟,每次scroll检索的结果都会合并到总得结果集中；数据量大时存在oom内存溢出风险，大数据量时可以采用handler函数来处理每次slice scroll检索的结果(后面介绍)
        ESDatas<Map> sliceResponse = clientUtil.scrollSlice("test_demo/_search",
                "scrollSliceQuery", params,"1m",Map.class);//串行；如果数据量大，建议采用并行方式来执行
        logger.info("totalSize:"+sliceResponse.getTotalSize());
        logger.info("realSize size:"+sliceResponse.getDatas().size());
        log.info("Data===="+sliceResponse.getDatas().get(0));
    }

    /**
     * 并行方式执行slice scroll操作
     */
    public void testSimpleSliceScrollApiParral() {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");

        //scroll slice分页检索,max对应并行度，一般设置为与索引表的shards数一致
        int max = 6;

        Map params = new HashMap();
        params.put("sliceMax", max);//这里设置6个slice，建议不要大于索引表的shards数，必须使用sliceMax作为变量名称
        params.put("size", 100);//每页100条记录
        //scroll上下文有效期2分钟,每次scroll检索的结果都会合并到总得结果集中；数据量大时存在oom内存溢出风险，大数据量时可以采用handler函数来处理每次scroll检索的结果(后面介绍)
        ESDatas<Map> sliceResponse = clientUtil.scrollSliceParallel("test_demo/_search",
                "scrollSliceQuery", params,"2m",Map.class);//表示并行，会从slice scroll线程池中申请sliceMax个线程来并行执行slice scroll检索操作，大数据量多个shared分片的情况下建议采用并行模式
        logger.info("totalSize:"+sliceResponse.getTotalSize());
        logger.info("realSize size:"+sliceResponse.getDatas().size());
        logger.info(""+sliceResponse.getDatas().get(1));

    }

    /**
     * 串行方式执行slice scroll Handler操作
     */
    public void testSimpleSliceScrollApiHandler() {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
        //scroll slice分页检索,max对应并行度，一般设置为与索引表的shards数一致
        int max = 6;

        Map params = new HashMap();
        params.put("sliceMax", max);//这里设置6个slice，建议不要大于索引表的shards数，必须使用sliceMax作为变量名称
        params.put("size", 1000);//每页1000条记录
        //采用自定义handler函数处理每个slice scroll的结果集后，sliceResponse中只会包含总记录数，不会包含记录集合
        //scroll上下文有效期1分钟,大数据量时可以采用handler函数来处理每次scroll检索的结果，规避数据量大时存在的oom内存溢出风险
        ESDatas<Map> sliceResponse = clientUtil.scrollSlice("test_demo/_search",
                "scrollSliceQuery", params,"1m",Map.class, new ScrollHandler<Map>() {
                    @Override
                    public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果
                        List<Map> datas = response.getDatas();
                        long totalSize = response.getTotalSize();
                        log.info("totalSize:"+totalSize+",datas.size:"+datas.size());
                    }
                });//串行，如果数据量大建议采用并行模式
        long totalSize = sliceResponse.getTotalSize();
        log.info("=====totalSize:"+totalSize);
    }
    /**
     * 并行方式执行slice scroll Handler操作
     */
    public void testSimpleSliceScrollApiParralHandler() {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/scroll.xml");
        //scroll slice分页检索,max对应并行度，一般设置为与索引表的shards数一致
        int max = 6;
        Map params = new HashMap();
        params.put("sliceMax", max);//这里设置6个slice，建议不要大于索引表的shards数，必须使用sliceMax作为变量名称
        params.put("size", 1000);//每页1000条记录
        //采用自定义handler函数处理每个slice scroll的结果集后，sliceResponse中只会包含总记录数，不会包含记录集合
        //scroll上下文有效期1分钟,大数据量时可以采用handler函数来处理每次scroll检索的结果，规避数据量大时存在的oom内存溢出风险
        ESDatas<Map> sliceResponse = clientUtil.scrollSliceParallel("test_demo/_search",
                "scrollSliceQuery", params,"1m",Map.class, new ScrollHandler<Map>() {
                    @Override
                    public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果,注意结果是异步检索的
                        List<Map> datas = response.getDatas();
                        long totalSize = response.getTotalSize();
                       log.info("totalSize:"+totalSize+",datas.size:"+datas.size());
                    }
                });//表示并行，会从slice scroll线程池中申请sliceMax个线程来并行执行slice scroll检索操作，大数据量多个shared分片的情况下建议采用并行模式
        long totalSize = sliceResponse.getTotalSize();
        log.info("totalSize:"+totalSize);
    }


    public void deleteDocuments() {
        //Build a create/modify/get/delete document client object, single instance multi-thread security
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        //Batch delete documents
        clientUtil.deleteDocuments("demo",//indice name
                "demo",//idnex type
                new String[]{"2", "3"});//Batch delete document ids
    }

    public void testDeleteDocument(){
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        //删除不存在的文档
        String response = clientUtil.deleteDocument("demo",//索引表
                "demo",
                "6" //文档id
                ,"refresh=true"   //此参数刷新作用
        );
        System.out.println(response);
    }

    public void searchDemoByDocumentId() {
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        // ESDatas<Demo> esDatas = clientUtil.searchAllParallel("demo", Demo.class, 2);
        //Get the document object according to the document id, and return the Demo object
        Demo demo = clientUtil.getDocument("demo",//indice name
                "demo",//idnex type
                "2",//document id
                Demo.class);
        logger.info("searchByESId==:" + JSON.toJSONString(demo));
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
        params.put("applicationName2", "blackcatdemo2");
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
