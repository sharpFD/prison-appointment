package com.hdjd.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hdjd.springboot.dao")
public class SpringbootApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
