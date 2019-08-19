package com.alibaba.shopping.shopping_bean.bean.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_role_menu", schema = "screen", catalog = "")
public class SysRoleMenuEntity extends IdEntity implements java.io.Serializable{

    private SysRoleEntity sysRole;
    private SysMenuEntity sysMenu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid")
    public SysRoleEntity getSysRole() {
        return sysRole;
    }
    public void setSysRole(SysRoleEntity sysRole) {
        this.sysRole = sysRole;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menuid")
    public SysMenuEntity getSysMenu() {
        return sysMenu;
    }
    public void setSysMenu(SysMenuEntity sysMenu) {
        this.sysMenu = sysMenu;
    }
}
