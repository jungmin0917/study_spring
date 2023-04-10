package com.example.ex02.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// �̹� web.xml���� �������� ����� ó�������Ƿ� ControllerAdvice�� ������ �ʿ� ����
@Controller
public class CustomError {

	@GetMapping("/error")
	public String goErrorPage(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		String res = "";
		
		// ������ �߻��ߴٴ� ��
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
