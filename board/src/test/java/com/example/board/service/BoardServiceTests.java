package com.example.board.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardServiceTests {
	
	// BoardService 인터페이스를 주입받는 게 아니고, BeansGraph에 등록된 해당 인터페이스를 구현한 클래스가 주입된다.
	@Autowired
	private BoardService boardService;
	
	@Test
	public void serviceTest() {
		log.info(boardService);
	}
}
