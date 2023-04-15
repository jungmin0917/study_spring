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
	
	// ÃÖ½Å±Û 5°³¸¦ »ç¿ëÇÏ±â À§ÇØ ¹è¿­À» »ç¿ëÇÒ °ÍÀÌ´Ù.
	private Long[] arBno = {3094L, 3093L, 3092L, 3091L, 3090L};
	
	@Autowired
	private ReplyService replyService;

//	@Test
//	public void serviceTest() {
//		log.info(replyService);
//	}

//	@Test
//	public void registerTest() {
//		// ÃÖ½Å °Ô½Ã±Û 5°³¿¡ ´ñ±Û 2°³¾¿ ´Þ±â
//		
//		// ÃÑ 10°³ ´Þ °Å´Ï±î ½ºÆ®¸²À¸·Î ¶÷´Ù½Ä ÀÌ¿ë
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO replyVO = new ReplyVO();
//			
//			replyVO.setBno(arBno[(i - 1) % 5]);
//			replyVO.setReply("´ñ±Û Å×½ºÆ® " + i);
//			replyVO.setReplier("ÀÛ¼ºÀÚ " + i);
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
//		// ÀÏ´Ü ÇØ´ç reply °¡Á®¿Í¼­ ¸î°³ ¼öÁ¤ÇØ¼­ ´Ù½Ã ¾÷µ¥ÀÌÆ® ÇÏ¸é µÊ
//		
//		ReplyVO replyVO = replyService.findByRNO(28L);
//		
//		if(replyVO == null) {
//			log.info("¾ø´Â ´ñ±ÛÀÔ´Ï´Ù");
//			return;
//		}
//		
//		replyVO.setReply("ÇÏÇÏÁK");
//		replyVO.setReplier("ÅˆÈ÷ÆR");
//		
//		log.info(replyService.modify(replyVO));
//	}
	
	@Test
	public void findAllByBNOTest() {
		replyService.findAllByBNO(new Criteria(), 3094L).forEach(log::info);
	}
}
