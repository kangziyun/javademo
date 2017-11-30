package com.skishop.order.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skishop.order.dao.AddressAddDaoImpl;

@Service
public class AddressAddServiceImpl {
	@Resource
	private AddressAddDaoImpl addressadddaoImpl;
	public void addAddress(int id,String address){
		this.addressadddaoImpl.addAddress(id, address);
	}
}
