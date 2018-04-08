package com.imooc.girl.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;   // Spring自带的Log框架
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// @Aspect     // 添加Aspect注解，声明AOP'文件???'
 // @Component  // 引入到Spring容器中
public class HttpAspect02 {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect02.class);

    // @Pointcut("execution(public * com.imooc.girl.controller.GirlController02.*(..))")
    public void log() { }

    // @Before("log()")
    public void doBefore() {

        logger.info("110110110");
    }

    // @After("log()")
    public void doAfter() {
        logger.info("220220220");
    }


}
