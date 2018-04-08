package com.imooc.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect     // 添加Aspect注解，声明AOP'文件???'
@Component  // 引入到Spring容器中
public class HttpAspect03 {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect03.class);

    @Pointcut("execution(public * com.imooc.girl.controller.GirlController02.*(..))")
    public void log() { }

    // 获取传递的内容
    @Before("log()")
    // 传递一个JoinPoint对象，用于获取Class的各个元素/函数等
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // url
        logger.info("url={}", request.getRequestURL());

        // method
        logger.info("methdo={}", request.getMethod());

        // ip
        logger.info("ip={}", request.getRemoteAddr());

        // 类方法
        //  joinPoint.getSignature().getDeclaringTypeName()：该函数获取类名
        //  joinPoint.getSignature().getName(): 该函数获取函数名
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());

        // 参数
        logger.info("args={}", joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter() {
        logger.info("220220220");
    }

    // 获取返回内容
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);
    }


}
