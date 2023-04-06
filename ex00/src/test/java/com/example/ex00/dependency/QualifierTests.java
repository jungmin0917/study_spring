package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex00.dependency.qualifier.Computer;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class QualifierTests {
	
	@Autowired // 자동 주입
	@Qualifier("desktop")
	private Computer desktop; // 인터페이스 주입

	@Autowired // 자동 주입
	@Qualifier("laptop")
	private Computer laptop; // 인터페이스 주입
	
	// Primary에 의한 자동 주입
	@Autowired // 자동 주입
	private Computer computer; // 인터페이스 주입
	
	@Test
	public void testQualifier() {
		log.info("-----------------------");
		log.info("computer : " + desktop);
		log.info(desktop.getScreenWidth());
		log.info("-----------------------");

		log.info("-----------------------");
		log.info("computer : " + laptop);
		log.info(laptop.getScreenWidth());
		log.info("-----------------------");

		log.info("-----------------------");
		log.info("computer : " + computer);
		log.info(computer.getScreenWidth());
		log.info("-----------------------");
	}
}
