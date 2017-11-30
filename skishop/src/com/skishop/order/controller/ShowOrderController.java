package com.skishop.order.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skishop.order.service.OrderServiceImpl;

@Controller
@RequestMapping("/submitorder")
public class ShowOrderController {
	@Resource
	private OrderServiceImpl orderserviceImpl;
	@RequestMapping
	
}
