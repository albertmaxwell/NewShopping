package com.alibaba.shopping.shoppingcommonutils.common.utils;

import com.alibaba.shopping.common.bean.TSUser;
import com.alibaba.shopping.common.utils.ContextHolderUtils;
import com.alibaba.shopping.shoppingcommonutils.common.service.ClientManager;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 金海洋
 * @date 2019/8/29  -14:07
 */
public class ResourceUtil {

	public static final String LOCAL_CLINET_USER = "LOCAL_CLINET_USER";

	/**
	 *
	 * @return
	 */
	public static final TSUser getSessionUser() {
		ClientManager clientManager = ClientManager.getInstance();
		HttpSession session = ContextHolderUtils.getSession();
		if(clientManager.getClient(session.getId())!=null){
			return clientManager.getClient(session.getId()).getUser();

		}else{
			TSUser u = (TSUser) session.getAttribute(ResourceUtil.LOCAL_CLINET_USER);
			Client client = new Client();
			client.setIp("");
			client.setLogindatetime(new Date());
			client.setUser(u);
			clientManager.addClinet(session.getId(), client);
		}
		return null;
	}

}
