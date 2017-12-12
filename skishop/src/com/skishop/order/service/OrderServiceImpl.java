package com.skishop.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.entity.Orders;
import com.skishop.order.dao.OrderDaoImpl;

@Service
public class OrderServiceImpl {
	@Resource
	private OrderDaoImpl orderdaoImpl;
	public void addOrder(Orders o){
		this.orderdaoImpl.addOrder(o);
	}
	public List<Orders> showEditOrder(int userid){
		return this.orderdaoImpl.selectEditOrder(userid);
	}
	public List<Orders> showUneditOrder(int userid){
		return this.orderdaoImpl.selectUneditOrder(userid);
	}
	public void deleteOrder(int id){
		this.orderdaoImpl.deleteOrder(id);
	}
}
