package com.example.ex02.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex02.domain.vo.InfoDTO;
import com.example.ex02.domain.vo.StudentVO;

import lombok.extern.log4j.Log4j;

// Controller 어노테이션이 	붙었으므로 이것도 스프링 컨테이너가 관리한다.
@Controller
@RequestMapping("/ex/*") // ex02/ex/~~~~ 에 해당되는 모든 요청은 여기로 옴
@Log4j
public class SampleController {
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	// HttpServletRequest 객체를 사용하고 싶으면 인수 부분에 넣어주면 됨
	public void basic(HttpServletRequest req) {
		log.info("basic" + req.getMethod());
	}
	
//	@RequestMapping
//	public void basic2() {
//		log.info("basic2");
//	}
	
	// @RequestMapping(method = RequestMethod.GET)과 동일함
	// 좀 더 짧게 GET요청에 대해서만 받고 싶을 때 이렇게 쓰면 됨
	@GetMapping("/basicOnlyGet")
	public void basic3() {
		log.info("basic3");
	}
	
	// 외부에서 파라미터가 전달됐을 때 받는 방법
	// 외부에서 전달된 파라미터를 매개변수 필드명과 자동으로 매핑한다.
	@GetMapping("/ex01")
	public void ex01(InfoDTO infoDTO) {
		log.info("ex01 : " + infoDTO.getName() + ", " + infoDTO.getAge());
	}
	
	@GetMapping("/ex02")
	// 만약 여기 매개변수명과 들어온 파라미터 키값이 다른 경우, 객체로 받지 말고 아래와 같이 처리한다.
	// 외부에서 전달된 파라미터의 이름과 매개변수가 다를 경우 @RequestParam을 사용하여 어디로 전달받을지 알려준다.
	// 아래와 같은 경우, 만약 파라미터 키값이 각각 data1, data2로 들어왔을 때를 상정한다.
	public void ex02(@RequestParam("data1") String name, @RequestParam("data2") int age) {
		log.info("ex02 : " + name + ", " + age);
	}
	
	// 이번엔 똑같은 파라미터명으로 여러 개 들어올 때를 상정한다
	// 이럴 땐 List나 배열에 담는다.
	
	@GetMapping("/ex03")
	// 기본 경로가 아닌 다른 경로로 라우팅하려면 String으로 하여 GetMapping에 대한 반환값을 정해준다
	// 아래와 같이 RequestParam으로 data를 입력해놓으면 data 쿼리스트링 키값으로 여러 개가 들어올 시 알아서 arraylist에 add가 된다.
	public String ex03(@RequestParam("data") ArrayList<String> datas) {
		log.info("datas " + datas);
		return "ex03";
	}
	// 게시글 첨부파일, 체크박스 쓰거나 할 때 사용이 될 것이다.
	
//	그대로 쓰면 infoDTO로 받는 쪽에서 쓸 수 있지만, 만약 객체명을 바꿔서 쓰고 싶으면 ModelAttribute 어노테이션을 사용한다
//	만약 키값을 수정해서 쓰고 싶거나 매개변수가 많아진다면 직접 requestScope에 담아서 전달해야 한다.
//	이 때 request 객체를 직접 불러오지 않고, Model이라는 데이터 전달자를 사용하게 된다.
//	하지만 화면 쪽에 전달할 데이터가 1개라면, @ModelAttribute()를 사용하여 화면에 전달해준다.
//	@ModelAttribute("화면에서 사용할 key값")
	@GetMapping("/ex04")
	public String ex04(@ModelAttribute("dto") InfoDTO infoDTO) {
		log.info("-------------------");
		log.info("ex04");
		log.info(infoDTO.toString());
		log.info("-------------------");
		
		return "ex04";
	}
	
	// 아래와 같이 객체에 없는 다른 하나의 값을 더 넘기고 싶다면 아래와 같이 하면 된다.
	@GetMapping("/ex05")
	public void ex05(InfoDTO infoDTO, @ModelAttribute("gender") String gender) {
		log.info("ex05-----------------");
		log.info(infoDTO.toString());		
		log.info("ex05-----------------");
	}
	
	
	// 이번엔 데이터 전달자인 Model 객체를 만들어서 넘겨보자.
//	Model 객체는 파라미터로 request 객체를 받는다.
//	따라서 여러 개의 데이터를 화면에 전달할 때, model.addAttribute(KEY, VALUE)를 사용한다.
//	화면에서는 model에 설정한 KEY로 VALUE를 사용할 수 있다.
	
	
	@GetMapping("/ex06")
	public String ex06(InfoDTO infoDTO, String gender, Model model) {
		log.info("ex06-----------------");
		log.info(infoDTO.toString());
		log.info("gender : " + gender);
		
		// 위와 비교해보면 다른 게, 직접 매개변수 쪽에서 @ModelAttribute 어노테이션을 사용하지 않고 여기서 model 객체를 사용하여 넘긴다.
		model.addAttribute("dto", infoDTO);
		model.addAttribute("gender", gender);
		
		return "ex/ex06";
	}
	
//	@GetMapping
//	외부에서 학생의 번호, 국어, 영어, 수학 점수를 모델 객체로 전달받는다.
//	파라미터명과 매개변수에 선언된 모델 객체의 필드명이 동일하면 자동으로 매핑된다.
//	리턴 시 명시한 페이지로 이동이 되고, 모델 객체는 직접 KEY를 지정하지 않아도
//	View쪽에서 앞글자만 소문자로 바뀐 값으로 해당 필드에 접근할 수 있다
//	public String ex07(StudentVO studentVO) {
//		log.info("ex07------------------------------");
//		
//		log.info(studentVO.toString());
//		
//		return "ex/ex07";
//	}
}









