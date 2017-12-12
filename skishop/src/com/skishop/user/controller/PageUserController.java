package com.skishop.user.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skishop.entity.Page;
import com.skishop.entity.Product;
import com.skishop.entity.User;
import com.skishop.user.service.PageUserServiceImpl;

@Controller
@RequestMapping("/pageuser")
public class PageUserController {
	@Resource
	private PageUserServiceImpl pageuserserviceImpl;
	@RequestMapping("/show")
	public String showUser(HttpServletRequest request){
		String pagenum=request.getParameter("pageNum");
		int num = 0;
		if(pagenum == null || pagenum.equals("")){
			num = 1;
		}else{
			num = Integer.parseInt(pagenum);
		}
		List<User> list = this.pageuserserviceImpl.pageshow(num);
		Long count = this.pageuserserviceImpl.pageCount();
		Page<User> p = new Page<User>(num,3);
		p.setList(list);
		p.setTotalCount(count);
		request.setAttribute("page", p);
		return "userlist";
	}
	@RequestMapping("/delete")
	public void DeleteUser(@RequestParam("id") int id,HttpServletRequest request,HttpServletResponse response){
		this.pageuserserviceImpl.deleteUser(id);
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
