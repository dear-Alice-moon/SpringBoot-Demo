package com.moon.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class User2 {

    @ApiModelProperty("用户编号")
    private Long id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户年龄")
    private Integer age;

    @ApiModelProperty("创建时间")
    private Date createDate;


}
