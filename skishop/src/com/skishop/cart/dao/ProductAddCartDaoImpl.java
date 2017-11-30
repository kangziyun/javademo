package com.skishop.cart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.Product;

@Repository
public class ProductAddCartDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public Product findById(int id){
		return (Product)this.sessionFactory.getCurrentSession().get(Product.class, id);
	}
}
