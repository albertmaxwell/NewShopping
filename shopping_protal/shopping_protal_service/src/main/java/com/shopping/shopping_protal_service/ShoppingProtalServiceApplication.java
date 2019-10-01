package com.shopping.shopping_protal_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shopping.shopping_protal_service.*"})
@MapperScan("com.alibaba.shopping.shopping_protal_dao.*")
@EnableJpaRepositories(basePackages = "com.alibaba.shopping.shopping_protal_dao.dao")
public class ShoppingProtalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingProtalServiceApplication.class, args);
	}

}
