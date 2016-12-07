package com.mercury.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

import oracle.jdbc.internal.OracleTypes;

public class Test2A {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Session session = HibernateUtil.currentSession();	
		Query query = session.getNamedQuery("userSP");
		List<User> list = query.list();
		for(User u:list){
			System.out.println(u);
		}
		//should be able to write
		session.doWork(new Work(){
			@Override
			public void execute(Connection conn) throws SQLException{
				CallableStatement cs = conn.prepareCall("{?=call queryUser()}");
				cs.registerOutParameter(1, OracleTypes.CURSOR);
				cs.execute();
				ResultSet rs = (ResultSet)cs.getObject(1);
				while(rs.next()){
					System.out.println(rs.getString("Name") + "\t" + rs.getInt("Age"));
				}
			}
		});
		HibernateUtil.closeSession();
	}
}
