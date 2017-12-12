package com.skishop.user.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.User;

@Repository
public class ImproveUserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public void updateUser(int id,String password,String address){
		Session session = this.sessionFactory.getCurrentSession();
		User u = session.get(User.class, id);
		u.setPassword(password);
		u.setAddress(address);
		session.beginTransaction();
		session.update(u);
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
}
