package com.skishop.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.entity.Orders;
import com.skishop.entity.User;
import com.skishop.order.dao.PageOrderDaoImpl;
import com.skishop.user.dao.PageUserDaoImpl;

@Service
@Transactional(readOnly=true)
public class PageOrderServiceImpl {
	@Resource
	private PageOrderDaoImpl pageorderdaoImpl;
	public List<Orders> pageshow(int pageNum){
		return this.pageorderdaoImpl.selectOrderByPage(pageNum,3);
	}
	public Long pageCount(){
		return this.pageorderdaoImpl.findCountByPage();
	}
	public void editSign(int id){
		this.pageorderdaoImpl.editsign(id);
	}
	public void deleteOrder(int id){
		this.pageorderdaoImpl.deleteOrder(id);
	}
}
