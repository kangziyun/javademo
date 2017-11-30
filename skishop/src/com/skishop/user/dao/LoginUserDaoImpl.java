package com.skishop.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.User;

@Repository
public class LoginUserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public List<User> findByUsername(String nameoremail){
		String hql ="from User where name=:name or mailaddress=:mail";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", nameoremail);
		query.setParameter("mail", nameoremail);
		return query.list();
	}
}
