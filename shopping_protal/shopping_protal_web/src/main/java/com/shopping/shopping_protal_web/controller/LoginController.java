package com.shopping.shopping_protal_web.controller;


import com.alibaba.shopping.common.bean.TSUser;
import com.alibaba.shopping.common.exception.ResultException;
import com.alibaba.shopping.common.json.AjaxJson;
import com.alibaba.shopping.common.response.ResponseMessage;
import com.alibaba.shopping.common.response.Result;

import com.alibaba.shopping.common.utils.ContextHolderUtils;
import com.alibaba.shopping.shopping_bean.bean.LoginUserVo;
import com.alibaba.shopping.shopping_bean.bean.entity.SysUserEntity;

import com.alibaba.shopping.shoppingcommonutils.common.cache.RedisService;
import com.alibaba.shopping.shoppingcommonutils.common.service.ClientManager;
import com.alibaba.shopping.shoppingcommonutils.common.service.LoginService;
import com.alibaba.shopping.shoppingcommonutils.common.utils.ResourceUtil;
import com.shopping.shopping_protal_service.service.UserService;
import com.shopping.shopping_protal_web.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
	/*@Autowired
	RedisService redisService;*/
	@Autowired
	LoginService login;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Resource
	private ClientManager clientManager;


	/**
	 *
	 * 登录用户每调用一次这个接口
	 *
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	//@Cacheable(cacheNames = "users")实现序列化的返回对象才能进入缓存
	@ApiOperation(value = "用户登录接口", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> login(@RequestBody LoginVo loginVo, HttpServletRequest request) {
		try {
			/*redisService.set("1","value22222");
			System.out.println(redisService.get("1"));
			System.out.println("jinhaiyang");*/
			SysUserEntity user = userService.login(loginVo.getUsername(), loginVo.getPassword());
			if(user!=null){
				TSUser tsUser=new TSUser();
				tsUser.setUsername(user.getUsername());
				//这个方法主要完成用户的session的保存或者更新，就是把用户保存到系统中
				login.saveLoginUserInfo(request, tsUser);
				return Result.success(user);
			}else{
				return Result.error("用户密码错误");
			}
		} catch (ResultException e) {
			e.printStackTrace();
			return Result.error("用户密码错误");
		}

	}

	/**
	 *
	 * 登录用户每调用一次这个接口
	 *
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value = "/loginOne", method = RequestMethod.POST)
	@ResponseBody
	//@Cacheable(cacheNames = "users")实现序列化的返回对象才能进入缓存
	@ApiOperation(value = "用户登录接口", notes = "传入对象数据")
	public ResponseMessage<?> login(@RequestParam("username") String username, @RequestParam("password") String password
			, HttpServletRequest request){
		try {
			SysUserEntity user = userService.login(username, password);
			if(user!=null){
				TSUser tsUser=new TSUser();
				tsUser.setUsername(user.getUsername());
				//这个方法主要完成用户的session的保存或者更新，就是把用户保存到系统中
				login.saveLoginUserInfo(request, tsUser);
				//userService.getFunctionMap("23ert45er2er4er6re6ert256rtet21424");
				return Result.success(user);
			}else{
				return Result.error("用户密码错误");
			}
		} catch (ResultException e) {
			e.printStackTrace();
			return Result.error("用户密码错误");
		}

	}


	/**
	 * 退出系统
	 *
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "用户退出登陆接口", notes = "传入对象数据")
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson loginOut(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		AjaxJson json=new AjaxJson();
		String message=null;
		message="退出成功";
		try {
			HttpSession session = ContextHolderUtils.getSession();
			TSUser user = ResourceUtil.getSessionUser();
			clientManager.removeClinet(session.getId());
			session.invalidate();
			json.setMsg(message);
		} catch (Exception e) {
			e.printStackTrace();
			message="退出异常";
			json.setMsg(message);
		}
		return json;
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


	/**
	 * sql学习
	 * @return
	 */
	@RequestMapping(value = "/learnSql", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "学习sql", notes = "传入参数", produces = "application/json")
	public ResponseMessage<?> learnSql(HttpServletRequest request) {
		try {
			List<Map<String, Object>> mapList=null;
//			String sql="select *  from  user";
//			String sql="select ifnull(username,0) as username from  user  where username='ccc'";
//			String sql="select case username  when 'admin' then '8888' END taxData from user ";
//			String sql="select * from t_s_base_user left join t_s_user_org on t_s_base_user.id=t_s_user_org.user_id";
//			String sql="select *  from t_s_base_user where username like '%' group by delete_flag having username='admin' order by create_date desc limit 0,1 ";
//			String sql="select *  from project_daily  order by create_date desc limit 0,2 ";
//			String sql="select *  from project_daily   where create_by='jhy' union all select *  from project_daily  where create_by='fangzhen'";
//			String sql="select aa.*, sum(bpm_status) from project_daily aa group by title";
//			String sql="SELECT FORMAT(title,2) as title from project_daily ";
//			String sql="SELECT create_date from project_daily where create_date>STR_TO_DATE('2019-05-01 13:14:10',\"%Y-%m-%d %H:%i:%s\") ";
//          left join会返回一个左表中所有的数据  一旦和右边的表有多个匹配就继续另起一行然后就就是新的一个数据，与右表没有匹配的数据还是继续保留
			String sql="select *  from ";
			mapList = jdbcTemplate.queryForList(sql);
			//List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{comId, number, id});
			return Result.success(mapList);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("查询失败");
		}

	}





}
