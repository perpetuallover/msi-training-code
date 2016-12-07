package com.mercury.test;

import org.hibernate.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test2B {
	public static void main(String[] args){
		try{
			Session session = HibernateUtil.currentSession();
			// Compare load and get method
			// load need primary key
			User user1 = (User)session.load(User.class, "Tracy");
			// user1 is a proxy(like agency) object, but it is not null.
			System.out.println("user1==null?" + (user1==null));
			System.out.println("***** This line is displayed before query *****");
			System.out.println(user1); // This line will trigger the query
			User user2 = (User)session.get(User.class, "Tommy");
			System.out.println("***** This line is displayed after query *****");
			System.out.println(user2);
			// If an Object does not exist, they have different outputs
			// get method returns null
			User user3 = (User)session.load(User.class, "abcd");
			// load method throws a runtime exception
			User user4 = (User)session.get(User.class, "abcd");
			System.out.println(user4);		
		} finally{
			HibernateUtil.closeSession();
		}
	}
}
