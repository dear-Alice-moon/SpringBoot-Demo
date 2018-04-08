package com.imooc.girl.enums;

/**
 * 定义枚举, 规范code -- Message
 */
public enum ResultEnum {

    UNKNOW_ERROR(-1, "未知错误!"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学!"),
    MIDDLE_SCHOOL(101, "你可能还在上初中!"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
