package com.skishop.order.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skishop.entity.User;
import com.skishop.order.dao.AddressAddDaoImpl;

@Service
public class AddressAddServiceImpl {
	@Resource
	private AddressAddDaoImpl addressadddaoImpl;
	public User addAddress(int id,String address){
		return this.addressadddaoImpl.addAddress(id, address);
	}
}
