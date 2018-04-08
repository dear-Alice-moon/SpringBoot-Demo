package com.imooc.girl.controller;

import com.imooc.girl.properties.GirlProperties02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody  // 这2个注解，相当于@RestController
public class HelloController_0b {

    @Autowired
    private GirlProperties02 girlProperties02;

    @RequestMapping(value = {"/hello_02", "hi"}, method = RequestMethod.GET)
    public String say(){

        return girlProperties02.getCupSize();
    }

}
