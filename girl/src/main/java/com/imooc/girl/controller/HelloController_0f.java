package com.imooc.girl.controller;

import com.imooc.girl.properties.GirlProperties02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello_03")  // 给整个类添加一个url
public class HelloController_0f {

    @Autowired
    private GirlProperties02 girlProperties02;

    // @@RequestParam 获取参数
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    // public String say(@RequestParam("id") Integer myId){  // 获取url输入参数的值
    public String say(@RequestParam(value = "id", required = false, defaultValue = "10") Integer myId){  // 设置默认值

        return "idd: " + myId;
        //return girlProperties02.getCupSize();
    }

}
