package com.example.ex01.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// 단위 테스트 페이지

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class JDBCTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		// Connection 객체 가져오기
		// Connection 객체를 열었으면 다시 close()로 닫아야 한다
		// 근데 여기서 try-with-resources 문법을 써볼 것이다.
		
		// try() 소괄호 안에 열 리소스를 전부 적는다
		try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")){
			log.info(connection);
		}catch(Exception e){
			fail(e.getMessage()); // junit의 메소드로, 만약 Exception이 발생해서 여기에 들어오면, 무조건 실패로 처리를 한 후 실행 중지시킴. (강제종료)
		}
	}
}
