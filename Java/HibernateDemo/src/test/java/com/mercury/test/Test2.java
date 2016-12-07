package com.mercury.test;

import java.util.List;

import org.hibernate.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Session session = HibernateUtil.currentSession();
		//How to call native SQL?
		// First way: define a sql-query block in the mapping file, better way separate the logic
		// then call getNamedQuery method
		Query query = session.getNamedQuery("userQuery");
		query.setInteger("age", 30);
		List<User> list = query.list();
		for(User u:list){
			System.out.println(u);
		}
		// Second way: call createSQLQuery method directly
		Query query2 = session.createSQLQuery("select * from Sample where Name = :name")
				.addEntity(User.class);
		query2.setString("name", "Tracy");
		User user = (User)query2.uniqueResult();
		System.out.println(user);
		HibernateUtil.closeSession();
	}
}
