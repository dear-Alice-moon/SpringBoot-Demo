package com.imooc.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Girl {

    @Id
    @GeneratedValue  // 设置id为自增
    private Integer id;

    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入内")
    private  Integer age;

    private float money;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Girl(String cupSize, Integer age) {
        this.cupSize = cupSize;
        this.age = age;
    }

    public Girl(Integer id, String cupSize, Integer age) {
        this.id = id;
        this.cupSize = cupSize;
        this.age = age;
    }

    public Girl(Integer id, String cupSize, Integer age, float money) {
        this.id = id;
        this.cupSize = cupSize;
        this.age = age;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
