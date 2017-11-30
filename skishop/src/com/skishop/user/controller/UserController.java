package com.skishop.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skishop.entity.User;
import com.skishop.user.service.RegistUserServiceImpl;

@Controller
@RequestMapping("/registuser")
public class UserController {
	
	@Resource
	private RegistUserServiceImpl RegistUserServiceImpl;
	
	@RequestMapping("/regist")
	public String regist(@RequestParam("username") String name,
			@RequestParam("password") String password,@RequestParam("mailaddress") String mailaddress,
			Model model, HttpSession session){
		User u = new User();
		u.setName(name);
		u.setPassword(password);
		u.setMailaddress(mailaddress);
		this.RegistUserServiceImpl.regist(u);

		return "redirect:/login.jsp";

	}
	@RequestMapping("/checkname")
	public void checkName(@RequestParam String un,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		String result = this.RegistUserServiceImpl.checkName(un);
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
