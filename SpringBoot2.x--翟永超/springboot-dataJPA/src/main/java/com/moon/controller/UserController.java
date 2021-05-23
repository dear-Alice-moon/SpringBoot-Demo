package com.moon.controller;

import com.moon.pojo.User;
import com.moon.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;

@Data
@AllArgsConstructor
@RestController
// @Controller
public class UserController {

    private UserService userService;


    /**
     * 新增 User 信息
     *
     * @param user  User实体类
     * @return
     *
     * @author  moon  2020/04/05  10:53
     */
    @PostMapping("/user")
    public int create(@RequestBody User user) {

        return userService.createUser(user.getId(), user.getName(), user.getAge(), user.getCreateDate());
    }


    /**
     * 根据'姓名'查询 User实体类 信息.
     *
     * @param name  姓名
     * @return
     *
     * @author  moon  2020/04/05  10:55
     */
    @GetMapping(value = "/user3/{name}")
    public List<User> getUserByName(@PathVariable("name") String name) {

        return userService.selectUserListByName(name);
    }


    /**
     * 根据'姓名'查询 User实体类 信息.
     *
     * @param name  姓名
     * @return
     *
     * @author  moon  2020/04/05  10:55
     */
    @GetMapping(value = "/user2")
    public List<User> getUserByName2(@RequestParam("name") String name) {

        return userService.selectUserListByName(name);
    }


    /**
     * 根据 '姓名' 删除 User实体类 信息.
     *
     * @param name  姓名
     * @return
     *
     * @author  moon  2020/04/05  10:57
     */
    @DeleteMapping("/user/{name}")
    public int deleteUserByName(@PathVariable String name) {

        return userService.deleteUserByName(name);
    }


    /**
     * 查询 User实体类 的所有数据.
     *
     * @return
     *
     * @author  moon  2020/04/05  10:59
     */
    @GetMapping("/user/count")
    public int getAllUsers() {

        return userService.selectAllUserNum();
    }


    /**
     * 删除所有用户.
     *
     * @return
     *
     * @author  moon  2020/04/05  11:00
     */
    @DeleteMapping("/user/all")
    public int deleteAllUsers() {

        return userService.deleteAllUsers();
    }


}
