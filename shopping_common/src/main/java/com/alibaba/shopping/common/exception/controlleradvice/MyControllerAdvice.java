package com.alibaba.shopping.common.exception.controlleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * @Auther: 金海洋
 * @Date: 2019/8/18  -11:40
 * @Description: 全局捕获异常和自定义全局捕获异常
 */
@ControllerAdvice  //不指定包默认加了@Controller和@RestController都能控制
//@ControllerAdvice(basePackages ="com.example.demo.controller")
public class MyControllerAdvice {

	/**
	 * 拦截捕捉自定义异常 MyException.class
	 * @param myex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = MyException.class)
	public Map<String,Object> myExceptionHandler(MyException myex){
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("code",myex.getCode());
		map.put("message",myex.getMessage());
		map.put("method",myex.getMethod());
		map.put("descinfo",myex.getDescinfo());
		//发生异常进行日志记录，写入数据库或者其他处理，此处省略
		return map;
	}



}
