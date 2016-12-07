package com.mercury.test;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test1 {
	public static void main(String[] args){
//		Configuration cfg = new Configuration().configure();
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		User user = new User("David", 78);	// user is transient
		session.save(user);					// user is persistent
		tx.commit();
		session.evict(user); 		// kick session out
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		for(User u: list){
			System.out.println(u);
		}
		HibernateUtil.closeSession();
	}
}
