package com.alibaba.shopping.shopping_bean.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/9/29  -15:00
 */
public class Album {

	//相册名称
	private String album_name;
	//相册序号
	private int album_sequence;
	//头像
	private List<Accessory> photos = new ArrayList<Accessory>();
	//相册
	private Accessory album_cover;
	//默认相册
	private boolean album_default;

	//相册信息
	private String alblum_info;

	//相册所属人
	private User user;

	public String getAlbum_name(){
		return this.album_name;
	}

	public void setAlbum_name(String album_name){
		this.album_name = album_name;
	}

	public List<Accessory> getPhotos(){
		return this.photos;
	}

	public void setPhotos(List<Accessory> photos){
		this.photos = photos;
	}

	public String getAlblum_info(){
		return this.alblum_info;
	}

	public void setAlblum_info(String alblum_info){
		this.alblum_info = alblum_info;
	}

	public int getAlbum_sequence(){
		return this.album_sequence;
	}

	public void setAlbum_sequence(int album_sequence){
		this.album_sequence = album_sequence;
	}

	public User getUser(){
		return this.user;
	}

	public void setUser(User user){
		this.user = user;
	}

	public boolean isAlbum_default(){
		return this.album_default;
	}

	public void setAlbum_default(boolean album_default){
		this.album_default = album_default;
	}

	public Accessory getAlbum_cover(){
		return this.album_cover;
	}

	public void setAlbum_cover(Accessory album_cover){
		this.album_cover = album_cover;
	}


}
