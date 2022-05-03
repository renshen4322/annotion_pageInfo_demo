package com.dn;

import com.dn.service.DocumentCRUD;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName:BBossDocmentTest
 * Package:com.dn
 * Description:
 *
 * @Date:2022/5/3 18:11
 * @Author: mark
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BBossDocmentTest {
    @Autowired
    private BBossESStarter bbossESStarter;
    @Autowired
    DocumentCRUD documentCRUD;

    private Logger logger = LoggerFactory.getLogger(BBossESStarterTestCase.class);//日志


    private ClientInterface clientInterface;//bboss dsl工具
}
