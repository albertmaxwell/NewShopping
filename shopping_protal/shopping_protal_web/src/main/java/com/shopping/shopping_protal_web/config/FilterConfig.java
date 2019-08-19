package com.shopping.shopping_protal_web.config;

import com.shopping.shopping_protal_web.filter.MyFilter;
import com.shopping.shopping_protal_web.filter.MyFilterTwo;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 金海洋
 * @date 2019/8/18  -17:13
 */
@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean =
				new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new MyFilter());
		//指定过滤器的执行顺序
		filterRegistrationBean.setOrder(2);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean2() {
		FilterRegistrationBean filterRegistrationBean =
				new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new MyFilterTwo());
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}


}
