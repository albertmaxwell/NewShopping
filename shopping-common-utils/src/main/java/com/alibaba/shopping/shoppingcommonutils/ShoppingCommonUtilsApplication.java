package com.alibaba.shopping.shoppingcommonutils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
/*@ComponentScan(basePackages = {"com.alibaba.shopping.shoppingcommonutils.common.*"})*/
@MapperScan("com.alibaba.shopping.shoppingcommonutils.common.*")
public class ShoppingCommonUtilsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoppingCommonUtilsApplication.class, args);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<文件服务启动成功>>>>>>>>>>>>>>>>>>>>>>");
	}


	/**
	 * 对上传文件的配置
	 *
	 * @return MultipartConfigElement配置实例
	 * @date 2018年6月29日 上午10:55:02
	 *//*
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 设置单个附件大小上限值(默认为1M)
		//选择字符串作为参数的话，单位可以用MB、KB;
		factory.setMaxFileSize("50MB");
		// 设置所有附件的总大小上限值
		factory.setMaxRequestSize("250MB");
		return factory.createMultipartConfig();
	}
*/

}
