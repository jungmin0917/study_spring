package com.example.ex02.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class TestMapperTests {
	@Autowired
	private TestMapper testMapper;
	
	
	@Test
	public void getListTest() {
//		testMapper.getList().forEach(log::info); // 람다식 사용해서 안에 있는 요소들 하나씩 꺼내서 출력함
		testMapper.getList().forEach(v->log.info(v)); // 이렇게 해도 됨. 위에꺼는 메소드 레퍼런스
	}
}
