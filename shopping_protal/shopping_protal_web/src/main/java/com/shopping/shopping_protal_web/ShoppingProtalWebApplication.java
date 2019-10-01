package com.shopping.shopping_protal_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages = {"com.shopping.shopping_protal_web.*","com.shopping.shopping_protal_service.*", "com.alibaba.shopping.shoppingcommonutils.common.*", "com.shoppingfilesplugin.shoppingfilesplugin.plugin.*","com.api.proxy.plugin.*"})
@MapperScan({"com.alibaba.shopping.shopping_protal_dao.*","com.alibaba.shopping.shoppingcommonutils.common.*"})
@ServletComponentScan
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.alibaba.shopping.shopping_protal_dao.dao")
//@EnableCaching
public class ShoppingProtalWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoppingProtalWebApplication.class, args);
	}

}
