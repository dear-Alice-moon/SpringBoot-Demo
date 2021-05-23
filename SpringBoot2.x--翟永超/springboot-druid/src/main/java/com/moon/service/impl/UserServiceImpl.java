package com.moon.service.impl;

import com.moon.pojo.User;
import com.moon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /*
    // 使用 jdbcTemplate 的方式一： 通过@Autowired注解的方式来使用。
    @Autowired
    private JdbcTemplate jdbcTemplate;
    */


    private JdbcTemplate jdbcTemplate;

    // 使用 jdbcTemplate 的方式二：通过构造函数初始化的方式使用，推荐这种方式。
    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * 新增一个用户
     *
     * @param name  姓名
     * @param age   年龄
     * @return
     *
     * @author  moon  2020/04/02  08:57
     */
    @Override
    public int createUser(Long id, String name, Integer age, Date createDate) {

        return jdbcTemplate.update("INSERT INTO user(id, name, age, create_date) VALUES(?, ?, ?, ?)", id, name, age, createDate);
    }


    /**
     * 根据 name 查询用户
     *
     * @param name  姓名
     * @return
     *
     * @author  moon  2020/04/02  08:59
     */
    @Override
    public List<User> selectUserListByName(String name) {

        List<User> userList = jdbcTemplate.query("SELECT id, name, age, create_date FROM user WHERE name = ?",
                (resultSet, i) -> {
                    User user = new User();
                    user.setId(resultSet.getLong("ID"));
                    user.setName(resultSet.getString("NAME"));
                    user.setAge(resultSet.getInt("AGE"));
                    user.setCreateDate(resultSet.getDate("CREATE_DATE"));
                    return user;
                }, name);

        return userList;
    }


    /**
     * 根据 name 删除用户
     *
     * @param name  姓名
     * @return
     *
     * @author  moon  2020/04/02  09:00
     */
    @Override
    public int deleteUserByName(String name) {

        return jdbcTemplate.update("DELETE FROM user WHERE name = ?", name);
    }


    /**
     * 获取用户总量
     *
     * @return
     *
     * @author  moon  2020/04/02  09:01
     */
    @Override
    public int selectAllUserNum() {

        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM user", Integer.class);
    }


    /**
     * 删除所有用户
     *
     * @return
     *
     * @author  moon  2020/04/02  09:02
     */
    @Override
    public int deleteAllUsers() {

        return jdbcTemplate.update("DELETE FROM user");
    }

}
