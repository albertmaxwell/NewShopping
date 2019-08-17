package com.alibaba.shopping.shopping_protal_dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.alibaba.shopping.shopping_protal_dao.*"})
@MapperScan("com.alibaba.shopping.shopping_protal_dao.mapper")
public class ShoppingProtalDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingProtalDaoApplication.class, args);
	}

}
