package com.skishop.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.entity.Product;
import com.skishop.product.dao.ProductListDaoImpl;

@Service
@Transactional(readOnly=true)
public class ProductListServiceImpl {
	@Resource
	private ProductListDaoImpl productlistDaoImpl;
	public  List<Product> list(){
		return this.productlistDaoImpl.findAll();
	}
}
