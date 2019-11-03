package com.shopping.shopping_protal_web.controller;

import com.alibaba.shopping.common.common.enums.ErrorCode;
import com.alibaba.shopping.common.common.exception.ResultException;
import com.alibaba.shopping.common.common.vo.ResultVo;
import com.alibaba.shopping.common.response.ResponseMessage;
import com.alibaba.shopping.common.response.Result;
import com.alibaba.shopping.common.vo.PictureVo;
import com.alibaba.shopping.common.vo.ResultVoFactory.DataGrid;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Accessory;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Album;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_protal_dao.jpadao.Accessorydao;
import com.shopping.shopping_protal_service.service.Jpaservice;
import com.shopping.shopping_protal_web.tools.AlbumViewTools;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.runner.FilePluginConfig;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.service.FileServicePluginFiles;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 金海洋
 * @date 2019/10/3  -9:24
 */
@Controller
@RequestMapping("/myShopController")
public class MyShopController {

	@Autowired
	Jpaservice sss;
	@Autowired
	private AlbumViewTools bbb;
	@Autowired
	private Accessorydao accessorydao;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private FileServicePluginFiles fileServicePluginFiles;
	@Value("${files.controller.enable:false}")
	private boolean controllerEnable;

	/**
	 * 商品发布  点击发布商品的时候
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addGoods",method = RequestMethod.GET)
	public String addGoods(Model model){

		Map<String,Object> map = new HashMap<String, Object>();
		List<GoodsClass> goodsClassList=sss.getGoodsClassList(map);
		model.addAttribute("goodsClassList",goodsClassList);
		return "web/GoodsFaBu";

	}


	@RequestMapping(value = "/goodsFabBuSecond",method = RequestMethod.GET)
	public String goodsFabBuSecond(HttpServletRequest request, HttpServletResponse response){



		return "web/GoodsFaBuSecond";
	}


	/**
	 * 销售中的商品
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "salingGoods")
	public String salingGoods(Model model){

		return "";

	}

	/**
	 * 仓库商品
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "caokuGoods")
	public String caokuGoods(Model model){

		return "";

	}

	/**
	 *
	 * 违规商品
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "weiguiGoods")
	public String weiguiGoods(Model model){

		return "";

	}

	/**
	 * 商品分类
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "goodsClass")
	public String goodsClass(Model model){

		return "";

	}

	/**
	 * 品牌申请
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "brandRequest")
	public String brandRequest(Model model){

		return "";

	}

	/**
	 * 被举报禁售
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "jubaoGoods")
	public String jubaoGoods(Model model){

		return "";

	}

	/**
	 * 闲置发布
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "xianzhiRes")
	public String xianzhiRes(Model model){

		return "";

	}

	/**
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "register")
	public String register(Model model){

		return "";

	}

	/**
	 * 淘宝导入
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "taobaoExp")
	public String taobaoExp(Model model){

		return "";

	}

	/**
	 * 订单管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "orderMangage")
	public String orderMangage(Model model){

		return "";

	}

	/**
	 * 支付方式
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "patStyle")
	public String patStyle(Model model){

		return "";

	}

	/**
	 * 物流工具
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "wuliuTools")
	public String wuliuTools(Model model){

		return "";

	}

	/**
	 * 我的店铺
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "myShop")
	public String myShop(Model model){

		return "";

	}

	/**
	 * 店铺设置
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "shopSet")
	public String shopSet(Model model){

		return "";

	}

	/**
	 * 子账户管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "sunAccountMsg")
	public String sunAccountMsg(Model model){

		return "";

	}

	/**
	 * 主题设置
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "themeSet")
	public String themeSet(Model model){

		return "";

	}

	/**
	 * 导航管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "daohangMsg")
	public String daohangMsg(Model model){

		return "";

	}

	/**
	 * 友情链接
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "friendLink")
	public String friendLink(Model model){

		return "";

	}

	/**
	 * 退款管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "quitMoney")
	public String quitMoney(Model model){

		return "";

	}

	/**
	 * 退货管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "quitGoods")
	public String quitGoods(Model model){

		return "";

	}

	/**
	 * 咨询管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "askMsg")
	public String askMsg(Model model){

		return "";

	}

	/**
	 * 投诉管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "fuckMsg")
	public String fuckMsg(Model model){

		return "";

	}

	/**
	 * 竞价直通车
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "jingjiaCar")
	public String jingjiaCar(Model model){

		return "";

	}

	/**
	 * 活动管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "activityMsg")
	public String activityMsg(Model model){

		return "";

	}

	/**
	 * 团购管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "teamMsg")
	public String teamMsg(Model model){

		return "";

	}

	/**
	 * 天天特价
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "dayGoodPrice")
	public String dayGoodPrice(Model model){

		return "";

	}

	/**
	 * 组合销售
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "togetherSale")
	public String togetherSale(Model model){

		return "";

	}

	/**
	 * 买就送
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "buyAndGive")
	public String buyAndGive(Model model){

		return "";

	}

	/**
	 * 金币管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "moneyMsg")
	public String moneyMsg(Model model){

		return "";

	}

	/**
	 * 广告管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "adMsg")
	public String adMsg(Model model){

		return "";

	}

	/**
	 * 图片管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/picMsg")
	public String picMsg(Model model){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Album> albumList=sss.getAlbumPage(map);
		model.addAttribute("albumList",albumList);
		//List<Accessory> s=bbb.query_album("1");
		model.addAttribute("albumViewTools", this.bbb);
		return "web/PicMsg";
	}


	/**
	 * 创建相册
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/createAlbum",method = RequestMethod.GET)
	public String createAlbum(Model model){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Album> albumList=sss.getAlbumPage(map);
		model.addAttribute("aaa",albumList);
		return "web/albumUp";
	}


	/**
	 * 创建相册
	 * @param model
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping(value = "/createAlbum",method = RequestMethod.GET)
	public AjaxJson createAlbum(String bid, String bname){
		AjaxJson ajaxJson=new AjaxJson();
		Album album=new Album();
		album.setAlbum_name(bname);
		album.setAlbum_sequence(Integer.parseInt(bid));
		sss.saveAlbum(album);
		ajaxJson.setMsg("相册添加成功");
		ajaxJson.setObj("ok");
		ajaxJson.setSuccess(true);
		return ajaxJson;
	}*/

	/**
	 * 查询相册下拉框字典
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/albumDic",method = RequestMethod.GET)
	public String albumDic(Model model){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Album> albumList=sss.getAlbumDic(map);
		model.addAttribute("albumList",albumList);
		return "web/PicMsg";
	}


	/**
	 * 获取相册列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getAlbumPage",method = RequestMethod.GET)
	public String getAlbumPage(Model model,String pid){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Album> albumList=sss.getAlbumPage(map);
		model.addAttribute("albumList",albumList);

		return "web/PicMsg";
	}

	/**
	 * 获取图片列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getAccessoryList",method = RequestMethod.GET)
	public String getAlbumList(Model model, String id,HttpServletRequest request){
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		// TODO: 2019/11/2 没有人员权限的相册
		List<PictureVo> pictureVos=new ArrayList<>();
		Map<String,Object> map = new HashMap<String, Object>();
		int currData=((pageNum-1)*20)+1;
		int overData=pageNum*20;
		map.put("id",id);
		map.put("currData",currData+1);
		map.put("overData",overData);
		map.put("pageSize",20);
		map.put("pageNum",pageNum);
		DataGrid dataGrid= accessorydao.findPicList(map);
		List<Map<String, Object>>  total=jdbcTemplate.queryForList("select * from wemall_accessory  where ext='fff'");
		dataGrid.setTotal(total.size());
		List<Accessory> picList=dataGrid.getResults();
		for (int i = 0; i <picList.size() ; i++) {
			PictureVo pictureVo=new PictureVo();
			if(null!=picList.get(i).getPath()){
				Map<String, Object> pic=jdbcTemplate.queryForMap("select * from file_upload where id='"+picList.get(i).getPath()+"'");
				String ss="http://localhost:8056/"+pic.get("url").toString();
				pictureVo.setUrl(ss);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date=pic.get("create_time").toString();
				pictureVo.setCreateDate(date.substring(0,10));
				pictureVos.add(pictureVo);
			}
		}
		model.addAttribute("pictureVos",pictureVos);
		model.addAttribute("dataGrid",dataGrid);

		return "web/picList";
	}

	/**
	 *
	 * 图片列表配置分页
	 * @param pageable
	 * @return
	 */
	/*@RequestMapping(value = "/getPicturePage", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "图片列表接口", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> getPicturePage(@RequestParam(value = "page", defaultValue = "0") Integer page,
												@RequestParam(value = "size", defaultValue = "3") Integer size,@ApiParam(name = "查询字段对象")  PictureVo pictureVo){
		Page<Book> datas = accessorydao.findPictureCriteria(page, size, pictureVo);

		return Result.success(datas);
	}*/

	/**
	 * 上传文件
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/swfUpload",method = RequestMethod.GET)
	public void swfUpload(Model model,String pid){


	}



	/**
	 * 获取相册详情
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getAlbumDetailById",method = RequestMethod.GET)
	public String getAlbumDetailById(Model model,String id){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Album> albumList=sss.getAlbumPage(map);
		model.addAttribute("albumList",albumList);
		return "web/PicMsg";
	}





	/**
	 * 文件上传
	 * @param file
	 * @param suffix
	 * @return
	 */
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public ResultVo upload(@RequestParam("file") MultipartFile file
			, @RequestParam("suffix") String suffix
			, @RequestParam(value = "busName", required = false) String busName //业务名
			, HttpServletRequest request) {
		ResultVo resultVo = null;

		if(!controllerEnable) {
			resultVo = new ResultVo();
			resultVo.setCode(ErrorCode.ERROR.getCode());
			resultVo.setMessage("文件服务未开启");
			return resultVo;
		}

		String path = request.getContextPath();
		FilePluginConfig fpc = FilePluginConfig.getInstance();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/" + fpc.getFileWebPrefix() + "/";
		try {
			if(file == null || StringUtils.isEmpty(suffix)) {
				throw new ResultException(ErrorCode.PARAM_ERROR.getCode(), "参数错误");
			}
			resultVo = fileServicePluginFiles.upload(file, suffix, basePath, busName);
		} catch (ResultException e) {
			e.printStackTrace();
			resultVo = e.getResultVO();
		}
		return resultVo;
	}


	/**
	 * 多文件上传
	 * @param file
	 * @param suffix
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/swfUploads", method=RequestMethod.POST)
	public ResultVo swfUploads(MultipartFile Filedata, HttpServletRequest request,
							   HttpServletResponse response, String ID,
							   String Filename , String album_id) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		//MultipartFile multipartFile = (MultipartFile) request;

		List<MultipartFile> file=new ArrayList<>();
		file.add(Filedata);
		String suffix="png";
		String busName="1111";
		ResultVo resultVo = new ResultVo<>();
		resultVo.setOk(true);
		if(!controllerEnable) {
			resultVo = new ResultVo();
			resultVo.setCode(ErrorCode.ERROR.getCode());
			resultVo.setMessage("文件服务未开启");
			resultVo.setOk(false);
			return resultVo;
		}
		String[] s = suffix.split(",");
		if(file.size() != s.length) {
			resultVo = new ResultVo();
			resultVo.setCode(ErrorCode.ERROR.getCode());
			resultVo.setMessage("文件与后缀不对应");
			resultVo.setOk(false);
			return resultVo;
		}

		//传输文件
		List<String> ids = new ArrayList<>();
		for(int i=0; i<file.size(); i++) {
			ResultVo<String> temp = upload(file.get(i), s[i], busName, request);
			if(10000 == temp.getCode()) {
				ids.add(temp.getData());
			} else {
				resultVo.setMessage("部分文件未上传");
			}
		}
		resultVo.setData(ids);

		//User user=new User();

		Accessory image = new Accessory();
		List<Album> album=sss.findAlbumBySomeThing("select obj from Album obj where obj.id=?1",Long.parseLong(album_id));
		image.setAddTime(new Date());
		image.setExt("fff");
		image.setPath(ids.get(0));
		image.setWidth(233);
		image.setHeight(233);
		image.setAlbum(album.get(0));
		image.setName(Filename);
		//image.setUser(user);
		sss.save(image);

		return resultVo;

	}




}
