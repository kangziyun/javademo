package com.skishop.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skishop.entity.CartItem;
import com.skishop.entity.Orders;
import com.skishop.entity.User;
import com.skishop.order.service.AddressAddServiceImpl;
import com.skishop.order.service.OrderServiceImpl;

@Controller
@RequestMapping("/submitorder")
public class SubmitOrderController {
	@Resource
	private OrderServiceImpl orderserviceImpl;
	@Resource
	private AddressAddServiceImpl addressserviceImpl;
	@RequestMapping("/add")
	public String add(@RequestParam("address") String address,HttpSession session){
		User u = (User) session.getAttribute("user");
		this.addressserviceImpl.addAddress(u.getId(), address);
		List<CartItem> l = (List) session.getAttribute("cartlist");
		for(CartItem ci:l){
			Orders o = new Orders();
			o.setProductid(ci.getProduct().getId());   
			o.setProductcount(ci.getCount());
			o.setUserid(u.getId());
			o.setAdmitsign(0);
			this.orderserviceImpl.addOrder(o);
		}
		
		return "success";
		}
}
