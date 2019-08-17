package com.alibaba.shopping.shopping_protal_dao.mapper;

import com.alibaba.shopping.shopping_bean.bean.UserMembers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author 金海洋
 * @describe
 * @date 2019/8/10  12:50
 */
public interface UserMapper  {

	List<UserMembers> selectAllUser();
}
