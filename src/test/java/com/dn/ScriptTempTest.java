package com.dn;

import com.dn.estest.script.ScriptImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName:ScriptTempTest
 * Package:com.tinge.xingchao.xcelasticsearch
 * Description:
 *
 * @Date:2022/5/8 22:49
 * @Author: mark
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ScriptTempTest {

    @Autowired
    private ScriptImpl scripImpl;

    @Test
    public void testBulkAddDynamicDocument(){
        scripImpl.testBulkAddDynamicDocument();
    }

    @Test
    public void updateDocumentByScriptPath(){
        scripImpl.updateDocumentByScriptPath();
    }
    @Test
    public void updateDocumentByScriptQueryPath(){
        scripImpl.updateDocumentByScriptQueryPath();
    }
}
