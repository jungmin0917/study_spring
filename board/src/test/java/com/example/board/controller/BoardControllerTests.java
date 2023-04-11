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
@ContextConfiguration({ // ������ �� �� �̷��� ����� ��
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j

// ���⼭ �׽�Ʈ�ϸ� ������ ��Ĺ ������ؼ� ȭ�� ��� �ʿ� ����.
public class BoardControllerTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc; // ��û, ������ ������ ���� �� �ִ� ��ü
	
	@Before // �ٸ� �޼ҵ庸�� ���� ����
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	// ��ü ���
//	@Test
//	public void listTest() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
//	}
	
	// ��� ó��
//	@Test
//	public void registerTest() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "�׽�Ʈ �� �� ����")
//				.param("content", "�׽�Ʈ �� �� ����")
//				.param("writer", "hgd0000")
//				).andReturn().getFlashMap());
//	}
	
	// ��ȸ
//	@Test
//	public void readTest() throws Exception{
//		Long bno = 12L;
//		
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
//				.param("bno", bno.toString())
//				).andReturn().getModelAndView().getModelMap());
//	}
	
	// ���� ó��
//	@Test
//	public void removeTest() throws Exception{
//		
//		Long bno = 8L;
//		
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
//				.param("bno", bno.toString())
//				).andReturn().getFlashMap());
//	}
	
	// ���� ó��
//	@Test
//	public void modifyTest() throws Exception{
//		
//		Long bno = 7L;
//		
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//				.param("title", "������ �Խñ� ����")
//				.param("content", "������ �Խñ� ����")
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










