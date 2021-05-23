package com.imooc.girl.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 对Girl项目进行API测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlController07Test {

    @Autowired
    private GirlController07 girlController;

    @Test
    public void girlList() throws Exception {

        girlController.girlList();
    }


}
