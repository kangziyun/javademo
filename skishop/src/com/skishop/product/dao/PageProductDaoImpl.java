package com.skishop.product.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.Orders;
import com.skishop.entity.Product;
import com.skishop.entity.ProductType;
import com.skishop.entity.User;



@Repository
public class PageProductDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<Product> selectProductByPage(int pageNum,int pageSize){
		List<Product> list=new ArrayList<Product>();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product");
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	public Long findCountByPage(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("select count(id) from Product");
		return (Long)query.uniqueResult();
	}
	public void deleteProduct(int id){
		Session session=this.sessionFactory.getCurrentSession();
		Product p = session.get(Product.class, id);
		session.beginTransaction();
		session.delete(p);
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
	public List<ProductType> selectAll(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from ProductType");
		return query.list();
	}
	public void addProduct(Product p){
		Session session=this.sessionFactory.getCurrentSession();
		session.save(p);
		session.flush();
		session.clear();
	}
	public Product selectById(int id){
		Product p = (Product) this.sessionFactory.getCurrentSession().get(Product.class, id);
		return p;
	}
	public void updateById(Product p){
		Session session=this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(p);
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
}
