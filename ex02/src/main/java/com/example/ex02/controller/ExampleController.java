package com.example.ex02.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ExampleController {
	
	// �̸��� �Է��ϰ� ��� �Ǵ� ��� ��ư�� Ŭ���Ѵ�
	// ��� �ð��� 09:00, ��� �ð��� 18:00�̴�
	// ��� ��ư Ŭ�� �� 9�ð� ������ �������� ó���ϰ�,
	// ��� ��ư Ŭ�� �� 18�� ���̶�� ����� �ƴ� �����ð����� ó���Ѵ�.
	// �ý��� �ð����� ó���Ѵ�
	
	// ��� JSP�� work ��� �ȿ� �����ϸ�, �Ʒ��� ���� �б⺰�� JSP������ �� ���� �ۼ��Ѵ�
	// getToWork.jsp
	// leaveWork.jsp
	// late.jsp
	// work.jsp
	
	@GetMapping("/ex1")
	public String ex1Home() {
		log.info("ex1 home���� ����");
		
		return "work/home";
	}
	
	@PostMapping("/ex1/action")
	public String ex1Action(String name, String type, Model model) {
		
		// ���� �ð��� ����Ѵ�
		// LocalTime ��ü ���
		LocalTime now = LocalTime.now();
		
		model.addAttribute("name", name);

		String res = ""; // ������ ��
		
		if(type.equals("getTo")) { // ��� ������ ��
			LocalTime target = LocalTime.of(9, 0); // ���� 9��

			if(now.isAfter(target)) { // ����
				res = "work/late";
			}else {
				res = "work/getToWork";
			}
		}else { // ��� ������ ��
			LocalTime target = LocalTime.of(18, 0); // ���� 6��
			
			if(now.isBefore(target)) { // �������
				res = "work/work";
			}else {
				res = "work/leaveWork";
			}
		}
		
		return res;
	}
}
