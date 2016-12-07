package com.mercury.db;
import java.sql.*;

import com.mercury.util.JdbcUtil;

import oracle.jdbc.OracleTypes;
public class OracleDemo03 {
	public static void main(String[] args){
		// remember 3 statements
		// frontUI -> backend Database
		try{
			Connection conn = JdbcUtil.getConnection();
			String spq = "{?=call saveuser(?, ?)}";
			CallableStatement cs = conn.prepareCall(spq);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, "Frank");
			cs.setInt(3, 47);
			cs.execute();
			System.out.println("Returned value: " + cs.getInt(1));
			String sp2 = "{?=call queryuser()}";
			cs = conn.prepareCall(sp2);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(1);
			while(rs.next()){
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age"));
			}
			rs.close();			
		} catch(Exception e){
			System.err.println(e);
		}
	}
}
