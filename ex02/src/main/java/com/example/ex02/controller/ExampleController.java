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
	
	// 이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다
	// 출근 시간은 09:00, 퇴근 시간은 18:00이다
	// 출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
	// 퇴근 버튼 클릭 시 18시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
	// 시스템 시간으로 처리한다
	
	// 모든 JSP는 work 경로 안에 생성하며, 아래와 같이 분기별로 JSP문서를 한 개씩 작성한다
	// getToWork.jsp
	// leaveWork.jsp
	// late.jsp
	// work.jsp
	
	@GetMapping("/ex1")
	public String ex1Home() {
		log.info("ex1 home으로 진입");
		
		return "work/home";
	}
	
	@PostMapping("/ex1/action")
	public String ex1Action(String name, String type, Model model) {
		
		// 현재 시간을 계산한다
		// LocalTime 객체 사용
		LocalTime now = LocalTime.now();
		
		model.addAttribute("name", name);

		String res = ""; // 리턴할 곳
		
		if(type.equals("getTo")) { // 출근 눌렀을 때
			LocalTime target = LocalTime.of(9, 0); // 오전 9시

			if(now.isAfter(target)) { // 지각
				res = "work/late";
			}else {
				res = "work/getToWork";
			}
		}else { // 퇴근 눌렀을 때
			LocalTime target = LocalTime.of(18, 0); // 오후 6시
			
			if(now.isBefore(target)) { // 조기퇴근
				res = "work/work";
			}else {
				res = "work/leaveWork";
			}
		}
		
		return res;
	}
}
