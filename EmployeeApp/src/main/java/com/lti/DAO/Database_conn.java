package com.lti.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_conn {

	public static Connection getConn() throws SQLException{
		String url = "jdbc:oracle:thin:@DESKTOP-GIUOJQT:1521:XE";
		String un = "system";
		String pw = "pranav";
		
		Connection conn = DriverManager.getConnection(url,un,pw);
		
	//	System.out.println("Connection Estabilished");
		
		if(conn!=null) {
			System.out.println("Connected");
		}
		
		//DESKTOP-GIUOJQT
		
		return conn;
		
	}
	
	
	public static void main(String[] args) throws SQLException {
		getConn();
	}
}
