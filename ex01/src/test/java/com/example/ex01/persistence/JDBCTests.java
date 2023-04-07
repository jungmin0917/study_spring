package com.example.ex01.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// ���� �׽�Ʈ ������

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
		// Connection ��ü ��������
		// Connection ��ü�� �������� �ٽ� close()�� �ݾƾ� �Ѵ�
		// �ٵ� ���⼭ try-with-resources ������ �Ẽ ���̴�.
		
		// try() �Ұ�ȣ �ȿ� �� ���ҽ��� ���� ���´�
		try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")){
			log.info(connection);
		}catch(Exception e){
			fail(e.getMessage()); // junit�� �޼ҵ��, ���� Exception�� �߻��ؼ� ���⿡ ������, ������ ���з� ó���� �� �� ���� ������Ŵ. (��������)
		}
	}
}
