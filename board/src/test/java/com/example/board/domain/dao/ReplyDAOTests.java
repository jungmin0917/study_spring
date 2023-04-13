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
//		// ÀÏ´Ü ÇØ´ç reply °¡Á®¿Í¼­ ¸î°³ ¼öÁ¤ÇØ¼­ ´Ù½Ã ¾÷µ¥ÀÌÆ® ÇÏ¸é µÊ
//		
//		ReplyVO replyVO = replyDAO.findByRNO(19L);
//		
//		if(replyVO == null) {
//			log.info("¾ø´Â ´ñ±ÛÀÔ´Ï´Ù");
//			return;
//		}
//		
//		replyVO.setReply("ÇÏÇÏÁK");
//		replyVO.setReplier("ÅˆÈ÷ÆR");
//		
//		log.info(replyDAO.modify(replyVO));
//	}
	
	@Test
	public void selectAllTest() {
		replyDAO.selectAll(3093L).forEach(log::info);
	}
	
}
