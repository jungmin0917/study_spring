package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
// 따로 컨트롤러 자체에 RequestMapping은 하지 않을 것 (바로 루트에서 접근)
public class TaskController {
	
// 아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우, admin.jsp로 이동
// 아이디가 user일 경우, user.jsp로 이동

//	admin.jsp
//	user.jsp
	
//	입력받는 것도 form으로 만들어볼까
	
//	일단 입력받을 페이지를 만들어보자
	@GetMapping("form")
	public String formPage() { // ex의 form으로 가게 함
		// 별다른 처리는 필요없을 것 같음
		log.info("form 페이지로 접근함");
		
		return "ex/form";
	}
	
	@PostMapping("formAction")
	public String formAction(String id, String pw) { // 아이디랑 패스워드값 받음
		log.info("formAction 페이지로 접근함");

		if(id.equals("admin")) {
			return "ex/admin";
		}else if(id.equals("user")) {
			return "ex/user";
		}else {
			return "ex/form";
		}
	}
	
	@GetMapping("/loginForm")
	public String goLoginForm() {
		return "task/task01/login";
	}
	
	@PostMapping("/login")
	public String login(RedirectAttributes redirectAttributes, String id, String pw) {
		// 난 리다이렉트 써볼 거니까 RedirectAttributes를 써보자
		log.info("id : " + id);
		log.info("pw : " + pw);
		
		redirectAttributes.addFlashAttribute("id", id);
		redirectAttributes.addFlashAttribute("pw", pw);

		if(id.equals("admin")) {
			return "redirect:loginAdmin";
		}else {
			return "redirect:loginUser";
		}
	}
	
	@RequestMapping("/loginAdmin")
	public String loginAdmin() {
		return "task/task01/admin";
	}

	@RequestMapping("/loginUser")
	public String loginUser() {
		return "task/task01/user";
	}
}
