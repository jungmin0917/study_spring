package com.example.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

// 서버를 실행하는 것이 아니고 따로 JUnit 쪽에서 돌아가기 때문에 ContextConfiguration이 필요
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTests {

	@Autowired // BoardMapper 인터페이스 주입
	private BoardMapper boardMapper;
	
	// BoardMapper.getList()를 사용했을 때 해당 테이블 레코드가 리스트로 나오면 성공

//	@Test
//	public void getListTest() {
//		boardMapper.getList().forEach(log::info);
//	}
	
	@Test
	public void insertTest() {
		BoardVO board = new BoardVO();
		
		board.setTitle("새로 작성한 글 제목3");
		board.setContent("새로 작성한 글 내용3");
		board.setWriter("user03");
		
		boardMapper.insert(board);
		
		log.info(board);
	}
}











