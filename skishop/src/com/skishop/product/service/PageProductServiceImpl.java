package com.skishop.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skishop.entity.Product;
import com.skishop.entity.ProductType;
import com.skishop.product.dao.PageProductDaoImpl;

@Service
@Transactional(readOnly=true)
public class PageProductServiceImpl {
	@Resource
	private PageProductDaoImpl pageproductdaoImpl;
	public List<Product> pageshow(int pageNum){
		return this.pageproductdaoImpl.selectProductByPage(pageNum,3);
	}
	public Long pageCount(){
		return this.pageproductdaoImpl.findCountByPage();
	}
	public void deleteProduct(int id){
		this.pageproductdaoImpl.deleteProduct(id);
	}
	public List<ProductType> findAllType(){
		return this.pageproductdaoImpl.selectAll();
	}
	public void addProduct(Product p){
		this.pageproductdaoImpl.addProduct(p);
	}
	public Product findById(int id){
		return this.pageproductdaoImpl.selectById(id);
	}
	public void edit(Product p){
		this.pageproductdaoImpl.updateById(p);
	}
}
