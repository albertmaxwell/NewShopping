package com.shoppingfilesplugin.shoppingfilesplugin.plugin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	private Logger logger = LoggerFactory.getLogger(WebConfig.class);
	
	@Value("${files.path}")
	private String filesPath;
	@Value("${files.web.prefix}")
	private String filesWebPrefix;
	@Value("${files.springboot.local.look.enable:false}")
	private boolean localLookEnable;

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if(!StringUtils.isEmpty(filesWebPrefix)) {
			//如果web前缀不为空，则代表开启了文件访问服务
			if (localLookEnable) {
				registry.addResourceHandler("/" + filesWebPrefix + "/**").addResourceLocations("file:" + filesPath);
				logger.info("文件路径已映射：前缀={}，路径={}", filesWebPrefix, filesPath);
			}
		}
    }
}
