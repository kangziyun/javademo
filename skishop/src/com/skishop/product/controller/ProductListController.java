package com.skishop.product.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skishop.entity.Product;
import com.skishop.product.service.ProductListServiceImpl;

@Controller
@RequestMapping("/listproduct")
public class ProductListController  {
	
	@Resource
	private ProductListServiceImpl productlistserviceImpl;
	@RequestMapping("/list")
	public String list(HttpSession session){
		List<Product> l = this.productlistserviceImpl.list();
		session.setAttribute("products", l);
		return "shop";
	}
}
