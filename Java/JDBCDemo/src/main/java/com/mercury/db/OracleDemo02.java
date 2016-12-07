package com.mercury.db;
import java.sql.*;
import java.util.Scanner;

import com.mercury.util.JdbcUtil;
public class OracleDemo02 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input name: ");
		String name = scanner.nextLine();
		try{
			//industry don't use statement
			Connection conn = JdbcUtil.getConnection();
			//String sql = "select * from sample where name='" + name + "'";
			String sql = "select * from sample where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			//Statement st = conn.createStatement();
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age"));
			}
		} catch(Exception e ){
			System.err.println(e);
		}
		scanner.close();
	}
	// SQL Injection Attack: abc' or '1' = 1
}
