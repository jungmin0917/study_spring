package com.example.board.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardServiceTests {
	
	// BoardService 인터페이스를 주입받는 게 아니고, BeansGraph에 등록된 해당 인터페이스를 구현한 클래스가 주입된다.
	@Autowired
	private BoardService boardService;
	
//	@Test
//	public void serviceTest() {
//		log.info(boardService);
//	}
//	
//	@Test
//	public void registerTest() {
//		BoardVO boardVO = new BoardVO();
//		
//		boardVO.setTitle("새 글 제목");
//		boardVO.setContent("새 글 내용");
//		boardVO.setWriter("새 글 작성자");
//		
//		boardService.register(boardVO);
//		
//		log.info("생성된 게시글 번호 : " + boardVO.getBno());
//	}
	
//	@Test
//	public void getTest() {
//		BoardVO boardVO = boardService.get(11L);
//		
//		if(boardVO != null) {
//			log.info(boardVO);
//			return;
//		}
//		
//		log.info("NO BOARD");
//	}
	
//	@Before // 이 어노테이션을 달면 먼저 시작함 (@Test는 빼야 함)
//	public void modifyTest() {
//		BoardVO boardVO = boardService.get(7L);
//		
//		if(boardVO == null) {
//			log.info("NO BOARD");
//			return;
//		}
//		
//		boardVO.setTitle("바뀐 제목");
//		boardVO.setContent("바뀐 내용");
//		boardVO.setWriter("바뀐 작성자");
//		
//		if(boardService.modify(boardVO)) {
//			log.info("UPDATE SUCCESS");
//			return;
//		}
//		
//		log.info("UPDATE FAILURE");
//		
//	}
	
//	@Test
//	public void removeTest() {
//		Long bno = 11L;
//		
//		BoardVO boardVO = boardService.get(bno);
//		
//		if(boardVO == null) {
//			log.info("NO BOARD");
//			return;
//		}
//		
//		if(boardService.remove(bno)) {
//			log.info("DELETE SUCCESS");
//			return;
//		}
//		
//		log.info("DELETE FAILURE");
//	}
	
	@Test
	public void getListTest() {
		boardService.getList().forEach(log::info);
	}
	
}









