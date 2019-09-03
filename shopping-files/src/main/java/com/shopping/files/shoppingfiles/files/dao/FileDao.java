package com.shopping.files.shoppingfiles.files.dao;

import com.shopping.files.shoppingfiles.files.entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao extends JpaRepository<FileUpload, String> {
	
	public List<FileUpload> findByChannel(String channel);
	
	public List<FileUpload> findByIdIn(List<String> ids);
}
