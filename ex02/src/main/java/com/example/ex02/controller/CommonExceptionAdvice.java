package com.example.ex02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	// 어떤 Exception이 발생했을 때 아래의 메소드를 실행할지
//	@ExceptionHandler(Exception.class) // 모든 Exception에 대해서
//	public String except(Exception e, Model model) {
//		// log.info는 그냥 출력, log.error는 에러 출력
//		log.error("Exception : " + e.getMessage());
//		
//		model.addAttribute("exception", e); // 데이터 전달자 model에 Exception 객체를 담음
//		
//		log.error(model.toString()); // 실제로 담겼는지 확인차
//		
//		return "/error/500";
//	}
//	
//	// 404 에러 (요청한 페이지가 없을 때)
//	@ExceptionHandler(NoHandlerFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND) // HTTP 응답코드 직접 지정
//	public String except404(NoHandlerFoundException e) {
//		return "/error/404";
//	}
	
}
