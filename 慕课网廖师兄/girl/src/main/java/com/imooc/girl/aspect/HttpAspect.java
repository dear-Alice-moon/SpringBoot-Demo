package com.imooc.girl.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Aspect     // 添加Aspect注解，声明AOP'文件???'
// @Component  // 引入到Spring容器中
public class HttpAspect {

    // @Before("execution(public * com.imooc.girl.controller.GirlController02.girlList(..))")
    // @Before("execution(public * com.imooc.girl.controller.GirlController02.*(..))")
    public void log() {

        System.out.printf("AOP面向切面编程之：前置通知 \n");
    }

    // @After("execution(public * com.imooc.girl.controller.GirlController02.*(..))")
    public  void doAfter() {
        System.out.printf("AOP面向切面编程之：后置通知 \t");
    }




}
