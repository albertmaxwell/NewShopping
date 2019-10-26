package com.alibaba.shopping.shopping_bean.bean.shopentity.domain;


import org.springframework.data.jpa.repository.Lock;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class IdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    private Date addTime;


    private boolean deleteStatus;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Date getAddTime(){
        return this.addTime;
    }

    public void setAddTime(Date addTime){
        this.addTime = addTime;
    }

    public boolean isDeleteStatus(){
        return this.deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus){
        this.deleteStatus = deleteStatus;
    }
}