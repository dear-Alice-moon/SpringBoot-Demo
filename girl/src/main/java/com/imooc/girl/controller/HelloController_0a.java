package com.imooc.girl.controller;

import com.imooc.girl.properties.GirlProperties02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController_0a {

    @Autowired
    private GirlProperties02 girlProperties02;

    @RequestMapping(value = "/hello_01", method = RequestMethod.GET)
    public String say(){

        return girlProperties02.getCupSize();
    }

}
