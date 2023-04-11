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
	
	// BoardService �������̽��� ���Թ޴� �� �ƴϰ�, BeansGraph�� ��ϵ� �ش� �������̽��� ������ Ŭ������ ���Եȴ�.
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
//		boardVO.setTitle("�� �� ����");
//		boardVO.setContent("�� �� ����");
//		boardVO.setWriter("�� �� �ۼ���");
//		
//		boardService.register(boardVO);
//		
//		log.info("������ �Խñ� ��ȣ : " + boardVO.getBno());
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
	
//	@Before // �� ������̼��� �޸� ���� ������ (@Test�� ���� ��)
//	public void modifyTest() {
//		BoardVO boardVO = boardService.get(7L);
//		
//		if(boardVO == null) {
//			log.info("NO BOARD");
//			return;
//		}
//		
//		boardVO.setTitle("�ٲ� ����");
//		boardVO.setContent("�ٲ� ����");
//		boardVO.setWriter("�ٲ� �ۼ���");
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









