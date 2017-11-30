package com.skishop.cart.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.cart.dao.ProductAddCartDaoImpl;
import com.skishop.entity.Product;

@Service
@Transactional(readOnly=true)
public class ProductAddCartServiceImpl {
	@Resource
	private ProductAddCartDaoImpl productaddcartdaoImpl;
	public Cart add(int id,Cart c){
		Product p = this.productaddcartdaoImpl.findById(id);
		if(c==null){
			c = new Cart();
		}
		c.addCart(p);
		return c;
	}
}
