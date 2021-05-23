package com.moon;

import com.moon.pojo.User;
import com.moon.service.UserService;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidApplicationTests {

	@Autowired
	private UserService userService;

	@Before
	public void setUp() {
		// 准备，情况user表
		userService.deleteAllUsers();

		System.out.println("---------------------- 删除所有数据，顺利执行 ----------------------");
	}


	@Test
	public void test() throws Exception {

		// 插入5个用户
		userService.createUser(1001L, "Tom", 10, new Date());
		userService.createUser(1002L, "Mike", 11, new Date());
		userService.createUser(1003L, "Didispace", 30, new Date());
		userService.createUser(1004L, "Oscar", 21, new Date());
		userService.createUser(1005L, "Linda", 17, new Date());
		System.out.println("---------------------- 插入5条数据，顺利执行 ----------------------");


		// 查询名为 Oscar 的用户，判断年龄是否匹配。
		List<User> userList = userService.selectUserListByName("Oscar");
		Assert.assertEquals(21, userList.get(0).getAge().intValue());
		Assert.assertEquals(new Integer(21), userList.get(0).getAge());
		System.out.println("---------------------- 根据姓名查询数据，顺利执行 ----------------------");


		// 查询数据库，应该有5个用户。
		Assert.assertEquals(5, userService.selectAllUserNum());
		System.out.println("---------------------- 查询所有数据，顺利执行 ----------------------");


		// 删除两个用户
		userService.deleteUserByName("Tom");
		userService.deleteUserByName("Mike");
		System.out.println("---------------------- 根据姓名删除数据，顺利执行 ----------------------");

		// 查询数据库，应该有3个用户.
		Assert.assertEquals(3, userService.selectAllUserNum());
		System.out.println("---------------------- 查询所有数据，顺利执行 ----------------------");

	}


	@Test
	public void contextLoads() {

		System.out.println("--------------- Hello SpringBoot JdbcTemplate ---------------");
	}


}
