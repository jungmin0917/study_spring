package com.example.board.mapper;

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

public class ReplyMapperTests {
	
	// �ֽű� 5���� ����ϱ� ���� �迭�� ����� ���̴�.
	private Long[] arBno = {3094L, 3093L, 3092L, 3091L, 3090L};
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void mapperTest() {
		log.info(replyMapper);
	}
	
//	@Test
//	public void insertTest() {
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
//			replyMapper.insert(replyVO);
//		});
//	}
	
//	@Test
//	public void selectTest() {
//		log.info(replyMapper.select(10L));
//	}
	
//	@Test
//	public void deleteTest() {
//		log.info(replyMapper.delete(10L));
//	}
	
//	@Test
//	public void deleteAllTest() {
//		log.info(replyMapper.deleteAll(3091L));
//	}
	
//	@Test
//	public void updateTest() {
//		// �ϴ� �ش� reply �����ͼ� � �����ؼ� �ٽ� ������Ʈ �ϸ� ��
//		
//		ReplyVO replyVO = replyMapper.select(9L);
//		
//		if(replyVO == null) {
//			log.info("���� ����Դϴ�");
//			return;
//		}
//		
//		replyVO.setReply("�����K");
//		replyVO.setReplier("ň���R");
//		
//		log.info(replyMapper.update(replyVO));
//	}
	
	@Test
	public void selectAllTest() {

		replyMapper.selectAll(new Criteria(2, 10), 3094L).forEach(log::info);
	}
	
}











