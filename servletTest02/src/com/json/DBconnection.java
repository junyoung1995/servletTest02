package com.json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBconnection {
	private static final String driver = "org.mariadb.jdbc.Driver";
	private static final String url = "jdbc:mariadb://127.0.0.1:3306/";
	private static final String id = "root";
	private static final String pw = "0000";
	private static Connection connection;

	PreparedStatement pstmt = null;

	private static void connectDB() {

		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, id, pw);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			System.out.println(e.getMessage());
		}

	}
	public static void main(String[] args) {
		DBconnection test = new DBconnection();
		test.connectDB();
	}
}