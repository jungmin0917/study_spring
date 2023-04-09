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
	
	
	// ��ǰ�� ���ڵ带 �Է¹ް� �ش� ��ǰ���� ����Ѵ�
	// ��¡�� ���� 4383927
	// ���� ���� 0832147
	// ���� ���� 9841631
	// ������ġ 5587578
	
	@GetMapping("/goods")
	public String goods() {
		log.info("goods�� ����");
		
		return "/market/goods";
	}
	
	@PostMapping("/goods/action")
	public String goodsAction(String barcode, Model model) {
		String productName = null;
		
		switch (barcode) {
		case "4383927":
			productName = "��¡�� ����";
			break;
		case "0832147":
			productName = "���� ����";
			break;
		case "9841631":
			productName = "���� ����";
			break;
		case "5587578":
			productName = "������ġ";
			break;
		default:
			productName = "���� ��ǰ";
			break;
		}
		
		model.addAttribute("productName", productName);
		
		return "/market/cashier";
	}
	
//	������ ���η��� �ش� ��ǰ�� ����
//	��ư�� ���� �� ���� Ŭ���� ���η���ŭ ��ǰ�� ���� ����
	
//	@GetMapping("/sale")
//	�޼ҵ�� : goChangeSale
//	saleChange.jsp
//	����, ��ǰ��, ���� �� 3���� �׸����� �����Ѵ�
//	�� ��ǰ�� ���� �κ��� radio ��ư���� �����Ѵ�.
//	������ ��ư�� �� 4���� ��ư���� �����ϰ�,
//	���� 10%, 30%, 60%, 90%
//	�������� ���� ��ư�� �����Ͽ� form �±׸� �����Ѵ�
	
//	@PostMapping("/change")
//	�޼ҵ�� : change
//	��ǰ �� ��ü�� ��ü ������ ���޹޴´�
//	���޹��� ��ǰ ���ݿ� �������� ������ ������ showChange.jsp�� �����Ѵ�
	
	@GetMapping("/sale")
	public String goChangeSale() {
		return "/product/saleChange";
	}
	
	@PostMapping("/change")
	public String change(ProductVO productVO, Model model) {
		model.addAttribute(productVO);
		
		// ������ �����Ͽ� ����ϱ�
		
		double salePrice = productVO.getProductPrice() * (100 - productVO.getProductRate()) / 100.0;
		
		DecimalFormat df = new DecimalFormat("0.00");
		String formattedPrice = df.format(salePrice);
		
		model.addAttribute("salePrice", formattedPrice);
		
		return "/product/showChange";
	}
	
}











