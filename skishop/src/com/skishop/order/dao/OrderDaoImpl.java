package com.skishop.order.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.Orders;
import com.skishop.entity.User;

@Repository
public class OrderDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public void addOrder(Orders o){
		Session session=this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(o);
		session.flush();
		session.clear();
		session.getTransaction().commit();
		
	}
	public List<Orders> selectOrder(int userid){
		String hql = "from Orders where userid=:userid";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userid", userid);
		return query.list();
		
	}
}
