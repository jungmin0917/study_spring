package com.example.board.mapper;

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

public class ReplyMapperTests {
	
	// 최신글 5개를 사용하기 위해 배열을 사용할 것이다.
	private Long[] arBno = {3094L, 3093L, 3092L, 3091L, 3090L};
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void mapperTest() {
		log.info(replyMapper);
	}
	
//	@Test
//	public void insertTest() {
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
//			replyMapper.insert(replyVO);
//		});
//	}
	
	@Test
	public void selectTest() {
		log.info(replyMapper.select(10L));
	}
}











