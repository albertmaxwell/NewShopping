package com.shopping.shopping_protal_service.service;

import com.alibaba.shopping.common.exception.ResultException;
import com.alibaba.shopping.shopping_bean.bean.entity.SysUserEntity;
import java.util.List;
import java.util.Map;


public interface UserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    SysUserEntity login(String username, String password) throws  ResultException;

    /**
     *
     * @param sysUserEntity
     * @throws ResultException
     */
    void addUser(SysUserEntity sysUserEntity) throws  ResultException;

    /**
     *
     * @param id
     * @throws ResultException
     */
    void deleteUser(Integer id) throws  ResultException;

    /**
     *
     * @param sysUserEntity
     * @throws ResultException
     */
    void updateUser(SysUserEntity sysUserEntity) throws  ResultException;

    /**
     *
     * @return
     * @throws ResultException
     */
    List<Map<String ,Object>> getAllUsers() throws  ResultException;

    /**
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    List<SysUserEntity> queryUsersByArray(int currPage, int pageSize)throws  ResultException;
}
