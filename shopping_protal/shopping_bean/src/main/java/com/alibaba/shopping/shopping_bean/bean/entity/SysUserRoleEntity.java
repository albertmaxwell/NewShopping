package com.alibaba.shopping.shopping_bean.bean.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_user_role", schema = "screen", catalog = "")
public class SysUserRoleEntity extends IdEntity implements java.io.Serializable{

    private SysUserEntity sysUser;
    private SysRoleEntity sysRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    public SysUserEntity getSysUser() {
        return sysUser;
    }
    public void setSysUser(SysUserEntity sysUser) {
        this.sysUser = sysUser;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid")
    public SysRoleEntity getSysRole() {
        return sysRole;
    }
    public void setSysRole(SysRoleEntity sysRole) {
        this.sysRole = sysRole;
    }
}
