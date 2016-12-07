package com.mercury.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;

public class HelloDaoBean01 extends HibernateDaoSupport implements HelloDao {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		return (List<User>) this.getHibernateTemplate().find("from User");
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}

}
