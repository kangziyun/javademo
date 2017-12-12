package com.skishop.product.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skishop.entity.Product;
import com.skishop.product.service.ProductListServiceImpl;

@Controller
@RequestMapping("/kindproduct")
public class ProductKindSelectController {
	@Resource
	private ProductListServiceImpl productlistserviceImpl;
	@RequestMapping("/list")
	public String list(HttpSession session,@RequestParam("choosetype") int choosetype,@RequestParam("selectoption") int selectoption){
		List<Product> l = this.productlistserviceImpl.ListDifferentType(choosetype, selectoption);
		session.setAttribute("products", l);
		return "shop";
	}
}
