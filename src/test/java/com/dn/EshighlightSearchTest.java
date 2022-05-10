package com.dn;

import com.dn.estest.searchafter.HighlightSearch;
import com.dn.service.DocumentCRUD;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

/**
 * ClassName:EshighlightSearchTest
 * Package:com.tinge.xingchao.xcelasticsearch
 * Description:
 *
 * @Date:2022/5/10 14:34
 * @Author: mark
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EshighlightSearchTest {

    @Autowired
    private HighlightSearch highlightSearch;

    @Autowired
    private DocumentCRUD documentCRUD;

    @Test
    public void initTestDemoData(){
        documentCRUD.delTestDemo();
        documentCRUD.testBulkAddDocuments();

    }

    @Test
    public void highlightSearch() throws ParseException {
        highlightSearch.highlightSearch();
    }

    @Test
    public void highlightSearchOther() throws ParseException {
        highlightSearch.highlightSearchOther();
    }
}
