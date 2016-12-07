package com.mercury.util;
import java.sql.*;
public class JdbcUtil {
	private static final String  DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String  URL = "jdbc:oracle:thin:@LAPTOP-FGSR7FAT:1521:XE";
	private static final String  USERNAME = "user1";
	private static final String  PASSWORD = "user1";
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName(DRIVER); // load the class in to memory
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(Exception e){
			System.err.println(e);
		}
		return conn;
	}
}
