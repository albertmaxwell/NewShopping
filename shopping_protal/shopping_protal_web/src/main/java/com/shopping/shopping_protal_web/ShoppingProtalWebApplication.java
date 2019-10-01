package com.shopping.shopping_protal_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages = { "com.alibaba.shopping.shopping_bean.bean.shopentity.*","com.shopping.shopping_protal_web.*","com.shopping.shopping_protal_service.*", "com.alibaba.shopping.shoppingcommonutils.common.*", "com.shoppingfilesplugin.shoppingfilesplugin.plugin.*","com.api.proxy.plugin.*","com.alibaba.shopping.shopping_protal_dao.*"})
@MapperScan({"com.alibaba.shopping.shopping_protal_dao.mapper","com.alibaba.shopping.shoppingcommonutils.common.*"})
@ServletComponentScan
@EnableSwagger2
@EntityScan("com.alibaba.shopping.shopping_bean.bean.shopentity.test")
@EnableJpaRepositories(basePackages = {"com.alibaba.shopping.shopping_protal_dao.jpadao"})
//@EnableCaching
public class ShoppingProtalWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoppingProtalWebApplication.class, args);
	}



}
