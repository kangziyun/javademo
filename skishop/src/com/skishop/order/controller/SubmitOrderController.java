package com.skishop.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public void add(@RequestParam("address") String address,HttpSession session,HttpServletRequest request,HttpServletResponse repsonse){
		User u = (User) session.getAttribute("user");
		User user = (User) this.addressserviceImpl.addAddress(u.getId(), address);
		session.setAttribute("user", user);
		List<CartItem> l = (List) session.getAttribute("cartlist");
		for(CartItem ci:l){
			Orders o = new Orders();
			o.setProductid(ci.getProduct().getId());   
			o.setProductname(ci.getProduct().getName());
			o.setProductcount(ci.getCount());
			o.setUserid(u.getId());
			o.setAdmitsign(0);
			o.setDeletesign(0);
			this.orderserviceImpl.addOrder(o);
			
		}
		
		try {
			request.getRequestDispatcher("/showorder/show").forward(request, repsonse);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
