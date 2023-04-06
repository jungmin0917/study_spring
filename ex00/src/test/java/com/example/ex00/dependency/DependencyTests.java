package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// ���� �׽�Ʈ�� �ϱ� ���� Ŭ����
// ������ ������Ѽ� �������� �ϴ� �� �ƴϰ�, Junit�̶�� ���� �׽�Ʈ ���α׷��� ������ �ָܼ� ���� ���̴�.

// �Ʒ� RunWith(���α׷���) ������̼��� ���� � �����׽�Ʈ ���α׷����� �����׽�Ʈ�� ���� ����
@RunWith(SpringJUnit4ClassRunner.class)

// �ش� �׽�Ʈ Ŭ�������� ����� ������ ���� ������ ��ġ ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

// �׽�Ʈ�� ����� �α��ؼ� ����ϱ� ���� �ʿ���
@Log4j
public class DependencyTests {
	@Autowired
	private Coding coding;
	
	@Test
	public void checkDependencyInjection() {
		log.info("--------------------"); // �α� ��� �޼ҵ��̴� log.info(����� ���� �� ���� ���ڿ�)
		log.info("coding : " + coding);
		log.info("computer : " + coding.getComputer());
		log.info("--------------------");
	}
}











