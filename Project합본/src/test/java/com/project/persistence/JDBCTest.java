package com.project.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/PROJECT?serverTimezone=Asia/Seoul",
				"admin",
				"admin1234")){
			System.out.println(con);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
