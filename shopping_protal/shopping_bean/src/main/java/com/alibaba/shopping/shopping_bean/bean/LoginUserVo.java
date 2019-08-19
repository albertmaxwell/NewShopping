package com.alibaba.shopping.shopping_bean.bean;

import com.alibaba.shopping.shopping_bean.bean.entity.SysMenuEntity;
import com.alibaba.shopping.shopping_bean.bean.entity.SysRoleEntity;
import com.alibaba.shopping.shopping_bean.bean.entity.SysUserEntity;

import java.util.List;

/**
 * @author 金海洋
 * @date 2019/8/18  -12:53
 */
public class LoginUserVo {

	private SysUserEntity user; //用户信息
	private List<SysRoleEntity> roles; //角色信息
	private List<SysMenuEntity> menus; //菜单信息

	//额外参数-socketid，用于websocket的唯一id
	private String socketId;

	public SysUserEntity getUser() {
		return user;
	}

	public void setUser(SysUserEntity user) {
		this.user = user;
	}

	public List<SysRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoleEntity> roles) {
		this.roles = roles;
	}

	public List<SysMenuEntity> getMenus() {
		return menus;
	}

	public void setMenus(List<SysMenuEntity> menus) {
		this.menus = menus;
	}

	public String getSocketId() {
		return socketId;
	}

	public void setSocketId(String socketId) {
		this.socketId = socketId;
	}


}
