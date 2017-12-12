package com.skishop.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.User;

@Repository
public class RegistUserDaoImpl{

	@Resource
	private SessionFactory sessionFactory;
	
	public void addUser(User u)throws Exception{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(u);
		session.flush();   
		
	}
	public List<String> findAllNames(){
		String hql = "select name from User ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
}
