package com.alibaba.shopping.shopping_bean.bean.shopentity.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 聊天朋友
 * @author
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "wemall_chattingfriend")
public class ChattingFriend extends IdEntity {

    /**
     * UID
     */
    private static final long serialVersionUID = -1686735184812269798L;

    //用户
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    //朋友
    @ManyToOne(fetch = FetchType.LAZY)
    private User friendUser;

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getFriendUser(){
        return this.friendUser;
    }

    public void setFriendUser(User friendUser){
        this.friendUser = friendUser;
    }
}
