package com.motelmanager.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "motel";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url + dbName,
					userName, password);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
