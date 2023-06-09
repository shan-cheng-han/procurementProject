package com.hs.controller;

import com.hs.bean.fazhi.Fazhi;
import com.hs.mapper.FazhiMapper;
import com.hs.mapper.SpareMapper;
import com.hs.mapper.SubclassMapper;
import com.hs.service.FazhiService;
import com.hs.service.SpareService;
import com.hs.service.SubclassService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/9 12:01
 */
@SpringBootTest

@Slf4j
public class FazhiControllerTest extends TestCase {



    @Autowired
    private SpareMapper spareMapper;
    @Autowired
    private SubclassMapper subclassMapper;
    @Autowired
    private FazhiMapper fazhiMapper;

    @Test
    public void testAddFazhi() {

        Fazhi a = new Fazhi();
        a.setId(1);
        a.setRemark("sadsa");
        a.setFazhiNum(1000);
        a.setSpareCode("10086");
        a.setLegalPersonCode("1200");
        Date date = new Date();
        //a.setCreateTime(date);
        //a.setModifyTime(date);
        a.setCreateMan("小明");
        a.setModifyMan("小明");

        fazhiMapper.addFazhi(a);

    }

    @Test
    public void testUpdateFazhi() {

        Fazhi a = new Fazhi();
        a.setRemark("sadsa");
        a.setFazhiNum(1000);
        a.setSpareCode("10086");
        a.setLegalPersonCode("1200");
        Date date = new Date();
        a.setCreateTime(date);
        a.setModifyTime(date);
        a.setCreateMan("小明");
        a.setModifyMan("小明");

        fazhiMapper.addFazhi(a);

    }

    @Test
    public void testQueryPage() {


    }

    @Test
    public void testGetSpareCodeAndNameByLegalPersonCode() {


    }

    @Test
    public void testGetSubclassNameBySpareCode() {



    }




}