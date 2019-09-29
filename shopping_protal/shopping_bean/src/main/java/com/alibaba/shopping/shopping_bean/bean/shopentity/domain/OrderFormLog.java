package com.alibaba.shopping.shopping_bean.bean.shopentity.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "wemall_order_log")
public class OrderFormLog extends IdEntity {

    //订单表格
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderForm of;
    //消息记录
    private String log_info;

    //用户记录
    @ManyToOne(fetch = FetchType.LAZY)
    private User log_user;

    //状态信息
    @Lob
    @Column(columnDefinition = "LongText")
    private String state_info;

    public String getState_info(){
        return this.state_info;
    }

    public void setState_info(String state_info){
        this.state_info = state_info;
    }

    public OrderForm getOf(){
        return this.of;
    }

    public void setOf(OrderForm of){
        this.of = of;
    }

    public String getLog_info(){
        return this.log_info;
    }

    public void setLog_info(String log_info){
        this.log_info = log_info;
    }

    public User getLog_user(){
        return this.log_user;
    }

    public void setLog_user(User log_user){
        this.log_user = log_user;
    }
}




