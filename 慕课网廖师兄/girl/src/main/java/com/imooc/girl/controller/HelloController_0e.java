package com.imooc.girl.controller;

import com.imooc.girl.properties.GirlProperties02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello_02")  // 给整个类添加一个url
public class HelloController_0e {

    @Autowired
    private GirlProperties02 girlProperties02;

    // @PathVariable 获取参数
    // @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)  //  方式一
    @RequestMapping(value = "/{id}/say", method = RequestMethod.GET)  // 方式二
    public String say(@PathVariable("id") Integer id){

        return "id: " + id;
        //return girlProperties02.getCupSize();
    }

}
