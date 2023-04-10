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
	
	// � Exception�� �߻����� �� �Ʒ��� �޼ҵ带 ��������
//	@ExceptionHandler(Exception.class) // ��� Exception�� ���ؼ�
//	public String except(Exception e, Model model) {
//		// log.info�� �׳� ���, log.error�� ���� ���
//		log.error("Exception : " + e.getMessage());
//		
//		model.addAttribute("exception", e); // ������ ������ model�� Exception ��ü�� ����
//		
//		log.error(model.toString()); // ������ ������ Ȯ����
//		
//		return "/error/500";
//	}
//	
//	// 404 ���� (��û�� �������� ���� ��)
//	@ExceptionHandler(NoHandlerFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND) // HTTP �����ڵ� ���� ����
//	public String except404(NoHandlerFoundException e) {
//		return "/error/404";
//	}
	
}
