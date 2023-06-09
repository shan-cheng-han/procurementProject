package com.hs;

import com.hs.bean.subclass.QuerySubclassVo;
import com.hs.service.SubclassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PurchaseApplicationTests {
    @Autowired
    private SubclassService subclassService;

    @Test
    void contextLoads() {
    }

    @Test
    void queryTest(){
        System.out.println(subclassService.subclassList(new QuerySubclassVo()));
    }

}
