package com.shopping.shopping_protal_web.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 金海洋
 * @date 2019/8/18  -13:27
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) //只过滤包含有ApiOperation注解的方法
				.paths(PathSelectors.any()) //对所有的路径进行监控
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("阿里巴巴电商API接口")
				.version("1.0.0")
				.build();
	}


}
