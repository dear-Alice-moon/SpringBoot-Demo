package com.imooc.girl.handle;

import com.imooc.girl.domain.Result;
import com.imooc.girl.exception.GirlException02;
import com.imooc.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常处理类
 */
@ControllerAdvice
public class MyExceptionHandle03 {

    private final static Logger logger = LoggerFactory.getLogger(MyExceptionHandle03.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if ( e instanceof GirlException02) {
            GirlException02 girlException = (GirlException02) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.error("[系统异常] {}", e);
            return ResultUtil.error(-1, "未知错误!");
        }

    }


}
