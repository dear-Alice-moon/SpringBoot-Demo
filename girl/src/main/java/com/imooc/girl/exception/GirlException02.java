package com.imooc.girl.exception;

import com.imooc.girl.enums.ResultEnum;

/**
 * 自定义异常处理类
 */
public class GirlException02 extends RuntimeException {

    private Integer code;

    public GirlException02(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public GirlException02(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
