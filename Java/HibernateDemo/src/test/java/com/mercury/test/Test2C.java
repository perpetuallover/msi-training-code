package com.mercury.test;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

abstract class Test2C {
	public static void main(String[] args){
		Session session = HibernateUtil.currentSession();
		Criteria ct = session.createCriteria(User.class);
		User user = (User)ct.add(Restrictions.eq("name", "Tommy"))
				.add(Restrictions.gt("age", 30)).uniqueResult();
		System.out.println(user);
		HibernateUtil.closeSession();
	}
}
