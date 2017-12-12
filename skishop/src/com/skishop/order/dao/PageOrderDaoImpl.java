package com.skishop.order.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.Orders;
import com.skishop.entity.User;

@Repository
public class PageOrderDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<Orders> selectOrderByPage(int pageNum,int pageSize){
		List<Orders> list=new ArrayList<Orders>();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Orders");
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	public Long findCountByPage(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("select count(id) from Orders");
		return (Long)query.uniqueResult();
	}
	public void editsign(int id){
		Session session=this.sessionFactory.getCurrentSession();
		Orders orders = session.get(Orders.class, id);
		session.beginTransaction();
		orders.setAdmitsign(1);
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
	public void deleteOrder(int id){
		Session session=this.sessionFactory.getCurrentSession();
		Orders orders = session.get(Orders.class, id);
		session.beginTransaction();
		session.delete(orders);
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
}
