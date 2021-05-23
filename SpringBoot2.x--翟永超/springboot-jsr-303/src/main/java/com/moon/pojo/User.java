package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@ApiModel(description = "用户实体")
public class User {

    @ApiModelProperty("用户编号")
    private Long id;

    @NotNull
    @Size(min = 2, max = 5)
    @ApiModelProperty("用户姓名")
    private String name;

    @NotNull
    @Max(100)
    @Min(10)
    @ApiModelProperty("用户年龄")
    private Integer age;

    @NotNull
    @Email
    @ApiModelProperty("用户邮箱")
    private String email;


    /**
     * 重写 toString() 函数
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }


    /**
     * 构造函数2
     *
     * @param id
     * @param name
     * @param age
     */
    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    /**
     * 全参构造函数
     *
     * @param id
     * @param name
     * @param age
     * @param email
     */
    public User(Long id, @NotNull @Size(min = 2, max = 5) String name, @NotNull @Max(100) @Min(10) Integer age, @NotNull @Email String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }


    /**
     * 无参构造函数
     */
    public User() {
        super();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
