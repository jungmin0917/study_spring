package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// 단위 테스트를 하기 위한 클래스
// 서버를 실행시켜서 서버에서 하는 게 아니고, Junit이라는 단위 테스트 프로그램을 돌려서 콘솔만 찍어내는 것이다.

// 아래 RunWith(프로그램명) 어노테이션을 통해 어떤 단위테스트 프로그램으로 단위테스트를 할지 선언
@RunWith(SpringJUnit4ClassRunner.class)

// 해당 테스트 클래스에서 사용할 스프링 설정 파일의 위치 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

// 테스트한 결과를 로깅해서 출력하기 위해 필요함
@Log4j
public class DependencyTests {
	@Autowired
	private Coding coding;
	
	@Test
	public void checkDependencyInjection() {
		log.info("--------------------"); // 로그 출력 메소드이다 log.info(출력할 변수 및 직접 문자열)
		log.info("coding : " + coding);
		log.info("computer : " + coding.getComputer());
		log.info("--------------------");
	}
}











