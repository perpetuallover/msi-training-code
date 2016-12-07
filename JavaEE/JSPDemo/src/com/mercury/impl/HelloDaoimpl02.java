package com.mercury.impl;

import java.util.List;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.util.HibernateUtil;
import org.hibernate.*;
public class HelloDaoimpl02 implements HelloDao {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		String hql = "from User";
		return session.createQuery(hql).list();
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		User user = (User)session.get(User.class, name);
		return user;
	}

}
