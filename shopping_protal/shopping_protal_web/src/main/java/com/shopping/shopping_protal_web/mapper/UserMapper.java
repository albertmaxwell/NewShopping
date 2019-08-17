package com.shopping.shopping_protal_web.mapper;

import com.shopping.shopping_protal_web.bean.UserMembers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author 金海洋
 * @describe
 * @date 2019/8/10  12:50
 */
@Mapper
public interface UserMapper {

	List<UserMembers> selectAllUser();
}
