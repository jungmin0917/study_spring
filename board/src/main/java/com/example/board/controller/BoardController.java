package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.domain.vo.BoardVO;
import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;

/**
 * Task		URL				Method		Parameter		Form				URL�̵�
 * 
 * ��ü ���	/board/list		GET							X					
 * ��� ó��	/board/register	POST		BoardVO			�Է�ȭ�� �ʿ�(�۾���)	��ü �������
 * ��ȸ		/board/read		GET			bno				X					����������
 * ���� ó��	/board/remove	GET			bno				�Է�ȭ�� �ʿ�(��P)		��ü �������
 * ���� ó��	/board/modify	POST		BoardVO			�Է�ȭ�� �ʿ�(�۾���)	�۾��� ��������
 * 
 */

@Log4j

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// ��ü ���
	@GetMapping("/list")
	public void list(Model model) {
		log.info("/list");
		model.addAttribute("boardList", boardService.getList());
	}
	
	// ��� ó��
	@PostMapping("/register")
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("/register : " + boardVO); // boardVO ��ü�� �Ѿ�Դ����� Ȯ��
		
		boardService.register(boardVO);

//		Session�� Flash ������ �ְ�, redirect�� ������ �ϸ� request ������ �ʱ�ȭ�ȴ�.
//		�ʱ�ȭ�Ǳ� ���� Flash ������ �����͸� �����س���, �ʱ�ȭ�� �� Flash �������� �����͸� ������ �´�.
//		�����͸� �����Դٸ� Flash ������ �ִ� �����ʹ� �������.
		
//		model.addAttribute("bno", boardVO.getBno());
		rttr.addFlashAttribute("bno", boardVO.getBno());
		
//		redirect�� �̵��� ����, ��� �տ� "redirect:"�� �ٿ� �ش�
		return "redirect:/board/list"; // ��� �� /board/list�� �����̷�Ʈ (���� Request ���� ���)
	}
}











