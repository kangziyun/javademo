package com.skishop.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.entity.User;
import com.skishop.user.dao.LoginUserDaoImpl;


@Service
@Transactional(readOnly=true)
public class LoginUserServiceImpl {	
	@Resource
	private LoginUserDaoImpl loginUserDaoImpl;
	public User login(String name, String pwd){
		List l=this.loginUserDaoImpl.findByUsername(name);
		User u = (User) l.get(0);
		if(l!=null){
			if(u.getPassword().equals(pwd)){
				return u;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
}

