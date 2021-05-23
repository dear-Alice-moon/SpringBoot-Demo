package com.moon;

import com.moon.jpa.UserRepository;
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
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {

		// 创建10条数据
		userRepository.save(new User("张三", 10, new Date()));
		userRepository.save(new User("李四", 15, new Date()));
		userRepository.save(new User("王五", 12, new Date()));
		userRepository.save(new User("Bob", 18, new Date()));
		userRepository.save(new User("Tom", 11, new Date()));
		userRepository.save(new User("Alice", 20, new Date()));
		userRepository.save(new User("刘涛", 9, new Date()));
		userRepository.save(new User("张红丽", 15, new Date()));
		userRepository.save(new User("柳江河", 16, new Date()));
		userRepository.save(new User("王大锤", 17, new Date()));


		// 测试 findAll，查询所有记录.
		Assert.assertEquals(10, userRepository.findAll().size());

		// 测试 findByName，查询姓名为“王大锤”、“Alice”的User
		Assert.assertEquals(17, userRepository.findByName("王大锤").getAge().intValue());
		Assert.assertEquals(17, userRepository.findUser("王大锤").getAge().intValue());
		Assert.assertEquals(20, userRepository.findUser("Alice").getAge().intValue());

		// 测试 findByNameAndAge，查询姓名为“张红丽”且年龄为15的User
		Assert.assertEquals("张红丽", userRepository.findByNameAndAge("张红丽", new Integer(15)).getName());

		// 测试删除姓名为“张三”的 User
		userRepository.delete(userRepository.findUser("张三"));

		List<User> userList = userRepository.findAll();
		int i = 1;
		for (User user : userList) {
			System.out.println("第" + i + "条user为：" + user.toString());
			i++;
		}

	}


	@Test
	public void contextLoads() {

		System.out.println("--------------- Hello SpringBoot Data JPA ---------------");
	}


}
