package com.skishop.product.dao;

import java.util.ArrayList;
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
	public List<Product> findHotProduct(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product where hotproduct=1");
		return query.list();
	}
	public List<Product> findNewProduct(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product where newproduct=1");
		return query.list();
	}
	public List<Product> findById(int id){
		List<Product> l = new ArrayList();
		Product p = this.sessionFactory.getCurrentSession().get(Product.class, id);
		l.add(p);
		return l;
	}
	public List<Product> findByTypeId(int typeid){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product where producttypeid=:typeid");
		query.setParameter("typeid", typeid);
		return query.list();
	}
}

