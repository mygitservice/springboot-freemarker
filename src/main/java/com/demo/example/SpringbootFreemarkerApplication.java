package com.demo.example;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.jms.annotation.EnableJms;

//@EnableJms //使用jms
//@EnableRabbit
@EnableCaching //使用缓存添加此注解
@ServletComponentScan //配置拦截器、过滤器
@SpringBootApplication
public class SpringbootFreemarkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFreemarkerApplication.class, args);
	}
}
