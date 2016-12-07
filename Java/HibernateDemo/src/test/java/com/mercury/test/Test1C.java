package com.mercury.test;

import java.util.List;

import org.hibernate.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test1C {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Session session = HibernateUtil.currentSession();
		String hq1 = "from User";
		Query query = session.createQuery(hq1);
		query.setCacheable(true);
		List<User> list = query.list();
		for(User u : list){
			System.out.println(u);
		}
		//When we run query.list() again, it will not run any query.
//		try{
//			Thread.sleep(6000); // Delay 6 seconds to make cache expire
//		} catch (Exception e){
//			e.printStackTrace();
//		}
		List<User> list2 = query.list();
		for(User u : list2){
			System.out.println(u);
		}
		HibernateUtil.closeSession();
	}
}
