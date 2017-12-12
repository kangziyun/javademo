package com.skishop.order.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skishop.entity.Orders;
import com.skishop.entity.Page;
import com.skishop.order.service.PageOrderServiceImpl;

@Controller
@RequestMapping("/pageorder")
public class PageOrderController {
	@Resource
	private PageOrderServiceImpl pageorderserviceImpl;
	@RequestMapping("/show")
	public String showOrder(HttpServletRequest request){
		String pagenum=request.getParameter("pageNum");
		int num = 0;
		if(pagenum == null || pagenum.equals("")){
			num = 1;
		}else{
			num = Integer.parseInt(pagenum);
		}
		List<Orders> list = this.pageorderserviceImpl.pageshow(num);
		Long count = this.pageorderserviceImpl.pageCount();
		Page<Orders> p = new Page<Orders>(num,3);
		p.setList(list);
		p.setTotalCount(count);
		request.setAttribute("page", p);
		return "orderlist";
	}
	@RequestMapping("/edit")
	public void editOrder(@RequestParam("orderid") int id,HttpServletRequest request,HttpServletResponse response){
		this.pageorderserviceImpl.editSign(id);
		try {
			request.getRequestDispatcher("show").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/delete")
	public void deleteOrder(@RequestParam("orderid") int id,HttpServletRequest request,HttpServletResponse response){
		this.pageorderserviceImpl.deleteOrder(id);
		try {
			request.getRequestDispatcher("show").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
