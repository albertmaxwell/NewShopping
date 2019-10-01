package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("orderdao")
public class OrderDaoImpl extends AbstractBaseDao<Test> implements OrderDao {
 
    @Override
    public List<Test> findOrderByStoreId(String storeId){
        List<Test> orders = this.findAll();
        return orders;
    }
 
    @Override
    public List<Test> findOrderByStatus(String storeId,Integer status) {
        List<Test> orders = this.find("SELECT o FROM Order o WHERE o.storeId = ? and o.status = ? order by o.createTime desc", storeId, status);
        return orders;
    }
 
    @Override
    public int getActiveOrderCount(String storeId) {
        return this.count("SELECT count(o) FROM Order o WHERE o.storeId = ? and o.status in (1,2)", storeId);
    }
 
    @Override
    public int getNewOrderCount(String storeId) {
        return this.count("SELECT count(o) FROM Order o WHERE o.storeId = ? and o.status = 0", storeId);
    }
 
    @Override
    public int getOrderCount(String storeId) {
        return this.count("SELECT count(o) FROM Order o WHERE o.storeId = ?", storeId);
    }
 
    @Override
    public List<Test> findOrderByStoreId(String storeId, Integer page, Integer pageSize) {
        return this.findPage((page -1) * pageSize, pageSize, "SELECT o FROM Order o WHERE o.storeId = ? order by o.createTime desc, o.id", storeId);
    }
 
    @Override
    public List<Test> findOrderByStatus(String storeId, Integer status, Integer page, Integer pageSize) {
        return this.findPage((page -1) * pageSize, pageSize, "SELECT o FROM Order o WHERE o.storeId = ? and o.status = ? order by o.createTime desc, o.id", storeId, status);
    }
 
    @Override
    public int getOrderByStatusCount(String storeId, Integer status) {
        return this.count("SELECT count(o) FROM Order o WHERE o.storeId = ? and o.status = ?", storeId, status);
    }
}
