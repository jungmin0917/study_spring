package com.example.ex02.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex02.domain.vo.InfoDTO;

import lombok.extern.log4j.Log4j;

// Controller ������̼��� 	�پ����Ƿ� �̰͵� ������ �����̳ʰ� �����Ѵ�.
@Controller
@RequestMapping("/ex/*") // ex02/ex/~~~~ �� �ش�Ǵ� ��� ��û�� ����� ��
@Log4j
public class SampleController {
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	// HttpServletRequest ��ü�� ����ϰ� ������ �μ� �κп� �־��ָ� ��
	public void basic(HttpServletRequest req) {
		log.info("basic" + req.getMethod());
	}
	
	@RequestMapping
	public void basic2() {
		log.info("basic2");
	}
	
	// @RequestMapping(method = RequestMethod.GET)�� ������
	// �� �� ª�� GET��û�� ���ؼ��� �ް� ���� �� �̷��� ���� ��
	@GetMapping("/basicOnlyGet")
	public void basic3() {
		log.info("basic3");
	}
	
	// �ܺο��� �Ķ���Ͱ� ���޵��� �� �޴� ���
	// �ܺο��� ���޵� �Ķ���͸� �Ű����� �ʵ��� �ڵ����� �����Ѵ�.
	@GetMapping("/ex01")
	public void ex01(InfoDTO infoDTO) {
		log.info("ex01 : " + infoDTO.getName() + ", " + infoDTO.getAge());
	}
	
	@GetMapping("/ex02")
	// ���� ���� �Ű�������� ���� �Ķ���� Ű���� �ٸ� ���, ��ü�� ���� ���� �Ʒ��� ���� ó���Ѵ�.
	// �ܺο��� ���޵� �Ķ������ �̸��� �Ű������� �ٸ� ��� @RequestParam�� ����Ͽ� ���� ���޹����� �˷��ش�.
	// �Ʒ��� ���� ���, ���� �Ķ���� Ű���� ���� data1, data2�� ������ ���� �����Ѵ�.
	public void ex02(@RequestParam("data1") String name, @RequestParam("data2") int age) {
		log.info("ex02 : " + name + ", " + age);
	}
	
	// �̹��� �Ȱ��� �Ķ���͸����� ���� �� ���� ���� �����Ѵ�
	// �̷� �� List�� �迭�� ��´�.
	
	@GetMapping("/ex03")
	// �⺻ ��ΰ� �ƴ� �ٸ� ��η� ������Ϸ��� String���� �Ͽ� GetMapping�� ���� ��ȯ���� �����ش�
	// �Ʒ��� ���� RequestParam���� data�� �Է��س����� data ������Ʈ�� Ű������ ���� ���� ���� �� �˾Ƽ� arraylist�� add�� �ȴ�.
	public String ex03(@RequestParam("data") ArrayList<String> datas) {
		log.info("datas " + datas);
		return "ex03";
	}
	// �Խñ� ÷������, üũ�ڽ� ���ų� �� �� ����� �� ���̴�.
}









