package com.dn.estest.crud;/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import com.alibaba.fastjson.JSON;
import com.dn.model.Demo;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.client.ClientOptions;
import org.frameworkset.elasticsearch.client.ClientUtil;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * for Elasticsearch 7.0 and upper
 */
@Service
@Slf4j
public class DocumentCRUD7 {
	private String mappath = "esmapper/demo7.xml";

	@Autowired
	private BBossESStarter bbossESStarter;

	/**
     * 修改索引表demo中type为demo的mapping结构，增加email字段
	 */
	public void updateDemoIndice(){
		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
		//修改索引表demo中type为demo的mapping结构，增加email字段，对应的dsl片段updateDemoIndice定义在esmapper/demo7.xml文件中
		String response = clientUtil.executeHttp("demo/_mapping","updateDemoIndice",ClientUtil.HTTP_PUT);
		System.out.println(response);
		//获取修改后的索引mapping结构
		String mapping = clientUtil.getIndice("demo");
		System.out.println(mapping);
	}
	public void testCreateTempate() throws ParseException{

		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
		//创建模板
		String response = clientUtil.createTempate("demotemplate_1",//模板名称
				"demoTemplate");//模板对应的脚本名称，在esmapper/demo.xml中配置
		System.out.println("createTempate-------------------------");
		System.out.println(response);
		//获取模板
		/**
		 * 指定模板
		 * /_template/demoTemplate_1
		 * /_template/demoTemplate*
		 * 所有模板 /_template
		 *
		 */
		String template = clientUtil.executeHttp("/_template/demotemplate_1",ClientUtil.HTTP_GET);
		System.out.println("HTTP_GET-------------------------");
		System.out.println(template);

	}

	/**
	 * 添加map记录
	 * @throws ParseException
	 */
	public void testAddAndUpdateMapDocument() throws ParseException {
		//创建创建/修改/获取/删除文档的客户端对象，单实例多线程安全
		ClientInterface clientUtil = bbossESStarter.getRestClient();
		//ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
		//构建一个对象，日期类型，字符串类型属性演示
		Demo demo = new Demo();
		demo.setDemoId(6L);//Specify the document id, the unique identity, and mark with the @ESId annotation. If the demoId already exists, modify the document; otherwise, add the document
		demo.setApplicationName("name for demo6");
		demo.setContentBody(" content body6");
		demo.setName("王明宇2");
		demo.setOrderId("NFZF15045871807281445364228");
		demo.setContrastStatus(1);
		demo.setAgentStartTime(new Date());
		demo.setAgentStartTimeZh(new Date());

		//强制刷新
		ClientOptions addOptions = new ClientOptions();
		addOptions.setIdField("demoId");
		//如果orderId对应的文档已经存在则更新，不存在则插入新增
		String response = clientUtil.addDocument("demo",//索引表
				"demo",
				demo,addOptions);
		/*String response = clientUtil.addDocument("demo",//indice name
				"demo",//idnex type   上下二个方式等同
				demo, "refresh=true");*/


	}

	/**
	 * 批量添加map记录 type都是_doc
	 * @throws ParseException
	 */
	public void testAddAndUpdateMapDocuments() throws ParseException {
		//创建创建/修改/获取/删除文档的客户端对象，单实例多线程安全
		ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
		List<Map> datas = new ArrayList<Map>();
		//构建一个对象，日期类型，字符串类型属性演示
		Map demo = new LinkedHashMap();
		demo.put("demoId","7");//文档id，唯一标识，@PrimaryKey注解标示,如果demoId已经存在做修改操作，否则做添加文档操作
		demo.put("agentStarttime",new Date());
		demo.put("applicationName","blackcatdemo2");
		demo.put("contentbody","this-is content body2");
		demo.put("agentStarttime",new Date());
		demo.put("name","|刘德华");
		demo.put("orderId","NFZF15045871807281445364228");
		demo.put("contrastStatus",2);
		datas.add(demo);

		demo = new LinkedHashMap();
		demo.put("demoId","8");//文档id，唯一标识，@PrimaryKey注解标示,如果demoId已经存在做修改操作，否则做添加文档操作
		demo.put("agentStarttime",new Date());
		demo.put("applicationName","blackcatdemo3");
		demo.put("contentbody","this-is content body3");
		demo.put("agentStarttime",new Date());
		demo.put("name","张三");
		demo.put("orderId","NFZF15045871807281445364228");
		demo.put("contrastStatus",3);
		datas.add(demo);


		demo = new LinkedHashMap();
		demo.put("demoId","9");//文档id，唯一标识，@PrimaryKey注解标示,如果demoId已经存在做修改操作，否则做添加文档操作
		demo.put("agentStarttime",new Date());
		demo.put("applicationName","blackcatdemo4");
		demo.put("contentbody","this-is content body4");
		demo.put("agentStarttime",new Date());
		demo.put("name","李四");
		demo.put("orderId","NFZF15045871807281445364229");
		demo.put("contrastStatus",4);
		datas.add(demo);


		//强制刷新
		ClientOptions addOptions = new ClientOptions();
		addOptions.setIdField("orderId")
		.setRefresh("true");
		//如果orderId对应的文档已经存在则更新，不存在则插入新增
		String response = clientUtil.addDocuments("demo",//索引表
				datas,addOptions);


	}




	/**
	 * 检索文档
	 * @throws ParseException
	 */
	public void testSearch() throws ParseException {
		//创建加载配置文件的客户端工具，用来检索文档，单实例多线程安全
		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
		//设定查询条件,通过map传递变量参数值,key对于dsl中的变量名称
		//dsl中有四个变量
		//        applicationName1
		//        applicationName2
		//        startTime
		//        endTime
		Map<String,Object> params = new HashMap<String,Object>();
		//设置applicationName1和applicationName2两个变量的值
		params.put("applicationName1", "prvider-annotoion-pageInfo");
		params.put("applicationName2", "blackcatdemo2");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//设置时间范围,时间参数接受long值
		params.put("startTime",dateFormat.parse("2017-09-02 00:00:00"));
		params.put("endTime",new Date());
		//执行查询，demo为索引表，_search为检索操作action
		ESDatas<Demo> esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
				clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
				"searchDatas",//esmapper/demo.xml中定义的dsl语句
				params,//变量参数
				Demo.class);//返回的文档封装对象类型
        log.info(JSON.toJSONString("esDatas========="+esDatas.getDatas()));
		long count = clientUtil.count("demo","countDatas",//esmapper/demo.xml中定义的dsl语句
				params);//变量参数

		log.info("countDatas===="+count);
		//获取结果对象列表，最多返回1000条记录
		List<Demo> demos = esDatas.getDatas();

//		String json = clientUtil.executeRequest("demo/_search",//demo为索引表，_search为检索操作action
//				"searchDatas",//esmapper/demo.xml中定义的dsl语句
//				params);

//		String json = com.frameworkset.util.SimpleStringUtil.object2json(demos);
		//获取总记录数
		long totalSize = esDatas.getTotalSize();
		log.info("searchDatas==size==="+totalSize);
		esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
				clientUtil.searchAll("demo",Demo.class);
		totalSize = esDatas.getTotalSize();
		System.out.println(totalSize);

	}

	/**
	 * 检索文档
	 * @throws ParseException
	 */
	public void testSearchWithCustomEscape() throws ParseException {
		//创建加载配置文件的客户端工具，用来检索文档，单实例多线程安全
		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
		//设定查询条件,通过map传递变量参数值,key对于dsl中的变量名称
		//dsl中有四个变量
		//        applicationName1
		//        applicationName2
		//        startTime
		//        endTime
		Map<String,Object> params = new HashMap<String,Object>();
		//设置applicationName1和applicationName2两个变量的值
		params.put("applicationName1","demo4");
		params.put("applicationName2","demo5");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//设置时间范围,时间参数接受long值
		params.put("startTime",dateFormat.parse("2017-09-02 00:00:00"));
		params.put("endTime",new Date());
		//执行查询，demo为索引表，_search为检索操作action
		ESDatas<Demo> esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
				clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
						"searchWithCustomEscape",//esmapper/demo.xml中定义的dsl语句
						params,//变量参数
						Demo.class);//返回的文档封装对象类型
		//检索单个文档
		Demo single = clientUtil.searchObject("demo/_search",//demo为索引表，_search为检索操作action
				"searchWithCustomEscape",//esmapper/demo.xml中定义的dsl语句
				params,//变量参数
				Demo.class );
		//获取结果对象列表，最多返回1000条记录
		List<Demo> demos = esDatas.getDatas();

//		String json = clientUtil.executeRequest("demo/_search",//demo为索引表，_search为检索操作action
//				"searchDatas",//esmapper/demo.xml中定义的dsl语句
//				params);

//		String json = com.frameworkset.util.SimpleStringUtil.object2json(demos);
		//获取总记录数
		long totalSize = esDatas.getTotalSize();
		System.out.println(totalSize);

		try {
			//执行查询，demo为索引表，_search为检索操作action
			esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
					clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
							"searchWithCustomEscapeWithError",//esmapper/demo.xml中定义的dsl语句
							params,//变量参数
							Demo.class);//返回的文档封装对象类型
			//获取结果对象列表，最多返回1000条记录
			demos = esDatas.getDatas();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}


	/**
	 * SourceFilter检索文档
	 * @throws ParseException
	 */
	public void testSearchSourceFilter() throws ParseException {
		//创建加载配置文件的客户端工具，用来检索文档，单实例多线程安全
		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/demo.xml");
		//设定查询条件,通过map传递变量参数值,key对于dsl中的变量名称
		//dsl中有四个变量
		//        applicationName1
		//        applicationName2
		//        startTime
		//        endTime
		Map<String,Object> params = new HashMap<String,Object>();
		//设置applicationName1和applicationName2两个变量的值，将多个应用名称放到list中，通过list动态传递参数
		List<String> datas = new ArrayList<String>();
		datas.add("blackcatdemo2");
		datas.add("blackcatdemo3");
		params.put("applicationNames",datas);

		List<String> includes = new ArrayList<String>(); //定义要返回的source字段
		includes.add("agentStarttime");
		includes.add("applicationName");
		params.put("includes",includes);

		List<String> excludes = new ArrayList<String>(); //定义不需要返回的source字段
		excludes.add("contentbody");
		excludes.add("demoId");
		params.put("excludes",excludes);


		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//设置时间范围,时间参数接受long值或者日期类型
		//说明： 也可以接受日期类型，如果传入Date类型的时间并且通过map传参，则需要手动进行日期格式转换成字符串格式的日期串，通过entity传参则不需要
		params.put("startTime",dateFormat.parse("2017-09-02 00:00:00") );
		params.put("endTime",new Date() );
		params.put("pageSize",1000);//设置每页返回的记录条数

		//执行查询，demo为索引表，_search为检索操作action
		ESDatas<Demo> esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
				clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
						"searchSourceFilter",//esmapper/demo.xml中定义的dsl语句
						params,//变量参数
						Demo.class);//返回的文档封装对象类型
		//获取总记录数
		long totalSize = esDatas.getTotalSize();

		//获取结果对象列表，最多返回1000条记录
		List<Demo> demos = esDatas.getDatas();

		System.out.println(totalSize);

	}


	/**
	 * 分页检索文档
	 * @throws ParseException
	 */
	public void testPagineSearch() throws ParseException {
		//创建加载配置文件的客户端工具，用来检索文档，单实例多线程安全
		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
		//设定查询条件,通过map传递变量参数值,key对于dsl中的变量名称
		//dsl中有四个变量
		//        applicationName1
		//        applicationName2
		//        startTime
		//        endTime
		Map<String,Object> params = new HashMap<String,Object>();
		//设置applicationName1和applicationName2两个变量的值
		params.put("applicationName1","blackcatdemo2");
		params.put("applicationName2","blackcatdemo3");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//设置时间范围,时间参数接受long值
		params.put("startTime",dateFormat.parse("2017-09-02 00:00:00"));
		params.put("endTime",new Date());

		ESDatas<Demo> esDatas =  null;//返回的文档封装对象类型
		//保存总记录数
		long totalSize = 0;
		//保存每页结果对象列表，最多返回1000条记录
		List<Demo> demos = null;
		int i = 0; //页码
		do{//遍历获取每页的记录
			//设置分页参数
			params.put("from",i * 1000);//分页起点
			params.put("size",1000);//每页返回1000条
			i ++;//往前加页码
			//执行查询，demo为索引表，_search为检索操作action
			 esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
					clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
							"searchPagineDatas",//esmapper/demo.xml中定义的dsl语句
							params,//变量参数
							Demo.class);//返回的文档封装对象类型
			demos = esDatas.getDatas();//每页结果对象列表，最多返回1000条记录
			totalSize = esDatas.getTotalSize();//总记录数
			if(i * 1000 > totalSize) {
				break;
			}
		}while(true);

		System.out.println(totalSize);
	}

	/**
	 * 检索文档
	 * @throws ParseException
	 */
	public void testSearchArray() throws ParseException {
		//创建加载配置文件的客户端工具，用来检索文档，单实例多线程安全
		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);

		//设定查询条件,通过map传递变量参数值,key对于dsl中的变量名称
		//dsl中有四个变量
		//        applicationName1
		//        applicationName2
		//        startTime
		//        endTime
		Map<String,Object> params = new HashMap<String,Object>();
		//设置applicationName1和applicationName2两个变量的值
		List<String> datas = new ArrayList<String>();
		datas.add("blackcatdemo2");
		datas.add("blackcatdemo3");
		params.put("applicationNames",datas);
//		params.put("applicationName2","blackcatdemo3");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//设置时间范围,时间参数接受long值
		params.put("startTime",dateFormat.parse("2017-09-02 00:00:00"));
		params.put("endTime",new Date());
		//执行查询，demo为索引表，_search为检索操作action
		ESDatas<Demo> esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
				clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
						"searchDatasArray",//esmapper/demo.xml中定义的dsl语句
						params,//变量参数
						Demo.class);//返回的文档封装对象类型
		//获取结果对象列表，最多返回1000条记录
		List<Demo> demos = esDatas.getDatas();

//		String json = clientUtil.executeRequest("demo/_search",//demo为索引表，_search为检索操作action
//				"searchDatas",//esmapper/demo.xml中定义的dsl语句
//				params);

//		String json = com.frameworkset.util.SimpleStringUtil.object2json(demos);
		//获取总记录数
		long totalSize = esDatas.getTotalSize();
		System.out.println(totalSize);
	}

	public void testpons(){
		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
		Demo demo = new Demo();
		demo.setDemoId(2L);
		demo.setAgentStartTime(new Date());
		demo.setApplicationName("blackcatdemo2");
		demo.setContentBody("bulk update content body2");
		demo.setName("刘德华bulk update ");
		demo.setOrderId("NFZF15045871807281445364228");
		demo.setContrastStatus(2);
		clientUtil.addDocument("demo",//索引表

				"updatePartDocument",
				demo);
	}


	public void testTerm(){

		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/orderQuery.xml");
		ESDatas<Demo> esDatas =clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
				"queryOrderList",//esmapper/demo.xml中定义的dsl语句
				Demo.class);
		//获取结果对象列表，最多返回1000条记录
		List<Demo> demos = esDatas.getDatas();
		//获取总记录数
		long totalSize = esDatas.getTotalSize();
		System.out.println(totalSize);
	}

	public void testDirectDslQuery(){
		String queryAll = "{\"query\": {\"match_all\": {}}}";
		ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
		ESDatas<Demo> esDatas =clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
				queryAll,//queryAll变量对应的dsl语句
				Demo.class);
		//获取结果对象列表，最多返回1000条记录
		List<Demo> demos = esDatas.getDatas();
		//获取总记录数
		long totalSize = esDatas.getTotalSize();
		System.out.println(totalSize);
	}

	/**
	 * Elasticsearch-SQL插件功能测试方法
	 */
	public void testESSQL(){
		ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
		ESDatas<Map> esDatas =  //ESDatas包含当前检索的记录集合，最多10条记录，由sql中的limit属性指定
				clientUtil.searchList("/_sql",//sql请求
						"select * from vem_order_index_2018 limit 0,10", //elasticsearch-sql支持的sql语句
						Map.class);//返回的文档封装对象类型
		//获取结果对象列表
		List<Map> demos = esDatas.getDatas();
		//获取总记录数
		long totalSize = esDatas.getTotalSize();
		System.out.println(totalSize);
	}

	public void test(){
		ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
		String dsl = "{\"size\":1000,\"query\": {\"match_all\": {}},\"sort\": [\"_doc\"]}";
		//执行查询，demo为索引表，_search为检索操作action
		ESDatas<Demo> esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
				clientUtil.searchList("demo/_search",//demo为索引表，_search为检索操作action
						dsl,//dsl语句
						Demo.class);//返回的文档封装对象类型
	}
}
