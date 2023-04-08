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
// ���� ��Ʈ�ѷ� ��ü�� RequestMapping�� ���� ���� �� (�ٷ� ��Ʈ���� ����)
public class TaskController {
	
// ���̵�� ��й�ȣ�� �Է¹��� �� ���̵� admin�� ���, admin.jsp�� �̵�
// ���̵� user�� ���, user.jsp�� �̵�

//	admin.jsp
//	user.jsp
	
//	�Է¹޴� �͵� form���� ������
	
//	�ϴ� �Է¹��� �������� ������
	@GetMapping("form")
	public String formPage() { // ex�� form���� ���� ��
		// ���ٸ� ó���� �ʿ���� �� ����
		log.info("form �������� ������");
		
		return "ex/form";
	}
	
	@PostMapping("formAction")
	public String formAction(String id, String pw) { // ���̵�� �н����尪 ����
		log.info("formAction �������� ������");

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
		// �� �����̷�Ʈ �Ẽ �Ŵϱ� RedirectAttributes�� �Ẹ��
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
