package com.example.ex02.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 이미 web.xml에서 이쪽으로 오라고 처리했으므로 ControllerAdvice로 설정할 필요 없음
@Controller
public class CustomError {

	@GetMapping("/error")
	public String goErrorPage(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		String res = "";
		
		// 에러가 발생했다는 것
		if(status != null) {
			int statusCode = Integer.parseInt(status.toString());
			
			switch(statusCode) {
				case 404:
					res = "/error/404";
					break;
				default:
					res = "/error/500";
					break;
			}
		}
		
		return res;
	}
}
