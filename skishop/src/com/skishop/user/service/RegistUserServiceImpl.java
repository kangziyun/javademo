package com.skishop.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.entity.User;
import com.skishop.user.dao.RegistUserDaoImpl;

@Service
@Transactional(readOnly=true)
public class RegistUserServiceImpl {
	
	@Resource
	private RegistUserDaoImpl RegistUserDaoImpl;
	
	public void regist(User u){
		try {
			this.RegistUserDaoImpl.addUser(u);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public String checkName(String name){
		if(this.RegistUserDaoImpl.findAllNames().contains(name)){
			return	"已经存在";
		}else{
			return "null";
		}
	}
}
