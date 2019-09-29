package com.alibaba.shopping.shopping_bean.bean.shopentity.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "wemall_homepage")
public class HomePage extends IdEntity {
    //拥有者
    @OneToOne(fetch = FetchType.LAZY)
    private User owner;
    //浏览顾客
    @OneToMany(mappedBy = "homepage", cascade = {javax.persistence.CascadeType.REMOVE})
    private List<Visit> customers = new ArrayList();

    public User getOwner(){
        return this.owner;
    }

    public void setOwner(User owner){
        this.owner = owner;
    }

    public List<Visit> getCustomers(){
        return this.customers;
    }

    public void setCustomers(List<Visit> customers){
        this.customers = customers;
    }
}




