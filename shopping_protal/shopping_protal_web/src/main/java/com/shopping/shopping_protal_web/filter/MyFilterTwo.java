package com.shopping.shopping_protal_web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 监听器配置  在servlet之前进行过滤处理
 * @author 金海洋
 * @date 2019/8/18  -17:12
 */
public class MyFilterTwo implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilterTwo init ");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("MyFilterTwo doFilter"+req.getParameter("id"));
		chain.doFilter(request, response);
		return ;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("MyFilterTwo destroy");

	}
}
