package com.moon.service;

import com.moon.pojo.User;

import java.util.Date;
import java.util.List;

public interface UserService {


    /**
     * 新增一个用户
     *
     * @param id             id
     * @param name           姓名
     * @param age            年龄
     * @param createDate     创建时间
     * @return
     *
     * @author  moon  2020/04/02  08:57
     */
    int createUser(Long id, String name, Integer age, Date createDate);


    /**
     * 根据 name 查询用户
     *
     * @param name  姓名
     * @return
     *
     * @author  moon  2020/04/02  08:59
     */
    List<User> selectUserListByName(String name);


    /**
     * 根据 name 删除用户
     *
     * @param name  姓名
     * @return
     *
     * @author  moon  2020/04/02  09:00
     */
    int deleteUserByName(String name);


    /**
     * 获取用户总量
     *
     * @return
     *
     * @author  moon  2020/04/02  09:01
     */
    int selectAllUserNum();


    /**
     * 删除所有用户
     *
     * @return
     *
     * @author  moon  2020/04/02  09:02
     */
    int deleteAllUsers();


}
