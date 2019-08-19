package com.shopping.shopping_protal_service.service.serviceImpl;
import com.alibaba.shopping.common.exception.ResultException;

import com.alibaba.shopping.shopping_bean.bean.entity.SysUserEntity;
import com.alibaba.shopping.shopping_protal_dao.mapper.UserMapper;
import com.shopping.shopping_protal_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 *
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public SysUserEntity login(String username, String password) throws ResultException {

        SysUserEntity user = userMapper.findByUsername(username);
        return  user;
    }

    /**
     *
     * @param sysUserEntity
     * @throws ResultException
     */
    @Override
    public void addUser(SysUserEntity sysUserEntity) throws ResultException {

        userMapper.save(sysUserEntity);
    }

    /**
     *
     * @param id
     * @throws ResultException
     */
    @Override
    public void deleteUser(Integer id) throws ResultException {

        userMapper.deleteById(id);

    }

    /**
     *
     * @param sysUserEntity
     * @throws ResultException
     */
    @Override
    public void updateUser(SysUserEntity sysUserEntity) throws ResultException {

        userMapper.updateById(sysUserEntity);
    }

    @Override
    public List<Map<String ,Object>> getAllUsers() throws ResultException {
        System.out.println("从数据库中获取缓存");
        List<Map<String ,Object>> users=userMapper.selectAll();
        return users;

    }

    /**
     * 静态数组分页
     * @param currPage
     * @param pageSize
     * @return
     */
    @Override
    public List<SysUserEntity> queryUsersByArray(int currPage, int pageSize)throws ResultException {
        //查询全部数据
        List<SysUserEntity> students = userMapper.queryUsersByArray();
        //从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
        //到第几条数据结束
        int lastIndex = currPage * pageSize;
        return students.subList(firstIndex, lastIndex); //直接在list中截取
    }



}
