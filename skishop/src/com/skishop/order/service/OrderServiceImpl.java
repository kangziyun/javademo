package com.skishop.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.entity.Orders;
import com.skishop.order.dao.OrderDaoImpl;

@Service
@Transactional(readOnly=true)
public class OrderServiceImpl {
	@Resource
	private OrderDaoImpl orderdaoImpl;
	public void addOrder(Orders o){
		this.orderdaoImpl.addOrder(o);
	}
	public List<Orders> showOrder(int userid){
		return this.orderdaoImpl.selectOrder(userid);
	}
}
