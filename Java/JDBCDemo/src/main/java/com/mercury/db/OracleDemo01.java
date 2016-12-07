package com.mercury.db;

import java.sql.*;

import com.mercury.util.JdbcUtil;

public class OracleDemo01 {

	
	public static void main(String[] args){
		try{
			//Class.forName(name).newInstance();
			Connection conn = JdbcUtil.getConnection();
			
			String sql = "insert into sample values('David', 55)";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			sql = "select * from sample";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age"));
			}
			rs.close();
		} catch(Exception e ){
			System.err.println(e);
		}
	}
}
