package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;

import java.util.List;

public interface OrderDao extends BaseDao<Test> {
 
    List<Test> findOrderByStoreId(String storeId);
 
    List<Test> findOrderByStatus(String storeId, Integer status);

    int getActiveOrderCount(String storeId);

    int getNewOrderCount(String storeId);

    int getOrderCount(String storeId);

    List<Test> findOrderByStoreId(String storeId, Integer page, Integer pageSize);
 
    List<Test> findOrderByStatus(String storeId, Integer status, Integer page, Integer pageSize);
 
    int getOrderByStatusCount(String storeId, Integer status);
}
