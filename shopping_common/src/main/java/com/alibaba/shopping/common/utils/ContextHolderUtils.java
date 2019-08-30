package com.alibaba.shopping.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 静态成员变量在类装载的时候就进行了创建，在整个程序结束时按序销毁。
 * 实例变量在类实例化对象时候创建，在对象销毁的时候销毁。
 * 局部变量在局部范围使用时创建，跳出局部范围销毁。
 * @author 金海洋
 * @date 2019/8/29  -11:07
 */
public class ContextHolderUtils {

	//全局用户共享的session池   map里面封装的一个是session的id 一个是session的值
	private static final Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();

	public static Map<String, HttpSession> getSessionMap() {
		return sessionMap;
	}

	/**
	 * SpringMvc下获取request
	 *
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;

	}

	/**
	 * SpringMvc下获取session
	 * 栈是方法或函数执行的时候临时开辟的存储空间，方法或函数执行完毕就会释放
	 *
	 * 如果当前用户存在session在系统中  那么久把这个session返回去
	 * 如果当前系统没有这个session  那么就把这个session保存在系统的session中
	 * sessionId作为session的key  当前请求的用户session作为session的值
	 *
	 * @return
	 */
	public static HttpSession getSession() {
		HttpServletRequest request = getRequest();
		//String tempSessionId = request.getParameter("requestedSessionId");
		String tempSessionId = request.getParameter("sessionId");
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		if(!StringUtil.isEmpty(tempSessionId) && !tempSessionId.equals(sessionId)){
			sessionId = tempSessionId;
			if(sessionMap.containsKey(sessionId)){
				session = sessionMap.get(sessionId);
			}
		}
		if(!sessionMap.containsKey(sessionId)){
			sessionMap.put(sessionId, session);
		}
		return session;
	}

	public static HttpSession getSession(String sessionId){
		HttpSession session = sessionMap.get(sessionId);
		return session == null ? getSession() : session;
	}

	public static void removeSession(String sessionId){
		if(sessionMap.containsKey(sessionId)){
			sessionMap.remove(sessionId);
		}
	}


}
