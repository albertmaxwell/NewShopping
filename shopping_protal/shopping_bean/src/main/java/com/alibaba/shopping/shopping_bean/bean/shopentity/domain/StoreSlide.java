package com.alibaba.shopping.shopping_bean.bean.shopentity.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "wemall_store_slide")
public class StoreSlide extends IdEntity {
    private String url;

    //附件
    @OneToOne(fetch = FetchType.LAZY)
    private Accessory acc;

    //店铺
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    public Store getStore(){
        return this.store;
    }

    public void setStore(Store store){
        this.store = store;
    }

    public String getUrl(){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public Accessory getAcc(){
        return this.acc;
    }

    public void setAcc(Accessory acc){
        this.acc = acc;
    }
}




