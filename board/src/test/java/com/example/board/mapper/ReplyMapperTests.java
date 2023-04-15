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
	
	// ÃÖ½Å±Û 5°³¸¦ »ç¿ëÇÏ±â À§ÇØ ¹è¿­À» »ç¿ëÇÒ °ÍÀÌ´Ù.
	private Long[] arBno = {3094L, 3093L, 3092L, 3091L, 3090L};
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void mapperTest() {
		log.info(replyMapper);
	}
	
//	@Test
//	public void insertTest() {
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
//		// ÀÏ´Ü ÇØ´ç reply °¡Á®¿Í¼­ ¸î°³ ¼öÁ¤ÇØ¼­ ´Ù½Ã ¾÷µ¥ÀÌÆ® ÇÏ¸é µÊ
//		
//		ReplyVO replyVO = replyMapper.select(9L);
//		
//		if(replyVO == null) {
//			log.info("¾ø´Â ´ñ±ÛÀÔ´Ï´Ù");
//			return;
//		}
//		
//		replyVO.setReply("ÇÏÇÏÁK");
//		replyVO.setReplier("ÅˆÈ÷ÆR");
//		
//		log.info(replyMapper.update(replyVO));
//	}
	
	@Test
	public void selectAllTest() {

		replyMapper.selectAll(new Criteria(2, 10), 3094L).forEach(log::info);
	}
	
}











