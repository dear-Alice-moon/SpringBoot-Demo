package com.moon;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class Swagger2MarkupApplication {

	public static void main(String[] args) {
		SpringApplication.run(Swagger2MarkupApplication.class, args);
	}

}
