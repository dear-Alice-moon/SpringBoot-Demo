package com.moon;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class JSR303Application {

	public static void main(String[] args) {
		SpringApplication.run(JSR303Application.class, args);
	}

}
