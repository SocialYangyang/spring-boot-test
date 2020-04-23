package com.example.springboottest1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



//exclude = SecurityAutoConfiguration.class取消浏览器验证登陆
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.example.springboottest1.mapper")//有了@MapperScan，那么mappper文件下的接口都不用添加@Mapper
//@ComponentScan(basePackages = {"com.example.*"})
public class Springboottest1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboottest1Application.class, args);
	}
}
