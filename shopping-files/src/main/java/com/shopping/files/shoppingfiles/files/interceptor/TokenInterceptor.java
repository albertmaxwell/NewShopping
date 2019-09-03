package com.shopping.files.shoppingfiles.files.interceptor;


import com.alibaba.shopping.common.common.consts.SystemConst;

import com.alibaba.shopping.common.common.enums.ErrorCode;
import com.alibaba.shopping.common.common.util.TokenUtil;
import com.alibaba.shopping.common.common.vo.ResultVo;
import com.shopping.files.shoppingfiles.files.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 令牌校验
 * @author 盛凯 2018-10-25
 */
//@Component
public class TokenInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);
	//PC密钥
	@Value("${key.channel.pc}")
	private String keyChannelPc;
	//微信密钥
	@Value("${key.channel.wechat}")
	private String keyChannelWechat;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding(SystemConst.ENCODING_UTF8);
    	response.setContentType("text/html; charset=utf-8");
    	response.setCharacterEncoding(SystemConst.ENCODING_UTF8);
    	
    	ResultVo resultVo = new ResultVo();
    	
    	String channel = request.getParameter("channel"); //渠道
    	String tag = request.getParameter("tag"); //盐
    	String timestamp = request.getParameter("timestamp"); //时间戳
    	String token = request.getParameter("token"); //密钥
    	
    	//校验参数完整性
    	if(StringUtils.isEmpty(channel) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(token)) {
    		resultVo.setCode(ErrorCode.PARAM_ERROR.getCode());
    		resultVo.setMessage("缺少必要参数");
    		response.getWriter().print(JsonUtil.toJsonString(resultVo));
    		
    		logger.warn(request.getRequestURL() + "：访问被拒绝（缺少必要参数）：" + JsonUtil.toJsonString(request.getParameterMap()));
    		return false;
    	}
    	
    	String localKey = null;
    	if(SystemConst.CHANNEL_PC.equals(channel)) {
    		//pc
    		localKey = keyChannelPc;
    	} else if(SystemConst.CHANNEL_WECHAT.equals(channel)) {
    		//微信 
    		localKey = keyChannelWechat;
    	} else {
    		resultVo.setCode(ErrorCode.PARAM_ERROR.getCode());
    		resultVo.setMessage("渠道不支持：" + channel);
    		response.getWriter().print(JsonUtil.toJsonString(resultVo));
    		
    		logger.warn(request.getRequestURL() + "：访问被拒绝（渠道不支持）：" + JsonUtil.toJsonString(request.getParameterMap()));
    		return false;
    	}
    	
    	String localToken = TokenUtil.buildToken(localKey, tag, timestamp);
    	if(localToken.equals(token)) {
    		//令牌通过
    		return true;
    	} else {
    		resultVo.setCode(ErrorCode.PARAM_ERROR.getCode());
    		resultVo.setMessage("token异常");
    		response.getWriter().print(JsonUtil.toJsonString(resultVo));
    		
    		logger.warn(request.getRequestURL() + "：访问被拒绝（token异常）：" + JsonUtil.toJsonString(request.getParameterMap()));
    		return false;
    	}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
	
}
