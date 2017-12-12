package com.skishop.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loginadmin")
public class LoginAdminController {
	@RequestMapping("/login")
	public String login(@RequestParam("admin") String name,@RequestParam("password")String password,HttpServletRequest request){
		if(name.equals("admin")&&password.equals("123")){
			return "/main";
		}else{
			request.setAttribute("errorInfo", "密码错误请重新输入");
			return "admin";
		}
		
	}
}
