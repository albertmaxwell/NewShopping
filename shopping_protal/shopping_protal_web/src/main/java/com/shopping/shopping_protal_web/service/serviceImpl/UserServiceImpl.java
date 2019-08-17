package com.shopping.shopping_protal_web.service.serviceImpl;



import com.shopping.shopping_protal_web.bean.UserMembers;
import com.shopping.shopping_protal_web.mapper.UserMapper;
import com.shopping.shopping_protal_web.service.UserService;
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
