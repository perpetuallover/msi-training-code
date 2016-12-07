package com.mercury.test;

import org.hibernate.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test1A {
	public static void main(String[] args){
		Session session = HibernateUtil.currentSession();
		// user is in persistence status in session
		User user = (User)session.load(User.class, "Tommy");
		System.out.println(user);
		HibernateUtil.closeSession();
		//When session is closed, user is detached, but can be modified
		//user.setAge(36);
		user.setName("Scott");
		// Open a new session
		Session session2 = HibernateUtil.currentSession();
		session2.merge(user); // user is persistence in session2
		System.out.println("*****************************************");
		user = (User)session2.load(User.class, "Tommy");
		System.out.println(user);
		//If we make a transaction at this time, the table will be updated
		Transaction tx= session2.beginTransaction();
		user.setAge(42);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
