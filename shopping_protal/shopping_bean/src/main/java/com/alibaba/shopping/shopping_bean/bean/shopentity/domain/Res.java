package com.alibaba.shopping.shopping_bean.bean.shopentity.domain;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "wemall_res")
public class Res extends IdEntity {
    //名称
    private String resName;
    //类型
    private String type;
    //价格
    private String value;

    //角色
    @ManyToMany(mappedBy = "reses", targetEntity = Role.class, fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList();
    //序列
    private int sequence;
    //信息
    private String info;

    @Transient
    public String getRoleAuthorities(){
        List roleAuthorities = new ArrayList();
        for (Role role : this.roles){
            roleAuthorities.add(role.getRoleCode());
        }
        return StringUtils.join(roleAuthorities.toArray(), ",");
    }

    public String getResName(){
        return this.resName;
    }

    public void setResName(String resName){
        this.resName = resName;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public List<Role> getRoles(){
        return this.roles;
    }

    public void setRoles(List<Role> roles){
        this.roles = roles;
    }

    public String getInfo(){
        return this.info;
    }

    public void setInfo(String info){
        this.info = info;
    }

    public int getSequence(){
        return this.sequence;
    }

    public void setSequence(int sequence){
        this.sequence = sequence;
    }
}




