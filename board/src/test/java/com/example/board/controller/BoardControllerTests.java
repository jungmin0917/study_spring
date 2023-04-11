package com.example.board.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ // 여러개 쓸 땐 이렇게 적어야 함
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j

// 여기서 테스트하면 일일이 톰캣 재시작해서 화면 띄울 필요 없음.
public class BoardControllerTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc; // 요청, 응답을 보내고 받을 수 있는 객체
	
	@Before // 다른 메소드보다 먼저 실행
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	// 전체 목록
//	@Test
//	public void listTest() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
//	}
	
	// 등록 처리
//	@Test
//	public void registerTest() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "테스트 새 글 제목")
//				.param("content", "테스트 새 글 내용")
//				.param("writer", "hgd0000")
//				).andReturn().getFlashMap());
//	}
	
	// 조회
//	@Test
//	public void readTest() throws Exception{
//		Long bno = 12L;
//		
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
//				.param("bno", bno.toString())
//				).andReturn().getModelAndView().getModelMap());
//	}
	
	// 삭제 처리
//	@Test
//	public void removeTest() throws Exception{
//		
//		Long bno = 8L;
//		
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
//				.param("bno", bno.toString())
//				).andReturn().getFlashMap());
//	}
	
	// 수정 처리
//	@Test
//	public void modifyTest() throws Exception{
//		
//		Long bno = 7L;
//		
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//				.param("title", "수정한 게시글 제목")
//				.param("content", "수정한 게시글 내용")
//				.param("writer", "codingman")
//				.param("bno", bno.toString())
//				).andReturn().getFlashMap());
//	}
	
	@Test
	public void goModifyTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/board/modify")
				.param("bno", "7")
				);
	}
}










