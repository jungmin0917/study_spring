package com.example.ex02.controller;

import java.text.DecimalFormat;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ex02.domain.vo.ProductVO;

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
	
	
	// 상품의 바코드를 입력받고 해당 상품명을 출력한다
	// 오징어 땅콩 4383927
	// 초코 우유 0832147
	// 벌꿀 피자 9841631
	// 샌드위치 5587578
	
	@GetMapping("/goods")
	public String goods() {
		log.info("goods에 진입");
		
		return "/market/goods";
	}
	
	@PostMapping("/goods/action")
	public String goodsAction(String barcode, Model model) {
		String productName = null;
		
		switch (barcode) {
		case "4383927":
			productName = "오징어 땅콩";
			break;
		case "0832147":
			productName = "초코 우유";
			break;
		case "9841631":
			productName = "벌꿀 피자";
			break;
		case "5587578":
			productName = "샌드위치";
			break;
		default:
			productName = "없는 상품";
			break;
		}
		
		model.addAttribute("productName", productName);
		
		return "/market/cashier";
	}
	
//	선택한 할인률을 해당 상품에 적용
//	버튼을 여러 개 만들어서 클릭된 할인률만큼 상품의 가격 적용
	
//	@GetMapping("/sale")
//	메소드명 : goChangeSale
//	saleChange.jsp
//	선택, 상품명, 가격 총 3개의 항목으로 구성한다
//	각 상품의 선택 부분은 radio 버튼으로 구성한다.
//	할인율 버튼은 총 4개의 버튼으로 제작하고,
//	각각 10%, 30%, 60%, 90%
//	마지막에 적용 버튼을 제작하여 form 태그를 전송한다
	
//	@PostMapping("/change")
//	메소드명 : change
//	상품 모델 객체로 전체 내용을 전달받는다
//	전달받은 상품 가격에 할인율을 적용한 가격을 showChange.jsp로 전달한다
	
	@GetMapping("/sale")
	public String goChangeSale() {
		return "/product/saleChange";
	}
	
	@PostMapping("/change")
	public String change(ProductVO productVO, Model model) {
		model.addAttribute(productVO);
		
		// 할인율 적용하여 계산하기
		
		double salePrice = productVO.getProductPrice() * (100 - productVO.getProductRate()) / 100.0;
		
		DecimalFormat df = new DecimalFormat("0.00");
		String formattedPrice = df.format(salePrice);
		
		model.addAttribute("salePrice", formattedPrice);
		
		return "/product/showChange";
	}
	
}











