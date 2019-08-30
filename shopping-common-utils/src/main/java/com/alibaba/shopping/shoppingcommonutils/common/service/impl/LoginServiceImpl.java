package com.alibaba.shopping.shoppingcommonutils.common.service.impl;

import com.alibaba.shopping.common.bean.TSUser;
import com.alibaba.shopping.common.utils.ContextHolderUtils;
import com.alibaba.shopping.shoppingcommonutils.common.service.LoginService;
import com.alibaba.shopping.shoppingcommonutils.common.utils.Client;
import com.alibaba.shopping.shoppingcommonutils.common.utils.ClientManager;
import com.alibaba.shopping.shoppingcommonutils.common.utils.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

import static com.alibaba.shopping.shoppingcommonutils.common.utils.util.getIpAddr;

/**
 * @author 金海洋
 * @date 2019/8/29  -14:12
 */
@Service("login")
@Transactional
public class LoginServiceImpl implements LoginService {


	/**
	 * 保存登录用户信息，并将当前登录用户的组织机构赋值到用户实体中；
	 *
	 * @param req request
	 */
	@Override
	public void saveLoginUserInfo(HttpServletRequest req, TSUser user) {
		Map<String, HttpSession> httpSession=ContextHolderUtils.getSessionMap();
		String message = null;
		//1  如果当前登录人的session不存在 那么就把这个用户的session存到系统中 并且在
		//   这个方法中返回添加的session
		//2  如果这个用户的session存在那么就就返回存在的session
		//3  http是无状态的因此 无法通过无法根据http请求的次数来判断是否为同一用户，因此
		//   只能通过客户端储存的cookies的id  保存到session为sessionid来以此让服务端判断是否为同一用户
		//4  获取session
		HttpSession session = ContextHolderUtils.getSession();
		//把session的登录用户保存到session中   下面这个方法会覆盖第一次保存的用户???
		session.setAttribute(ResourceUtil.LOCAL_CLINET_USER, user);
		//IE列表操作按钮的样式
		String browserType = "";
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if ("BROWSER_TYPE".equals(cookie.getName())) {
				//获取浏览器的类型
				browserType = cookie.getValue();
			}
		}
		session.setAttribute("brower_type", browserType);
		//【基础权限】切换用户，用户分拥有不同的权限，切换用户权限错误问题
		//当前session为空 或者 当前session的用户信息与刚输入的用户信息一致时，则更新Client信息
		//如果当前登录的用户的sessionid能够从cilent中找到  说明是登录过的用户
		Client clientOld = ClientManager.getClient(session.getId());
		if (clientOld == null || clientOld.getUser() == null || user.equals(clientOld)) {
			Client client = new Client();
			client.setIp(getIpAddr(req));
			client.setLogindatetime(new Date());
			client.setUser(user);
			//一个sessionId对应一个客户端
			ClientManager.addClinet(session.getId(), client);
		} else {
			//这种情况是当前登录的用户的与系统存在的session一致，说明这个用户的浏览器一致没有关闭
			//并且一直和这个用户建立一种session会话  当然存在也说明这个用户已经登录过一次了
			//第二次登陆的时候就会更新一下这个用户的客户端在服务端的信息  比如登陆时间的重新计时等
			//这种回话的前提时这个用户第二次登陆的时候的用户名也要和系统存在的一致
			//如果不一致，则注销session并通过session=req.getSession(true)初始化session
			Client client = new Client();
			//把这个用户上一次在系统中保存的信息都删除掉
			ClientManager.removeClinet(session.getId());
			session.invalidate();
			session = req.getSession(true);//session初始化
			session.setAttribute(ResourceUtil.LOCAL_CLINET_USER, user);
			session.setAttribute("randCode", req.getParameter("randCode"));//保存验证码
			//更新这个用户当前的信息
			ClientManager.addClinet(session.getId(), client);
		}
	}






}
