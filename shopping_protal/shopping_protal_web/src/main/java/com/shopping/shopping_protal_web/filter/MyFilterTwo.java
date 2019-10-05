package com.shopping.shopping_protal_web.filter;

import com.alibaba.shopping.common.utils.ContextHolderUtils;
import com.alibaba.shopping.shopping_bean.bean.LoginUserVo;
import com.alibaba.shopping.shopping_bean.bean.entity.SysMenuEntity;
import com.alibaba.shopping.shoppingcommonutils.common.service.ClientManager;
import com.alibaba.shopping.shoppingcommonutils.common.utils.Client;
import org.apache.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 监听器配置  在servlet之前进行过滤处理
 * @author 金海洋
 * @date 2019/8/18  -17:12
 */
public class MyFilterTwo implements Filter {

	private String[] filterHtmls = {"/page/test/logintest.html","/page/web/tianmao.html"};


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		//System.out.println("MyFilterTwo init ");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		response.setContentType("application/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		boolean isFilter = false;
		if(uri.indexOf(".html") != -1) {
			for(String html : filterHtmls) {
				if(uri.indexOf(html) != -1) {
					isFilter = true;
					break;
				}
			}
 			if(!isFilter) {
				HttpSession session = ContextHolderUtils.getSession();
				System.out.println(session);
				Client client= ClientManager.getClient(session.getId());
				if(null!=client){
					filterChain.doFilter(servletRequest, servletResponse);
				}else{
					response.sendRedirect(request.getContextPath()+"/page/test/logintest.html");
				}
			}
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//System.out.println("MyFilterTwo destroy");

	}
}
