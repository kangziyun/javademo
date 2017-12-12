package com.skishop.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.entity.User;
import com.skishop.user.dao.PageUserDaoImpl;

@Service
@Transactional(readOnly=true)
public class PageUserServiceImpl {
	@Resource
	private PageUserDaoImpl pageuserdaoImpl;
	public List<User> pageshow(int pageNum){
		return this.pageuserdaoImpl.selectUserByPage(pageNum,3);
	}
	public Long pageCount(){
		return this.pageuserdaoImpl.findCountByPage();
	}
	public void deleteUser(int id){
	this.pageuserdaoImpl.deleteUser(id);
	}
}
