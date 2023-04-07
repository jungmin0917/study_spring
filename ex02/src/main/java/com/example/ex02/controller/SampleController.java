package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

// Controller 어노테이션이 	붙었으므로 이것도 스프링 컨테이너가 관리한다.
@Controller
@RequestMapping("/ex/*") // ex02/ex/~~~~ 에 해당되는 모든 요청은 여기로 옴
@Log4j
public class SampleController {
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basic() {
		log.info("basic");
	}
}
