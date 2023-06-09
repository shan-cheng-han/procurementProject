package com.hs.dictionary.controller;

import com.hs.dictionary.service.DictionaryService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 韩善成
 * @data 2023/6/7 6:25
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DictionaryControllerTest {

    @Autowired
    private DictionaryService dictionaryService;

    @Test
    public void testQuery() {
        dictionaryService.query();
        System.out.println("aa");
    }
}