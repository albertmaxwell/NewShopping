package com.shopping.shopping_protal_web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 金海洋
 * @date 2019/8/18  -17:17
 */
public class CountListener implements HttpSessionListener {

	private int count = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		count++;
		se.getSession().getServletContext().setAttribute("count", count);
		System.out.println("新增在线人数，当前在线人数："+count);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		count--;
		se.getSession().getServletContext().setAttribute("count", count);
		System.out.println("删减在线人数，当前在线人数："+count);
	}





}
