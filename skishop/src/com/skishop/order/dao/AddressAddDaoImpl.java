package com.skishop.order.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.Orders;
import com.skishop.entity.User;

@Repository
public class AddressAddDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public User addAddress(int id,String address){
		Session session=this.sessionFactory.getCurrentSession();
		User u = session.get(User.class, id);
		u.setAddress(address);
		session.update(u);
		session.flush();
		return u;
	}
}
