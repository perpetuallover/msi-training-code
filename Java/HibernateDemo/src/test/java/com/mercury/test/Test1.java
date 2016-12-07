package com.mercury.test;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;
public class Test1 {
	public static void main(String[] args){
//		Configuration cfg = new Configuration().configure(/**/);
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		User user = new User("Tommy",58); // user is transient
		//first reaction go to table and check
		session.save(user);	//user is persistent
		tx.commit();
		session.evict(user); //detached
		String hq1 = "from User";
		Query query = session.createQuery(hq1);
		List<User> list = query.list();
		for(User u : list){
			System.out.println(u);	
			System.out.println("user==u ? " + (user == u));
		}
		//tx.commit();
		//in hibernate all write process must in transaction and use commit to execute
		session.close();
	}
}
