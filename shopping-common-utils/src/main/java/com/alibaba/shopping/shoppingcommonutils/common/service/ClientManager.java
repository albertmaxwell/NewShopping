package com.alibaba.shopping.shoppingcommonutils.common.service;

import com.alibaba.shopping.common.bean.TSUser;
import com.alibaba.shopping.common.utils.ContextHolderUtils;
import com.alibaba.shopping.shoppingcommonutils.common.bean.ApplicationContextUtil;
import com.alibaba.shopping.shoppingcommonutils.common.utils.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author 金海洋
 * @date 2019/8/29  -14:21
 */
@Service("clientManager")
public class ClientManager {

	/**国际化缓存key*/
	private final static String ONLINE_CLIENTS_CACHE_KEY ="online_client_users";

	@Autowired
	CacheServiceI cacheService;


	/**
	 * 根据sessionId 得到Client 对象
	 * @param sessionId
	 */
	public static Client getClient(String sessionId){
		if(!StringUtils.isEmpty(sessionId)&&ContextHolderUtils.getSession().getAttribute(sessionId)!=null){
			//cilent储存的是在线用户对象   现在第一个用户进来还没有真正在线  所以这个cilent就没有数据
			Client client=(Client)ContextHolderUtils.getSession().getAttribute(sessionId);
			return (Client)ContextHolderUtils.getSession().getAttribute(sessionId);
		}
		else{
			return null;
		}
	}

	/**
	 * 用户登录，向session中增加用户信息
	 * @param sessionId
	 * @param client
	 */
	public static void addClinet(String sessionId, Client client){
		//当前session会话，保存登录用户信息  真正将用户信息保存session
		ContextHolderUtils.getSession().setAttribute(sessionId, client);

		//保存在线用户信息列表
		if(client !=null && client.getUser()!=null){
			Client ret = new Client();
			ret.setIp(client.getIp());
			ret.setLogindatetime(client.getLogindatetime());
			//在线用户列表缓存，只保留几个字段显示即可，其他菜单权限内容不需要，降低内存占用
			TSUser t = new TSUser();
			t.setUsername(client.getUser().getUsername());
			t.setUsername(client.getUser().getUsername());
			ret.setUser(t);
			// TODO: 2019/8/30  addClientToCachedMap(sessionId,ret);
		}
	}


	/**
	 * 用户退出登录 从Session中删除用户信息
	 * sessionId
	 */
	public void removeClinet(String sessionId){
		try {
			//从静态常量池中删除对应的session
			ContextHolderUtils.removeSession(sessionId);
		} catch (Exception e) {}

		try {
			//从静态常量池中删除对应的session
			HttpSession session = ContextHolderUtils.getSession();
			session.removeAttribute(sessionId);
		} catch (Exception e) {}
		//从在线用户列表移除用户
		removeClientFromCachedMap(sessionId);
	}

	/**
	 * 向ehcache缓存中增加Client对象
	 * @author xugj
	 * */
	private  boolean addClientToCachedMap(String sessionId, Client client){
		HashMap<String, Client> onLineClients ;
		if(cacheService.get(CacheServiceI.FOREVER_CACHE, ONLINE_CLIENTS_CACHE_KEY)==null){
			onLineClients = new HashMap<String, Client>();
		}
		else{
			onLineClients =(HashMap<String, Client>) cacheService.get(CacheServiceI.FOREVER_CACHE,ONLINE_CLIENTS_CACHE_KEY);
		}
		onLineClients.put(sessionId, client);
		cacheService.put(CacheServiceI.FOREVER_CACHE,ONLINE_CLIENTS_CACHE_KEY, onLineClients);
		return true;
	}


	/**
	 * 从缓存中的Client集合中删除 Client对象
	 *
	 * */
	private boolean removeClientFromCachedMap(String sessionId){
		HashMap<String, Client> onLineClients ;
		if(cacheService.get(CacheServiceI.FOREVER_CACHE, ONLINE_CLIENTS_CACHE_KEY)!=null){
			onLineClients =(HashMap<String, Client>) cacheService.get(CacheServiceI.FOREVER_CACHE,ONLINE_CLIENTS_CACHE_KEY);
			onLineClients.remove(sessionId);
			cacheService.put(CacheServiceI.FOREVER_CACHE, ONLINE_CLIENTS_CACHE_KEY, onLineClients);
			return true;
		}
		else{
			return false;
		}
	}

	public static ClientManager getInstance() {
		ClientManager clientManager = ApplicationContextUtil.getContext().getBean(ClientManager.class);
		return clientManager;
	}

}
