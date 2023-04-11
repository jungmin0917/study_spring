package com.example.board.domain.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardDAOTests {
	
	@Autowired
	BoardDAO boardDAO;
	
//	@Test
//	public void daoTest() {
//		log.info(boardDAO);
//	}
	
//	@Test
//	public void registerTest() {
//		
//		BoardVO boardVO = new BoardVO();
//		
//		boardVO.setTitle("게시글 제목");
//		boardVO.setContent("게시글 내용");
//		boardVO.setWriter("jungmin0917");
//		
//		boardDAO.register(boardVO);
//	}
	
//	@Test
//	public void getTest() {
//		Long bno = 10L;
//		
//		BoardVO boardVO = boardDAO.get(bno);
//		
//		if(boardVO == null) {
//			log.info("NO BOARD");
//			return;
//		}
//		
//		log.info(boardVO);
//	}
	
//	@Test
//	public void modifyTest() {
//		Long bno = 10L;
//		
//		BoardVO boardVO = boardDAO.get(bno);
//		
//		if(boardVO == null) {
//			log.info("NO BOARD");
//			return;
//		}
//		
//		boardVO.setTitle("수정된 제목");
//		boardVO.setContent("수정된 내용");
//		boardVO.setWriter("수정된 게시자");
//		
//		if(boardDAO.modify(boardVO)) {
//			log.info("UPDATE SUCCESS");
//			return;
//		}
//		
//		log.info("UPDATE FAILURE");
//	}
	
//	@Test
//	public void removeTest() {
//		Long bno = 10L;
//
//		if(boardDAO.remove(bno)) {
//			log.info("SUCCESS");
//			return;
//		}
//		
//		log.info("DELETE FAILURE");
//	}
	
	@Test
	public void getListTest() {
		boardDAO.getList(new Criteria()).forEach(log::info);
	}
}











