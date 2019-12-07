package com.shopping.shopping_protal_service.service.serviceImpl;
import com.alibaba.shopping.common.emun.Globals;
import com.alibaba.shopping.common.entity.TSFunction;
import com.alibaba.shopping.common.exception.ResultException;

import com.alibaba.shopping.common.utils.ContextHolderUtils;
import com.alibaba.shopping.shopping_bean.bean.entity.SysUserEntity;
import com.alibaba.shopping.shopping_protal_dao.mapper.UserMapper;

import com.alibaba.shopping.shoppingcommonutils.common.service.ClientManager;
import com.alibaba.shopping.shoppingcommonutils.common.utils.Client;
import com.shopping.shopping_protal_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 *
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ClientManager clientManager;

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


    /**
     *
     * @param userid
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Map<Integer, List<TSFunction>> getFunctionMap(String userid) {
        HttpSession session = ContextHolderUtils.getSession();
        Client client = clientManager.getClient(session.getId());
        if (client.getFunctionMap() == null || client.getFunctionMap().size() == 0) {
            Map<Integer, List<TSFunction>> functionMap = new HashMap<Integer, List<TSFunction>>();
            //获取用户授权菜单
            Map<String, TSFunction> loginFunctionslist = this.getLoginUserFunction(userid);
            if (loginFunctionslist.size() > 0) {
                Collection<TSFunction> allFunctions = loginFunctionslist.values();
                for (TSFunction function : allFunctions) {
                    //权限类型菜单不在首页加载
                    if(Globals.Function_TYPE_FROM.intValue() == function.getFunctionType().intValue()){
                        continue;
                    }
                    //菜单层级
                    int level = function.getFunctionLevel();
                    if (!functionMap.containsKey(level)) {
                        functionMap.put(level,new ArrayList<TSFunction>());
                    }
                    functionMap.get(level).add(function);
                }
                // 菜单栏排序
                Collection<List<TSFunction>> c = functionMap.values();
                for (List<TSFunction> list : c) {
                    for (TSFunction function : list) {
                        //如果有子级菜单 则地址设为空
                        if(function.hasSubFunction(functionMap))function.setFunctionUrl("");
                    }
                    // TODO: 2019/9/25
                    //Collections.sort(list, new NumberComparator());
                }
            }
            loginFunctionslist.clear();
            loginFunctionslist = null;
            client.setFunctionMap(functionMap);
            return functionMap;
        }else{
            //log.debug("------------【从Session 缓存中】获取登录用户菜单--------------userid: "+ userid);
            return client.getFunctionMap();
        }
    }

    /**
     * 获取用户菜单列表
     *
     * @param userId 用户ID
     * @return
     */
    @Transactional(readOnly = true)
    public Map<String, TSFunction> getLoginUserFunction(String userId) {
        Map<String, TSFunction> loginActionlist = new HashMap<String, TSFunction>();
        //查询用户角色对应的授权菜单
        StringBuilder hqlsb1 = new StringBuilder("select distinct f from TSFunction f,TSRoleFunction rf,TSRoleUser ru  ").append("where ru.TSRole.id=rf.TSRole.id and rf.TSFunction.id=f.id and ru.TSUser.id=? ");
        //查询用户组织机构授权的菜单
        StringBuilder hqlsb2 = new StringBuilder("select distinct c from TSFunction c,TSRoleFunction rf,TSRoleOrg b,TSUserOrg a ").append("where a.tsDepart.id=b.tsDepart.id and b.tsRole.id=rf.TSRole.id and rf.TSFunction.id=c.id and a.tsUser.id=?");
        //根据上述sql以及用户id获取对应菜单集合
        List<TSFunction> list1=null ;
        List<TSFunction> list2=null ;
        for (TSFunction function : list1) {
            loginActionlist.put(function.getId(), function);
        }
        for (TSFunction function : list2) {
            loginActionlist.put(function.getId(), function);
        }
        list1.clear();
        list2.clear();
        return loginActionlist;
    }

}
