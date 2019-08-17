package com.shopping.shopping_protal_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shopping.shopping_protal_service.*"})
public class ShoppingProtalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingProtalServiceApplication.class, args);
	}

}
