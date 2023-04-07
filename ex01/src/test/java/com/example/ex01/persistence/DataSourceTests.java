package com.example.ex01.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class DataSourceTests {
	@Autowired // DataSource 객체를 사용할 건데, 우리가 root-context.xml에서 DataSource 필드에 대해 미리 설정을 해놨다. 그래서 우리가 root-context.xml에 설정했던 생성자로 자동 주입이 될 것이다.
	private DataSource dataSource;
	
	@Test
	public void testConnecton() {
		try(Connection connection = dataSource.getConnection()){
			log.info(connection);
		}catch(Exception e) {
			fail(e.getMessage());			
		}
	}


}
