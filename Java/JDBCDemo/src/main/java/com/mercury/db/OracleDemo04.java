package com.mercury.db;
import java.sql.*;

import com.mercury.util.JdbcUtil;
public class OracleDemo04 {
	public static void main(String[] args){
		try{
			Connection conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			String sql1 = "update sample set age=age+1 where name = 'Tracy'";
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.execute();
			String sql2 = "update sample set age=age+1 where name = 'Alice'";
			ps = conn.prepareStatement(sql2);
			ps.execute();
			conn.commit();
			ps.close();
		} catch(Exception e){
			System.err.println(e);
		}
		//mongodb weakness: do not support transaction
	}
}
