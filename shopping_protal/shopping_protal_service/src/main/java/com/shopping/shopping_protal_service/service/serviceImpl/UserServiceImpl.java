package com.shopping.shopping_protal_service.service.serviceImpl;

import com.alibaba.shopping.shopping_bean.bean.UserMembers;
import com.alibaba.shopping.shopping_protal_dao.mapper.UserMapper;
import com.shopping.shopping_protal_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 金海洋
 * @describe
 * @date 2019/8/10  12:44
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public List<UserMembers> getAllUser() {

		List<UserMembers> userMembers=userMapper.selectAllUser();

		return userMembers;
	}
}
