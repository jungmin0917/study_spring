package com.example.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

// ������ �����ϴ� ���� �ƴϰ� ���� JUnit �ʿ��� ���ư��� ������ ContextConfiguration�� �ʿ�
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTests {

	@Autowired // BoardMapper �������̽� ����
	private BoardMapper boardMapper;
	
	// BoardMapper.getList()�� ������� �� �ش� ���̺� ���ڵ尡 ����Ʈ�� ������ ����

//	@Test
//	public void getListTest() {
//		boardMapper.getList().forEach(log::info);
//	}
	
//	@Test
//	public void insertTest() {
//		BoardVO board = new BoardVO();
//		
//		board.setTitle("���� �ۼ��� �� ����5");
//		board.setContent("���� �ۼ��� �� ����5");
//		board.setWriter("user05");
//		
//		boardMapper.insert(board);
//		
//		log.info(board);
//	}
	
//	@Test
//	public void readTest() {
//		BoardVO board = boardMapper.read(5L);
//		
//		log.info(board);
//	}
	
	@Test
	public void deleteTest() {
		// �ش� �Խñ��� �ִ������� Ȯ��
		Long bno = 5L;
		
		// �Խñ��� ������ ���� ����
		if(boardMapper.read(bno) != null) {
			log.info("DELETE COUNT : " + boardMapper.delete(bno));
			return;
		}
		
		log.info("NO BOARD");
	}
}











