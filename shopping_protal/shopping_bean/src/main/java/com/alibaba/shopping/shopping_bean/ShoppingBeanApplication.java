package com.alibaba.shopping.shopping_bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.alibaba.shopping.shopping_bean.*"})
public class ShoppingBeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingBeanApplication.class, args);
	}

}
