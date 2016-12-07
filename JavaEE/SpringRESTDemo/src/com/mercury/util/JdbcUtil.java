package com.mercury.util;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
//	private static final String  DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private static final String  URL = "jdbc:oracle:thin:@LAPTOP-FGSR7FAT:1521:XE";
//	private static final String  USERNAME = "user1";
//	private static final String  PASSWORD = "user1";
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			//database connection pool
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
