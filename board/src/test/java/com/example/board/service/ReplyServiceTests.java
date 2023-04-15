package com.example.board.service;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class ReplyServiceTests {
	
	// �ֽű� 5���� ����ϱ� ���� �迭�� ����� ���̴�.
	private Long[] arBno = {3094L, 3093L, 3092L, 3091L, 3090L};
	
	@Autowired
	private ReplyService replyService;

//	@Test
//	public void serviceTest() {
//		log.info(replyService);
//	}

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
//			replyService.register(replyVO);
//		});
//	}
	
//	@Test
//	public void findByRNOTest() {
//		log.info(replyService.findByRNO(30L));
//	}
	
//	@Test
//	public void removeTest() {
//		log.info(replyService.remove(30L));
//	}
	
//	@Test
//	public void removeAllByBNOTest() {
//		log.info(replyService.removeAllByBNO(3091L));
//	}
	
//	@Test
//	public void modifyTest() {
//		// �ϴ� �ش� reply �����ͼ� � �����ؼ� �ٽ� ������Ʈ �ϸ� ��
//		
//		ReplyVO replyVO = replyService.findByRNO(28L);
//		
//		if(replyVO == null) {
//			log.info("���� ����Դϴ�");
//			return;
//		}
//		
//		replyVO.setReply("�����K");
//		replyVO.setReplier("ň���R");
//		
//		log.info(replyService.modify(replyVO));
//	}
	
	@Test
	public void findAllByBNOTest() {
		replyService.findAllByBNO(new Criteria(), 3094L).forEach(log::info);
	}
}
