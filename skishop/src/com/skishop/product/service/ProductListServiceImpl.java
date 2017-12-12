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
	public List<Product> ListDifferentType(int choosetype,int selectoption){
		if(choosetype==1){
			return this.productlistDaoImpl.findHotProduct();
		}
		if(choosetype==2){
			return this.productlistDaoImpl.findNewProduct();
		}
		if(choosetype==4){
			return this.productlistDaoImpl.findById(selectoption);
		}
		if(choosetype==3){
			return this.productlistDaoImpl.findByTypeId(selectoption);
		}
		else{
			return null;
		}
	}
}
