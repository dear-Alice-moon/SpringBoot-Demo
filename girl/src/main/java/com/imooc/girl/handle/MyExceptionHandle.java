package com.imooc.girl.handle;

import com.imooc.girl.domain.Result;
import com.imooc.girl.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常处理类
 */
// @ControllerAdvice
public class MyExceptionHandle {

    // @ExceptionHandler(value = Exception.class)
    // @ResponseBody
    public Result handle(Exception e) {
        return ResultUtil.error(100, e.getMessage());
    }


}
