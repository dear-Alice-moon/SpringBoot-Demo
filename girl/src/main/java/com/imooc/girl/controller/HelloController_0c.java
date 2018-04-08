package com.imooc.girl.controller;

import com.imooc.girl.properties.GirlProperties02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello_02")  // 给整个类添加一个url
public class HelloController_0c {

    @Autowired
    private GirlProperties02 girlProperties02;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(){

        return girlProperties02.getCupSize();
    }

}
