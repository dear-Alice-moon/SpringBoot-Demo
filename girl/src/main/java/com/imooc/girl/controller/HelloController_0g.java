package com.imooc.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imooc.girl.properties.GirlProperties02;


@RestController
@RequestMapping("/hello_04")  // 给整个类添加一个url
public class HelloController_0g {

    @Autowired
    private GirlProperties02 girlProperties02;

    // @RequestParam 获取参数
    // @RequestMapping(value = "/say", method = RequestMethod.GET)
    // @GetMapping注解替代 @RequestMapping(value = "", method = RequestMethod.GET)注解
    @GetMapping(value = "/say")  // 推荐
    public String say(@RequestParam(value = "id", required = false, defaultValue = "10") Integer myId){  // 设置默认值

        return "idd: " + myId;
        //return girlProperties02.getCupSize();
    }

}
