package com.json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JsonDAO {
	private static final String driver = "org.mariadb.jdbc.Driver";
	private static final String url = "jdbc:mariadb://127.0.0.1:3306/";
	private static final String id = "root";
	private static final String pw = "0000";
	private static Connection conn;
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Connection 생성 성공");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
