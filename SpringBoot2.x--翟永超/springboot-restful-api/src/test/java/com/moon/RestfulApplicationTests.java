package com.moon;

import com.moon.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}


	@Test
	public void contextLoads() throws Exception {

		// 测试 UserController
		RequestBuilder request;

		// 1、get查一下user列表，应该为空.
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk())
							.andExpect(content().string(equalTo("[]")));

		System.out.println("----------------- 函数1结束 -----------------");


		// 2、post提交一个user
		request = post("/users/").contentType(MediaType.APPLICATION_JSON)
				                               .content("{\"id\":1,\"name\":\"test...\",\"age\":20}");  // 注意，报文中不要有空格!!!
		mvc.perform(request).andExpect(content().string(equalTo("success")));

		System.out.println("----------------- 函数2结束 -----------------");


		// 3、get获取user列表，应该有刚才插入的数据。
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"test...\",\"age\":20}]")));

		System.out.println("----------------- 函数3结束 -----------------");


		// 4、put修改id为1的user
		request = put("/users/1").contentType(MediaType.APPLICATION_JSON)
												.content("{\"name\":\"AAAtest...\",\"age\":300}");
		mvc.perform(request).andExpect(content().string(equalTo("success")));

		System.out.println("----------------- 函数4结束 -----------------");


		// 5、get一个id为1的user
		request = get("/users/1");
		mvc.perform(request).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"AAAtest...\",\"age\":300}")));

		System.out.println("----------------- 函数5结束 -----------------");


		// 6、del删除id为1的user
		request = delete("/users/1");
		mvc.perform(request).andExpect(content().string(equalTo("success")));

		System.out.println("----------------- 函数6结束 -----------------");


		// 7、get查一下user列表，应该为空。
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

		System.out.println("----------------- 函数7结束 -----------------");

	}

}
