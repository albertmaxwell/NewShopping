package com.shopping.shopping_protal_web.config;

import com.shopping.shopping_protal_web.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author 金海洋
 * @date 2019/8/18  -17:29
 */
public class InterceptorConfig implements WebMvcConfigurer {

		@Autowired
		MyInterceptor myInterceptor;
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			//注册拦截器 拦截规则
			//多个拦截器时 以此添加 执行顺序按添加顺序
			//registry.addInterceptor(myInterceptor).addPathPatterns("/*");
		}
	}
