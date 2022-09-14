package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static { 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace(); 
		} 
	}
	 
	//Class.forName 을 높은 버전에선 안해도 작동한다. 낮은버전에선 적어주어야한다
	
	@Test
	public void testConnection(){
		try {
			String url="jdbc:oracle:thin:@localhost:1521:iot";
			String id="book_ex";
			String pw="book_ex";
			Connection con = DriverManager.getConnection(url,id,pw);
			
			log.info(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

}

