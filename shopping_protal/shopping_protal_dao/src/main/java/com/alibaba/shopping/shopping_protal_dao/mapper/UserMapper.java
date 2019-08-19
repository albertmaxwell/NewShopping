package com.alibaba.shopping.shopping_protal_dao.mapper;

import com.alibaba.shopping.shopping_bean.bean.UserMembers;
import com.alibaba.shopping.shopping_bean.bean.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * @author 金海洋
 * @describe
 * @date 2019/8/10  12:50
 */
public interface UserMapper  {

	SysUserEntity findByUsername(String username);

	void save(SysUserEntity sysUserEntity);

	void deleteById(Integer id);

	void updateById(SysUserEntity sysUserEntity);

	List<Map<String ,Object>> selectAll();

	List<SysUserEntity> queryUsersByArray();

}
