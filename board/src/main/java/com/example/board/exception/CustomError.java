package com.example.board.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// �̹� web.xml���� �������� ����� ó�������Ƿ� ControllerAdvice�� ������ �ʿ� ����
@Controller
public class CustomError {

	@GetMapping("/error")
	public String goErrorPage() {
		return "/error/error";
	}
	
}
