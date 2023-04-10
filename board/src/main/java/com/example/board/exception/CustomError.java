package com.example.board.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 이미 web.xml에서 이쪽으로 오라고 처리했으므로 ControllerAdvice로 설정할 필요 없음
@Controller
public class CustomError {

	@GetMapping("/error")
	public String goErrorPage() {
		return "/error/error";
	}
	
}
