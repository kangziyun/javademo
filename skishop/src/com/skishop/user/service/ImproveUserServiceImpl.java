package com.skishop.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.entity.User;
import com.skishop.user.dao.ImproveUserDaoImpl;

@Service
@Transactional
public class ImproveUserServiceImpl {
	@Resource
	private ImproveUserDaoImpl improveuserdaoImpl; 
	public void improve(int id,String password,String address){
		this.improveuserdaoImpl.updateUser(id, password, address);
	}
}
