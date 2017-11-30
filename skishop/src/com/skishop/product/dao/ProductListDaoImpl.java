package com.skishop.product.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.Product;

@Repository
public class ProductListDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<Product> findAll(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product");
		return query.list();
	}
}
