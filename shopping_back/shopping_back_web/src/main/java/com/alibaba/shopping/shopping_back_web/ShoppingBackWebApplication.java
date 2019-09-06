package com.alibaba.shopping.shopping_back_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.alibaba.shopping.shopping_back_web.*","com.alibaba.shopping.shopping_back_service.*", "com.alibaba.shopping.shoppingcommonutils.*", "com.shoppingfilesplugin.shoppingfilesplugin.plugin.*","com.api.proxy.plugin.*"})
@MapperScan({"com.alibaba.shopping.shopping_back_dao.*","com.alibaba.shopping.shoppingcommonutils.common.*"})
@ServletComponentScan
@EnableSwagger2
@EnableJpaRepositories("com.alibaba.shopping.shoppingcommonutils.basic.service")
@EntityScan("com.alibaba.shopping.shoppingcommonutils.basic.model")
public class ShoppingBackWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingBackWebApplication.class, args);
	}

}
