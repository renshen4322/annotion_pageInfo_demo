package com.dn.service;

import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.frameworkset.elasticsearch.scroll.HandlerInfo;
import org.frameworkset.elasticsearch.scroll.ScrollHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:EsDataService
 * Package:com.dn.service
 * Description:
 *
 * @Date:2022/5/6 10:17
 * @Author: mark
 */
@Service
@Slf4j
public class EsDataService {

    @Autowired
    private BBossESStarter bbossESStarter;

    private ClientInterface clientInterface;//bboss dsl工具
    /**
     * 源库索引全量数据导入
     * 并行方式执行slice scroll操作：将一个es的数据导入另外一个es数据，需要在application.properties文件中定义default和es233的两个集群
     */
    public void testSimpleSliceScrollApiParralHandlerExport() {
        ClientInterface clientUtil522 = ElasticSearchHelper.getRestClientUtil("default");//定义一个对应目标集群default的客户端组件实例

        final ClientInterface clientUtil234 = ElasticSearchHelper.getRestClientUtil("es233"); //定义一个对应源集群es233的客户端组件实例

        //从源集群索引demo中按每批10000笔记录查询数据，在handler中通过addDocuments将批量检索出的数据导入目标库
        ESDatas<Map> sliceResponse = clientUtil522.searchAllParallel("demo",10000, new ScrollHandler<Map>() {
                    @Override
                    public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果,注意结果是异步检索的
                        List<Map> datas = response.getDatas();
                        clientUtil234.addDocuments("index233","indextype233",datas);
                        //将分批查询的数据导入目标集群索引index233，索引类型为indextype233，如果是elasticsearch 7以上的版本，可以去掉索引类型参数，例如：
                        //clientUtil234.addDocuments("index233",datas);
                        long totalSize = response.getTotalSize();
                        log.info("totalSize:"+totalSize+",datas.size:"+datas.size());
                    }
                },Map.class //指定检索的文档封装类型
                ,6);//6个工作线程并发导入

        long totalSize = sliceResponse.getTotalSize();
        log.info("totalSize:"+totalSize);

    }
    /**
     * 源库索引有查询条件导入
     * 并行方式执行slice scroll操作：将一个es的数据导入另外一个es数据，需要在application.properties文件中定义default和es233的两个集群
     */
     public void testSimpleSliceScrollApiParralHandlerExport2() {
        ClientInterface clientUtil522 = ElasticSearchHelper.getConfigRestClientUtil("default","esmapper/scroll.xml");//定义一个对应源集群default的客户端组件实例，并且加载配置了scrollSliceQuery dsl的xml配置文件

        final ClientInterface clientUtil234 = ElasticSearchHelper.getRestClientUtil("es233"); //定义一个对应目标集群es233的客户端组件实例
        //scroll slice分页检索,max对应并行度，与源表shards数一致即可
        int max = 6;
        Map params = new HashMap();
        params.put("sliceMax", max);//最多6个slice，不能大于share数，必须使用sliceMax作为变量名称
        params.put("size", 5000);//每批5000条记录
        //采用自定义handler函数处理每个slice scroll的结果集后，sliceResponse中只会包含总记录数，不会包含记录集合
        //scroll上下文有效期1分钟，从源集群索引demo中查询数据
        ESDatas<Map> sliceResponse = clientUtil522.scrollSliceParallel("test_demo/_search",
                "scrollSliceQuery", params,"1m",Map.class, new ScrollHandler<Map>() {
                    @Override
                    public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果,注意结果是异步检索的
                        List<Map> datas = response.getDatas();
                        clientUtil234.addDocuments("index233","indextype233",datas);
                        //将分批查询的数据导入目标集群索引index233，索引类型为indextype233，如果是elasticsearch 7以上的版本，可以去掉索引类型参数，例如：
                        //clientUtil234.addDocuments("index233",datas);
                        long totalSize = response.getTotalSize();
                        System.out.println("totalSize:"+totalSize+",datas.size:"+datas.size());
                    }
                });

        long totalSize = sliceResponse.getTotalSize();
        System.out.println("totalSize:"+totalSize);

    }

    /**
     * spring boot全量导入
     * 并行方式执行slice scroll操作：将一个es的数据导入另外一个es数据，需要在application.properties文件中定义default和es233的两个集群
     */

    public void testSimpleSliceScrollApiParralHandlerExport3() {
        ClientInterface clientUtil522 = bbossESStarter.getRestClient("default");//定义一个对应目标集群default的客户端组件实例

        final ClientInterface clientUtil234 = bbossESStarter.getRestClient("es233"); //定义一个对应源集群es233的客户端组件实例

        //从源集群索引demo中按每批10000笔记录查询数据，在handler中通过addDocuments将批量检索出的数据导入目标库
        ESDatas<Map> sliceResponse = clientUtil522.searchAllParallel("demo",10000, new ScrollHandler<Map>() {
                    @Override
                    public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果,注意结果是异步检索的
                        List<Map> datas = response.getDatas();
                        clientUtil234.addDocuments("index233","indextype233",datas);
                        //将分批查询的数据导入目标集群索引index233，索引类型为indextype233，如果是elasticsearch 7以上的版本，可以去掉索引类型参数，例如：
                        //clientUtil234.addDocuments("index233",datas);
                        long totalSize = response.getTotalSize();
                        System.out.println("totalSize:"+totalSize+",datas.size:"+datas.size());
                    }
                },Map.class //指定检索的文档封装类型
                ,6);//6个工作线程并发导入

        long totalSize = sliceResponse.getTotalSize();
        System.out.println("totalSize:"+totalSize);

    }
    /**
     *  spring boot 有查询条件导入
     * 并行方式执行slice scroll操作：将一个es的数据导入另外一个es数据，需要在application.properties文件中定义default和es233的两个集群
     */
    public void testSimpleSliceScrollApiParralHandlerExportDsl() {
        ClientInterface clientUtil522 = bbossESStarter.getConfigRestClient("default","esmapper/scroll.xml");//定义一个对应源集群default的客户端组件实例，并且加载配置了scrollSliceQuery dsl的xml配置文件

        final ClientInterface clientUtil234 = bbossESStarter.getRestClient("es233"); //定义一个对应目标集群es233的客户端组件实例
        //scroll slice分页检索,max对应并行度，与源表shards数一致即可
        int max = 6;
        Map params = new HashMap();
        params.put("sliceMax", max);//最多6个slice，不能大于share数，必须使用sliceMax作为变量名称
        params.put("size", 500);//每批500条记录
        //采用自定义handler函数处理每个slice scroll的结果集后，sliceResponse中只会包含总记录数，不会包含记录集合
        //scroll上下文有效期1分钟，从源集群索引demo中查询数据
        ESDatas<Map> sliceResponse = clientUtil522.scrollSliceParallel("test_demo/_search",
                "scrollSliceQuery", params,"1m",Map.class, new ScrollHandler<Map>() {
                    @Override
                    public void handle(ESDatas<Map> response, HandlerInfo handlerInfo) throws Exception {//自己处理每次scroll的结果,注意结果是异步检索的
                        List<Map> datas = response.getDatas();
                        clientUtil234.addDocuments("index233","indextype233",datas);
                        //将分批查询的数据导入目标集群索引index233，索引类型为indextype233，如果是elasticsearch 7以上的版本，可以去掉索引类型参数，例如：
                        //clientUtil234.addDocuments("index233",datas);
                        long totalSize = response.getTotalSize();
                        System.out.println("totalSize:"+totalSize+",datas.size:"+datas.size());
                    }
                });

        long totalSize = sliceResponse.getTotalSize();
        System.out.println("totalSize:"+totalSize);

    }
}
