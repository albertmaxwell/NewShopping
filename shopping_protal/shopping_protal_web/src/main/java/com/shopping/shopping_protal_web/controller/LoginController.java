package com.shopping.shopping_protal_web.controller;


import com.alibaba.shopping.common.exception.ResultException;
import com.alibaba.shopping.common.response.ResponseMessage;
import com.alibaba.shopping.common.response.Result;
import com.alibaba.shopping.shopping_bean.bean.entity.SysUserEntity;
import com.shopping.shopping_protal_service.service.RedisService;
import com.shopping.shopping_protal_service.service.UserService;
import com.shopping.shopping_protal_web.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.zltrj.message.plugin.constants.MessageType;
import com.zltrj.message.plugin.disruptor.MessageInfo;
import com.zltrj.message.plugin.disruptor.MsgQueue;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * @author 金海洋
 * @date 2019/8/17  -13:21
 */
@Api(tags = "用户登录接口")
@Controller
@RequestMapping("/loginController")
public class LoginController {

	@Autowired
	UserService userService;
	@Autowired
	RedisService redisService ;

	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	//@Cacheable(cacheNames = "users")实现序列化的返回对象才能进入缓存
	@ApiOperation(value = "用户登录接口", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> login(@RequestBody LoginVo loginVo, HttpServletRequest request) {
		try {
			System.out.println();
			//redisService.set("1","value22222");
			//System.out.println(redisService.get("1"));
			System.out.println("jinhaiyang");
			send();
			SysUserEntity user = userService.login(loginVo.getUsername(), loginVo.getPassword());
			if(user!=null){
				return Result.success(user);
			}else{
				return Result.error("用户密码错误");
			}
		} catch (ResultException e) {
			e.printStackTrace();
			return Result.error("用户密码错误");
		}

	}

	public void send(){
		System.out.println("热部署");
	}


	/**
	 * 用户新增
	 * @return
	 */

	//@CachePut缓存新增或更新的数据到缓存，其中缓存的名称为people，数据的key是person的id
	//@CachePut(value = "userId", key = "#SysUserEntity.id")
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户新增接口", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> addUser(@RequestBody SysUserEntity sysUserEntity, HttpServletRequest request) {
		try {
			MessageInfo info = new MessageInfo();
			info.setType(MessageType.WECHAT_TEMPLETE);
			MsgQueue.publishMessge(info);
			System.out.println("wrwerw");
			 userService.addUser(sysUserEntity);
				return Result.success("用户添加成功");
		} catch (ResultException e) {
			e.printStackTrace();
			return Result.error("用户添加失败");
		}

	}

	/**
	 * 用户删除
	 * @return
	 */
	//@CacheEvict从缓存people中删除key为id的数据
	//如果没有指定key，则方法参数作为key
	//@CacheEvict(value = "id")
	@RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户删除接口", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> deleteUserById(@RequestParam("id") Integer id, HttpServletRequest request) {
		try {
			 userService.deleteUser(id);
				return Result.success("用户删除失败");
		} catch (ResultException e) {
			e.printStackTrace();
			return Result.error("用户删除失败");
		}

	}


	/**
	 * 用户更新
	 * @return
	 */
	//@CachePut缓存新增或更新的数据到缓存，其中缓存的名称为people，数据的key是person的id
	//@CachePut(value = "userId", key = "#SysUserEntity.id")
	@RequestMapping(value = "/updateUserById", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户更新接口", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> updateUserById(@RequestBody SysUserEntity sysUserEntity, HttpServletRequest request) {

		try {
			 userService.updateUser(sysUserEntity);
				return Result.success("用户更新成功");
		} catch (ResultException e) {
			e.printStackTrace();
			return Result.error("用户更新失败");
		}

	}


	/**
	 * 用户全部查询
	 * @return
	 */
	//@CachePut缓存新增或更新的数据到缓存，其中缓存的名称为people，数据的key是person的id
	//@Cacheable(cacheNames = "users")
	@RequestMapping(value = "/findAllUser", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户全部查询接口", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> findAllUser(HttpServletRequest request,String is) {
		try {
			List<Map<String ,Object>> users= userService.getAllUsers();
				return Result.success(users);
		} catch (ResultException e) {
			e.printStackTrace();
			return Result.error("查询失败");
		}

	}


	/**
	 * 静态数组分页查询
	 * @return
	 */
	@RequestMapping(value = "/userPage", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "静态数组分页查询", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> userPage(@RequestParam(value = "currPage") Integer currPage,
									   @RequestParam(value = "pageSize") Integer pageSize,
									   HttpServletRequest request) {
		try {
			List<SysUserEntity> userPageData = userService.queryUsersByArray(currPage, pageSize);
				return Result.success(userPageData);
		} catch (ResultException e) {
			e.printStackTrace();
			return Result.error("查询失败");
		}

	}


}
