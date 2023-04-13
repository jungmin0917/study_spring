package com.example.board.domain.dao;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.domain.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class ReplyDAOTests {
	
	private Long[] arBno = {3094L, 3093L, 3092L, 3091L, 3090L};
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Test
	public void daoTest() {
		log.info(replyDAO);
	}

	
//	@Test
//	public void registerTest() {
//		// �ֽ� �Խñ� 5���� ��� 2���� �ޱ�
//		
//		// �� 10�� �� �Ŵϱ� ��Ʈ������ ���ٽ� �̿�
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO replyVO = new ReplyVO();
//			
//			replyVO.setBno(arBno[(i - 1) % 5]);
//			replyVO.setReply("��� �׽�Ʈ " + i);
//			replyVO.setReplier("�ۼ��� " + i);
//			
//			replyDAO.register(replyVO);
//		});
//	}
	
//	@Test
//	public void findByRNOTest() {
//		log.info(replyDAO.findByRNO(20L));
//	}
	
//	@Test
//	public void removeTest() {
//		log.info(replyDAO.remove(20L));
//	}
	
//	@Test
//	public void removeAllByBNOTest() {
//		log.info(replyDAO.removeAllByBNO(3092L));
//	}
	
//	@Test
//	public void modifyTest() {
//		// �ϴ� �ش� reply �����ͼ� � �����ؼ� �ٽ� ������Ʈ �ϸ� ��
//		
//		ReplyVO replyVO = replyDAO.findByRNO(19L);
//		
//		if(replyVO == null) {
//			log.info("���� ����Դϴ�");
//			return;
//		}
//		
//		replyVO.setReply("�����K");
//		replyVO.setReplier("ň���R");
//		
//		log.info(replyDAO.modify(replyVO));
//	}
	
	@Test
	public void selectAllTest() {
		replyDAO.selectAll(3093L).forEach(log::info);
	}
	
}
