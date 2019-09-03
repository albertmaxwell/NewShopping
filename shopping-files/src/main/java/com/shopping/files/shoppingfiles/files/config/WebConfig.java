package com.shopping.files.shoppingfiles.files.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${file.path}")
	private String filePath;
	@Value("${web.file.url}")
	private String webFileUrl;

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/"+webFileUrl+"/**").addResourceLocations("file:" + filePath);  
    }


}
