package com.alibaba.shopping.shopping_bean.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/9/29  -14:59
 */
public class Accessory {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 8707872936870153411L;
	//附近名称
	private String name;
	//附件路径
	private String path;
	//大小
	private float size;
	//宽度
	private int width;
	//高度
	private int height;
	//扩展名
	private String ext;
	//名称详情
	private String info;

	/*//所属人
	private User user;*/

	//相册
	private Album album;

	private Album cover_album;

	//系统配置
	private SysConfig config;

	//goods主列表
	private List<Goods> goods_main_list = new ArrayList<Goods>();

	//goods列表
	private List<Goods> goods_list = new ArrayList<Goods>();

	public List<Goods> getGoods_main_list(){
		return this.goods_main_list;
	}

	public void setGoods_main_list(List<Goods> goods_main_list){
		this.goods_main_list = goods_main_list;
	}

	public List<Goods> getGoods_list(){
		return this.goods_list;
	}

	public void setGoods_list(List<Goods> goods_list){
		this.goods_list = goods_list;
	}

	/*public User getUser(){
		return this.user;
	}

	public void setUser(User user){
		this.user = user;
	}*/

	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPath(){
		return this.path;
	}

	public void setPath(String path){
		this.path = path;
	}

	public float getSize(){
		return this.size;
	}

	public void setSize(float size){
		this.size = size;
	}

	public int getWidth(){
		return this.width;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getHeight(){
		return this.height;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public String getExt(){
		return this.ext;
	}

	public void setExt(String ext){
		this.ext = ext;
	}

	public Album getAlbum(){
		return this.album;
	}

	public void setAlbum(Album album){
		this.album = album;
	}

	public Album getCover_album(){
		return this.cover_album;
	}

	public void setCover_album(Album cover_album){
		this.cover_album = cover_album;
	}

	public SysConfig getConfig(){
		return this.config;
	}

	public void setConfig(SysConfig config){
		this.config = config;
	}


}
