package com.dn.estest.script;/*
 *  Copyright 2008 biaoping.yin
 *
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
import com.dn.model.Demo;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ScriptImpl {
	private String mappath = "esmapper/demo.xml";

	public void testBulkAddDynamicDocument() {
		//创建批量创建文档的客户端对象，单实例多线程安全
		ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
		List<Demo> demos = new ArrayList<Demo>();
		Demo demo = new Demo();//定义第一个对象
		demo.setDemoId(7L);
		demo.setAgentStartTime(new Date());
		demo.setAgentStartTimeZh(new Date());
		demo.setApplicationName("blackcatdemo7");
		demo.setContentBody("this is content body7");
		demo.setName("李明明77\t");
		demo.setOrderId("NFZF15045871807281445364228");
		demo.setContrastStatus(2);
		DynamicPriceTemplate dynamicPriceTemplate = new DynamicPriceTemplate();
		dynamicPriceTemplate.setGoodsId(2);
		List<Rule> ruleList = new ArrayList<Rule>();
		Rule rule = new Rule();
		rule.setRuleCount(100);
		rule.setRuleExist(true);
		rule.setRuleId("asdfasdfasdf");
		ruleList.add(rule);

		rule = new Rule();
		rule.setRuleCount(101);
		rule.setRuleExist(false);
		rule.setRuleId("bbbb");
		ruleList.add(rule);

		rule = new Rule();
		rule.setRuleCount(103);
		rule.setRuleExist(true);
		rule.setRuleId("ccccc");
		ruleList.add(rule);
		dynamicPriceTemplate.setRules(ruleList);
		demo.setDynamicPriceTemplate(dynamicPriceTemplate);
		demos.add(demo);//添加第一个对象到list中
		demo = new Demo();//定义第二个对象
		demo.setDemoId(8L);
		demo.setAgentStartTime(new Date());
		demo.setAgentStartTimeZh(new Date());
		demo.setApplicationName("blackcatdemo8");
		demo.setContentBody("四大\"天王，这种文化很好");
		demo.setName("张学友88\t\n\r");
		demo.setOrderId("NFZF15045871807281445364228");
		demo.setContrastStatus(2);
		demos.add(demo);//添加第二个对象到list中
		demo.setDynamicPriceTemplate(new HashMap());
		dynamicPriceTemplate.setGoodsId(3);
		dynamicPriceTemplate.setGoodName("自行车");
		//dynamicPriceTemplate.setRules(new ArrayList<Rule>());
		//批量添加或者修改文档，将两个对象添加到索引表demo中
		String response = clientUtil.addDocuments("demo",//索引表
				"demo",//索引类型
				demos,"refresh");//为了测试效果,启用强制刷新机制

		log.info("addDocument-------------------------");
		System.out.println(response);
		//获取第一个文档
		response = clientUtil.getDocument("demo",//索引表
				"demo",//索引类型
				"7");//w
		System.out.println("getDocument-------------------------");
		System.out.println(response);
		//获取第二个文档
		response = clientUtil.getDocument("demo",//索引表
				"demo",//索引类型
				"8"//文档id
		);

	}

	public void updateDocumentByScriptPath(){
		//创建加载配置文件的客户端工具，用来检索文档，单实例多线程安全
		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
		Map<String,Object> params = new HashMap<String,Object>();
		DynamicPriceTemplate dynamicPriceTemplate = new DynamicPriceTemplate();
		dynamicPriceTemplate.setGoodsId(1);
		List<Rule> ruleList = new ArrayList<Rule>();
		Rule rule = new Rule();
		rule.setRuleCount(100);
		rule.setRuleExist(true);
		rule.setRuleId("fast test88");
		ruleList.add(rule);
		rule = new Rule();
		rule.setRuleCount(101);
		rule.setRuleExist(false);
		rule.setRuleId("bbb$b");
		ruleList.add(rule);
		rule = new Rule();
		rule.setRuleCount(103);
		rule.setRuleExist(true);
		rule.setRuleId("ccccc");
		ruleList.add(rule);
		dynamicPriceTemplate.setRules(ruleList);
		//为id为7的文档增加last和nick两个属性
		params.put("last","gaudreau");
		params.put("nick","hockey");
		params.put("dynamicPriceTemplate",dynamicPriceTemplate);
		//通过script脚本为id为7的文档增加last和nick两个属性，为了演示效果强制refresh，实际环境慎用
		clientUtil.updateByPath("demo/demo/7/_update?refresh","scriptDsl",params);
		//获取更新后的文档，会看到新加的2个字段属性
		String doc = clientUtil.getDocument("demo","demo","7");
		System.out.println(doc);

	}


	public void updateDocumentByScriptQueryPath(){
		//创建加载配置文件的客户端工具，用来检索文档，单实例多线程安全
		ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(mappath);
		Map<String,Object> params = new HashMap<String,Object>();
		DynamicPriceTemplate dynamicPriceTemplate = new DynamicPriceTemplate();
		dynamicPriceTemplate.setGoodsId(1);
		dynamicPriceTemplate.setGoodName("asd\"国家");
		List<Rule> ruleList = new ArrayList<Rule>();
		Rule rule = new Rule();
		rule.setRuleCount(100);
		rule.setRuleExist(true);
		rule.setRuleId("asdfasd$fasdf");
		ruleList.add(rule);

		rule = new Rule();
		rule.setRuleCount(101);
		rule.setRuleExist(false);
		rule.setRuleId("bbbb");
		ruleList.add(rule);

		rule = new Rule();
		rule.setRuleCount(103);
		rule.setRuleExist(true);
		rule.setRuleId(null);
		ruleList.add(rule);
		dynamicPriceTemplate.setRules(ruleList);


		//为id为2的文档增加last和nick两个属性
		params.put("last","gaudre$au");
		params.put("nick","hockey");
		params.put("id",8);
		params.put("dynamicPriceTemplate",dynamicPriceTemplate);
		//通过script脚本为id为2的文档增加last和nick两个属性，为了演示效果强制refresh，实际环境慎用
		clientUtil.updateByPath("demo/demo/_update_by_query?refresh","scriptDslByQuery",params);
		//获取更新后的文档，会看到新加的2个字段属性
		String doc = clientUtil.getDocument("demo","demo","8");
		System.out.println(doc);

	}


}
