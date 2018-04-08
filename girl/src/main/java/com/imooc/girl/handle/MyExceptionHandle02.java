package com.imooc.girl.handle;

import com.imooc.girl.domain.Result;
import com.imooc.girl.exception.GirlException;
import com.imooc.girl.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常处理类
 */
// @ControllerAdvice
public class MyExceptionHandle02 {

    // @ExceptionHandler(value = Exception.class)
    // @ResponseBody
    public Result handle(Exception e) {
        if ( e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            return ResultUtil.error(-1, "未知错误!");
        }


    }


}
