package com.skishop.user.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.skishop.entity.Orders;
import com.skishop.entity.Product;
import com.skishop.entity.User;

@Repository
public class PageUserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public void deleteUser(User u){
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(u);
	}
	public List<User> selectUserByPage(int pageNum,int pageSize){
		List<User> list=new ArrayList<User>();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User");
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	public Long findCountByPage(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("select count(id) from User");
		return (Long)query.uniqueResult();
	}
	public void deleteUser(int id){
		Session session=this.sessionFactory.getCurrentSession();
		User u = session.get(User.class, id);
		session.beginTransaction();
		session.delete(u);
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
}
