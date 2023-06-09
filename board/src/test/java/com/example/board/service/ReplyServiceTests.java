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
	
	// 최신글 5개를 사용하기 위해 배열을 사용할 것이다.
	private Long[] arBno = {3094L, 3093L, 3092L, 3091L, 3090L};
	
	@Autowired
	private ReplyService replyService;

//	@Test
//	public void serviceTest() {
//		log.info(replyService);
//	}

//	@Test
//	public void registerTest() {
//		// 최신 게시글 5개에 댓글 2개씩 달기
//		
//		// 총 10개 달 거니까 스트림으로 람다식 이용
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO replyVO = new ReplyVO();
//			
//			replyVO.setBno(arBno[(i - 1) % 5]);
//			replyVO.setReply("댓글 테스트 " + i);
//			replyVO.setReplier("작성자 " + i);
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
//		// 일단 해당 reply 가져와서 몇개 수정해서 다시 업데이트 하면 됨
//		
//		ReplyVO replyVO = replyService.findByRNO(28L);
//		
//		if(replyVO == null) {
//			log.info("없는 댓글입니다");
//			return;
//		}
//		
//		replyVO.setReply("하하핳");
//		replyVO.setReplier("흫히힣");
//		
//		log.info(replyService.modify(replyVO));
//	}
	
	@Test
	public void findAllByBNOTest() {
		replyService.findAllByBNO(new Criteria(), 3094L).forEach(log::info);
	}
}
