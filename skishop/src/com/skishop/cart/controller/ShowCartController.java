package com.skishop.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skishop.cart.service.Cart;
import com.skishop.entity.CartItem;

@Controller
@RequestMapping("/showcart")
public class ShowCartController {
	@RequestMapping("/show")
	public String showCart(HttpSession session,HttpServletRequest request){
		int sum=0;
		int count=0;
		List<CartItem> cartlist = new ArrayList();
		Cart c = (Cart) session.getAttribute("cart");
		System.out.println(c);
		if (c==null) {
			return "checkout2";
		}else{
			Iterator i=c.container.values().iterator();
			while(i.hasNext()){
				CartItem ci = new CartItem();
				ci=(CartItem)i.next();
				sum = sum + ci.getCount()*ci.getProduct().getDiscountprice();
				cartlist.add(ci);
				count++;
			}
			if(count==0){
				return "checkout2";
			}else{
			session.setAttribute("cartlist", cartlist);
			session.setAttribute("count", count);
			session.setAttribute("sum", sum);
			return "checkout";
			}
			}
	}
	@RequestMapping("/delete")
	public void  deleteItem(@RequestParam("productId")String productid,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		Cart c = (Cart)session.getAttribute("cart");
		c.deleteCart(Integer.parseInt(productid));
		try {
			request.getRequestDispatcher("/showcart/show").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/edit")
	public void  editItem(@RequestParam("productId")String productid,@RequestParam("count")String count,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		Cart c = (Cart)session.getAttribute("cart");
		c.editCart(Integer.parseInt(productid),Integer.parseInt(count));
		try {
			request.getRequestDispatcher("/showcart/show").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/clear")
	public void  clearCart(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		Cart c = (Cart)session.getAttribute("cart");
		c.clearCart();
		try {
			request.getRequestDispatcher("/showcart/show").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
