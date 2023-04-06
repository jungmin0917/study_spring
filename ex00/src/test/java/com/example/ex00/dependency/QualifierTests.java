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
	
	@Autowired // �ڵ� ����
	@Qualifier("desktop")
	private Computer desktop; // �������̽� ����

	@Autowired // �ڵ� ����
	@Qualifier("laptop")
	private Computer laptop; // �������̽� ����
	
	// Primary�� ���� �ڵ� ����
	@Autowired // �ڵ� ����
	private Computer computer; // �������̽� ����
	
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
