package com.moon.test;

import com.moon.pojo.User;
import com.moon.pojo.User2;

import java.util.Date;

public class UserTest {

    public static void main(String[] args) {

        User user = new User(1001L, "张三", new Integer(20));
        System.out.println("user为：" + user);

        User2 user2 = new User2();
        user2.setId(1002L);
        user2.setName("李四");
        user2.setAge(new Integer(21));
        user2.setCreateDate(new Date());
        System.out.println("user2为：" + user2);
        System.out.println("user2为：" + user2.toString());

    }

}
