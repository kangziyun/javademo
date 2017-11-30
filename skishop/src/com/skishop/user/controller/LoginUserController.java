package com.skishop.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skishop.entity.User;
import com.skishop.user.service.LoginUserServiceImpl;

@Controller
@RequestMapping("/loginindex")
public class LoginUserController {
	
	@Resource
	private LoginUserServiceImpl loginuserserviceImpl;
	
	@RequestMapping("/loginuser")
	public String login(@RequestParam("username") String username,
	@RequestParam("password") String password,
	Model model,HttpSession session){
		User u=this.loginuserserviceImpl.login(username, password);
		if(u!=null){
			session.setAttribute("user",u);
			System.out.println("密码正确");
			return "index";
		}else{
			System.out.println("密码错误");
			model.addAttribute("errorinfo", "您的账号或密码不正确！");
			return "login";
			
		}
	}
	
}
