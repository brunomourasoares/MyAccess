package com.myaccess.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	private Connection conn;
	
	private String driver =  "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/myaccess_db";
	private String user = "root";
	private String password = "123456";
	
	public Connection connect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}