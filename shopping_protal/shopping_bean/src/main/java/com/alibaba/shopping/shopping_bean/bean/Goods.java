package com.alibaba.shopping.shopping_bean.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/9/29  -15:26
 */
public class Goods {

	/**
	 * UID
	 *//*
	private static final long serialVersionUID = -4611982955098188929L;

	private String seo_keywords;

	//seo描述
	private String seo_description;
	//名称
	private String goods_name;

	//价格
	private BigDecimal goods_price;

	//店铺价格
	private BigDecimal store_price;
	//库存
	private int goods_inventory;
	//库存类型
	private String inventory_type;
	private int goods_salenum;
	private String goods_serial;

	//重量
	private BigDecimal goods_weight;

	//量
	private BigDecimal goods_volume;
	//小费
	private String goods_fee;

	//细节
	private String goods_details;
	//是否为推荐店铺
	private boolean store_recommend;
	//推荐店铺时间
	private Date store_recommend_time;
	//是否为推荐
	private boolean goods_recommend;
	//点击量
	private int goods_click;

	//收藏量
	private int goods_collect;

	//店铺
	private Store goods_store;
	//状态
	private int goods_status;
	private Date goods_seller_time;
	private int goods_transfee;

	//商品分类
	private GoodsClass gc;

	//主照片
	private Accessory goods_main_photo;

	//照片

	private List<Accessory> goods_photos = new ArrayList<Accessory>();

	// 商品自定义分类

	private List<UserGoodsClass> goods_ugcs = new ArrayList<UserGoodsClass>();

	// 商品规格，SKU

	private List<GoodsSpecProperty> goods_specs = new ArrayList<GoodsSpecProperty>();

	private GoodsBrand goods_brand;

	private String goods_property;

	private String goods_inventory_detail;
	private int ztc_status;
	private int ztc_pay_status;
	private int ztc_price;
	private int ztc_dredge_price;
	private Date ztc_apply_time;

	private Date ztc_begin_time;
	private int ztc_gold;
	private int ztc_click_num;

	private User ztc_admin;

	private String ztc_admin_content;

	private List<GroupGoods> group_goods_list = new ArrayList<GroupGoods>();

	private Group group;

	private int group_buy;

	private List<Consult> consults = new ArrayList<Consult>();

	private List<Evaluate> evaluates = new ArrayList<Evaluate>();

	private List<Favorite> favs = new ArrayList<Favorite>();

	private int goods_choice_type;

	private int activity_status;

	private BigDecimal goods_current_price;

	private int bargain_status;

	private List<BargainGoods> bgs = new ArrayList<BargainGoods>();

	private int delivery_status;

	private int combin_status;

	private Date combin_begin_time;

	private Date combin_end_time;

	private BigDecimal combin_price;

	private List<Goods> combin_goods = new ArrayList<Goods>();

	private DeliveryGoods dg;

	private BigDecimal mail_trans_fee;

	private BigDecimal express_trans_fee;

	private BigDecimal ems_trans_fee;

	private Transport transport;

	private BigDecimal description_evaluate;

	private List<Dynamic> dynamics = new ArrayList<Dynamic>();

	private List<BargainGoods> bargainGoods_list = new ArrayList<BargainGoods>();

	private DeliveryGoods d_main_goods;

	private List<DeliveryGoods> d_goods_list = new ArrayList<DeliveryGoods>();

	private List<ActivityGoods> ag_goods_list = new ArrayList<ActivityGoods>();

	private GoodsReturnItem gri;

	private List<Evaluate> evas = new ArrayList<Evaluate>();

	private boolean weixin_shop_recommend;

	private Date weixin_shop_recommendTime;

	private boolean weixin_shop_hot;

	private Date weixin_shop_hotTime;

	public boolean isWeixin_shop_recommend(){
		return this.weixin_shop_recommend;
	}

	public void setWeixin_shop_recommend(boolean weixin_shop_recommend){
		this.weixin_shop_recommend = weixin_shop_recommend;
	}

	public Date getWeixin_shop_recommendTime(){
		return this.weixin_shop_recommendTime;
	}

	public void setWeixin_shop_recommendTime(Date weixin_shop_recommendTime){
		this.weixin_shop_recommendTime = weixin_shop_recommendTime;
	}

	public boolean isWeixin_shop_hot(){
		return this.weixin_shop_hot;
	}

	public void setWeixin_shop_hot(boolean weixin_shop_hot){
		this.weixin_shop_hot = weixin_shop_hot;
	}

	public Date getWeixin_shop_hotTime(){
		return this.weixin_shop_hotTime;
	}

	public void setWeixin_shop_hotTime(Date weixin_shop_hotTime){
		this.weixin_shop_hotTime = weixin_shop_hotTime;
	}

	public List<Evaluate> getEvas(){
		return this.evas;
	}

	public void setEvas(List<Evaluate> evas){
		this.evas = evas;
	}

	public BigDecimal getDescription_evaluate(){
		return this.description_evaluate;
	}

	public void setDescription_evaluate(BigDecimal description_evaluate){
		this.description_evaluate = description_evaluate;
	}

	public GoodsReturnItem getGri(){
		return this.gri;
	}

	public void setGri(GoodsReturnItem gri){
		this.gri = gri;
	}

	public List<ActivityGoods> getAg_goods_list(){
		return this.ag_goods_list;
	}

	public void setAg_goods_list(List<ActivityGoods> ag_goods_list){
		this.ag_goods_list = ag_goods_list;
	}

	public DeliveryGoods getD_main_goods(){
		return this.d_main_goods;
	}

	public void setD_main_goods(DeliveryGoods d_main_goods){
		this.d_main_goods = d_main_goods;
	}

	public List<DeliveryGoods> getD_goods_list(){
		return this.d_goods_list;
	}

	public void setD_goods_list(List<DeliveryGoods> d_goods_list){
		this.d_goods_list = d_goods_list;
	}

	public List<Dynamic> getDynamics(){
		return this.dynamics;
	}

	public void setDynamics(List<Dynamic> dynamics){
		this.dynamics = dynamics;
	}

	public List<BargainGoods> getBargainGoods_list(){
		return this.bargainGoods_list;
	}

	public void setBargainGoods_list(List<BargainGoods> bargainGoods_list){
		this.bargainGoods_list = bargainGoods_list;
	}

	public int getDelivery_status(){
		return this.delivery_status;
	}

	public void setDelivery_status(int delivery_status){
		this.delivery_status = delivery_status;
	}

	public List<Consult> getConsults(){
		return this.consults;
	}

	public void setConsults(List<Consult> consults){
		this.consults = consults;
	}

	public int getGroup_buy(){
		return this.group_buy;
	}

	public void setGroup_buy(int group_buy){
		this.group_buy = group_buy;
	}

	public int getZtc_status(){
		return this.ztc_status;
	}

	public void setZtc_status(int ztc_status){
		this.ztc_status = ztc_status;
	}

	public int getZtc_price(){
		return this.ztc_price;
	}

	public void setZtc_price(int ztc_price){
		this.ztc_price = ztc_price;
	}

	public Date getZtc_begin_time(){
		return this.ztc_begin_time;
	}

	public void setZtc_begin_time(Date ztc_begin_time){
		this.ztc_begin_time = ztc_begin_time;
	}

	public int getZtc_gold(){
		return this.ztc_gold;
	}

	public void setZtc_gold(int ztc_gold){
		this.ztc_gold = ztc_gold;
	}

	public String getSeo_keywords(){
		return this.seo_keywords;
	}

	public void setSeo_keywords(String seo_keywords){
		this.seo_keywords = seo_keywords;
	}

	public String getSeo_description(){
		return this.seo_description;
	}

	public void setSeo_description(String seo_description){
		this.seo_description = seo_description;
	}

	public String getGoods_name(){
		return this.goods_name;
	}

	public void setGoods_name(String goods_name){
		this.goods_name = goods_name;
	}

	public int getGoods_inventory(){
		return this.goods_inventory;
	}

	public void setGoods_inventory(int goods_inventory){
		this.goods_inventory = goods_inventory;
	}

	public String getInventory_type(){
		return this.inventory_type;
	}

	public void setInventory_type(String inventory_type){
		this.inventory_type = inventory_type;
	}

	public int getGoods_salenum(){
		return this.goods_salenum;
	}

	public void setGoods_salenum(int goods_salenum){
		this.goods_salenum = goods_salenum;
	}

	public String getGoods_serial(){
		return this.goods_serial;
	}

	public void setGoods_serial(String goods_serial){
		this.goods_serial = goods_serial;
	}

	public BigDecimal getGoods_price(){
		return this.goods_price;
	}

	public void setGoods_price(BigDecimal goods_price){
		this.goods_price = goods_price;
	}

	public BigDecimal getStore_price(){
		return this.store_price;
	}

	public void setStore_price(BigDecimal store_price){
		this.store_price = store_price;
	}

	public BigDecimal getGoods_weight(){
		return this.goods_weight;
	}

	public void setGoods_weight(BigDecimal goods_weight){
		this.goods_weight = goods_weight;
	}

	public String getGoods_fee(){
		return this.goods_fee;
	}

	public void setGoods_fee(String goods_fee){
		this.goods_fee = goods_fee;
	}

	public String getGoods_details(){
		return this.goods_details;
	}

	public void setGoods_details(String goods_details){
		this.goods_details = goods_details;
	}

	public boolean isStore_recommend(){
		return this.store_recommend;
	}

	public void setStore_recommend(boolean store_recommend){
		this.store_recommend = store_recommend;
	}

	public Date getStore_recommend_time(){
		return this.store_recommend_time;
	}

	public void setStore_recommend_time(Date store_recommend_time){
		this.store_recommend_time = store_recommend_time;
	}

	public boolean isGoods_recommend(){
		return this.goods_recommend;
	}

	public void setGoods_recommend(boolean goods_recommend){
		this.goods_recommend = goods_recommend;
	}

	public int getGoods_click(){
		return this.goods_click;
	}

	public void setGoods_click(int goods_click){
		this.goods_click = goods_click;
	}

	public Store getGoods_store(){
		return this.goods_store;
	}

	public void setGoods_store(Store goods_store){
		this.goods_store = goods_store;
	}

	public int getGoods_status(){
		return this.goods_status;
	}

	public void setGoods_status(int goods_status){
		this.goods_status = goods_status;
	}

	public Date getGoods_seller_time(){
		return this.goods_seller_time;
	}

	public void setGoods_seller_time(Date goods_seller_time){
		this.goods_seller_time = goods_seller_time;
	}

	public int getGoods_transfee(){
		return this.goods_transfee;
	}

	public void setGoods_transfee(int goods_transfee){
		this.goods_transfee = goods_transfee;
	}

	public GoodsClass getGc(){
		return this.gc;
	}

	public void setGc(GoodsClass gc){
		this.gc = gc;
	}

	public Accessory getGoods_main_photo(){
		return this.goods_main_photo;
	}

	public void setGoods_main_photo(Accessory goods_main_photo){
		this.goods_main_photo = goods_main_photo;
	}

	public List<Accessory> getGoods_photos(){
		return this.goods_photos;
	}

	public void setGoods_photos(List<Accessory> goods_photos){
		this.goods_photos = goods_photos;
	}

	public List<UserGoodsClass> getGoods_ugcs(){
		return this.goods_ugcs;
	}

	public void setGoods_ugcs(List<UserGoodsClass> goods_ugcs){
		this.goods_ugcs = goods_ugcs;
	}

	public List<GoodsSpecProperty> getGoods_specs(){
		return this.goods_specs;
	}

	public void setGoods_specs(List<GoodsSpecProperty> goods_specs){
		this.goods_specs = goods_specs;
	}

	public GoodsBrand getGoods_brand(){
		return this.goods_brand;
	}

	public void setGoods_brand(GoodsBrand goods_brand){
		this.goods_brand = goods_brand;
	}

	public String getGoods_property(){
		return this.goods_property;
	}

	public void setGoods_property(String goods_property){
		this.goods_property = goods_property;
	}

	public String getGoods_inventory_detail(){
		return this.goods_inventory_detail;
	}

	public void setGoods_inventory_detail(String goods_inventory_detail){
		this.goods_inventory_detail = goods_inventory_detail;
	}

	public int getZtc_pay_status(){
		return this.ztc_pay_status;
	}

	public void setZtc_pay_status(int ztc_pay_status){
		this.ztc_pay_status = ztc_pay_status;
	}

	public User getZtc_admin(){
		return this.ztc_admin;
	}

	public void setZtc_admin(User ztc_admin){
		this.ztc_admin = ztc_admin;
	}

	public String getZtc_admin_content(){
		return this.ztc_admin_content;
	}

	public void setZtc_admin_content(String ztc_admin_content){
		this.ztc_admin_content = ztc_admin_content;
	}

	public Date getZtc_apply_time(){
		return this.ztc_apply_time;
	}

	public void setZtc_apply_time(Date ztc_apply_time){
		this.ztc_apply_time = ztc_apply_time;
	}

	public int getZtc_click_num(){
		return this.ztc_click_num;
	}

	public void setZtc_click_num(int ztc_click_num){
		this.ztc_click_num = ztc_click_num;
	}

	public int getZtc_dredge_price(){
		return this.ztc_dredge_price;
	}

	public void setZtc_dredge_price(int ztc_dredge_price){
		this.ztc_dredge_price = ztc_dredge_price;
	}

	public int getGoods_collect(){
		return this.goods_collect;
	}

	public void setGoods_collect(int goods_collect){
		this.goods_collect = goods_collect;
	}

	public List<GroupGoods> getGroup_goods_list(){
		return this.group_goods_list;
	}

	public void setGroup_goods_list(List<GroupGoods> group_goods_list){
		this.group_goods_list = group_goods_list;
	}

	public Group getGroup(){
		return this.group;
	}

	public void setGroup(Group group){
		this.group = group;
	}

	public List<Evaluate> getEvaluates(){
		return this.evaluates;
	}

	public void setEvaluates(List<Evaluate> evaluates){
		this.evaluates = evaluates;
	}

	public int getGoods_choice_type(){
		return this.goods_choice_type;
	}

	public void setGoods_choice_type(int goods_choice_type){
		this.goods_choice_type = goods_choice_type;
	}

	public int getActivity_status(){
		return this.activity_status;
	}

	public void setActivity_status(int activity_status){
		this.activity_status = activity_status;
	}

	public BigDecimal getGoods_current_price(){
		return this.goods_current_price;
	}

	public void setGoods_current_price(BigDecimal goods_current_price){
		this.goods_current_price = goods_current_price;
	}

	public List<Favorite> getFavs(){
		return this.favs;
	}

	public void setFavs(List<Favorite> favs){
		this.favs = favs;
	}

	public int getBargain_status(){
		return this.bargain_status;
	}

	public void setBargain_status(int bargain_status){
		this.bargain_status = bargain_status;
	}

	public BigDecimal getGoods_volume(){
		return this.goods_volume;
	}

	public void setGoods_volume(BigDecimal goods_volume){
		this.goods_volume = goods_volume;
	}

	public BigDecimal getMail_trans_fee(){
		return this.mail_trans_fee;
	}

	public void setMail_trans_fee(BigDecimal mail_trans_fee){
		this.mail_trans_fee = mail_trans_fee;
	}

	public BigDecimal getExpress_trans_fee(){
		return this.express_trans_fee;
	}

	public void setExpress_trans_fee(BigDecimal express_trans_fee){
		this.express_trans_fee = express_trans_fee;
	}

	public BigDecimal getEms_trans_fee(){
		return this.ems_trans_fee;
	}

	public void setEms_trans_fee(BigDecimal ems_trans_fee){
		this.ems_trans_fee = ems_trans_fee;
	}

	public Transport getTransport(){
		return this.transport;
	}

	public void setTransport(Transport transport){
		this.transport = transport;
	}

	public List<BargainGoods> getBgs(){
		return this.bgs;
	}

	public void setBgs(List<BargainGoods> bgs){
		this.bgs = bgs;
	}

	public DeliveryGoods getDg(){
		return this.dg;
	}

	public void setDg(DeliveryGoods dg){
		this.dg = dg;
	}

	public List<Goods> getCombin_goods(){
		return this.combin_goods;
	}

	public void setCombin_goods(List<Goods> combin_goods){
		this.combin_goods = combin_goods;
	}

	public int getCombin_status(){
		return this.combin_status;
	}

	public void setCombin_status(int combin_status){
		this.combin_status = combin_status;
	}

	public Date getCombin_begin_time(){
		return this.combin_begin_time;
	}

	public void setCombin_begin_time(Date combin_begin_time){
		this.combin_begin_time = combin_begin_time;
	}

	public Date getCombin_end_time(){
		return this.combin_end_time;
	}

	public void setCombin_end_time(Date combin_end_time){
		this.combin_end_time = combin_end_time;
	}

	public BigDecimal getCombin_price(){
		return this.combin_price;
	}

	public void setCombin_price(BigDecimal combin_price){
		this.combin_price = combin_price;
	}
*/
}
