package com.alibaba.shopping.shoppingcommonutils.common.service;

import com.alibaba.shopping.common.bean.TSUser;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 金海洋
 * @date 2019/8/29  -14:10
 */
public interface LoginService {

	public void saveLoginUserInfo(HttpServletRequest req, TSUser user);

}
