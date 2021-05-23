package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@ApiModel(description = "用户实体")
public class User {

    @Id
    @GeneratedValue
    @ApiModelProperty("用户编号")
    private Long id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户年龄")
    private Integer age;

    @ApiModelProperty("创建时间")
    private Date createDate;


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
                ", createDate=" + createDate +
                '}';
    }


    /**
     * 构造函数2，不含 Id 属性.
     *
     * @param name
     * @param age
     * @param createDate
     */
    public User(String name, Integer age, Date createDate) {
        this.name = name;
        this.age = age;
        this.createDate = createDate;
    }


    /**
     * 全参构造函数
     *
     * @param id
     * @param name
     * @param age
     * @param createDate
     */
    public User(Long id, String name, Integer age, Date createDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createDate = createDate;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
