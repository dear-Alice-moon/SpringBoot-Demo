package com.moon.pojo;

import lombok.Data;

// @Data
public class User {

    private Long id;

    private String name;

    private Integer age;


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
                '}';
    }

    /**
     * 全参构造函数
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
}
