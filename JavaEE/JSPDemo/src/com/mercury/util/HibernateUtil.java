package com.mercury.util;

import org.hibernate.*;
import org.hibernate.cfg.*;
//published in 2011
//improve performance of hibernate(tunning)
//1. session management thread local
//2. Hibernate catching
public class HibernateUtil {
	private static final SessionFactory FACTORY;//all capital letter means constant
	// initialize final, static variable, singleton?
	static{
		try{
			FACTORY = new Configuration().configure().buildSessionFactory();
		} catch(Exception e){
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	private static final ThreadLocal<Session> SESSION = new ThreadLocal<Session>(){
		@Override
		protected Session initialValue(){
			return FACTORY.openSession();
		}
	};
	//1. synchronize hairachy
	//2. threadlocal: shallow copy of shared resource
	public static SessionFactory getSessionFactory(){
		return FACTORY;
	}
	public static Session currentSession() throws HibernateException{
		Session s = SESSION.get();
		if(s == null){
			s = FACTORY.openSession();
			SESSION.set(s);
		}
		return s;
	}
	public static void closeSession() throws HibernateException{
		Session s = SESSION.get();
		SESSION.set(null); // in garbage collection, because reference is null
		if (s!=null) s.close();
	}
	
}
