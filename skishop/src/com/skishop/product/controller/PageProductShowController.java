package com.skishop.product.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skishop.entity.Page;
import com.skishop.entity.Product;
import com.skishop.product.service.PageProductServiceImpl;

@Controller
@RequestMapping("/pageproduct")
public class PageProductShowController {
	@Resource
	private PageProductServiceImpl pageproductserviceImpl;
	@RequestMapping("/show")
	public String showProduct(HttpServletRequest request){
		String pagenum=request.getParameter("pageNum");
		int num = 0;
		if(pagenum == null || pagenum.equals("")){
			num = 1;
		}else{
			num = Integer.parseInt(pagenum);
		}
		List list = this.pageproductserviceImpl.pageshow(num);
		Long count = this.pageproductserviceImpl.pageCount();
		Page<Product> p = new Page<Product>(num,3);
		p.setList(list);
		p.setTotalCount(count);
		request.setAttribute("page", p);
		return "productlist";
	}
	@RequestMapping("/delete")
	public void deleteOrder(@RequestParam("productid") int id,HttpServletRequest request,HttpServletResponse response){
		this.pageproductserviceImpl.deleteProduct(id);
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
	@RequestMapping("/findtypes")
	public String findTypes(HttpServletRequest request){
		List l = this.pageproductserviceImpl.findAllType();
		request.setAttribute("pts", l);
		return "form";
	}
	@RequestMapping("/add")
	public void addProduct(@RequestParam("pname")String pname,@RequestParam("pdescription")String pdescription,@RequestParam("price")int price,@RequestParam("dispricecount")int dispricecount,@RequestParam("hotps")int hotps,@RequestParam("newps")int newps,@RequestParam("pt")int pt,HttpServletRequest request,HttpServletResponse response){
		Product p = new Product();
		p.setName(pname);
		p.setDescription(pdescription);
		p.setPrice(price);
		p.setDiscountprice(dispricecount);
		p.setHotproduct(hotps);
		p.setNewproduct(newps);
		p.setProducttypeid(pt);
		this.pageproductserviceImpl.addProduct(p);
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
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String editProduct(@RequestParam("productid")int id,HttpServletRequest request){
		Product p = this.pageproductserviceImpl.findById(id);
		List l = this.pageproductserviceImpl.findAllType();
		request.setAttribute("pts", l);
		request.setAttribute("pro", p);
		return "editform";
		
	}
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public void edit(@RequestParam("productid")int id,@RequestParam("pname")String pname,@RequestParam("pdescription")String pdescription,@RequestParam("price")int price,@RequestParam("dispricecount")int dispricecount,@RequestParam("hotps")int hotps,@RequestParam("newps")int newps,@RequestParam("pt")int pt,HttpServletRequest request,HttpServletResponse response){
		Product p = this.pageproductserviceImpl.findById(id);
		p.setName(pname);
		p.setDescription(pdescription);
		p.setPrice(price);
		p.setDiscountprice(dispricecount);
		p.setHotproduct(hotps);
		p.setNewproduct(newps);
		p.setProducttypeid(pt);
		this.pageproductserviceImpl.edit(p);
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
