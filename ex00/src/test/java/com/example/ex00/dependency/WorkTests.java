package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex00.dependency.qualifier.Outback;
import com.example.ex00.dependency.qualifier.Restaurant;
import com.example.ex00.dependency.qualifier.Vips;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

// 여기에 쓸 클래스들을 어디서 찾을 건지 지정하는 파일
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class WorkTests {

	// 클래스 restaurant
	@Autowired
	private com.example.ex00.dependency.Restaurant restaurant2;
	
	@Autowired
	@Qualifier("outback")
	private Restaurant outback;
	
	@Autowired
	@Qualifier("vips")
	private Restaurant vips;
	
	// 인터페이스 restaurant
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void checkDependency() {
		log.info("------------------");
		log.info("restaurant : " + restaurant2);
		log.info("chef : " + restaurant2.getChef());
		log.info("------------------");
	
		log.info("------------------");
		log.info("outback : " + outback.sidebar());
		log.info("outback : " + outback.steak);
		log.info("vips : " + vips.sidebar());
		log.info("vips : " + vips.steak);
		log.info("restaurant : " + restaurant.sidebar());
		log.info("restaurant : " + restaurant.steak);
		log.info("------------------");
		
	}
}





